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
       <form action="../ProfesorServlet" method="POST">
             Nombre del grupo: <input type="text" name="nombreGrupo"><br>
             <input type="hidden" name="operacion" value="2"><br>
             <center><input type="submit" value="Crear" class="btnGeneric" /></center>
       </form>
       <footer>
            2016 - Bosque de Hiria.
       </footer>    
    </body>
</html>