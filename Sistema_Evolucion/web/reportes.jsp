<%-- 
    Document   : reportes
    Created on : 14-jul-2020, 14:34:04
    Author     : VB
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </head>
    <style>
        body{
            margin: auto;
            background-image: url(imagenes/fondo6.jpg);
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
            text-align: center;
        }
        .nav-tabs{
            font-size: 30px;
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
        .cerrar{
            text-decoration: none;
            color: white;
            border-radius: 10px;
            font-size: 20px;
            background: rgba(300,30,0,0.9);
        }
        .nav-link{
            color: white;
            margin-right: 20px;
        }
        .cerrar{
            float: bottom;
            margin: 0px 0px 10px 770px;
        }
        .nav-link:hover{
            color: white;
        }
    </style>
    <body>        
        <div class="container">
            <h1 class="titulo">Reportes</h1>
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="btn nav-link" href="rdia.jsp">Dia</a>
                </li>
                <li class="nav-item">
                    <a class="btn nav-link" href="rmes.jsp">Mes</a>
                </li>
                <li class="nav-item">
                    <a class="btn nav-link" href="ryear.jsp">Año</a>
                </li>
                <li class="nav-item">
                    <a class="btn cerrar nav-link" href="index.jsp">Salir</a>
                </li>
            </ul>
        </div>

    </body>
</html>
