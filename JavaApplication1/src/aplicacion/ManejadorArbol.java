/*
 * Esta clase contiene los metodos necesarios para 
 * manejar el arbol de codificacion
 */
package aplicacion;

import aplicacion.ArbolDeCodificacion.NodoH;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 16171024
 */
public class ManejadorArbol {
    
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
    
    
    public static void muestraMapa(HashMap<String, String> hm){
        
        for (Map.Entry<String, String> pair : hm.entrySet()) {
            System.out.print(pair.getKey() + " - ");
            System.out.println(pair.getValue());
        }
    }
    
    public static HashMap<String, String> getCodificacion(ArbolDeCodificacion a){
        
        return getCodificacion0(a.raiz, "");
    }
    
    static HashMap<String, String> codigos = new HashMap<>();
    private static  HashMap<String, String> getCodificacion0(NodoH nodo, String codigo){
        
        
        if(nodo.getId() == null){
            getCodificacion0(nodo.getIzquierda(), codigo + "0");
            getCodificacion0(nodo.getDerecha(), codigo + "1");
        }else{
            codigos.put(nodo.getId(), codigo);
        }
        
        return codigos;
    }
}
