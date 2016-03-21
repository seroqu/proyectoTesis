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
            <b>Bienvenido a la plataforma del bosque de Hiria  <%= usurname %></b>
       </section>
       <h2 class="subtitle">¿Qué desea hacer?</h2>
       <section>
           <a href="buscarEstudiante.jsp">Buscar Estudiante</a>
       </section>    
       <section>
           <a href="crearGruposEstudiantes.jsp">Crear grupo de estudiantes</a>
       </section>  
       <section>
           <a href="administrarActividades.jsp">Administrar actividades</a>
       </section>    
       <section>
           <a href="modificarInformaciónPersonal.jsp">Modificar información personal</a>
       </section>    
       <section>
           <a href="accederChat.jsp">Acceder al chat</a>
       </section>
       <section>    
           <a href="LogOutServlet">Cerrar sesión</a>
       </section> 
       <footer>
            2016 - Bosque de Hiria.
       </footer>    
    </body>
</html>