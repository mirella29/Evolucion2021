<%-- 
    Document   : rdia.jsp
    Created on : 14-jul-2020, 14:37:14
    Author     : VB
--%>

<%@page import="modelo.detalleVenta"%>
<%@page import="ayuda.ayuditas"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.venta"%>
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
    </head>
    <%
        double total = 0;
    %>
    <style>
        .enviar{
            text-align: center;
        }
        body{
            margin: 0px;
            background-image: url(imagenes/fondo5.jpg);        
            -webkit-background-size: cover;
            -moz-background-size: cover;
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
            background: rgba(0,0,0,0.3);
        }
        td{
            font-size: 20px;
            color: white;
            background: rgba(0,0,0,0.2);
        }
        .btn{
            text-decoration: none;
            color: white;
            border-radius: 10px;
            font-size: 20px;
            background: rgba(250,170,50,0.9);
            text-align: center;
        }
        .btn:hover{
            color: white;
        }
        .fechin{
            font-size: 20px;
            margin: 10px ;
            background: black;
        }
        .f1{
            margin-top: 30px; 
        }

        .subt{
            color: white;
            font-size: 30px;
            margin: 20px;
        }

        .cbo{
            width: 200px;
            color: black;
            font-size: 20px;
            text-align: center;
        }
        input{
            margin: 20px;
        }
    </style>       
    <body>
        <div class="container">
            <h1 class="titulo" align="center">Reporte Por Mes</h1>
            <form action="servletReporte" class="enviar">

                <div class="subt">Seleccione mes </div>
                <div class="container">
                    <select name="fecha" class="cbo">
                        <option value="01">Enero</option>
                        <option value="02">Febrero</option>
                        <option value="03">Marzo</option>
                        <option value="04">Abril</option>
                        <option value="05">Mayo</option>
                        <option value="06">Junio</option>
                        <option value="07">Julio</option>
                        <option value="08">Agosto</option>
                        <option value="09">Septiembre</option>
                        <option value="10">Octubre</option>
                        <option value="11">Novienbre</option>
                        <option value="12">Diciembre</option>
                    </select>
                </div>
                <input type="submit" name="accion" value="Enviar" class="btn">
            </form>
            <form class="f1">

                <table class="table table-striped">
                    <thead>
                        <tr>
                            <td>Id</td><td>Cliente</td><td>Empleado</td><td>Fecha</td><td>Total</td><td>Detalle</td>
                        </tr>
                    </thead>
                    <tbody></tbody>
                    <%
                        if (request.getAttribute("lista") != null) {
                            List<venta> lista = (ArrayList<venta>) request.getAttribute("lista");
                            for (int i = 0; i < lista.size(); i++) {
                                    total += lista.get(i).getTotal();%>
                    <tr>
                        <td><%=lista.get(i).getId()%></td>
                        <td><%= new ayuditas().ObtenerNombreClienteReporte(String.valueOf(lista.get(i).getCliente()))%></td>
                        <td><%= new ayuditas().ObtenerNombreEmpleadoReporte(String.valueOf(lista.get(i).getEmpleado()))%></td>
                        <td><%=lista.get(i).getFecha()%></td>
                        <td><%=lista.get(i).getTotal()%></td>
                        <td><input type="radio" name="id" value="<%=lista.get(i).getId()%>"></td>
                    </tr>    
                    <%}
                        }
                    %>
                    <tr>
                        <td colspan="4"></td>
                        <td><% out.print("S/. " + total); %></td>
                    </tr>
                    </tbody>
                </table>
                <p align="center"><input type="submit" name="accion" value="Ver Detalle De Factura" class="btn">                       
                    <a  href="reportes.jsp" class="btn"/>Salir</a>
                </p> 

            </form>
            <form>
                <table class="table table-striped">

                    <%
                        if (request.getAttribute("listaDV") != null) {
                            List<detalleVenta> lista = (ArrayList<detalleVenta>) request.getAttribute("listaDV");%>
                    <tr>
                        <td>Id</td><td>Venta</td><td>Producto</td><td>Cantidad</td>
                    </tr>
                    <%
                            for (int i = 0; i < lista.size(); i++) {%>
                    <tr>
                        <td><%=lista.get(i).getId()%></td>
                        <td><%=lista.get(i).getId_venta()%></td>
                        <td><%= new ayuditas().ObtenerNombreProductoReporte(String.valueOf(lista.get(i).getId_producto()))%></td>
                        <td><%=lista.get(i).getCantidad()%></td>
                    </tr>    
                    <%}
                        }
                    %>

                </table>
        </div> 
    </form>
</body>
</html>
