/*
 * Esta clase contiene los metodos necesarios para 
 * manejar el arbol de codificacion
 */
package aplicacion;

import aplicacion.ArbolDeCodificacion.NodoH;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import util.ManejadorArchivos;
import util.ManejadorCadenas;

/**
 * @author Jose Correa
 * @author Alejandro romero
 */
public class ManejadorArbol {
    
    private static HashMap<String, String> codigos;
    
    /**
     * Este metodo recibe una cadena y calcula las frecuencias 
     * de todos los caracteres que contiene la cadena.
     * @param s cadena de la cual se generara el arregle de frecuencias
     * @return HashMap<Caracter, Frecuencia>
     */
    public static HashMap<String, AtomicInteger> getFrecuencias(String s){
        
        String clave;
        HashMap <String, AtomicInteger> mapa = new HashMap <String, AtomicInteger> ();
        for (int i = 0; i < s.length(); i++){
            clave = s.substring(i,i+1);
            if((mapa.get(clave)) != null)
                mapa.get(clave).incrementAndGet();
            else
                mapa.put(clave, new AtomicInteger(1));
        }
        
        return mapa;
    }
    
    
    /**
     * Este metodo regresa un string con la representacion
     * de todo el hashmap que pasa como parametro
     * @param hm hasmap que se desea imprimir
     * @return string con contenido de hashmap
     */
    public static String mapaToString(HashMap<String, String> hm){
        if(hm == null) return "";
        
        StringBuilder sf = new StringBuilder();
        
        for (Map.Entry<String, String> pair : hm.entrySet()) {
            sf.append(pair.getKey());
            sf.append("-");
            sf.append(pair.getValue());
            sf.append(";");
        }
        
        return sf.toString();
    }
    
    /**
     * Este metodo crea la codificacion de Huffman desde el Arbol de 
     * Huffman que pasa como parametro
     * @param a Arbol de Huffman (ArbolDeCodificacion)
     * @return HashMap codificaciones
     */
    public static HashMap<String, String> getCodificacion(ArbolDeCodificacion a){
        codigos = new HashMap<>();
        
        if(a.raiz == null) return null;
        return getCodificacion0(a.raiz, "");
    }
    
    /**
     * Este motodo es el metodo recursivo que se utiliza para recorrer el Arbol de Huffman
     * y crear las codificaciones
     * @param nodo 
     * @param codigo
     * @return 
     */
    private static  HashMap<String, String> getCodificacion0(NodoH nodo, String codigo){
        
        
        if(nodo.getId() == null){
            getCodificacion0(nodo.getIzquierda(), codigo + "0");
            getCodificacion0(nodo.getDerecha(), codigo + "1");
        }else{
            codigos.put(nodo.getId(), codigo);
        }
        
        return codigos;
    }
    
    /**
     * Este metodo se encarga de crear la codificacion del archivo 
     * (String) que pasa como parametro con respecto a los codigos 
     * que tambien pasan como parametro
     * @param archivo String a comprimir
     * @param codigos codigos para comprecion
     * @return Arreglo de bytes con la codificacion del archivo
     */
    private static byte [] codifica(String archivo, HashMap<String, String> codigos){
        BitSet buffer = new BitSet();
        int index = 0;
        int cont = 0;
        
        for (int i = 0; i < archivo.length(); i ++) {
            //para cada letra del archivo
            String codigo = codigos.get(archivo.substring(i,i+1));
            for(int j = 0; j < codigo.length(); j++){
                buffer.set(index++,(codigo.charAt(j) == '1'));
                cont++;
            }
        }
        buffer.set(index++,true);
        cont ++;
        
        int resto = cont % 8;
        byte [] datos = buffer.toByteArray();
        byte [] d = new byte[datos.length+1];
        
        d[0] = (byte) resto;
        for (int i = 0; i < datos.length ; i++) {
            d[i+1] = datos[i];
        }
        return d;
    }
        
    private static int indice = 0;
    private static String decodifica(byte [] archivo, HashMap<String, String> codigos){
        if(codigos == null || codigos.isEmpty()) return "";
        
        StringBuffer cadena = new StringBuffer();
        StringBuffer bytes_string = new StringBuffer();
        
        indice = 0;
        
        int resto = archivo[0];
        //recuperamos el archvo completo como representacion de string
        for(int i = 1; i < archivo.length - 1; i ++)
            bytes_string.append(getStringFromByte(archivo[i],(byte)8));
        bytes_string.append(getStringFromByte(archivo[archivo.length-1],(byte)((resto == 0)?7 :resto-1)));
        
        
        //decodificamos el archivo
        int length = bytes_string.length();
        while(indice < length){
            cadena.append(getCaracter(bytes_string.toString(), codigos));
        }
        
        return cadena.toString();
    }
    
    private static String getCaracter(String bytes_string, HashMap<String, String> codigos){
        
        if(codigos.size() == 1)
            for (Map.Entry<String,String> pair : codigos.entrySet())
                return pair.getKey();
            
        HashMap<String, String> codigos2 = (HashMap<String, String>) codigos.clone();
        String temp;
        ArrayList<String> removibles = new ArrayList();
        for (Map.Entry<String,String> pair : codigos2.entrySet()) {
            temp = pair.getValue();
            pair.setValue(temp.substring(1, temp.length()));
            if(("1".equals(temp.substring(0, 1))) != (bytes_string.charAt(indice) == '1'))
                removibles.add(pair.getKey());
        }
        
        // removemos los removibles
        for(String s: removibles)
            codigos2.remove(s);
        
        indice ++;
        return getCaracter(bytes_string, codigos2);
    }
    
    public static void descomprime(String a_cod, String a_des) throws IOException{
        ManejadorArchivos ma = new ManejadorArchivos();
        HashMap<String, String> codificacion = new HashMap<>();
        byte [] datos = null;
        
        int indice_archivo = 0;
        byte [] a = ma.getContenidoArchivoBytes(a_cod);
        
        //calculamos la cantidad de codigos que hay
        int u = (byte)(a[indice_archivo++]);
        int d = (int)((a[indice_archivo++]));
        
        int tam_cod = (int) (d<<8) | u ;
        for (int i = 0; i < tam_cod; i++)
            codificacion.put((char)a[indice_archivo++] + "", getStringFromByte(a[indice_archivo++], a[indice_archivo++]));
        
        datos = Arrays.copyOfRange(a, (tam_cod*3) +1, a.length);
        ma.setContenidoArchivo(a_des, ManejadorArbol.decodifica(datos, codificacion));
    }

    public static void comprime(String url, String contenido, HashMap<String, String> codigos) throws IOException {
        if(contenido == null || contenido.isEmpty() || codigos == null){ 
            System.out.println("No se condiguio comprimir el archivo");
            return;
        }
        
        ManejadorArchivos ma = new ManejadorArchivos();
        ma.setContenidoArchivoByte(url, 
                                      ManejadorArbol.codifica(contenido, codigos),
                                      ManejadorArbol.codificaCodigos(codigos));
    }
    
    private static String getStringFromByte(byte b, byte tam){
        StringBuilder s = new StringBuilder();
        short tmp = 0;
        
        for(int i = 7; i > (7-tam)   ; i--){
            tmp = (short) (b << (i+8));
            s.append(tmp<0? "1":"0");
        }
            
        return s.toString();
    }

    private static byte [] codificaCodigos(HashMap<String, String> codigos) {
        if(codigos == null) return null;
        
        int tam = codigos.size();
        byte [] array = new byte [(tam*3) + 2];
        int cont = 0;
        
        array[cont++] = (byte)tam;
        array[cont++] = (byte)(tam >>> 8);
        for (Map.Entry<String,String> pair : codigos.entrySet()) {
            array[cont++] = (byte)pair.getKey().charAt(0);
            array[cont++] = (byte)getByteFromString(pair.getValue());
            array[cont++] = (byte)pair.getValue().length();
        }
        
        
        return array;
    }
    
    private static byte getByteFromString(String s){
        
        if(s == null || s.isEmpty())
            return 0;
        
        BitSet buffer = new BitSet();
        int index = 0;
        
        for (int i = 0; i < s.length(); i ++) {
            buffer.set(index++,(s.charAt(i) == '1'));
        }
        
        return (buffer.toByteArray().length == 0)? 0: buffer.toByteArray()[0];
    }
}
