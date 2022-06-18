/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.moreno.controlador;

import com.moreno.models.Movies;
import com.moreno.dao.MoviesManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author cristina
 */
@WebServlet(name = "InsertMovies", urlPatterns = {"/InsertMovies"})
public class InsertMovies extends HttpServlet {

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
            out.println("<title>Servlet InsertMovies</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertMovies at " + request.getContextPath() + "</h1>");
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
        
        HttpServletRequest req = (HttpServletRequest) request;
        Integer valoracion = 0;
        String titulo = req.getParameter("m_titulo"); // name del jsp
        String genero = req.getParameter("m_genero");
        valoracion = (!req.getParameter("m_valoracion").equals("")) ? Integer.parseInt(req.getParameter("m_valoracion")) : valoracion;
        boolean visto = Boolean.valueOf(request.getParameter("m_visto"));
        visto = (visto);
        String formato = req.getParameter("m_formato");
        Movies movie = new Movies(titulo, genero, valoracion, visto, formato);

        try {                  
            mm.create(movie);
            response.sendRedirect("InsertMovies");

        } catch (NumberFormatException ex) {
            mm.setErrors(true);
            mm.setStatus("Valoracion '" + valoracion + "' no es un número válido");
        } catch (Exception ex) {
            Throwable cause = ex.getCause();
            mm.setErrors(true);
            if (cause instanceof ConstraintViolationException) {
                StringBuilder status = new StringBuilder("Error creando un título ");
                ConstraintViolationException e = (ConstraintViolationException) cause;
                e.getConstraintViolations().stream().forEach(v -> status.append(v.getMessage() + " "));
                mm.setStatus(status.toString());
            } else if (cause instanceof OptimisticLockException) {
                mm.setStatus("El título ha sido modificado por otro usuario.");
            } else {
                mm.setStatus("Excepcion general (Rollback)");
            }
        }
    }

}
