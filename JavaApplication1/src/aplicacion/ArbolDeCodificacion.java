package aplicacion;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jose Correa
 * @author Alejandro Romero
 */
public class ArbolDeCodificacion {
    
    NodoH raiz;
    static LinkedList<NodoH> lista = new LinkedList<NodoH>();
    public static ArbolDeCodificacion getArbolCodificacion(HashMap<String, AtomicInteger> nodos){
        
        ArbolDeCodificacion a = new ArbolDeCodificacion();
        for (Map.Entry<String, AtomicInteger> pair : nodos.entrySet()) {
            lista.add(new NodoH(pair.getKey(),pair.getValue().intValue(),true, null, null));
        }
        
        while(lista.size() > 1){
            Collections.sort(lista);
            NodoH n1 = lista.get(0);
            NodoH n2 = lista.get(1);
            
            a.raiz = new NodoH(null, n1.frecuencia + n2.frecuencia, false, n1, n2);
            lista.add(a.raiz);
            lista.remove(n1);
            lista.remove(n2);
        }
        
        return a;
    }
    static class NodoH implements Comparable{
        
        private static int contador =0;
        private final String id;
        private final int CONTADOR;
        private int frecuencia;
        private NodoH izquierda;
        private NodoH derecha;
        
        public NodoH(String id, int frecuencia, boolean isElemento, NodoH izquierda, NodoH derecha) {
            this.id = id;
            this.CONTADOR = contador++;
            this.frecuencia = frecuencia;
            this.izquierda = izquierda;
            this.derecha = derecha;
        }

        public int getContador() {
            return CONTADOR;
        }
        public String getId() {
            return id;
        }

        public int getFrecuencia() {
            return frecuencia;
        }

        public NodoH getIzquierda() {
            return izquierda;
        }

        public NodoH getDerecha() {
            return derecha;
        }

        @Override
        public int compareTo(Object o) {
            NodoH nodo = (NodoH)o;
            
            if(frecuencia < nodo.frecuencia)
                return -1;
            else if(frecuencia > nodo.frecuencia)
                return 1;
            
            return 0;
        }
        
        
    }
}
