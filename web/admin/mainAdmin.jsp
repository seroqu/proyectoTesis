<html>
    <link  rel="stylesheet" type="text/css" href="recursos/css/base.css">  
    <link  rel="stylesheet" type="text/css" href="recursos/css/style.css">
    <title>Bosque de Hiria Inicio</title>
    </head>
    <body>
       <section>
            <h1>Portal Principal</h1>
            <% 
                String usurname = (String)request.getSession().getAttribute("nombreUsuario");
                if(usurname==null){
                   response.sendRedirect("index.jsp");
                }
            %>            
            <b>Bienvenido al portal de administración del bosque de Hiria  <%= usurname %></b>
       </section>
       <h2 class="subtitle">¿Qué desea hacer?</h2>
       <section>
           <a href="registrarAdmin.jsp">Registrar otro Administrador</a>
           <a href="verPeticonesProfsores.jsp">Ver peticiones de profesores</a>
           <a href="verMensajes.jsp">Leer Mensajes</a>
           <a href="buscarUsuarios.jsp">buscar usuarios</a>
           <a href="verMensajes.jsp">Modificar usuario</a>
       </section>    
       <footer>
            2016 - Bosque de Hiria.
       </footer>    
    </body>
</html>