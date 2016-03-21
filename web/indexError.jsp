<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Proyecto Skynet</title>
        <script src="http://code.createjs.com/soundjs-0.5.2.min.js"></script>
        <link  rel="stylesheet" type="text/css" href="recursos/css/estilos.css">  
        <link  rel="stylesheet" type="text/css" href="recursos/css/base.css">  
        <link  rel="stylesheet" type="text/css" href="recursos/css/style.css">  
    </head>
    <body>
         <% 
                String usurname = (String)request.getSession().getAttribute("nombreUsuario");
                
                if(usurname!=null){
                   response.sendRedirect("main.jsp");
                }
          %>
      <div id='inicio'>
      <center><h1>PROYECTO SKYNET</h1></center>
      <section>
         <h2>Inicio de sesión</h2>
         <label style="color : red">USUARIO O CONTRASEÑA INVALIDO, POR FAVOR INTENTE DE NUEVO</label>
         <form action="LoginServlet" method="POST">
            <ul class="input-list style-1 clearfix">
                <li>
                    Usuario: <input placeholder=":usuario" type="text" name="username">
                </li>
                <li>
                    Contraseña: <input placeholder=":contraseña" type="password" name="password">
                </li>
            </ul>
            <br>
                    <center><input type="submit" value="Entrar" class="btnGeneric" /></center>
         </form>
         <section> <a href="auth/recover.jsp">Recuperar contraseña</a></section>
         <section> <a href="auth/signup.jsp">Registrarse</a></section>
      </section>   
      </div>
      <footer id="footer">
                2015 - Proyecto Skynet
      </footer>
    </body>
</html>
