/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import modelo.empleado;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class AdminTest {
    
    public AdminTest() {
    }
    
    @Test
    public void testConcatenacion() {
        empleado e = new empleado("Scott", "Aquino");
        String nombreCompleto = e.nombreCompleto();
    }
    
    @Test
    public void testUsuario() {
        empleado e = new empleado("admin", "admin");
        String usuarioAdmin = e.usuarioAdmin();
    }
    
    @Test
    public void testDatosAdmin() {
        empleado e = new empleado("71443846", "Scott", "Aquino", "Los Olivos", "961810079");
        String datosAdmin = e.datosAdmin();
    }
}
