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
 * @author 16171024
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
    
    
    public static String mapaToString(HashMap<String, String> hm){
        StringBuilder sf = new StringBuilder();
        
        for (Map.Entry<String, String> pair : hm.entrySet()) {
            sf.append(pair.getKey());
            sf.append("-");
            sf.append(pair.getValue());
            sf.append(";");
        }
        
        return sf.toString();
    }
    
    public static HashMap<String, String> getCodificacion(ArbolDeCodificacion a){
        codigos = new HashMap<>();
        
        if(a.raiz == null) return null;
        return getCodificacion0(a.raiz, "");
    }
    
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
     * 
     * @param archivo
     * @param codigos
     * @return 
     */
    private static byte [] codifica(String archivo, HashMap<String, String> codigos){
        BitSet buffer = new BitSet();
        int index = 0;
        
        for (int i = 0; i < archivo.length(); i ++) {
            //para cada letra del archivo
            String codigo = codigos.get(archivo.substring(i,i+1));
            for(int j = 0; j < codigo.length(); j++)
                buffer.set(index++,(codigo.charAt(j) == '1'));
        }
        
        return buffer.toByteArray();
    }
        
    private static int indice = 0;
    private static String decodifica(byte [] archivo, HashMap<String, String> codigos){
        
        StringBuffer cadena = new StringBuffer();
        StringBuffer bytes_string = new StringBuffer();
        
        indice = 0;
        
        for(int i = 0; i < archivo.length; i ++)
            bytes_string.append(getStringFromByte(archivo[i]));
        
        //decodificamos el archivo
        int length = archivo.length*8;
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
        int tam_cod = (int)a[indice_archivo++];
        for (int i = 0; i < tam_cod; i++)
            codificacion.put((char)a[indice_archivo++] + "", getStringFromByte(a[indice_archivo++]));
        
        datos = Arrays.copyOfRange(a, tam_cod, a.length);
        ma.agregaContenidoArchivo(a_des, ManejadorArbol.decodifica(datos, codificacion));
    }

    public static void comprime(String url, String contenido, HashMap<String, String> codigos) throws IOException {
        ManejadorArchivos ma = new ManejadorArchivos();
        ma.agregaContenidoArchivoByte(url, 
                                      ManejadorArbol.codifica(contenido, codigos),
                                      ManejadorArbol.codificaCodigos(codigos));
    }
    
    private static String getStringFromByte(byte b){
        
        StringBuilder s = new StringBuilder();
        short tmp = 0;
        
        for(int i = 7; i > -1 ; i--){
            tmp = (short) (b << (i+8));
            s.append(tmp<0? "1":"0");
        }
            
        return s.toString();
    }

    private static byte [] codificaCodigos(HashMap<String, String> codigos) {
        int tam = codigos.size();
        byte [] array = new byte [(tam*2) + 1];
        int cont = 0;
        
        array[cont++] = (byte)tam;
        for (Map.Entry<String,String> pair : codigos.entrySet()) {
            array[cont++] = (byte)pair.getKey().charAt(0);
            array[cont++] = (byte)getByteFromString(pair.getValue());
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
