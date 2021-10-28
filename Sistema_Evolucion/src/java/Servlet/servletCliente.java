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

/**
 *
 * @author VB
 */
@WebServlet(name = "servletCliente", urlPatterns = {"/servletCliente"})
public class servletCliente extends HttpServlet {

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
        
        if(accion.equals("listar") || accion.equals("listart")){
            List<cliente> lista = new ArrayList<>();
            cliente a = null;
            try {
                PreparedStatement pst = cn.prepareStatement("select * from cliente");
                rs = pst.executeQuery();
                while(rs.next()){
                    a = new cliente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6));
                    lista.add(a);
                }                
                
            } catch (Exception e) {
            }
            request.setAttribute("lista", lista);
            if(accion.equals("listar"))request.getRequestDispatcher("listarCliente.jsp").forward(request, response);
            else request.getRequestDispatcher("listarClientet.jsp").forward(request, response);
        }        
        
        
        else if(accion.equals("agregar") || accion.equals("agregart")){
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            try {
                PreparedStatement pst = cn.prepareCall("insert into cliente values(?,?,?,?,?,?)");
                pst.setString(1, null);
                pst.setString(2, dni);
                pst.setString(3, nombre);
                pst.setString(4, apellido);
                pst.setString(5, direccion); 
                pst.setString(6, telefono);
                int s = pst.executeUpdate();
            } catch (Exception e) {}
            if(accion.equals("agregar"))request.getRequestDispatcher("index.jsp").forward(request, response);
            else request.getRequestDispatcher("indext.jsp").forward(request, response);
        }
        
        else if(accion.equals("editar") || accion.equals("editart")){
            String codigo = request.getParameter("codigo");
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            try {
                PreparedStatement pst = cn.prepareCall("update cliente set dni_cli=?,nombre_cli=?,apellido_cli=?,direccion_cli=?,telefono_cli=? where id_cliente=?");
                pst.setString(1, dni);
                pst.setString(2, nombre);
                pst.setString(3, apellido);
                pst.setString(4, direccion);
                pst.setString(5, telefono);
                pst.setInt(6, Integer.parseInt(codigo));         
                int s = pst.executeUpdate();
            } catch (Exception e) {}
            if(accion.equals("editar"))request.getRequestDispatcher("index.jsp").forward(request, response);
            else request.getRequestDispatcher("indext.jsp").forward(request, response);
        }
        
        else if(accion.equals("eliminar")){
            
            String cod = request.getParameter("cod");
            try {
                PreparedStatement pst = cn.prepareCall("delete from cliente where id_cliente=?");
                pst.setInt(1, Integer.parseInt(cod));
                int s = pst.executeUpdate();
            } catch (Exception e) {}request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        else if(accion.equals("buscar") || accion.equals("buscart")){
            String dni = request.getParameter("buscado");   
            List<cliente> lista = new ArrayList<>();
            cliente a = null;
            try {
                PreparedStatement pst = cn.prepareCall("select * from cliente where dni_cli=?");
                pst.setString(1, dni);
                rs = pst.executeQuery();
                while(rs.next()){
                    a = new cliente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6));
                    lista.add(a);
                }                
                
            } catch (Exception e) {
            }
            request.setAttribute("lista", lista);
            if(accion.equals("buscar"))request.getRequestDispatcher("listarCliente.jsp").forward(request, response);
            else request.getRequestDispatcher("listarClientet.jsp").forward(request, response);
        }
        else if(accion.equals("Salir") || accion.equals("Salirt")){
           if(accion.equals("Salir"))request.getRequestDispatcher("index.jsp").forward(request, response);
           else request.getRequestDispatcher("indext.jsp").forward(request, response);
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
            Logger.getLogger(servletCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletCliente.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servletCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletCliente.class.getName()).log(Level.SEVERE, null, ex);
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
