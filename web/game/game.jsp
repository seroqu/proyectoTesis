<%-- 
    Document   : game
    Created on : Jul 16, 2015, 9:06:14 PM
    Author     : Sebastian
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BDH - Juego</title>
        <script src="https://code.createjs.com/createjs-2015.05.21.min.js"></script>
        <script src="http://code.createjs.com/soundjs-0.5.2.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
        <script src="../recursos/javascript/game.js"></script> 
        <link  rel="stylesheet" type="text/css" href="../recursos/css/estilos.css">  
        <link  rel="stylesheet" type="text/css" href="../recursos/css/base.css">  
        <link  rel="stylesheet" type="text/css" href="../recursos/css/style.css">
    </head>
    <body onload="init();">
        <%
            String usurname = (String) request.getSession().getAttribute("nombreUsuario");
            if (usurname == null) {
                response.sendRedirect("../index.jsp");
            }
        %>
        <h1>Historia</h1>
        <section>
            <center><canvas id="mundoJuego" width="1000" height="1000" style="border:1px solid #d3d3d3;"></canvas></center>  
        </section>
        <section>
            <a href="../index.jsp">Atras</a>   
        </section>
    </body> 
</html>
