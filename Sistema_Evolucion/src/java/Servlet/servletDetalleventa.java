/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Conexion.conexion;
import ayuda.ayuditas;
import fecha.Fecha;
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

/**
 *
 * @author VB
 */
@WebServlet(name = "servletDetalleventa", urlPatterns = {"/servletDetalleventa"})
public class servletDetalleventa extends HttpServlet {

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
        
        String accion = request.getParameter("accion");
        Connection cn = new conexion().getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        if(accion.equals("agregar")){
            String dni = request.getParameter("dni");
            int id_producto = Integer.parseInt(request.getParameter("idd_producto"));
            int id_venta = new ayuditas().obtenerIdVenta();
            double cantidad = Double.parseDouble(request.getParameter("cantidad"));
            try {
                pst = cn.prepareCall("insert into detalle_venta values(?,?,?,?)");
                pst.setString(1, null);
                pst.setInt(2, id_venta);
                pst.setInt(3, id_producto);
                pst.setDouble(4, cantidad);
                int r = pst.executeUpdate();
            } catch (Exception e) {}
            
             
            try {
                pst = cn.prepareCall("update producto set cantidad=cantidad-? where id_producto = ?");
                pst.setDouble(1, cantidad);
                pst.setInt(2, id_producto);
                int r = pst.executeUpdate();
            } catch (Exception e) {}
            response.sendRedirect("venta.jsp?id_producto="+id_producto+"&dni="+dni+"&activo=1");

        }
        
        else if(accion.equals("eliminarp")){
            String dni = request.getParameter("dni");
            String codigoP = request.getParameter("codigop");
            double cantidad = 0;
            try {
                pst = cn.prepareCall("select cantidad from producto2 where id_producto = ?");
                pst.setString(1, codigoP);
                rs = pst.executeQuery();
                while(rs.next()){
                    cantidad = rs.getDouble(1);
                }
            } catch (Exception e) {}
            
             
            try {
                pst = cn.prepareCall("update producto set cantidad=? where id_producto = ?");
                pst.setDouble(1, cantidad);
                pst.setString(2, codigoP);
                int r = pst.executeUpdate();
            } catch (Exception e) {}
            
            try {
                pst = cn.prepareCall("delete from detalle_venta where id_producto = ?");
                pst.setString(1, codigoP);
                int r = pst.executeUpdate();
            } catch (Exception e) {}
            response.sendRedirect("venta.jsp?dni="+dni+"&activo=1");

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
            Logger.getLogger(servletDetalleventa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletDetalleventa.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servletDetalleventa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletDetalleventa.class.getName()).log(Level.SEVERE, null, ex);
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
