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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author VB
 */
@WebServlet(name = "servletLogin", urlPatterns = {"/servletLogin"})
public class servletLogin extends HttpServlet {

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
        Connection cn = new conexion().getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        if(accion.equals("Enviar")){
            String nombre = "";
            int rango = 3;
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            HttpSession session_usuario = request.getSession();
            
            try {
                pst = cn.prepareCall("select nombre_empleado,rango_empleado from empleados where usuario_empleado=? and password_empleado=?");
                pst.setString(1, usuario);
                pst.setString(2, password);
                rs = pst.executeQuery();
                while (rs.next()) {                
                    nombre = rs.getString(1);
                    rango = rs.getInt(2);
                }
            } catch (Exception e) {}
            int intentos = 3;
            if(request.getParameter("intentos") != null){
                intentos = Integer.parseInt(request.getParameter("intentos"));
            }
            session_usuario.setAttribute("usuario", nombre);
            session_usuario.setAttribute("rango", rango);
            if(!nombre.equals("") && rango == 0)response.sendRedirect("index.jsp");
            else if(!nombre.equals("") && rango == 1)response.sendRedirect("indext.jsp");
            else{
                intentos--;
                response.sendRedirect("login.jsp?msg=Datos incorrectos&intentos="+intentos);
            }
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
            Logger.getLogger(servletLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletLogin.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servletLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletLogin.class.getName()).log(Level.SEVERE, null, ex);
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
