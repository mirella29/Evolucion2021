<%-- 
    Document   : login
    Created on : 30-jun-2020, 21:58:00
    Author     : VB
--%>

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
    <style>
        body{
            background-image: url(imagenes/fondo2.jpg);
            background-size: cover;
        }
        .btn,.editar{
            text-decoration: none;
            color: white;
            border-radius: 10px;
            font-size: 20px;
            background: rgba(250,170,50,0.9);
        }
    </style>
    <body>
        <%
            String msg = request.getParameter("msg");
            String intentos = request.getParameter("intentos");
            if (intentos == null) {
                intentos = "4";
            }

            if (msg != null) {%>
        <script>alert("Usted cuenta con <%=intentos%> intento para ingresar")</script>
        <%}

                    if (intentos.equals("0")) {%>
        <script>
            alert("Ha vencido sus intentos");
            window.close();
        </script>

        <%}
            out.print(intentos);
        %>        
        <div class="container mt-5 col-lg-4">
            <div class="col-sm-11">
                <div class="card-body" style="background-color: blanchedalmond">
                    <form class="form-sign" action="servletLogin">
                        <div class="form-group text-center">
                            <h1>Login</h1>
                            <img src="imagenes/logo.gif" alt="/imagenes/login.gif" alt="100" width="230">
                            <br><br>
                            <h4>Bienvenido(a) al Sistema</h4>
                        </div>
                        <div class="form-group">
                            <label>Usuario:</label>
                            <input type="text" name="usuario" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Password:</label>
                            <input type="password" name="password" class="form-control">
                        </div><br>
                        <input type="hidden" name="intentos" value="<%=intentos%>">
                        <%if (!intentos.equals("0")) {%><input type="submit" name="accion" value="Enviar" class="btn btn-block"><%}%>
                    </form>
                </div>
            </div>
    </body>
</html>
