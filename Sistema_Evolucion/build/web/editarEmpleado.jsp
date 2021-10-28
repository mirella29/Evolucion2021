<%-- 
    Document   : listar
    Created on : 18-jun-2020, 16:56:06
    Author     : VB
--%>

<%@page import="modelo.empleado"%>
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
            empleado a = null;
            try {
                Connection cn = new conexion().getConnection();
                PreparedStatement pst = cn.prepareStatement("select * from empleados where id_empleado=?");
                pst.setString(1, codigo);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    a = new empleado(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getString(9));
                   
                }                
                
            } catch (Exception e) {
            }
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
    function vdni(){
        var dni=document.getElementById("dni").value;
        var telefono=document.getElementById("telefono").value;
        if(dni.length!==8)
        {
            alert("el dni debe tener 8 caracteres");
            return false;
        }
        if(telefono.length!==9)
        {
            alert("el telefono debe tener 9 caracteres");
            return false;
        }
        return true;
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
            <form action="servletEmpleado" method="GET">

                       <h2>INGRESE DATOS</h2>


                        <div class="form-group">
                            <h1>INGRESE DATOS</h1>
                        </div>
                        <div class="form-group">
                            <label for="dni">Dni</label>
                            <input type="text" name="dni" class="form-control" id="dni" value="<%=a.getDni()%>" onkeypress="return letras(event)" required="" maxlength="8"/>
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" name="nombre" class="form-control" id="nombre" value="<%=a.getNombre()%>" onkeypress="return letras(event)" required=""/>
                        </div>
                        <div class="form-group">
                            <label for="apellido">Apellido</label>
                            <input type="text" name="apellido" class="form-control" id="apellido" value="<%=a.getApellido()%>" onkeypress="return letras(event)" required=""/>
                        </div>
                        <div class="form-group">
                            <label for="direccion">Direccion</label>
                            <input type="text" name="direccion" class="form-control" id="direccion" value="<%=a.getDireccion()%>" required=""/>
                        </div>
                        <div class="form-group">
                            <label for="telefono">Telefono</label>
                            <input type="text" name="telefono" class="form-control" id="telefono" value="<%=a.getTelefono()%>" onkeypress="return numeros(event)" required="" maxlength="9"/>
                        </div>
                        <div class="form-group">
                            <label for="rango">Rango</label>

                                <select name="rango" id="rango" class="form-group">
                                    <option value="0">Administrador</option>
                                    <option value="1">Trabajador</option>
                                </select>                        
                        </div>
                        <div class="form-group">
                            <label for="usuario">Usuario</label>
                            <input type="text" name="usuario" class="form-control" id="usuario" value="<%=a.getUsuario()%>" required=""/>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" name="password" class="form-control" id="password" value="<%=a.getPassword()%>" required=""/>
                        </div>

                        <input type="submit" value="Procesar" class="btn btn-primary" onclick="return vdni();"/>
                        <input type="hidden" name="accion" value="editar">
                        <input type="submit" value="Salir" class="btn btn-primary"/>
                        <input type="hidden" name="codigo" value="<%=a.getId()%>">

            </form>
        </div>
    </body>
</html>
