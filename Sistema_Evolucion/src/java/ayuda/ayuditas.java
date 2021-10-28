/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayuda;

import Conexion.conexion;
import fecha.Fecha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.categoria;
import modelo.cliente;
import modelo.detalleVenta;
import modelo.producto;

/**
 *
 * @author VB
 */
public class ayuditas {
    public String devolverRango(int a){
        if(a == 0) return "ADMINISTRADOR";
        else return "VENDEDOR(A)";
    }
    
    public List<categoria> llenarCategoria(){
        List<categoria> lista = new ArrayList<>();
        
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select * from categoria");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                categoria a = new categoria(rs.getInt(1), rs.getString(2));
                lista.add(a);
            }
            
        } catch (Exception e) {}
        
        return lista;
    }
    
    public String llenarDescripcionCategoria(int id){
        String descripcion = "";
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select descripcion_categoria from categoria where id_categoria=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                descripcion = rs.getString(1);
            }
            
        } catch (Exception e) {}
        
        return descripcion;
    }
    
    public List<categoria>  llenarDescripcionCategoria(){
        List<categoria> lista = new ArrayList<>();
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select * from categoria");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
               categoria a = new categoria(rs.getInt(1), rs.getString(2));
               lista.add(a);
            }
            
        } catch (Exception e) {}
        
        return lista;
    }
    
    public List<String> llenarClieneEnVenta(String dni){
        List<String> lista = new ArrayList<>();
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select id_cliente,nombre_cli,apellido_cli from cliente where dni_cli=?");
            pst.setString(1, dni);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                lista.add(rs.getString(1));
                String nombre = rs.getString(2)+" "+rs.getString(3);
                lista.add(nombre);
            }
            
        } catch (Exception e) {}
        
        return lista;
    }
    
    
    public List<producto> llenarDetalleProducto(String categoria){
        List<producto> lista = new ArrayList<>();
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select id_producto,nombre_producto,precio_venta,cantidad from producto where id_producto=?");
            pst.setString(1, categoria);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                producto a = new producto(rs.getInt(1), rs.getString(2), 0 , rs.getDouble(3), rs.getDouble(4), 0);
                lista.add(a);
            }
            
        } catch (Exception e) {}
        
        return lista;
    }
    
    public int llenarDetalleProductoAyuda(String categoria){
        List<producto> lista = new ArrayList<>();
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select id_producto,nombre_producto,precio_venta,cantidad from producto where id_producto=?");
            pst.setString(1, categoria);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                producto a = new producto(rs.getInt(1), rs.getString(2), 0 , rs.getDouble(3), rs.getDouble(4), 0);
                lista.add(a);
            }
            
        } catch (Exception e) {}
        
        if(lista.size()!= 0)return lista.size();
        else return 0;
    }
    
    public String obtenerIdCLiente(String dni){
        String id = "";
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select id_cliente from cliente where dni_cli=?");
            pst.setString(1, dni);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                id = rs.getString(1);
            }
            
        } catch (Exception e) {}
        
        return id;
    }
    
    public String obtenerIdEmpleado(String nombre){
        String id = "";
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select id_empleado from empleados where nombre_empleado=?");
            pst.setString(1, nombre);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                id = rs.getString(1);
            }
            
        } catch (Exception e) {}
        
        return id;
    }
    
    public int obtenerIdVenta(){
        int id = -1;
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select id_venta from venta order by id_venta desc limit 1");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
            }
            
        } catch (Exception e) {}
        
        return id;
    }
    
    public List<detalleVenta> listarDetalleVenta(){
        int id_venta = obtenerIdVenta();
        List<detalleVenta> lista = new ArrayList<>();
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select * from detalle_venta where id_venta=?");
            pst.setInt(1, id_venta);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                detalleVenta a = new detalleVenta(rs.getInt(1), rs.getInt(2),rs.getInt(3), rs.getDouble(4));
                lista.add(a);
            }
            
        } catch (Exception e) {}
        
        return lista;
    }
    
    public List<producto> listarDetalleVentaProducto(int id_producto){
        List<producto> lista = new ArrayList<>();
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select * from producto where id_producto=?");
            pst.setInt(1, id_producto);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                producto a = new producto(rs.getInt(1), rs.getString(2),rs.getDouble(3), rs.getDouble(4),rs.getDouble(5),rs.getInt(6));
                lista.add(a);
            }
            
        } catch (Exception e) {}
        
        return lista;
    }
    
    public void Venta(double total){
         int id_venta = obtenerIdVenta();
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("update venta set total=? where id_venta=?");
            pst.setDouble(1, total);
            pst.setInt(2, id_venta);
            int r = pst.executeUpdate();
            
        } catch (Exception e) {}
    }
    
    public void copiarTabla(){
        int cantProductos = 0;
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select * from producto ");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                cantProductos ++;
            }
            
        } catch (Exception e) {}
        
        List<producto> lista = new ArrayList<>();
        int contador = 0;
           try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select id_producto,cantidad from producto");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                producto pro = new producto(rs.getInt(1), "", 0, 0, rs.getDouble(2), 0);
                lista.add(pro);
            }
            
            } catch (Exception e) {} 
         
        for (int i = 0; i < cantProductos; i++) {
            try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("update producto2 set cantidad=? where id_producto=?");
            pst.setDouble(1, lista.get(i).getCantidad());
            pst.setInt(2, lista.get(i).getId());
            int t = pst.executeUpdate();
            
            } catch (Exception e) {} 
        }
        
    }
    
    public void copiarTabla2(){
        int cantProductos = 0;
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select * from producto2 ");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                cantProductos ++;
            }
            
        } catch (Exception e) {}
        
        List<producto> lista = new ArrayList<>();
        int contador = 0;
           try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select id_producto,cantidad from producto2");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                producto pro = new producto(rs.getInt(1), "", 0, 0, rs.getDouble(2), 0);
                lista.add(pro);
            }
            
            } catch (Exception e) {} 
           
        for (int i = 0; i < cantProductos; i++) {
            try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("update producto set cantidad=? where id_producto=?");
            pst.setDouble(1, lista.get(i).getCantidad());
            pst.setInt(2, lista.get(i).getId());
            int t = pst.executeUpdate();
            
            } catch (Exception e) {} 
        }
        
        int id_venta = obtenerIdVenta();
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("delete from venta where id_venta=?");
            pst.setInt(1, id_venta);
            int r = pst.executeUpdate();
            
        } catch (Exception e) {}
        
    }
    
    public String ObtenerNombreClienteReporte(String dni){
        String nombre = "";
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select nombre_cli,apellido_cli from cliente where id_cliente=?");
            pst.setString(1, dni);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){                
                nombre = rs.getString(1)+" "+rs.getString(2);                
            }
            
        } catch (Exception e) {}
        
        return nombre;
    }
    
    public String ObtenerNombreEmpleadoReporte(String dni){
        String nombre = "";
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select nombre_empleado,apellido_empleado from empleados where id_empleado=?");
            pst.setString(1, dni);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){                
                nombre = rs.getString(1)+" "+rs.getString(2);                
            }
            
        } catch (Exception e) {}
        
        return nombre;
    }
    
    public String ObtenerNombreProductoReporte(String dni){
        String nombre = "";
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select nombre_producto from producto where id_producto=?");
            pst.setString(1, dni);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){                
                nombre = rs.getString(1);                
            }
            
        } catch (Exception e) {}
        
        return nombre;
    }
    
    public List<Integer> Year(){
        List<Integer> lista = new ArrayList<>();
        String fecha = new Fecha().getDate();
        String msg = "";
        
        for (int i = 0; i < 4; i++) {
            msg += String.valueOf(fecha.charAt(i));
        }
        System.out.println(msg);
        int xxd = Integer.parseInt(msg);
        for (int i = xxd-5; i != xxd; i++) {
            lista.add(i);
        }
        lista.add(xxd);
        
        return lista;
    }
    
    public String noDobleDni(String dni){
        String id = "";
        int cont = 0;
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select * from cliente where dni_cli=?");
            pst.setString(1, dni);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                cont++;
            }
            
        } catch (Exception e) {}
        if(cont != 0) id = "El cliente ya esta registrado";
        return id;
    }
    
    public String noDobleDniEm(String dni){
        String id = "";
        int cont = 0;
        try {
            Connection cn = new conexion().getConnection(); 
            PreparedStatement pst = cn.prepareCall("select * from empleados where dni_empleado=?");
            pst.setString(1, dni);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                cont++;
            }
            
        } catch (Exception e) {}
        if(cont != 0) id = "El Trabajador ya esta registrado";
        return id;
    }
}

