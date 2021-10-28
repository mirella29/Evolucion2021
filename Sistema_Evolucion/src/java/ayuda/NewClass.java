/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayuda;

import Conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.producto;

/**
 *
 * @author VB
 */
public class NewClass {
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
}
