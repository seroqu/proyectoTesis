<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.createjs.com/soundjs-0.5.2.min.js"></script>
        <link  rel="stylesheet" type="text/css" href="../recursos/css/estilos.css">  
        <link  rel="stylesheet" type="text/css" href="../recursos/css/base.css">  
        <link  rel="stylesheet" type="text/css" href="../recursos/css/style.css">
        <title>Registro de usuarios</title>
    </head>
    <body>
        <h1>Registro</h1>
        <section>
         <form action="../SignUpServlet" method="POST">
           
                   Usuario: <input placeholder=":usuario" required type="text" name="username">
                   Contraseña: <input placeholder=":contraseña" required type="password" name="password">
                   Repetir contraseña: <input placeholder=":contraseña" required type="password" name="repassword">
                   Correo <input placeholder=":correo" type="email" required name="email">
           
            <br>
            <center><input type="submit" value="Entrar" class="btnGeneric" /></center>
         </form>
        </section>
        <section>
            <a href="../index.jsp">Atras</a> 
        </section>
        <footer id="footer">
            2016 - Bosque de Hiria.
        </footer>
    </body>
</html>
