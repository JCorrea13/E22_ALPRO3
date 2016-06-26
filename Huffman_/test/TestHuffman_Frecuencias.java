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
 * @author alejandro
 */
public class TestHuffman_Frecuencias {
    
    public TestHuffman_Frecuencias() {
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

    /**
     * Este test es de frecuencas repetidas
     * @throws java.io.IOException
     */
    @Test
    public void test1() throws IOException {
        String ruta = "archivos_test//prova.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        
        HashMap<String,AtomicInteger> frecuencias = ManejadorArbol.getFrecuencias(palabra);
        
      
        HashMap esperado = new HashMap();
        esperado.put("a", 5);
        esperado.put("b", 4);
        esperado.put("c", 3);
        esperado.put("d", 1);
        esperado.put("e", 2);
        esperado.put("\n", 3);
        boolean bandera=true;
        for(Map.Entry<String,AtomicInteger>pair: frecuencias.entrySet()){
            if(esperado.containsKey(pair.getKey())){
               if((int)esperado.get(pair.getKey())!=pair.getValue().intValue()){  
                  bandera=false;
               }
            }
            else
                bandera=false;
        }
        assertTrue(bandera); 
    }
    
    @Test
    public void test2() throws IOException {
        String ruta = "archivos_test//prova2.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        
        HashMap<String,AtomicInteger> frecuencias = ManejadorArbol.getFrecuencias(palabra);
        
      
        HashMap esperado = new HashMap();
        esperado.put("a", 3);
        esperado.put("b", 3);
        esperado.put("h", 3);
        esperado.put("g", 3);
        boolean bandera=true;
        for(Map.Entry<String,AtomicInteger>pair: frecuencias.entrySet()){
            if(esperado.containsKey(pair.getKey())){
               if((int)esperado.get(pair.getKey())!=pair.getValue().intValue()){  
                  bandera=false;
               }
            }
            else
                bandera=false;
        }
        assertTrue(bandera); 
    }
    
    @Test
    public void test3() throws IOException {
        String ruta = "archivos_test//prova3.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        
        HashMap<String,AtomicInteger> frecuencias = ManejadorArbol.getFrecuencias(palabra);
        
      
        HashMap esperado = new HashMap();
        esperado.put("a", 20);
        esperado.put("b", 1);
        esperado.put("c", 1);
        esperado.put("d", 1);
        esperado.put("e", 1);
        esperado.put("f", 1);
        boolean bandera=true;
        for(Map.Entry<String,AtomicInteger>pair: frecuencias.entrySet()){
            if(esperado.containsKey(pair.getKey())){
               if((int)esperado.get(pair.getKey())!=pair.getValue().intValue()){  
                  bandera=false;
               }
            }
            else
                bandera=false;
        }
        assertTrue(bandera); 
    }
    
    @Test
    public void test4() throws IOException {
        String ruta = "archivos_test//prova4.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        
        HashMap<String,AtomicInteger> frecuencias = ManejadorArbol.getFrecuencias(palabra);
        
        HashMap esperado = new HashMap();
        esperado.put("a", 2);
        esperado.put("o", 2);
        esperado.put("l", 1);
        esperado.put(" ", 3);
        boolean bandera=true;
        for(Map.Entry<String,AtomicInteger>pair: frecuencias.entrySet()){
            if(esperado.containsKey(pair.getKey())){
               if((int)esperado.get(pair.getKey())!=pair.getValue().intValue()){  
                  bandera=false;
               }
            }
            else
                bandera=false;
        }
        assertTrue(bandera); 
    }
    
    @Test
    public void test5() throws IOException {
        String ruta = "archivos_test//prova5.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        
        HashMap<String,AtomicInteger> frecuencias = ManejadorArbol.getFrecuencias(palabra);
        
      
        HashMap esperado = new HashMap();
       // esperado.put("", 0); o sea, si esperado es vacío
        boolean bandera = true;
        if(esperado.size()!=frecuencias.size())
            bandera=false;
        for(Map.Entry<String,AtomicInteger>pair: frecuencias.entrySet()){
            if(esperado.containsKey(pair.getKey())){
               if((int)esperado.get(pair.getKey())!=pair.getValue().intValue()){  
                  bandera=false;
                  break;
               }
            }
            else{
                bandera=false;
                break;
            }
        }
        assertTrue(bandera); 
    }
}

