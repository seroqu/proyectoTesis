/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import EJB.EjbUsuario;
import encapsulamiento.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilities.Conexion;
import utilities.Encriptado;
 
/**
 *
 * @author Sebastian
 */
public class LoginServlet extends HttpServlet {

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
    
    private EjbUsuario ejbUsuario;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Conexion c = new Conexion();
            
           
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            String respuesta = c.conectar(username, password);
            
            if(respuesta.equals("0")){
                
                 ejbUsuario = new EjbUsuario();
                 ejbUsuario.getUsuario().setUsername(username);
                 Usuario usuarioRetorno = ejbUsuario.obtenerUsuario();
                switch (usuarioRetorno.getTipo()) {
                    case "estudiante":
                        request.getSession().setAttribute("nombreUsuario", ejbUsuario.obtenerUsuario().getUsername());
                        request.getSession().setAttribute("email", ejbUsuario.obtenerUsuario().getEmail());
                        request.getSession().setAttribute("identificador", ejbUsuario.obtenerUsuario().getIdentificador());
                        request.getSession().setAttribute("nombre", ejbUsuario.obtenerUsuario().getNombre());
                        request.getSession().setAttribute("tipoUsuario", ejbUsuario.obtenerUsuario().getTipo());
                        response.sendRedirect("main.jsp");
                        break;
                    case "profesor":
                        request.getSession().setAttribute("nombreUsuario", ejbUsuario.obtenerUsuario().getUsername());
                        request.getSession().setAttribute("email", ejbUsuario.obtenerUsuario().getEmail());
                        request.getSession().setAttribute("identificador", ejbUsuario.obtenerUsuario().getIdentificador());
                        request.getSession().setAttribute("nombre", ejbUsuario.obtenerUsuario().getNombre());
                        request.getSession().setAttribute("tipoUsuario", ejbUsuario.obtenerUsuario().getTipo());
                        response.sendRedirect("teacher/mainTeacher.jsp");
                        break;
                    case "administrador":
                        request.getSession().setAttribute("nombreUsuario", ejbUsuario.obtenerUsuario().getUsername());
                        request.getSession().setAttribute("email", ejbUsuario.obtenerUsuario().getEmail());
                        request.getSession().setAttribute("identificador", ejbUsuario.obtenerUsuario().getIdentificador());
                        request.getSession().setAttribute("nombre", ejbUsuario.obtenerUsuario().getNombre());
                        request.getSession().setAttribute("tipoUsuario", ejbUsuario.obtenerUsuario().getTipo());
                        response.sendRedirect("admin/mainAdmin.jsp");
                        break;
                    default:
                        response.sendRedirect("indexError.jsp");
                        break;
                }
            
            }else{
                response.sendRedirect("indexError.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
