/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayuda;

import java.util.List;
import modelo.categoria;
import modelo.detalleVenta;
import modelo.producto;
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
public class ayuditasIT {
    
    public ayuditasIT() {
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
     * Test of devolverRango method, of class ayuditas.
//     */
//    @Test
//    public void testDevolverRango() {
//        System.out.println("devolverRango");
//        int a = 0;
//        ayuditas instance = new ayuditas();
//        String expResult = "";
//        String result = instance.devolverRango(a);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of llenarCategoria method, of class ayuditas.
//     */
//    @Test
//    public void testLlenarCategoria() {
//        System.out.println("llenarCategoria");
//        ayuditas instance = new ayuditas();
//        List<categoria> expResult = null;
//        List<categoria> result = instance.llenarCategoria();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of llenarDescripcionCategoria method, of class ayuditas.
//     */
//    @Test
//    public void testLlenarDescripcionCategoria_int() {
//        System.out.println("llenarDescripcionCategoria");
//        int id = 0;
//        ayuditas instance = new ayuditas();
//        String expResult = "";
//        String result = instance.llenarDescripcionCategoria(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of llenarDescripcionCategoria method, of class ayuditas.
//     */
//    @Test
//    public void testLlenarDescripcionCategoria_0args() {
//        System.out.println("llenarDescripcionCategoria");
//        ayuditas instance = new ayuditas();
//        List<categoria> expResult = null;
//        List<categoria> result = instance.llenarDescripcionCategoria();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of llenarClieneEnVenta method, of class ayuditas.
//     */
//    @Test
//    public void testLlenarClieneEnVenta() {
//        System.out.println("llenarClieneEnVenta");
//        String dni = "";
//        ayuditas instance = new ayuditas();
//        List<String> expResult = null;
//        List<String> result = instance.llenarClieneEnVenta(dni);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of llenarDetalleProducto method, of class ayuditas.
//     */
//    @Test
//    public void testLlenarDetalleProducto() {
//        System.out.println("llenarDetalleProducto");
//        String categoria = "";
//        ayuditas instance = new ayuditas();
//        List<producto> expResult = null;
//        List<producto> result = instance.llenarDetalleProducto(categoria);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of llenarDetalleProductoAyuda method, of class ayuditas.
//     */
//    @Test
//    public void testLlenarDetalleProductoAyuda() {
//        System.out.println("llenarDetalleProductoAyuda");
//        String categoria = "";
//        ayuditas instance = new ayuditas();
//        int expResult = 0;
//        int result = instance.llenarDetalleProductoAyuda(categoria);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of obtenerIdCLiente method, of class ayuditas.
//     */
//    @Test
//    public void testObtenerIdCLiente() {
//        System.out.println("obtenerIdCLiente");
//        String dni = "";
//        ayuditas instance = new ayuditas();
//        String expResult = "";
//        String result = instance.obtenerIdCLiente(dni);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of obtenerIdEmpleado method, of class ayuditas.
//     */
//    @Test
//    public void testObtenerIdEmpleado() {
//        System.out.println("obtenerIdEmpleado");
//        String nombre = "";
//        ayuditas instance = new ayuditas();
//        String expResult = "";
//        String result = instance.obtenerIdEmpleado(nombre);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of obtenerIdVenta method, of class ayuditas.
//     */
//    @Test
//    public void testObtenerIdVenta() {
//        System.out.println("obtenerIdVenta");
//        ayuditas instance = new ayuditas();
//        int expResult = 0;
//        int result = instance.obtenerIdVenta();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listarDetalleVenta method, of class ayuditas.
//     */
//    @Test
//    public void testListarDetalleVenta() {
//        System.out.println("listarDetalleVenta");
//        ayuditas instance = new ayuditas();
//        List<detalleVenta> expResult = null;
//        List<detalleVenta> result = instance.listarDetalleVenta();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listarDetalleVentaProducto method, of class ayuditas.
//     */
//    @Test
//    public void testListarDetalleVentaProducto() {
//        System.out.println("listarDetalleVentaProducto");
//        int id_producto = 0;
//        ayuditas instance = new ayuditas();
//        List<producto> expResult = null;
//        List<producto> result = instance.listarDetalleVentaProducto(id_producto);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of Venta method, of class ayuditas.
//     */
//    @Test
//    public void testVenta() {
//        System.out.println("Venta");
//        double total = 0.0;
//        ayuditas instance = new ayuditas();
//        instance.Venta(total);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of copiarTabla method, of class ayuditas.
//     */
//    @Test
//    public void testCopiarTabla() {
//        System.out.println("copiarTabla");
//        ayuditas instance = new ayuditas();
//        instance.copiarTabla();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of copiarTabla2 method, of class ayuditas.
//     */
//    @Test
//    public void testCopiarTabla2() {
//        System.out.println("copiarTabla2");
//        ayuditas instance = new ayuditas();
//        instance.copiarTabla2();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of ObtenerNombreClienteReporte method, of class ayuditas.
//     */
//    @Test
//    public void testObtenerNombreClienteReporte() {
//        System.out.println("ObtenerNombreClienteReporte");
//        String dni = "";
//        ayuditas instance = new ayuditas();
//        String expResult = "";
//        String result = instance.ObtenerNombreClienteReporte(dni);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of ObtenerNombreEmpleadoReporte method, of class ayuditas.
//     */
//    @Test
//    public void testObtenerNombreEmpleadoReporte() {
//        System.out.println("ObtenerNombreEmpleadoReporte");
//        String dni = "";
//        ayuditas instance = new ayuditas();
//        String expResult = "";
//        String result = instance.ObtenerNombreEmpleadoReporte(dni);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of ObtenerNombreProductoReporte method, of class ayuditas.
//     */
//    @Test
//    public void testObtenerNombreProductoReporte() {
//        System.out.println("ObtenerNombreProductoReporte");
//        String dni = "";
//        ayuditas instance = new ayuditas();
//        String expResult = "";
//        String result = instance.ObtenerNombreProductoReporte(dni);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of Year method, of class ayuditas.
//     */
//    @Test
//    public void testYear() {
//        System.out.println("Year");
//        ayuditas instance = new ayuditas();
//        int expResult = 6;
//        int result = instance.Year();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of noDobleDni method, of class ayuditas.
//     */
//    @Test
//    public void testNoDobleDni() {
//        System.out.println("noDobleDni");
//        String dni = "";
//        ayuditas instance = new ayuditas();
//        String expResult = "";
//        String result = instance.noDobleDni(dni);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of noDobleDniEm method, of class ayuditas.
//     */
//    @Test
//    public void testNoDobleDniEm() {
//        System.out.println("noDobleDniEm");
//        String dni = "";
//        ayuditas instance = new ayuditas();
//        String expResult = "";
//        String result = instance.noDobleDniEm(dni);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
