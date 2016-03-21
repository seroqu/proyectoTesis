<%-- 
    Document   : chat
    Created on : Jul 16, 2015, 9:09:55 PM
    Author     : Sebastian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Skynet - Chat</title>
        <script src="http://code.createjs.com/soundjs-0.5.2.min.js"></script>
        <link  rel="stylesheet" type="text/css" href="../recursos/css/estilos.css">  
        <link  rel="stylesheet" type="text/css" href="../recursos/css/base.css">  
        <link  rel="stylesheet" type="text/css" href="../recursos/css/style.css">
    </head>
    <body>
        <% 
          String usurname = (String)request.getSession().getAttribute("nombreUsuario");
          if(usurname==null){
             response.sendRedirect("../index.jsp");
          }
        %>
        <h1>Chat</h1>
        <section>
            <a href="../index.jsp">Atras</a>   
        </section>
    </body>
</html>
