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
        <title>BDH - Recuperar contraseña</title>
    </head>
    <body>
        <% 
                String respuesta = (String)request.getSession().getAttribute("resultadoMensage");
                
                
          %>
        <h1>Ops! Un error ha ocurrido!!</h1>
        <section>
           
            <label style="color : red"><%= respuesta %> </label>
        
        </section>
        <section>
            <h2>Escribe tu correo</h2>
            <form action="../EmailServletSend" method="POST">
                <ul class="input-list style-1 clearfix">
                    <li>
                        <input placeholder=":correo" type="email" name="recipient">
                    </li>
                </ul>
                <br>
                <center><input type="submit" value="Enviar" class="btnGeneric" /></center>
            </form>
        </section>
        <section>
            <a href="../index.jsp">Atras</a>   
        </section>
        <footer id="footer">
            2016 - Bosque de Hiria
        </footer>
    </body>
</html>
