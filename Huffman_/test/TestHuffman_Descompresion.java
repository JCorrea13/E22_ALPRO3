/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import aplicacion.ArbolDeCodificacion;
import aplicacion.ManejadorArbol;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
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
public class TestHuffman_Descompresion {
    
    public TestHuffman_Descompresion() {
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
        String ruta2 = "archivos_test/res1.docx";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        ManejadorArbol.comprime("archivos_test/pp.hf", palabra, codigos);
        ManejadorArbol.descomprime("archivos_test/pp.hf", ruta2);
        String palabra2 = ma.getContenidoArchivo(ruta2);
        //String verdadero="aaaabbbbbb";
        boolean bandera=true;
       if(!palabra2.equals(palabra))
           bandera=false;
        assertTrue(bandera); 
    }
    
     @Test
    public void test2() throws IOException {
        String ruta = "archivos_test/prova2.txt";
        String ruta2 = "archivos_test/res2.docx";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        ManejadorArbol.comprime("archivos_test/pp.hf", palabra, codigos);
        ManejadorArbol.descomprime("archivos_test/pp.hf", ruta2);
        String palabra2 = ma.getContenidoArchivo(ruta2);
        boolean bandera=true;
       if(!palabra2.equals(palabra))
           bandera=false;
        assertTrue(bandera); 
    }
    
    @Test
    public void test3() throws IOException {
        String ruta = "archivos_test/prova3.txt";
        String ruta2 = "archivos_test/res3.docx";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        ManejadorArbol.comprime("archivos_test/pp.hf", palabra, codigos);
        ManejadorArbol.descomprime("archivos_test/pp.hf", ruta2);
        String palabra2 = ma.getContenidoArchivo(ruta2);
        boolean bandera=true;
       if(!palabra2.equals(palabra))
           bandera=false;
        assertTrue(bandera); 
    }
    
    @Test
    public void test4() throws IOException {
        String ruta = "archivos_test/prova4.txt";
        String ruta2 = "archivos_test/res4.docx";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        ManejadorArbol.comprime("archivos_test/pp.hf", palabra, codigos);
        ManejadorArbol.descomprime("archivos_test/pp.hf", ruta2);
        String palabra2 = ma.getContenidoArchivo(ruta2);
        boolean bandera=true;
       if(!palabra2.equals(palabra))
           bandera=false;
        assertTrue(bandera); 
    }
    
     @Test(expected = NoSuchFileException.class)
    public void test5() throws IOException {
        String ruta = "archivos_test/prova5.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        ManejadorArbol.comprime("archivos_test/prova5.hf", palabra, codigos);
        ManejadorArbol.descomprime("archivos_test/prova5.hf", "archivos_test/prova5.des");
        String palabra2 = ma.getContenidoArchivo("archivos_test/prova5.des)");
        boolean bandera=true;
       if(!palabra2.equals(palabra))
           bandera=false;
        assertTrue(bandera); 
    }
}
