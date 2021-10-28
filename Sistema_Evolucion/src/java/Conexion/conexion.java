/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexion {
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection cn=null;
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/modateens";
        String user="root";
        String pass="";
        Class.forName(driver);
        cn = DriverManager.getConnection(url,user,pass);        
        if(cn!=null)System.out.println("Conexion Exitosa");
        else System.out.println("No se pudo Conectar");
        return cn;
    }
    
    
    
}
