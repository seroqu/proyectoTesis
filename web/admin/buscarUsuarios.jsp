<html>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="stylesheet" type="text/css" href="../recursos/css/base.css">  
        <link  rel="stylesheet" type="text/css" href="../recursos/css/style.css">
        <link  rel="stylesheet" type="text/css" href="../recursos/css/estilos.css">  
        <title>BDH - Registro Admin</title>
    </head>
    <body>
        <section>
            <h1>Registrar Administrador</h1>
            <% 
                String usurname = (String)request.getSession().getAttribute("nombreUsuario");
                if(usurname==null){
                   response.sendRedirect("index.jsp");
                }
            %>            
            <b>Bienvenido a la plataforma del bosque de Hiria  <%= usurname %></b>
       </section>
       <h2 class="subtitle">Registrar Administrador</h2>
       <p>Ingrese la siguiente información:</p>
       <section>
          <form action="AdministracionAdmin" method="POST">
            <input placeholder=":usuario" type="text" name="usuario"><br>
            <input placeholder=":contraseña" type="password" name="contrasena"><br>
            <input placeholder=": repetir contraseña" type="password" name="repetir_contrasena"><br>
            <input placeholder=":correo" type="text" name="correo_electronico"><br>
            <input  name="operacion"  type="hidden" value="crearAdministrador"><br>
            <center><input type="submit" value="Entrar" class="btnGeneric" /></center>
         </form>
       </section>    
       <footer>
            2016 - Bosque de Hiria.
       </footer>    
    </body>
</html>