<%-- 
    Document   : listar
    Created on : 16 jun. 2022, 12:46:33
    Author     : cristina
--%>

<%@page import="java.lang.Exception"%>
<%@page import="java.util.List"%>
<%@page import="com.moreno.models.Movies"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="/MoviesManager/css/movies.css">  
        <title>Listado de películas y series</title>
    </head>
    <body>
        <header class="header">Listado </header>
        <nav class="nav"><a href="menu.jsp">Inicio</a></nav>
        <section class="content">
            <div class="col-md-8">
                <table aling = "center" border="1" class = "table">
                    <c:choose>
                        <c:when test="${!mm.errors}">
                            <tr>
                                <th>Id</th>
                                <th>Formato</th>
                                <th>Titulo</th>
                                <th>Genero</th>
                                <th>Valoración</th>
                                <th>Visto</th>
                            </tr>
                            <c:forEach items="${resultados}" var="movie">
                                <tr>
                                    <td>${movie.id}</td>
                                    <td>${movie.formato}</td>
                                    <td>${movie.titulo}</td>
                                    <td>${movie.genero}</td>
                                    <td>${movie.valoracion}</td>
                                    <td>${movie.visto}</td> 
                                </tr>    
                            </c:forEach> 
                        </c:when>
                        <c:otherwise> 
                            <div class ='error'> ${mm.status}</div>
                        </c:otherwise>
                    </c:choose>
                </table>         
            </div>
        </section>
        <c:if test="${!mm.errors}">
            <c:choose> 
                <c:when test="${mm.usuario.roles == 'Administrador' }">
                    <footer class="footer">Edición y Borrado</footer>
                    <section class="content">
                        <div>
                            <label>ID: </label>
                            <form action="MoviesEdit" method="POST">
                                <div class="field">
                                    <input type="number" id="id" name="m_id" required>
                                    <input type="submit" value="Editar" name = "accion">
                                </div>
                            </form>
                            <form action="MoviesEdit" method="POST">
                                <div class="field">
                                    <input type="number" id="id" name="m_id" required>
                                    <input type="submit" value="Borrar" name="accion">
                                </div>
                            </form>
                        </div>
                    </section>
                </c:when>
            </c:choose>
        </c:if>
    </body>
</html>
