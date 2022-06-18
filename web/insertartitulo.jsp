<%-- 
    Document   : buscarTitulo
    Created on : 16 jun. 2022, 11:36:37
    Author     : cristina
--%>

<%@page import="com.moreno.models.Genero"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/MoviesManager/css/movies.css">  
        <title>Insertar Título</title>
    </head>
    <body>
        <header class="header">Insertar Registro </header>
        <nav class="nav"><a href="index.html">Inicio</a></nav>
        <section class="content">
            <form action="InsertMovies" method="POST">
                <div class="col-md-8">
                    <table aling = "center" border="1" class = "table">
                        <div class="field">
                            <label class = "field label" for="id">Formato:</label>
                            <select type="text" name="m_formato" id="formato"><br/>
                                <option value="Peliculas">Películas</option>
                                <option value="Series">Series</option>
                                <option value="Documentales">Documentales</option>
                            </select>                         
                        </div> 
                        <div class="field">
                            <label class = "field label" for="titulo">Titulo:</label>
                            <input type="text" id="titulo" name="m_titulo" value="${mm.movie.titulo}" required>
                        </div>
                        <div class="field">
                            <label class = "field label">Género:</label>
                            <select class="form-control" id="genero" name="m_genero2">
                                <c:forEach items="${mm.genero.values}" var="genero">
                                    <option value="${genero}">${genero.getGenero()}</option>
                                </c:foreach>
                            </select>
                             <select type="text" name="m_genero" id="genero"><br/>
                                <option value="${mm.genero.ACCION}">Acción</option>
                                <option value="${mm.genero.AVENTURAS}">Aventuras</option>
                                <option value="${mm.genero.BELICA}">Bélica</option>
                                <option value="${mm.genero.CIENCIA_FICCION}">Ciencia Ficción</option>
                                <option value="${mm.genero.COMEDIA}">Comedia</option>
                                <option value="${mm.genero.DRAMA}">Drama</option>
                                <option value="${mm.genero.ROMANTICA}">Romántica</option>
                                <option value="${mm.genero.TERROR}">Terror</option>
                            </select>
                        </div>
                        <div class="field">
                            <label class = "field label" for="valoracion">Valoración:</label>
                            <input type="number" id="valoracion" name="m_valoracion" value="${mm.movie.valoracion}">
                        </div>
                        <div class="field">
                            <label class = "field label" for="visto">Visto:</label>
                            <input type="checkbox" id="visto" name="m_visto" value="true">
                        </div>
                        <div class="field">
                            <input type="submit" id="submit" name= "accion" value="Insertar">
                        </div>
                    </table>
                </div>
            </form>  
        </section>
    </body>
</html>
