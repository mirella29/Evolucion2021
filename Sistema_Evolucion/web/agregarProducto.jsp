<%-- 
    Document   : listar
    Created on : 18-jun-2020, 16:56:06
    Author     : VB
--%>

<%@page import="ayuda.ayuditas"%>
<%@page import="modelo.categoria"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<categoria> lista = new ayuditas().llenarCategoria();
%>
<style>
    #lol{
        margin:  10px;
    }
</style>
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
<!DOCTYPE html>
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
            <form action="servletProducto" method="GET">
                <table align="center">
                    <div class="form-group">
                        <h2>INGRESE DATOS</h2>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" name="nombre" class="form-control" id="nombre" onkeypress="return letras()()(event)" required="">
                    </div>
                    <div class="form-group">
                        <label for="precioc">Precio Compra</label>                        
                        <input type="text" name="precioc" class="form-control" id="precioc" onkeypress="return numeros()(event)" required=""/>
                    </div>
                    <div class="form-group">
                        <label for="preciov">Precio Venta</label>                        
                        <input type="text" name="preciov" class="form-control" id="preciov" onkeypress="return numeros()(event)" required=""/>
                    </div>
                    <div class="form-group">
                        <label for="cantidad">Cantidad</label>                        
                        <input type="number" name="cantidad" class="form-control" id="cantidad" onkeypress="return numeros()(event)" required="" maxlength="4"/>
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
                        <input type="hidden" name="accion" value="agregar">                        
                        <input type="submit" value="Procesar" class="btn btn-primary" id="lol"/>  
                        <a  href="index.jsp" class="btn btn-primary"/>Salir</a>
                    
                </table>
            </form>
        </div>                
    </body>
</html>
