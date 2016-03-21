<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bosque de Hiria</title>
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
      <center><h1>BOSQUE DE HIRIA</h1></center>
      <section>
         <h2>Inicio de sesión</h2>
         <form action="LoginServlet" method="POST">
                    Usuario: <input placeholder=":usuario" type="text" name="username"><br>
                    Contraseña: <input placeholder=":contraseña" type="password" name="password"><br>
                    <center><input type="submit" value="Entrar" class="btnGeneric" /></center>
         </form>
         <section> <a href="auth/recover.jsp">Recuperar contraseña</a></section>
         <section> <a href="auth/signup.jsp">Registrarse</a></section>
      </section>
      <footer id="footer">
                2016 - Bosque de Hiria.
      </footer>
      </div>
   </body>
</html>
