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
        BitSet bs = new BitSet();
        indice = 0;
        
        //conseguimos el BitSet del archivo
        for (int i = 0; i < archivo.length; i++) {
            bs.set(archivo[i]);
        }
        
        //decodificamos el archivo
        while(indice < archivo.length){
            cadena.append(getCaracter(bs, codigos));
        }
        
        return cadena.toString();
    }
    
    private static String getCaracter(BitSet bs, HashMap<String, String> codigos){
        
        if(codigos.size() == 1)
            return null; // regresamos el valor de la unica llave en el diccionario
        
        HashMap<String, String> codigos2 = (HashMap<String, String>) codigos.clone();
        String temp;
        ArrayList<String> removibles = new ArrayList();
        for (Map.Entry<String,String> pair : codigos2.entrySet()) {
            temp = pair.getValue();
            pair.setValue(temp.substring(0, temp.length()));
            if(("1".equals(temp.substring(0, 1))) != bs.get(indice))
                removibles.add(pair.getKey());
        }
        
        // removemos los removibles
        for(String s: removibles)
            codigos2.remove(s);
        
        indice ++;
        return getCaracter(bs, codigos2);
    }
    
    public static void descomprime(String a_cod, String a_des) throws IOException{
        ManejadorArchivos ma = new ManejadorArchivos();
        HashMap<String, String> codificacion = new HashMap<>();
        byte [] datos = null;
        
        ArrayList<String> a = ma.getContenidoArchivoCodificado(a_cod);
        String cod = a.get(0);
        
        int contador = 0;
        int contador_1 = 0;
        String tmp;
        while(true){
            if(ManejadorCadenas.buscaConcurrencia(cod,";", contador) == -1)
                break;
            
            tmp = cod.substring(ManejadorCadenas.buscaConcurrencia(cod,";", contador_1),
                                ManejadorCadenas.buscaConcurrencia(cod,";", contador));
            
            codificacion.put(tmp.substring(0,tmp.indexOf("-")), tmp.substring(tmp.indexOf("-"), tmp.length()));
            contador_1 = contador++;
        }
        
        //recuperamos los datos
        datos = a.get(1).getBytes();
        
        ma.agregaContenidoArchivo(a_des, ManejadorArbol.decodifica(datos, codificacion));
    }

    public static void comprime(String archivos_testprovaMainhf, String contenido, HashMap<String, String> codigos) throws IOException {
        ManejadorArchivos ma = new ManejadorArchivos();
        ma.agregaContenidoArchivoByte("archivos_test/provaMain.hf", 
                                      ManejadorArbol.codifica(contenido, codigos),
                                      ManejadorArbol.mapaToString(codigos) + "\n");
    }
}
