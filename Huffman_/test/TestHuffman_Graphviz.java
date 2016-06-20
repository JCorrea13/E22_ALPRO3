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
        String formato =ManejadorGraphviz.getFormatoGraphviz(a);
        boolean bandera=true;
        String verdadero ="digraph arboreHuffman { \n"
                         +  " node [shape = circle]; \n"
                         +   "6[label= \"12\"];\n"
                         +   "6 -> 4 [ label = \"0\"]; \n"
                         +   "6 -> 5 [ label = \"1\"]; \n"
                         +   "5[label= \"6\"];\n"
                         +   "5 -> 2 [ label = \"0\"]; \n"
                         +   "5 -> 3 [ label = \"1\"]; \n"
                         +   "3[label= \"h\"];\n"
                         +   "2[label= \"g\"];\n"
                         +   "4[label= \"6\"];\n"
                         +   "4 -> 0 [ label = \"0\"]; \n"
                         +   "4 -> 1 [ label = \"1\"]; \n"
                         +   "1[label= \"b\"];\n"
                         +   "0[label= \"a\"];\n"
                         +   "}";
        
        
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
                           + "10[label= \"25\"];\n"
                           + "10 -> 9 [ label = \"0\"]; \n"
                           + "10 -> 0 [ label = \"1\"]; \n"
                           + "0[label= \"a\"];\n"
                           + "9[label= \"5\"];\n"
                           + "9 -> 7 [ label = \"0\"]; \n"
                           + "9 -> 8 [ label = \"1\"]; \n"
                           + "8[label= \"3\"];\n"
                           + "8 -> 5 [ label = \"0\"]; \n"
                           + "8 -> 6 [ label = \"1\"]; \n"
                           + "6[label= \"2\"];\n"
                           + "6 -> 1 [ label = \"0\"]; \n"
                           + "6 -> 2 [ label = \"1\"]; \n"
                           + "2[label= \"c\"];\n"
                           + "1[label= \"b\"];\n"
                           + "5[label= \"f\"];\n"
                           + "7[label= \"2\"];\n"
                           + "7 -> 3 [ label = \"0\"]; \n"
                           + "7 -> 4 [ label = \"1\"]; \n"
                           + "4[label= \"e\"];\n"
                           + "3[label= \"d\"];\n}";
        
    
        
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
        String verdadero =      "digraph arboreHuffman { \n"
                                  +" node [shape = circle]; \n" 
                                   +"6[label= \"8\"];\n"
                                   +"6 -> 4 [ label = \"0\"]; \n"
                                   +"6 -> 5 [ label = \"1\"]; \n"
                                   +"5[label= \"5\"];\n"
                                   +"5 -> 3 [ label = \"0\"]; \n"
                                   +"5 -> 0 [ label = \"1\"]; \n"
                                   +"0[label= \" \"];\n"
                                   +"3[label= \"o\"];\n"
                                   +"4[label= \"3\"];\n"
                                   +"4 -> 2 [ label = \"0\"]; \n"
                                   +"4 -> 1 [ label = \"1\"]; \n"
                                   +"1[label= \"a\"];\n"
                                   +"2[label= \"l\"];\n"
                                   +"}";
        
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
        String verdadero ="digraph arboreHuffman { \n node [shape = circle]; \n}";
        
        if(!formato.equals(verdadero))
            bandera=false;
        
        assertTrue(bandera); 
    }
}
