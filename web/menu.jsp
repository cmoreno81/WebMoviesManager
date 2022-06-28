<%-- 
    Document   : menu
    Created on : 27 jun. 2022, 17:05:11
    Author     : cristina
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Movies Manager</title>
        <meta charset="ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/MoviesManager/css/movies.css">   
    </head>
    <body>
        <section class="content">
            <h1>Movies Manager</h1>
            <p>            
                Bienvenido - ${mm.usuario.usuario}
                <small> Usted es, ${mm.usuario.roles} </small>
            </p>      
            <c:if test="${mm.usuario.roles == 'Administrador' }">
                <a href="insertartitulo.jsp">
                    <div class="field label">
                        <input type="submit" value="Insertar">
                    </div>
                </a><br>
            </c:if>
            <form action="MoviesList" method="POST">
                <div class="field label">
                    <input type="submit" value="Buscar todos" name = "accion">
                </div>
            </form>
            <br>
            <form action="MoviesList" method="POST">
                <div>
                    <label class="field label" for="id">Buscar por: </label>
                    <select type="text" name="m_filtros" id="filtros"><br/>
                        <option value="id">ID</option>
                        <option value="titulo">Título</option>
                        <option value="genero">Género</option>
                    </select>
                    <input type="text" id="filtro" name="m_filtro" required>
                    <input type="submit" value="Buscar" name = "accion">
                </div> 
            </form>
            <form action="MoviesList" method="POST">
                <div class="field label">
                    <label for="id">Filtrar por: </label>
                    <select type="text" name="m_formato" id="formato"><br/>
                        <option value="Películas">Películas</option>
                        <option value="Series">Series</option>
                        <option value="Documentales">Documentales</option>
                    </select>
                    <input type="submit" value="Buscar vistas" name = "accion">
                    <input type="submit" value="Buscar pendientes" name = "accion">
                </div> 
            </form><br>
            <form action="Login" method="POST">
                <input type="submit" value="Cerrar" name = "accion">
                </div> 
            </form>
            <br>
        </section>
    </body>
</html>

