<html>
        <link  rel="stylesheet" type="text/css" href="../recursos/css/base.css">  
        <link  rel="stylesheet" type="text/css" href="../recursos/css/style.css">
        <title>Bosque de Hiria Inicio</title>
    </head>
    <body>
        <section>
          <h1>Portal Principal</h1>
          <% 
             String usurname = (String)request.getSession().getAttribute("nombreUsuario");
             if(usurname==null){
                response.sendRedirect("../index.jsp");
             }
          %>            
            <b>Bienvenido a la plataforma del bosque de Hiria  <%= usurname %></b>
       </section>
       <h2 class="subtitle"></h2>
       <form action="../ProfesorServlet" method="POST">
             Estudiante: <input type="text" name="estudiante"><br>
             <input type="hidden" name="operacion" value="1"><br>
             <center><input type="submit" value="Buscar" class="btnGeneric" /></center>
       </form>
       <footer>
            2016 - Bosque de Hiria.
       </footer>    
    </body>
</html>