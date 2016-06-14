package aplicacion;

import aplicacion.ArbolDeCodificacion.NodoH;

/**
 *
 * @author 16171024
 */
public class ManejadorGraphviz {
    
    
    public static String getFormatoGraphviz(ArbolDeCodificacion a){
        
        return "digraph arboreHuffman { \n node [shape = circle]; \n" + getFormatoGraphviz0(a.raiz) + "}";
        
    }
    
    private static String getFormatoGraphviz0(NodoH n){
        String s = "";
        if (n==null)
            return s;
        if(n.getIzquierda() != null)
            s += getRelacion(n, n.getIzquierda(),"0");
        if(n.getDerecha() != null)
            s += getRelacion(n, n.getDerecha(),"1");
               
        return s + getFormatoGraphviz0(n.getDerecha())
                 + getFormatoGraphviz0(n.getIzquierda());
    }

    private static String getRelacion(NodoH n, NodoH hijo, String label) {
        String s = "";
        if(hijo.getId()!=null)
            s=(n.getFrecuencia()+ " -> " + hijo.getId() + " [ label = \"" + label  + "\"]; \n");
        else
            s=(n.getFrecuencia()+ " -> " + hijo.getFrecuencia() + " [ label = \"" + label  + "\"]; \n");
        return s;
    }
}
