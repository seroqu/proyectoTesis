/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import EJB.EjbProfesor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebastian
 */
@WebServlet(name = "ProfesorServlet", urlPatterns = {"/ProfesorServlet"})
public class ProfesorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

     private EjbProfesor ejbProfesor; 
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         try {
            ejbProfesor = new EjbProfesor();
            if(request.getMethod().equals("POST")){
                String operation = request.getParameter("operacion");   
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title></title>");            
                out.println("</head>");
                out.println("<body>");
                String [] respuestas = new String[100];
                String resultado;
                switch (operation){
                   
                    case "1" : 
                        String estudiante = request.getParameter("estudiante");
                        ejbProfesor.setNombreEstudiante(estudiante);
                        respuestas = ejbProfesor.buscarEstudiante();
                        if(respuestas.length > 0 ){ 
                            request.getSession().setAttribute("nombreUsuario", "username");
                            request.getSession().setAttribute("tipoUsuario", "estudiante");
                            for (int i = 0; i < respuestas.length; i++) {
                              out.println("<p>Encontrado " + respuestas[i] + "</p>");
                            }
                        }else{
                            response.sendRedirect("auth/signup.jsp");
                        }
                    case "2" :
                        String nombreGrupo = request.getParameter("nombreGrupo");
                        String idProfesor = (String) request.getSession().getAttribute("identificador");
                        resultado = ejbProfesor.crearGrupo(nombreGrupo,idProfesor);
                        if(resultado.equals("0")){ 
                           out.println("<p>Grupo ha sido creado exitosamente</p>");
                        }else {
                            out.println("<p>Error intentando crear grupo" + resultado +"</p>");
                             out.println("<a href='teacher/mainTeacher.jsp'>Regresar </a>");
                        }
                    default:
                }  
                      
            out.println("</body>");
            out.println("</html>");      
                
           }
        } finally {    
             out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
