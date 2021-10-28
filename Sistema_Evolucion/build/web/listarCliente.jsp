<%-- 
    Document   : listar
    Created on : 18-jun-2020, 17:15:11
    Author     : VB
--%>

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
    </head>
    <style>  
        body{
            margin: auto;
            background-image: url(imagenes/fondo2.jpg);
            -o-background-size: cover;
            background-size: cover;
            padding-top: 50px;
        }
        .container{
            color: white;
            padding-top: 50px;
            padding-bottom: 30px;
            background: rgba(0,0,0,0.1);
        }
        .titulo{
            background: rgba(0,0,0,0.2);
        }
        tr{
            color: white;
            background: rgba(0,0,0,0.2);
        }
        td{
            background: rgba(0,0,0,0.2);
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
            background: rgba(0,0,0,0.2);
        }
    </style>
    <body>
        <div class="container">
            <h1 class="titulo" align="center">Lista de Clientes</h1>
            <table class="table table-striped">

                <thead>
                    <tr>
                        <td colspan="2" align="center"> <a class="btn" href="agregarCliente.jsp">Agregar</a></td>
                        <td><a class="btn salir" href="index.jsp">Salir</a></td
                    </tr>
                    <tr align="center">
                        <td>Id</td><td>Dni</td><td>Nombre</td><td>Apellido</td><td>Direccion</td><td>Telefono</td><td colspan="2">ACCIONES</td>
                    </tr>
                </thead>
                <tbody>
                    <%
                    List<cliente> lista = (ArrayList<cliente>) request.getAttribute("lista");
                    for (int i = 0; i < lista.size(); i++) {%>
                    <tr align="center">
                        <td><%=lista.get(i).getId_cliente()%></td>
                        <td><%=lista.get(i).getDni_cli()%></td>
                        <td><%=lista.get(i).getNombre_cli()%></td>
                        <td><%=lista.get(i).getApellido_cli()%></td>
                        <td><%=lista.get(i).getDireccion_cli()%></td>
                        <td><%=lista.get(i).getTelefono_cli()%></td>
                        <td> <a class="btn editar" href="editarCliente.jsp?cod=<%=lista.get(i).getId_cliente()%>">Actualizar</a> </td>
                        <td> <a class="btn eliminar" href="servletCliente?accion=eliminar&cod=<%=lista.get(i).getId_cliente()%>">Eliminar</a> </td>
                    </tr>
                    <%}
                    %>
                </tbody>
            </table>

            <form>
                <h1 class="buscar" align="center">Busqueda de Clientes</h1>
                <p align="center"> <input type="text" placeholder="Ingrese dni" name="buscado" required="" onkeypress="return numeros(event)" maxlength="8"> <input class="btn" type="submit" name="Buscar" value="Buscar"> </p>
                <input type="hidden" name="accion" value="buscar">
            </form>    

        </div> 
    </body>
</html>

