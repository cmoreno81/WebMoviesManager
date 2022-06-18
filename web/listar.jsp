<%-- 
    Document   : listar
    Created on : 16 jun. 2022, 12:46:33
    Author     : cristina
--%>

<%@page import="java.lang.Exception"%>
<%@page import="java.util.List"%>
<%@page import="com.moreno.models.Movies"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/MoviesManager/css/movies.css">  
        <title>Listado de películas y series</title>
    </head>
    <body>
        <header class="header">Listado </header>
        <nav class="nav"><a href="index.html">Inicio</a></nav>
        <section class="content">
            <div class="col-md-8">
                <table aling = "center" border="1" class = "table">
                    <tr>
                        <th></th>
                        <th>Id</th>
                        <th>Formato</th>
                        <th>Titulo</th>
                        <th>Genero</th>
                        <th>Valoración</th>
                        <th>Visto</th>
                        <th></th>
                    </tr>

                    <c:forEach items="${resultados}" var="movie">
                        <tr>
                            <td></td>
                            <td>${movie.id}</td>
                            <td>${movie.formato}</td>
                            <td>${movie.titulo}</td>
                            <td>${movie.genero}</td>
                            <td>${movie.valoracion}</td>
                            <td>${movie.visto}</td> 
                            <td></td>    
                        </tr>    
                    </c:forEach> 
                </table>         
            </div>
        </section>

        <footer class="footer">Edición y Borrado</footer>
        <section class="content">
            <div>
                <label>ID: </label>
                <form action="MoviesEdit" method="POST">
                    <div class="field">
                        <input type="text" id="id" name="m_id" value="${mm.movie.id}" required>
                        <input type="submit" value="Editar" name = "accion">
                    </div>
                </form>
                <form action="MoviesEdit" method="POST">
                    <div class="field">
                        <input type="text" id="id" name="m_id" value="${mm.movie.id}" required>
                        <input type="submit" value="Borrar" name="accion">
                    </div>
                </form>
            </div>
        </section>
    </body>
</html>
