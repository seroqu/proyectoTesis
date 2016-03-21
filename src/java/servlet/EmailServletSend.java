/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import EJB.EjbUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilities.EmailUtil;

/**
 *
 * @author Sebastian
 */
public class EmailServletSend extends HttpServlet {

    private String host;
    private String port;
    private String user;
    private String pass;
    private EjbUsuario ejbUsuario;
    
    @Override
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
          
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
         
        ejbUsuario = new EjbUsuario();
        
        if(request.getMethod().equals("POST")){
          
          String recipient = request.getParameter("recipient");
          String subject = "Recupera tu contraseña";
          String content = "link generator";
          String resultadoMensage = "";
          ejbUsuario.getUsuario().setEmail(recipient);
          String recuperarUser = ejbUsuario.recuperarUsuario();    
          if(recuperarUser.substring(0, 1).equals("0")){
            try {
                
                 recuperarUser = recuperarUser.substring(1, recuperarUser.length());
                EmailUtil.sendEmail(host, port, user, pass, recipient, subject,recuperarUser);
                resultadoMensage = "Revise su correo para recuperar su contraseña.";
                response.sendRedirect("auth/sucess.jsp");
                
            
            }catch (Exception ex) {
                ex.printStackTrace();
                resultadoMensage = "Error al intentar : " + ex.getMessage();
                response.sendRedirect("auth/recoverfail.jsp");
        } finally {
            request.getSession().setAttribute("resultadoMensage", resultadoMensage);
        }
  
          }else{
             resultadoMensage = "EL CORREO INGRESADO NO ESTA REGISTRADO EN LA APLICACION, POR FAVOR INTENTE DE NUEVO"; 
             request.getSession().setAttribute("resultadoMensage", resultadoMensage);
             response.sendRedirect("auth/recoverfail.jsp");
          }
        }
        
      
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
