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
import modelo.producto;

/**
 *
 * @author VB
 */
@WebServlet(name = "servletProducto", urlPatterns = {"/servletProducto"})
public class servletProducto extends HttpServlet {

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
        ResultSet rs;
        Connection cn = new conexion().getConnection();
        if(accion.equals("listar") || accion.equals("listart")){
            List<producto> lista = new ArrayList<>();
            producto a = null;
            try {
                PreparedStatement pst = cn.prepareStatement("select * from producto");
                rs = pst.executeQuery();
                while(rs.next()){
                    a = new producto(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getDouble(4), rs.getDouble(5), rs.getInt(6));
                    lista.add(a);
                }                
                
            } catch (Exception e) {
            }
            request.setAttribute("lista", lista);
            if(accion.equals("listar"))request.getRequestDispatcher("listarProducto.jsp").forward(request, response);
            else request.getRequestDispatcher("listarProductot.jsp").forward(request, response);
        }
        
        else if(accion.equals("agregar")){
            String nombre = request.getParameter("nombre");
            double precioc = Double.parseDouble(request.getParameter("precioc"));
            double preciov = Double.parseDouble(request.getParameter("preciov"));
            double cantidad = Double.parseDouble(request.getParameter("cantidad"));
            int id_categoria = Integer.parseInt(request.getParameter("categoria"));
            try {
                PreparedStatement pst = cn.prepareCall("insert into producto values(?,?,?,?,?,?)");
                pst.setString(1, null);
                pst.setString(2, nombre);
                pst.setDouble(3, precioc);
                pst.setDouble(4, preciov);
                pst.setDouble(5, cantidad); 
                pst.setInt(6, id_categoria);
                int s = pst.executeUpdate();
            } catch (Exception e) {}
            int codigo = 0;
            try {
                PreparedStatement pst = cn.prepareCall("select * from producto order by id_producto desc limit 1");
                rs = pst.executeQuery();
                while(rs.next()){
                    codigo = rs.getInt(1);
                }
            } catch (Exception e) {}
            try {
                PreparedStatement pst = cn.prepareCall("insert into producto2 values(?,?,?,?,?,?)");
                pst.setInt(1, codigo);
                pst.setString(2, nombre);
                pst.setDouble(3, precioc);
                pst.setDouble(4, preciov);
                pst.setDouble(5, cantidad); 
                pst.setInt(6, id_categoria);
                int s = pst.executeUpdate();
            } catch (Exception e) {}request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        else if(accion.equals("editar")){
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            double precioc = Double.parseDouble(request.getParameter("precioc"));
            double preciov = Double.parseDouble(request.getParameter("preciov"));
            double cantidad = Double.parseDouble(request.getParameter("cantidad"));
            int id_categoria = Integer.parseInt(request.getParameter("categoria"));
            try {
                PreparedStatement pst = cn.prepareCall("update producto set nombre_producto=?,precio_compra=?,precio_venta=?,cantidad=?,id_categoria=? where id_producto=?");
                pst.setString(1, nombre);
                pst.setDouble(2, precioc);
                pst.setDouble(3, preciov);
                pst.setDouble(4, cantidad);
                pst.setInt(5, id_categoria);
                pst.setInt(6, Integer.parseInt(codigo));         
                int s = pst.executeUpdate();
            } catch (Exception e) {}
            try {
                PreparedStatement pst = cn.prepareCall("update producto2 set nombre_producto=?,precio_compra=?,precio_venta=?,cantidad=?,id_categoria=? where id_producto=?");
                pst.setString(1, nombre);
                pst.setDouble(2, precioc);
                pst.setDouble(3, preciov);
                pst.setDouble(4, cantidad);
                pst.setInt(5, id_categoria);
                pst.setInt(6, Integer.parseInt(codigo));         
                int s = pst.executeUpdate();
            } catch (Exception e) {}request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        else if(accion.equals("eliminar")){
            
            String cod = request.getParameter("cod");
            try {
                PreparedStatement pst = cn.prepareCall("delete from producto where id_producto=?");
                pst.setInt(1, Integer.parseInt(cod));
                int s = pst.executeUpdate();
            } catch (Exception e) {}
            try {
                PreparedStatement pst = cn.prepareCall("delete from producto2 where id_producto=?");
                pst.setInt(1, Integer.parseInt(cod));
                int s = pst.executeUpdate();
            } catch (Exception e) {}request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        else if(accion.equals("buscar") || accion.equals("buscart")){
            String nombre = request.getParameter("buscado");   
            List<producto> lista = new ArrayList<>();
            producto a = null;
            try {
                PreparedStatement pst = cn.prepareCall("select * from producto where nombre_producto like '%"+nombre+"%'");
                rs = pst.executeQuery();
                while(rs.next()){
                    a = new producto(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getDouble(4), rs.getDouble(5), rs.getInt(6));
                    lista.add(a);
                }                
                
            } catch (Exception e) {
            }
            request.setAttribute("lista", lista);
            if(accion.equals("buscar"))request.getRequestDispatcher("listarProducto.jsp").forward(request, response);
            else request.getRequestDispatcher("listarProductot.jsp").forward(request, response);
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
            Logger.getLogger(servletProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletProducto.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servletProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servletProducto.class.getName()).log(Level.SEVERE, null, ex);
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
