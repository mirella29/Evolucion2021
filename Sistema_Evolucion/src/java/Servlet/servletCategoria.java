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
import modelo.categoria;
import modelo.cliente;

/**
 *
 * @author VB
 */
@WebServlet(name = "servletCategoria", urlPatterns = {"/servletCategoria"})
public class servletCategoria extends HttpServlet {

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
        String accion = request.getParameter("accion");
        ResultSet rs;
        Connection cn = new conexion().getConnection();
        if(accion.equals("listar")){
            List<categoria> lista = new ArrayList<>();
            categoria a = null;
            try {
                PreparedStatement pst = cn.prepareStatement("select * from categoria");
                rs = pst.executeQuery();
                while(rs.next()){
                    a = new categoria(rs.getInt(1),rs.getString(2));
                    lista.add(a);
                }                
                
            } catch (Exception e) {
            }
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("listarCategoria.jsp").forward(request, response);
        }
        
        else if(accion.equals("agregar")){
            String categoria = request.getParameter("descripcion");
            try {
                PreparedStatement pst = cn.prepareCall("insert into categoria values(?,?)");
                pst.setString(1, null);
                pst.setString(2, categoria);
                int s = pst.executeUpdate();
            } catch (Exception e) {}request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        else if(accion.equals("editar")){
            String codigo = request.getParameter("codigo");
            String categoria = request.getParameter("descripcion");
            try {
                PreparedStatement pst = cn.prepareCall("update categoria set descripcion_categoria =? where id_categoria =?");
                pst.setString(1, categoria);
                pst.setInt(2, Integer.parseInt(codigo));         
                int s = pst.executeUpdate();
            } catch (Exception e) {}request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        else if(accion.equals("eliminar")){
            
            String cod = request.getParameter("cod");
            try {
                PreparedStatement pst = cn.prepareCall("delete from categoria where id_categoria =?");
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
            Logger.getLogger(servletCategoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletCategoria.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servletCategoria.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletCategoria.class.getName()).log(Level.SEVERE, null, ex);
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
