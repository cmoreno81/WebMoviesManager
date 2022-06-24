<%-- 
    Document   : buscarTitulo
    Created on : 16 jun. 2022, 11:36:37
    Author     : cristina
--%>

<%@page import="com.moreno.models.Genero"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="/MoviesManager/css/movies.css">  
        <title>Insertar Título</title>
    </head>
    <body>
        <header class="header">Insertar Registro </header>
        <nav class="nav"><a href="menu.html">Inicio</a></nav>
        <section class="content">
            <form action="InsertMovies" method="POST">
                <div class="col-md-8">
                    <table aling = "center" border="1" class = "table">
                        <div class="field">
                            <label class = "field label" for="id">Formato:</label>
                            <select type="text" name="m_formato" id="formato"><br/>
                                <option value="Películas">Películas</option>
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
                            <!-- <select class="form-control" id="genero" name="m_genero2">
                                <c:forEach items="${mm.genero.values}" var="genero">
                                    <option value="${genero}">${mm.genero.value}</option>
                                </c:foreach>
                            </select>-->
                             <select type="text" name="m_genero" id="genero"><br/>
                                <option value="Acción">Acción</option>
                                <option value="Aventuras">Aventuras</option>
                                <option value="Bélica">Bélica</option>
                                <option value="Ciencia Ficción">Ciencia Ficción</option>
                                <option value="Comedia">Comedia</option>
                                <option value="Drama">Drama</option>
                                <option value="Romántica">Romántica</option>
                                <option value="Terror">Terror</option>
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
