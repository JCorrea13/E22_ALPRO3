
package aplicacion;

import java.io.IOException;
import java.util.HashMap;
import util.ManejadorArchivos;

/**
 *
 * @author Jose Corra
 * @author Alejandro Romero
 */
public class Main {

    public static void main(String[] args) throws IOException {
        
        
        String ruta = "archivos_test/provaMain.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        ManejadorArbol.mapaToString(codigos);
        System.out.println(ManejadorArbol.getFrecuencias(palabra));
        
        
        //ManejadorArbol.comprime("archivos_test/provaMain.hf", palabra, codigos);
        ManejadorArbol.descomprime("archivos_test/provaMain.hf", "archivos_test/provaMain.des");
        

        //ma.agregaContenidoArchivo("C:\\Users\\16171024.PORTOALEGRE\\Documents\\salida1.txt",ManejadorGraphviz.getFormatoGraphviz(a));
        System.out.println(ManejadorGraphviz.getFormatoGraphviz(a));
        
        
        
    }
}
