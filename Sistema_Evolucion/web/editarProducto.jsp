<%-- 
    Document   : listar
    Created on : 18-jun-2020, 16:56:06
    Author     : VB
--%>

<%@page import="ayuda.ayuditas"%>
<%@page import="modelo.categoria"%>
<%@page import="modelo.producto"%>
<%@page import="modelo.cliente"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="Conexion.conexion"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%
    String codigo = request.getParameter("cod");
            producto a = null;
            try {
                Connection cn = new conexion().getConnection();
                PreparedStatement pst = cn.prepareStatement("select * from producto where id_producto=?");
                pst.setString(1, codigo);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    a = new producto(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5),rs.getInt(6));
                   
                }                
                
            } catch (Exception e) {
            }
            
 List<categoria> lista = new ayuditas().llenarCategoria();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
    function numeros(e){
    key = e.keyCode || e.which;
    teclado = String.fromCharCode(key);
    numero = "0123456789";
    if (numero.indexOf(teclado) == -1) return false; 
    }

    function letras(e) {
        key = e.keyCode || e.which;
        teclado1 = String.fromCharCode(key).toLowerCase(); //convertir a minusculas
        letra = "abcdefghijklmnñopqrstuvwxyz ";
        if (letra.indexOf(teclado1) == -1)  return false;
    }
</script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <form action="servletProducto" method="GET">
                        <div class="form-group">
                            <h2>INGRESE DATOS</h2>
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" name="nombre" class="form-control" id="nombre" value="<%=a.getNombre()%> " onkeypress="return letras(event)" required="">
                        </div>
                        <div class="form-group">
                            <label for="precioc">Precio Compra</label>                        
                            <input type="text" name="precioc" class="form-control" id="precioc" value="<%=a.getPrecioc()%>" onkeypress="return numeros(event)" required=""/>
                        </div>
                        <div class="form-group">
                            <label for="preciov">Precio Venta</label>                        
                            <input type="text" name="preciov" class="form-control" id="preciov" value="<%=a.getPreciov()%>" onkeypress="return numeros(event)" required=""/>
                        </div>
                        <div class="form-group">
                            <label for="cantidad">Cantidad</label>                        
                            <input type="number" name="cantidad" class="form-control" id="cantidad" value="<%=a.getCantidad()%>" onkeypress="return numeros(event)" required="" maxlength="4"/>
                        </div>
                        <div class="form-group">
                            <label for="cantidad">Categoria</label>                        
                                <select name="categoria">
                                    <%
                                        for (int i = 0; i < lista.size(); i++) {%>
                                          <option value="<%=lista.get(i).getId()%>"><%=lista.get(i).getDescripcion()%></option>      
                                        <%}
                                    %>
                                </select>

                        </div>
                        <input type="submit" value="Procesar" class="btn btn-primary"/> 
                        <input type="hidden" name="accion" value="editar">
                        <input type="submit" value="Salir" class="btn btn-primary"/>
                        <input type="hidden" name="codigo" value="<%=a.getId()%>">

            </form>
        </div>            
    </body>
</html>
