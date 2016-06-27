package aplicacion;

import aplicacion.ArbolDeCodificacion.NodoH;
import java.util.LinkedList;

/**
 * @author Jose Correa
 * @author Alejandro Romero
 */
public class ManejadorGraphviz {
    
    private static LinkedList<String> hojas;
    
    /**
     * Este metodo obtiene el formatod de GraphViz desde el arbol de 
     * codificacion de Huffman
     * @param a Arbol de Huffman
     * @return String con sintaxis Graphviz
     */
    public static String getFormatoGraphviz(ArbolDeCodificacion a){
        
        hojas = new LinkedList();
        String relaciones = getFormatoGraphviz0(a.raiz);
        String shojas = getSintaxisHojas(hojas);
        
        return "digraph arboreHuffman { \n"+ shojas +"\nnode [shape = circle]; \n" + relaciones + "}";
        
    }
    
    /**
     * Este es el metodo recursivo para la creacion de del formato 
     * de Graphviz del arbol de huffman
     * @param n nodo
     * @return String de relaciones desde un arbol de huffman en 
     * sintaxis graphviz
     */
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

    /**
     * Este motodo crea la sintaxis de Grapviz para la relacion
     * entre dos nodos
     * @param n nodo padre
     * @param hijo nodo hijo
     * @param label etiqueta de la relacion (se espera '0' o '1')
     * @return String con la representacion de la relacion entre dos nodos
     */
    private static String getRelacion(NodoH n, NodoH hijo, String label) {
        String s = "";
        if(hijo.getId()!=null)
            s=(n.getContador()+ " -> " + hijo.getContador() + " [ label = \"" + label  + "\"]; \n");
        else
            s=(n.getContador()+ " -> " + hijo.getContador() + " [ label = \"" + label  + "\"]; \n");
        return s;
    }

    /**
     * Este metodo regresa la sintaxis para graphviz para los nodos
     * hojas del arbol de huffman
     * @param hojas lista de los nodos hoja
     * @return String con sintaxis Graphviz
     */
    private static String getSintaxisHojas(LinkedList<String> hojas) {
        StringBuilder s = new StringBuilder("node [shape = doublecircle]; ");
        
        for(String h: hojas)
            s.append(h + " ");
            
        s.append(";");
        return s.toString();
    }

    /**
     * Este metodo sirve para validar las etiquetas de los nodos hojas
     * solo permite la impresion de los caracteres imiprimibles
     * para evitar conflictos con la sintaxis de graphviz
     * @param caracater etiqueta del nodo
     * @return String con la etiqueta correspondiente para la sintaxis graphviz
     */
    private static String getLabelHoja(String caracter) {
        if(caracter.charAt(0) > 31 && caracter.charAt(0) < 255)
            return caracter;
        
        return "";
    }
}
