<%-- 
    Document   : ProductEdit
    Created on : 1 jun. 2022, 17:52:57
    Author     : cristina
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/MoviesManager/css/movies.css">  
        <title>Edit - Movies Manager</title>       
    </head>
    <body>
        <header class="header">Edit </header>
        <nav class="nav"><a href="index.html">Inicio</a></nav>
        <section class="content">
            <c:if test="${mm.status !=null}">
                <div class="${ (mm.errors)?'error':'info'}">${mm.status}</div>
            </c:if>
            <form action="MoviesEdit" method="POST">
                <div class="field">
                    <label for="pid">ID:</label>
                    <input type="text" id="mid" name="m_id" value= "${mm.movie.id}"readonly>
                </div>
                <div class="field">
                    <label for="pformato">Formato:</label>
                    <select type="text" name="m_formato" id="formato" value = "${mm.movie.formato}"><br/>
                        <option value="Peliculas">Películas</option>
                        <option value="Series">Series</option>
                        <option value="Documentales">Documentales</option>
                    </select>
                </div>
                <div class="field">
                    <label for="ptitulo">Título:</label>
                    <input type="text" id="mtitulo" name="m_titulo" value="${mm.movie.titulo}" required>
                </div>
                <div class="field">
                    <label for="pgenero">Género:</label>
                    <input type="text" id="mgenero" name="m_genero" value="${mm.movie.genero}">
                </div>
                <div class="field">
                    <label for="pvaloracion">Valoración:</label>
                    <input type="text" id="mvaloracion" name="m_valoracion" value="${mm.movie.valoracion}">
                </div>
                <div class="field">
                    <label for="pvisto">Visto:</label>
                    <input type="text" id="mvisto" name="m_visto" value="${mm.movie.visto}">
                </div>
                <div class="field">
                    <input type="submit" id="submit" name = "accion" value="Guardar">
                </div>
            </form>
        </section>
    </body>
</html>