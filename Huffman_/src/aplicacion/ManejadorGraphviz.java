package aplicacion;

import aplicacion.ArbolDeCodificacion.NodoH;
import java.util.LinkedList;

/**
 *
 * @author 16171024
 */
public class ManejadorGraphviz {
    
    private static LinkedList<String> hojas;
    public static String getFormatoGraphviz(ArbolDeCodificacion a){
        
        hojas = new LinkedList();
        String relaciones = getFormatoGraphviz0(a.raiz);
        String shojas = getSintaxisHojas(hojas);
        
        return "digraph arboreHuffman { \n"+ shojas +"\nnode [shape = circle]; \n" + relaciones + "}";
        
    }
    
    private static String getFormatoGraphviz0(NodoH n){
        String s = "";
        if (n==null)
            return s;
        
        if(n.getId() != null) hojas.add(String.valueOf(n.getContador()));
        
        s += n.getId()==null? n.getContador()+ "[label= \"" + n.getFrecuencia() +"\"];\n":
                n.getContador()+ "[label= \"" + getLabelHoja(n.getId()) +"\"];\n";
        
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
            s=(n.getContador()+ " -> " + hijo.getContador() + " [ label = \"" + label  + "\"]; \n");
        else
            s=(n.getContador()+ " -> " + hijo.getContador() + " [ label = \"" + label  + "\"]; \n");
        return s;
    }

    private static String getSintaxisHojas(LinkedList<String> hojas) {
        StringBuilder s = new StringBuilder("node [shape = doublecircle]; ");
        
        for(String h: hojas)
            s.append(h + " ");
            
        s.append(";");
        return s.toString();
    }

    private static String getLabelHoja(String id) {
        if(id.charAt(0) > 31 && id.charAt(0) < 255)
            return id;
        
        return "";
    }
}
