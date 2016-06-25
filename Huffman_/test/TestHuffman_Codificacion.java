/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import aplicacion.ArbolDeCodificacion;
import aplicacion.ManejadorArbol;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
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
public class TestHuffman_Codificacion {
    
    public TestHuffman_Codificacion() {
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
    public void test1() throws IOException {
      String ruta = "archivos_test/prova.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        
         HashMap esperado = new HashMap();
         LinkedList<String> lista = new LinkedList<String>();
         boolean bandera=true;
         
         for (Map.Entry<String,String> pair : codigos.entrySet()) {
             if(!lista.contains(pair.getValue()))
                 lista.add(pair.getValue());
             else
                 bandera=false;     
        }
        assertTrue(bandera); 
         
    }
    
    @Test
    public void test2() throws IOException {
      String ruta = "archivos_test/prova2.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        
         HashMap esperado = new HashMap();
         LinkedList<String> lista = new LinkedList<String>();
         boolean bandera=true;
         
         for (Map.Entry<String,String> pair : codigos.entrySet()) {
             if(!lista.contains(pair.getValue()))
                 lista.add(pair.getValue());
             else
                 bandera=false;     
        }
        assertTrue(bandera); 
         
    }
    
    @Test
    public void test3() throws IOException {
      String ruta = "archivos_test/prova3.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        
         HashMap esperado = new HashMap();
         LinkedList<String> lista = new LinkedList<String>();
         boolean bandera=true;
         
         for (Map.Entry<String,String> pair : codigos.entrySet()) {
             if(!lista.contains(pair.getValue()))
                 lista.add(pair.getValue());
             else
                 bandera=false;     
        }
        assertTrue(bandera); 
         
    }
    
    @Test
    public void test4() throws IOException {
      String ruta = "archivos_test/prova4.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        
         HashMap esperado = new HashMap();
         LinkedList<String> lista = new LinkedList<String>();
         boolean bandera=true;
         
         for (Map.Entry<String,String> pair : codigos.entrySet()) {
             if(!lista.contains(pair.getValue()))
                 lista.add(pair.getValue());
             else
                 bandera=false;     
        }
        assertTrue(bandera); 
         
    }
    
    @Test
    public void test5() throws IOException {
      String ruta = "archivos_test/prova5.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        
         LinkedList<String> lista = new LinkedList<String>();
         boolean bandera=true; 
        if (codigos != null) {
            if (codigos.isEmpty()) {
                bandera = true;
            }

            for (Map.Entry<String, String> pair : codigos.entrySet()) {
                if (!lista.contains(pair.getValue())) {
                    lista.add(pair.getValue());
                } else {
                    bandera = false;
                }
            }
        }
        assertTrue(bandera); 
         
    }
}