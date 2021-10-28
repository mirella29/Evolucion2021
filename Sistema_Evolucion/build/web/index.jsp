<%-- 
    Document   : index
    Created on : 18-jun-2020, 17:04:05
    Author     : VB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link >
        <title>JSP Page</title>
    </head>
    <style>  
        body{
            margin: auto;
            background-image: url(imagenes/fondo2.jpg);
            -o-background-size: cover;
            background-size: cover;
        }
        .imagen{
            margin: auto;
            padding: 24px;
            text-align: center;
        }
        .xd{
            padding: 10px;            
        }
        a{
            padding: 10px;
            text-decoration: none;
            color: black;
            border-radius: 10px;
            font-size: 26px;
            background: rgba(250,170,50,0.9);;
            margin: 0px 0px 0px 30px;
        }
        a:hover{
            color: white;              
        }

        .cerrar{
            float: bottom;
            margin: 0px 0px 10px 120px;
            background: rgba(300,30,0,0.9);
        }

        .usuario{
            color: black;
            padding-left:  10px;
            color: white;
            font-size: 30px;
        }
        a.usuario{
            border-radius: 0px;
            background: rgba(0,0,0,0.4);
            margin: 0px 0px 0px 0px;
        }
    </style>
    <body>
        <%
            String msg = request.getParameter("msg");
            if (msg != null) {
        %> <script> alert("<%= msg%>");</script> <%
            }
        %>
        <div class="xd"></div>
        <a href="servletCliente?accion=listar">Listar Cliente</a>
        <a href="servletEmpleado?accion=listar">Listar Empleado</a>
        <a href="servletCategoria?accion=listar">Categorias</a>
        <a href="servletProducto?accion=listar">Listar Producto</a>
        <a href="venta.jsp">Venta</a>
        <a href="reportes.jsp">Reporte de Ventas</a>
        <a class="cerrar"href="login.jsp">Cerrar Sesion</a>
        <div class="imagen">
            <img src="imagenes/fondo7.jpg" width="1175px">
        </div>
        <div class="usuario">
            <img src="imagenes/logo.gif" width="40px">
            <a class="usuario"><%out.print("Bienvenido a ModaTeens: " + session.getAttribute("usuario"));%></a>
        </div>
    </body>
</html>



