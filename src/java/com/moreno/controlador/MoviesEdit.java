/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.moreno.controlador;

import com.moreno.models.Movies;
import com.moreno.dao.MoviesManager;
import java.io.IOException;
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
@WebServlet(name = "MoviesEdit", urlPatterns = {"/MoviesEdit"})
public class MoviesEdit extends HttpServlet {

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
        Integer valoracion = 0;
        //Recogemos el id introducido
        String mid = request.getParameter("m_id");
        Integer id = Integer.parseInt(mid);
        Movies movie = mm.findMovie(id);
        if (movie == null) {
            mm.setStatus("Registro '" + mid + "' no encontrado.");
            response.setStatus(1);
        } else {
            mm.setMovie(movie);
        }

        String accion = request.getParameter("accion");
        try {
            switch (accion) {
                case "Editar":
                    request.setAttribute("movie", movie);
                    request.getRequestDispatcher("moviesedit.jsp").forward(request, response);
                    break;
                case "Guardar":
                    String titulo = request.getParameter("m_titulo");
                    String genero = request.getParameter("m_genero");
                    valoracion = Integer.parseInt(request.getParameter("m_valoracion"));
                    boolean visto = Boolean.valueOf(request.getParameter("m_visto"));
                    valoracion = (visto)? valoracion : 0;
                    String formato = request.getParameter("m_formato");

                    movie.setFormato(formato);
                    movie.setGenero(genero);
                    movie.setTitulo(titulo);
                    movie.setValoracion(valoracion);
                    movie.setVisto(visto);
                    mm.update(movie);
                    response.setStatus(1);
                    mm.setStatus("Registro actualizado correctamente.");
                    request.getRequestDispatcher("moviesedit.jsp").forward(request, response);
                    break;
                case "Borrar":
                    if (movie != null) {
                        mm.delete(movie);
                        response.setStatus(1);
                        mm.setStatus("Registro borrado correctamente.");
                        request.getRequestDispatcher("moviesedit.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("moviesedit.jsp").forward(request, response);
                    }
                    break;

            }
        } catch (NumberFormatException ex) {
            mm.setErrors(true);
            mm.setStatus("Valoración '" + valoracion + "' no es un número válido");
        } catch (IOException | ServletException ex) {
            Throwable cause = ex.getCause();
            mm.setErrors(true);
            if (cause instanceof ConstraintViolationException) {
                StringBuilder status = new StringBuilder("Error editando un título. ");
                ConstraintViolationException e = (ConstraintViolationException) cause;
                e.getConstraintViolations().stream().forEach(v -> status.append(v.getMessage()).append(" "));
                mm.setStatus(status.toString());
            } else if (cause instanceof OptimisticLockException) {
                mm.setStatus("El título ha sido modificado por otro usuario.");
            } else {
                mm.setStatus("Excepcion general (Rollback)");
            }
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
        processRequest(request, response);
    }

}
