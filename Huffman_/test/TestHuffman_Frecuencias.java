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
        String ruta = "C:\\Users\\alejandro\\Documents\\prueba3.txt";
        ManejadorArchivos ma = new ManejadorArchivos();
        String palabra = ma.getContenidoArchivo(ruta);
        
        ArbolDeCodificacion a = ArbolDeCodificacion.getArbolCodificacion(ManejadorArbol.getFrecuencias(palabra));
        HashMap<String, String> codigos = ManejadorArbol.getCodificacion(a);
        ManejadorArbol.muestraMapa(codigos);
        
        HashMap f = ManejadorArbol.getFrecuencias(palabra);
        HashMap esperado = new HashMap();
        //esperado.put(f, f)
        
        assertEquals(f, esperado);
    }
}
