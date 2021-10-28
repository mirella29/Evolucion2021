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
import modelo.detalleVenta;
import modelo.venta;

/**
 *
 * @author VB
 */
@WebServlet(name = "servletReporte", urlPatterns = {"/servletReporte"})
public class servletReporte extends HttpServlet {

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
        if(accion.equals("Enviar")){
            String fecha = request.getParameter("fecha");
            List<venta> lista = new ArrayList<>();
            venta v = null;
            try {
                pst = cn.prepareCall("select * from venta where fecha=?");
                pst.setString(1, fecha);
                rs = pst.executeQuery();
                while (rs.next()) {                
                    v = new venta(rs.getInt(1), rs.getInt(2), rs.getInt(3), fecha, rs.getDouble(5));
                    lista.add(v);
                }
            } catch (Exception e) {}
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("rdia.jsp").forward(request, response);
        }
        
        if(accion.equals("Ver Detalle De Factura")){
            String id = request.getParameter("id");
            List<detalleVenta> listaa = new ArrayList<>();
            detalleVenta dv = null;
            try {
                pst = cn.prepareCall("select * from detalle_venta where id_venta=?");
                pst.setString(1, id);
                rs = pst.executeQuery();
                while (rs.next()) {                
                    dv = new detalleVenta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4));
                    listaa.add(dv);
                }
            } catch (Exception e) {}
            request.setAttribute("listaDV", listaa);
            
            List<venta> lista = new ArrayList<>();
            venta v = null;
            try {
                pst = cn.prepareCall("select * from venta where id_venta=?");
                pst.setString(1, id);
                rs = pst.executeQuery();
                while (rs.next()) {                
                    v = new venta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(5));
                    lista.add(v);
                }
            } catch (Exception e) {}
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("rdia.jsp").forward(request, response);
        }
        
        if(accion.equals("EnviarMes")){
            String fecha = request.getParameter("fecha");
            List<venta> lista = new ArrayList<>();
            venta v = null;
            try {
                pst = cn.prepareCall("select * from venta where fecha like '%"+fecha+"%'");
                rs = pst.executeQuery();
                while (rs.next()) {                
                    v = new venta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(5));
                    lista.add(v);
                }
            } catch (Exception e) {}
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("rmes.jsp").forward(request, response);
        }
        
        if(accion.equals("Ver Detalle De Factura Mes")){
            String id = request.getParameter("id");
            List<detalleVenta> listaa = new ArrayList<>();
            detalleVenta dv = null;
            try {
                pst = cn.prepareCall("select * from detalle_venta where id_venta=?");
                pst.setString(1, id);
                rs = pst.executeQuery();
                while (rs.next()) {                
                    dv = new detalleVenta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4));
                    listaa.add(dv);
                }
            } catch (Exception e) {}
            request.setAttribute("listaDV", listaa);
            
            List<venta> lista = new ArrayList<>();
            venta v = null;
            try {
                pst = cn.prepareCall("select * from venta where id_venta=?");
                pst.setString(1, id);
                rs = pst.executeQuery();
                while (rs.next()) {                
                    v = new venta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(5));
                    lista.add(v);
                }
            } catch (Exception e) {}
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("rmes.jsp").forward(request, response);
        }
        
        if(accion.equals("EnviarYear")){
            String fecha = request.getParameter("fecha");
            List<venta> lista = new ArrayList<>();
            venta v = null;
            try {
                pst = cn.prepareCall("select * from venta where fecha like '%"+fecha+"%'");
                rs = pst.executeQuery();
                while (rs.next()) {                
                    v = new venta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(5));
                    lista.add(v);
                }
            } catch (Exception e) {}
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("ryear.jsp").forward(request, response);
        }
        
        if(accion.equals("Ver Detalle De Factura Year")){
            String id = request.getParameter("id");
            List<detalleVenta> listaa = new ArrayList<>();
            detalleVenta dv = null;
            try {
                pst = cn.prepareCall("select * from detalle_venta where id_venta=?");
                pst.setString(1, id);
                rs = pst.executeQuery();
                while (rs.next()) {                
                    dv = new detalleVenta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4));
                    listaa.add(dv);
                }
            } catch (Exception e) {}
            request.setAttribute("listaDVY", listaa);
            
            List<venta> lista = new ArrayList<>();
            venta v = null;
            try {
                pst = cn.prepareCall("select * from venta where id_venta=?");
                pst.setString(1, id);
                rs = pst.executeQuery();
                while (rs.next()) {                
                    v = new venta(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(5));
                    lista.add(v);
                }
            } catch (Exception e) {}
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("ryear.jsp").forward(request, response);
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
            Logger.getLogger(servletReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletReporte.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servletReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletReporte.class.getName()).log(Level.SEVERE, null, ex);
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
