/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Conexion.conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.cliente;
import modelo.empleado;

/**
 *
 * @author VB
 */
@WebServlet(name = "servletEmpleado", urlPatterns = {"/servletEmpleado"})
public class servletEmpleado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String accion = request.getParameter("accion");
        ResultSet rs;
        Connection cn = new conexion().getConnection();
        if(accion.equals("listar")){
            List<empleado> lista = new ArrayList<>();
            empleado a = null;
            try {
                PreparedStatement pst = cn.prepareStatement("select * from empleados");
                rs = pst.executeQuery();
                while(rs.next()){
                    a = new empleado(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9));
                    lista.add(a);
                }                
                
            } catch (Exception e) {
            }
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("listarEmpleado.jsp").forward(request, response);
        }
        
        else if(accion.equals("agregar")){
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            int rango = Integer.parseInt(request.getParameter("rango"));
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            try {
                PreparedStatement pst = cn.prepareCall("insert into empleados values(?,?,?,?,?,?,?,?,?)");
                pst.setString(1, null);
                pst.setString(2, dni);
                pst.setString(3, nombre);
                pst.setString(4, apellido);
                pst.setString(5, direccion); 
                pst.setString(6, telefono);
                pst.setInt(7, rango);
                pst.setString(8, usuario);
                pst.setString(9, password);
                int s = pst.executeUpdate();
            } catch (Exception e) {}request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        else if(accion.equals("editar")){
            String codigo = request.getParameter("codigo");
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            int rango = Integer.parseInt(request.getParameter("rango"));
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            try {
                PreparedStatement pst = cn.prepareCall("update empleados set dni_empleado=?,nombre_empleado=?,apellido_empleado=?,direccion_empleado=?,"
                        + "telefono_empleado=?, rango_empleado=?, usuario_empleado=?, password_empleado=? where id_empleado=?");
                pst.setString(1, dni);
                pst.setString(2, nombre);
                pst.setString(3, apellido);
                pst.setString(4, direccion);
                pst.setString(5, telefono);
                pst.setInt(6, rango);
                pst.setString(7, usuario);
                pst.setString(8, password);
                pst.setInt(9, Integer.parseInt(codigo));         
                int s = pst.executeUpdate();
            } catch (Exception e) {}request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        else if(accion.equals("eliminar")){
            
            String cod = request.getParameter("cod");
            try {
                PreparedStatement pst = cn.prepareCall("delete from empleados where id_empleado=?");
                pst.setInt(1, Integer.parseInt(cod));
                int s = pst.executeUpdate();
            } catch (Exception e) {}request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else if(accion.equals("Salir")){
           request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(servletEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(servletEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
