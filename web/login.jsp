<%-- 
    Document   : login
    Created on : 23 jun. 2022, 16:17:35
    Author     : cristina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="/MoviesManager/css/movies.css">
        <title>Login</title>
    </head>
    <body>
        <c:if test="${mm.status !=null}">
            <div class="${ (mm.errors)?'error':'info'}">${mm.status}</div>
        </c:if>
        <c:choose>
            <c:when test="${!mm.status}">
                <section class="content">
                    <form name="login" action="Login" method="POST">
                        <label class= "field" for="usuario">Usuario:</label>
                        <input type="text" name="m_usuario"/><br>
                        <label class= "field" for="pass">Contraseña:</label>
                        <input type="password" name="m_pass"/><br>
                        <div class="submit_content">
                            <input type="submit" value="Nuevo Usuario" name= "accion" />
                            <input type="submit" value="Login" name= "accion" />
                        </div>
                        
                    </form>
                </section>
            </c:when>
            <c:otherwise> 
                <div class ='error'> ${mm.status}</div>
            </c:otherwise>
        </c:choose>
    </body>
</html>
