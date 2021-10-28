<%-- 
    Document   : listar
    Created on : 18-jun-2020, 17:15:11
    Author     : VB
--%>

<%@page import="ayuda.ayuditas"%>
<%@page import="modelo.producto"%>
<%@page import="modelo.cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
    function numeros(e) {
        key = e.keyCode || e.which;
        teclado = String.fromCharCode(key);
        numero = "0123456789";
        if (numero.indexOf(teclado) == -1)
            return false;
    }

    function letras(e) {
        key = e.keyCode || e.which;
        teclado1 = String.fromCharCode(key).toLowerCase(); //convertir a minusculas
        letra = "abcdefghijklmnñopqrstuvwxyz ";
        if (letra.indexOf(teclado1) == -1)
            return false;
    }
</script>
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
            background-image: url(imagenes/fondo1.jpg);
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
        .buscar{
            background: rgba(0,0,0,0.3);
        }
    </style>
    <body>
        <div class="container">
            <h1 align="center">Lista de Productos</h1>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <td><a class="btn salir" href="indext.jsp">Salir</a></td
                    </tr>
                    <tr align="center">
                        <td>Id</td><td>Nombre</td><td>Precio Compra</td><td>Precio Venta</td><td>Cantidad</td><td>Categoria</td>
                    </tr>
                </thead>
                <tbody>
                    <%
                    List<producto> lista = (ArrayList<producto>) request.getAttribute("lista");
                    for (int i = 0; i < lista.size(); i++) {%>
                    <tr align="center">
                        <td><%=lista.get(i).getId()%></td>
                        <td><%=lista.get(i).getNombre()%></td>
                        <td><%=lista.get(i).getPrecioc()%></td>
                        <td><%=lista.get(i).getPreciov()%></td>
                        <td><%=lista.get(i).getCantidad()%></td>
                        <td><%=new ayuditas().llenarDescripcionCategoria(lista.get(i).getId_categoria())%></td>
                    </tr>
                    <%}
                    %>
                </tbody>
            </table>

            <form>
                <h1 align="center">Busqueda de Producto</h1>
                <p align="center"> <input type="text" placeholder="Ingrese nombre" name="buscado" required="" onkeypress="return letras(event)"> <input class="btn" type="submit" name="Buscar" value="Buscar"> </p>
                <input type="hidden" name="accion" value="buscar" >
            </form> 
        </div>
    </body>
</html>
