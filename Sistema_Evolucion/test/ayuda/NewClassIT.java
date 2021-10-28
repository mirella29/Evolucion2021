/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayuda;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author VB
 */
public class NewClassIT {
    
    public NewClassIT() {
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
     * Test of llenarDetalleProductoAyuda method, of class NewClass.
     */
//    @Test
//    public void testLlenarDetalleProductoAyuda() {
//        System.out.println("llenarDetalleProductoAyuda");
//        String categoria = "";
//        NewClass instance = new NewClass();
//        int expResult = 0;
//        int result = instance.llenarDetalleProductoAyuda(categoria);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of obtenerIdCLiente method, of class NewClass.
     */
    @Test
    public void testObtenerIdCLiente() {
        System.out.println("obtenerIdCLiente");
        String dni = "73357492";
        NewClass instance = new NewClass();
        String expResult = "1";
        String result = instance.obtenerIdCLiente(dni);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
