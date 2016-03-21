<%-- 
    Document   : recover
    Created on : Jul 13, 2015, 10:14:09 PM
    Author     : Sebastian
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.createjs.com/soundjs-0.5.2.min.js"></script>
        <link  rel="stylesheet" type="text/css" href="../recursos/css/estilos.css">  
        <link  rel="stylesheet" type="text/css" href="../recursos/css/base.css">  
        <link  rel="stylesheet" type="text/css" href="../recursos/css/style.css">
        <title>Actualizar contraseña</title>
    </head>
    <body>
         <% String respuesta = (String)request.getParameter("ursEnc"); %>
        <h1>ACTUALIZAR CONTRASEÑA</h1>
        <section>
            
            
            
            <h2>Escribe tu contraseña</h2>
            <form action="../UpdatePassword" method="POST">
                <ul class="input-list style-1 clearfix">
                    <li>
                        <input type="hidden" value="<%=respuesta %>" name="ursEnc">
                     </li>
                    <li>
                        <input placeholder=":contraseña" type="password" name="password">
                    </li>
                    <li>
                        <input placeholder=":repetir contraseña" type="password" name="repassword">
                    </li>
                </ul>
                <br>
                <center><input type="submit" value="Enviar" class="btnGeneric" /></center>
            </form>
        </section>
        <section>
            <a href="../index.jsp">Atras</a>   
        </section>
        <footer>
            2016 - Proyecto Bosque de Hiria
        </footer>
    </body>
</html>
