<%-- 
    Document   : listar
    Created on : 18-jun-2020, 16:56:06
    Author     : VB
--%>

<%@page import="ayuda.ayuditas"%>
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
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    
    <body>
        <div class="container">
            <h2>INGRESE DATOS</h2>
            <form>
                
                <div class="form-group">
                    <label for="dni">Dni</label>
                    <input type="text" name="dni" class="form-control" id="dni" onkeypress="return numeros(event)"  required="" maxlength="8"/>
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <input type="text" name="nombre" class="form-control" id="nombre" onkeypress="return letras(event)" required=""/>
                </div>
                <div class="form-group">
                    <label for="apellido">Apellido</label>
                    <input type="text" name="apellido" class="form-control" id="apellido" onkeypress="return letras(event)" required=""/>
                </div>
                <div class="form-group">
                    <label for="direccion">Direccion</label>
                    <input type="text" name="direccion" class="form-control" id="direccion" required=""/>
                </div>
                <div class="form-group">
                    <label for="telefono">Telefono</label>
                    <input type="text" name="telefono" class="form-control" id="telefono" onkeypress="return numeros(event)"  required="" maxlength="9"/>
                </div>
                <input type="submit" name="Procesar"value="Procesar" class="btn btn-primary" onclick="return vdni();"/>
                <a  href="index.jsp" class="btn btn-primary"/>Salir</a>
                <input type="hidden" name="accion" value="agregar">
                
                <%
                    if(request.getParameter("Procesar") != null){
                        String dni = request.getParameter("dni");
                        if((new ayuditas().noDobleDni(dni)).equals("")){
                            request.getRequestDispatcher( "servletCliente" ).forward( request, response );
                        }
                        else{%>
                        <script> alert("<%=new ayuditas().noDobleDni(dni)%>"); </script>  
                        <%}
                    }
                %>
            </form>
        </div>    
    </body>
</html>
