/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import aplicacion.ArbolDeCodificacion;
import aplicacion.ManejadorArbol;
import aplicacion.ManejadorGraphviz;
import java.io.IOException;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.ManejadorArchivos;

/**
 *
 * @author alejandro
 */
public class TestHuffman_Graphviz {
    
    public TestHuffman_Graphviz() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
     @Test
    public void test() throws IOException {
        String ruta = "archivos_test/prova.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        String formato =ManejadorGraphviz.getFormatoGraphviz(a);
        boolean bandera=true;
        String verdadero ="digraph arboreHuffman { \n"
                + " node [shape = circle]; \n"
                + "2[label= \"10\"];\n"
                + "2 -> 0 [ label = \"0\"]; \n"
                + "2 -> 1 [ label = \"1\"]; \n"
                + "1[label= \"b\"];\n"
                + "0[label= \"a\"];\n}";
        
        if(!formato.equals(verdadero))
            bandera=false;
        
        assertTrue(bandera); 
    }
    
         @Test
    public void test2() throws IOException {
        String ruta = "archivos_test/prova2.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        String formato =ManejadorGraphviz.getFormatoGraphviz(a);
        boolean bandera=true;
        String verdadero ="digraph arboreHuffman { \n"
                + " node [shape = circle]; \n"
                + "2[label= \"10\"];\n"
                + "2 -> 0 [ label = \"0\"]; \n"
                + "2 -> 1 [ label = \"1\"]; \n"
                + "1[label= \"b\"];\n"
                + "0[label= \"a\"];\n}";
        
        if(!formato.equals(verdadero))
            bandera=false;
        
        assertTrue(bandera); 
    }
         @Test
    public void test3() throws IOException {
        String ruta = "archivos_test/prova3.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        String formato =ManejadorGraphviz.getFormatoGraphviz(a);
        boolean bandera=true;
        String verdadero ="digraph arboreHuffman { \n"
                + " node [shape = circle]; \n"
                + "2[label= \"10\"];\n"
                + "2 -> 0 [ label = \"0\"]; \n"
                + "2 -> 1 [ label = \"1\"]; \n"
                + "1[label= \"b\"];\n"
                + "0[label= \"a\"];\n}";
        
        if(!formato.equals(verdadero))
            bandera=false;
        
        assertTrue(bandera); 
    }
         @Test
    public void test4() throws IOException {
        String ruta = "archivos_test/prova4.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        String formato =ManejadorGraphviz.getFormatoGraphviz(a);
        boolean bandera=true;
        String verdadero ="digraph arboreHuffman { \n"
                + " node [shape = circle]; \n"
                + "2[label= \"10\"];\n"
                + "2 -> 0 [ label = \"0\"]; \n"
                + "2 -> 1 [ label = \"1\"]; \n"
                + "1[label= \"b\"];\n"
                + "0[label= \"a\"];\n}";
        
        if(!formato.equals(verdadero))
            bandera=false;
        
        assertTrue(bandera); 
    }
         @Test
    public void test5() throws IOException {
        String ruta = "archivos_test/prova5.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        String formato =ManejadorGraphviz.getFormatoGraphviz(a);
        boolean bandera=true;
        String verdadero ="digraph arboreHuffman { \n"
                + " node [shape = circle]; \n"
                + "2[label= \"10\"];\n"
                + "2 -> 0 [ label = \"0\"]; \n"
                + "2 -> 1 [ label = \"1\"]; \n"
                + "1[label= \"b\"];\n"
                + "0[label= \"a\"];\n}";
        
        if(!formato.equals(verdadero))
            bandera=false;
        
        assertTrue(bandera); 
    }
}
