package aplicacion;

import aplicacion.ArbolDeCodificacion.NodoH;

/**
 *
 * @author 16171024
 */
public class ManejadorGraphviz {
    
    
    public static String getFormatoGraphviz(ArbolDeCodificacion a){
        
        return "digraph graphname { \n" + getFormatoGraphviz0(a.raiz) + "}";
        
    }
    
    private static String getFormatoGraphviz0(NodoH n){
        if(n == null) return "";
        
        return  (n.getDerecha() != null?  ////MULTIPLE LLAMADA A RECURSION
                (n.getId() + " -> " + getFormatoGraphviz0(n.getDerecha()) + "; \n"): "" ) 
                +(n.getIzquierda()!= null?
                (n.getId() + " -> " + getFormatoGraphviz0(n.getIzquierda()) + "; \n"): "");
    }
}
