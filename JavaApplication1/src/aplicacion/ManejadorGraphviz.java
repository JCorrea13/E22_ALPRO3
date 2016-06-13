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
        
        String s = "";
        
        s = (n.getDerecha() != null?  
                (n.getId() + " -> " + n.getDerecha().getId() + "; \n"): "" ) 
                +(n.getIzquierda()!= null?
                (n.getId() + " -> " + n.getIzquierda().getId() + "; \n"): "");
                
        return s + (n.getDerecha() != null?getFormatoGraphviz0(n.getDerecha()): "")
                 + (n.getIzquierda() != null?getFormatoGraphviz0(n.getIzquierda()): "");
    }
}
