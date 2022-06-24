/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.moreno.controlador;

import com.moreno.dao.MoviesManager;
import com.moreno.models.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cristina
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Inject
    MoviesManager mm;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("m_usuario");
        String password = request.getParameter("m_pass");

        boolean verificado = false;
        String accion = request.getParameter("accion");

        switch (accion) {
            case "Login":
                verificado = verificarUsuario(request, response);
                if (verificado) {
                    request.getRequestDispatcher("menu.html").forward(request, response);
                } else {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }

                break;
            case "Nuevo Usuario":
                Usuario newUser = new Usuario(usuario, password);
                mm.setUsuario(newUser);
                request.setAttribute("usuario", newUser);
                request.getRequestDispatcher("nuevoUsuario.jsp").forward(request, response);
                break;
            case "Insertar":
                String estado = request.getParameter("m_estado");
                String rol = request.getParameter("m_rol");
                String password2 = request.getParameter("m_pass2");
                boolean estadoB = false;
                if (estado.equals("Activado")) {
                    estadoB = true;
                }
                if (password2.equals(password)) {
                    Usuario newUser2 = new Usuario(usuario, password, estadoB, rol);
                    mm.create(newUser2);
                    response.setStatus(1);
                    mm.setStatus("Usuario insertado correctamente.");
                    request.getRequestDispatcher("menu.html").forward(request, response);
                } else {
                    mm.setStatus("Las contraseñas no coinciden.");
                    mm.setErrors(true);
                    request.getRequestDispatcher("nuevoUsuario.jsp").forward(request, response);
                }
                break;
            case "Cerrar":
                cerrarSesion(request, response);
                break;
        }
    }

    private boolean verificarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean verificado = false;
        HttpSession sesion;
        try {
            Usuario user = mm.findByUser(request.getParameter("m_usuario"));
            if (user != null) {
                mm.setUsuario(user);
                if (user.getUsuario().equals(request.getParameter("m_usuario")) && user.getPassword().equals(request.getParameter("m_usuario"))) {
                    verificado = true;
                    sesion = request.getSession();
                    sesion.setAttribute("usuario", user);
                }
            }
        } catch (Exception ex) {
            mm.setStatus("Usuario no encontrado.");
            mm.setErrors(true);
        }
        return verificado;
    }

    private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession sesion = request.getSession();
        sesion.setAttribute("usuario", null);
        sesion.invalidate();
        response.sendRedirect("login.jsp");
    }

}
