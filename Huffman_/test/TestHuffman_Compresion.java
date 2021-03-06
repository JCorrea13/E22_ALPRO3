/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import aplicacion.ArbolDeCodificacion;
import aplicacion.ManejadorArbol;
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
 * @author 16171002
 */
public class TestHuffman_Compresion {
    
    public TestHuffman_Compresion() {
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
        ManejadorArbol.comprime("archivos_test/prova.hf", palabra, codigos);
        String palabra2 = ma.getContenidoArchivo("archivos_test/prova.hf");
        String verdadero="abcd e\n" +"U�_�F\"";
        boolean bandera=true;
       if(!palabra2.equals(verdadero))
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
        ManejadorArbol.comprime("archivos_test/prova2.hf", palabra, codigos);
        String palabra2 = ma.getContenidoArchivo("archivos_test/prova2.hf");
        String verdadero="a bgh��W";
        boolean bandera=true;
       if(!palabra2.equals(verdadero))
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
        ManejadorArbol.comprime("archivos_test/prova3.hf", palabra, codigos);
        String palabra2 = ma.getContenidoArchivo("archivos_test/prova3.hf");
        String verdadero="abcd ef��o*";
        boolean bandera=true;
       if(!palabra2.equals(verdadero))
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
        ManejadorArbol.comprime("archivos_test/prova4.hf", palabra, codigos);
        String palabra2 = ma.getContenidoArchivo("archivos_test/prova4.hf");
        String verdadero=" al o�z";
        boolean bandera=true;
       if(!palabra2.equals(verdadero))
           bandera=false;
        assertTrue(bandera); 
    }
    
    @Test(expected = Exception.class)
    public  void ExpectedExceptiontest5() throws IOException {
        String ruta = "archivos_test/prova5.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        ManejadorArbol.comprime("archivos_test/prova5.hf", palabra, codigos);
        String palabra2 = ma.getContenidoArchivo("archivos_test/prova5.hf");
        String verdadero=" ";
        boolean bandera=true;
       if(!palabra2.equals(verdadero))
           bandera=false;
    }
}
