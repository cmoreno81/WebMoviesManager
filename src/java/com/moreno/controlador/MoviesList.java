/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.moreno.controlador;

import com.moreno.models.Movies;
import com.moreno.dao.MoviesManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cristina
 */
@WebServlet(name = "MoviesList", urlPatterns = {"/MoviesList"})
public class MoviesList extends HttpServlet {

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
            out.println("<title>Servlet MoviesManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MoviesManager at " + request.getContextPath() + "</h1>");
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
        String accion = request.getParameter("accion");
        String formato = request.getParameter("m_formato");
        String filtro = request.getParameter("m_filtros");
        String valueFiltro = request.getParameter("m_filtro");

        List<Movies> resultados = null;
        if (accion.equals("Buscar vistas") || accion.equals("Buscar pendientes")) {
            if (accion.equals("Buscar vistas")) {
                resultados = mm.findMoviesByVisto(true, formato);
            } else {
                resultados = mm.findMoviesByVisto(false, formato);
            }
        }

        if (accion.equals("Buscar")) {
            resultados = filtrar(filtro, valueFiltro, resultados);
        }

        switch (accion) {
            case "Buscar":
                if (isResults(resultados)) {
                    request.setAttribute("resultados", resultados);
                    request.getRequestDispatcher("listar.jsp").forward(request, response);
                } else {
                    response.setStatus(1);
                    request.getRequestDispatcher("moviesedit.jsp").forward(request, response);
                }
                break;
            case "Buscar todos":
                resultados = mm.findAllMovies();
                isResults(resultados);
                request.setAttribute("resultados", resultados);
                request.getRequestDispatcher("listar.jsp").forward(request, response);
                break;
            case "Buscar vistas":
                isResults(resultados);
                request.setAttribute("resultados", resultados);
                request.getRequestDispatcher("listar.jsp").forward(request, response);
                break;
            case "Buscar pendientes":
                isResults(resultados);
                request.setAttribute("resultados", resultados);
                request.getRequestDispatcher("listar.jsp").forward(request, response);
                break;
        }

    }

    private boolean isResults(List<Movies> resultados) {
        boolean isResults = false;
        if (!resultados.isEmpty() || resultados.size() > 0) {
            mm.setMovies(resultados);
            isResults = true;
        } else {
            mm.setStatus("No existen títulos en la base de datos.");
            mm.setErrors(true);
        }

        return isResults;
    }

    private List<Movies> filtrar(String filtro, String value, List<Movies> resultados) {
        switch (filtro) {
            case "id":
                resultados = new ArrayList<>();
                try {
                    Movies movie = mm.findMovie(Integer.parseInt(value));
                    if (movie != null) {
                        resultados.add(movie);
                    }
                } catch (NumberFormatException ex) {
                    mm.setErrors(true);
                    mm.setStatus("El ID: '" + value + "' no es un número válido.");
                }
                break;
            case "titulo":
                resultados = mm.findMoviesByName(value);
                break;
            default:
                resultados = mm.findMoviesByGenero(value);
                break;
        }
        return resultados;

    }

}
