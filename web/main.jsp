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
           <a href="game/game.jsp">Historia</a>
       </section>    
       <section>
           <a href="minigames/minigames.jsp">Minijuegos</a>
       </section>  
       <section>
           <a href="messages/chat.jsp">Chat</a>
       </section>    
       <section>
           <a href="activities/activities.jsp">Actividades</a>
       </section>    
       <section>    
           <a href="LogOutServlet">Cerrar sesión</a>
       </section> 
       <footer>
            2016 - Bosque de Hiria.
       </footer>    
    </body>
</html>