
package aplicacion;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import util.ManejadorArchivos;

/**
 * @author Jose Corra
 * @author Alejandro Romero
 */
public class Main {

    /**
     * Este é o metodo principal da aplicação, o que faz e comprimir e descomprimir
     * o arquivo, ao mismo tempo cria o arquivo comprimido (.hf) e o arquivo com o 
     * cogigo de Grapviz (.gv) no diretorio do arquivo comprimido.
     * 
     * @param args o primer String do array é a ruta do arquivo que se quer comprimir
     * @throws IOException posivel exception por falla na apertur do arquivo
     */
    public static void main(String[] args) throws IOException {
        
        //Criação do objeto para criar as rutas de tudos os arquivos
        File f = new File((args.length > 0)?args[0]:"archivos_test/prova.txt");

        //Criação das rutas de tudos os arquivos
        String rutaHf = (f.getPath().replace(f.getPath().substring(f.getPath().indexOf(".")), ".hf"));
        String rutaDes = (f.getPath().replace(f.getPath().substring(f.getPath().indexOf(".")), ".des"));
        String rutaGv = (f.getPath().replace(f.getPath().substring(f.getPath().indexOf(".")), ".gv"));
        
        //Leitura do arquivo
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(f.getCanonicalPath());
        
        //Obtenção de Arvore de Huffman y Codificações
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        
        //Comressão y Descompressão do arquivo
        ManejadorArbol.comprime(rutaHf, palabra, codigos);
        ManejadorArbol.descomprime(rutaHf, rutaDes);
        
        //Se cria o arquivo com codigo Graphviz
        ma.setContenidoArchivo(rutaGv,ManejadorGraphviz.getFormatoGraphviz(a));
    }
}
