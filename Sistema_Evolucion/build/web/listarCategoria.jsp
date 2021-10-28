<%-- 
    Document   : listar
    Created on : 18-jun-2020, 17:15:11
    Author     : VB
--%>

<%@page import="modelo.categoria"%>
<%@page import="modelo.cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

    </head>
    <style>  
        body{
            margin: auto;
            background-image: url(imagenes/fondo4.jpg);
            -o-background-size: cover;
            background-size: cover;
            padding-top: 30px;
        }
        .container{
            color: white;
            padding-top: 50px;
            padding-bottom: 30px;
            background: rgba(0,0,0,0.2);
        }
        .titulo{
            background: rgba(0,0,0,0.3);
        }
        tr{
            color: white;
            background: rgba(0,0,0,0.3);
        }
        td{
            background: rgba(0,0,0,0.3);
        }
        .btn,.editar{
            text-decoration: none;
            color: white;
            border-radius: 10px;
            font-size: 20px;
            background: rgba(250,170,50,0.9);
        }
        .btn:hover{
            color: white;
        }
        .salir,.eliminar{
            text-decoration: none;
            color: white;
            border-radius: 10px;
            font-size: 20px;
            background: rgba(300,30,0,0.9);
        }
    </style>
    <body>
        <div class="container">
            <h1 class="titulo">Lista de Categorias</h1>
            <table class="table table-striped">
                <thead>    
                    <tr>
                        <td colspan="2" align="center"> <a class="btn" href="agregarCategoria.jsp">Agregar</a></td>
                        <td><a class="btn salir" href="index.jsp">Salir</a></td>
                    </tr>
                    <tr align="center">
                        <td>Id</td><td>Descripcion</td><td colspan="2">ACCIONES</td>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<categoria> lista = (ArrayList<categoria>) request.getAttribute("lista");
                        for (int i = 0; i < lista.size(); i++) {%>
                    <tr align="center">
                        <td><%=lista.get(i).getId()%></td>
                        <td><%=lista.get(i).getDescripcion()%></td>
                        <td> <a class="btn editar" href="editarCategoria.jsp?cod=<%=lista.get(i).getId()%>">Actualizar</a> </td>
                        <td> <a class="btn eliminar" href="servletCategoria?accion=eliminar&cod=<%=lista.get(i).getId()%>">Eliminar</a> </td>
                    </tr>
                    <%}
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
