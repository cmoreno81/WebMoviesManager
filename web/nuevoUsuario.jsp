<%-- 
    Document   : nuevoUsuario
    Created on : 23 jun. 2022, 18:22:35
    Author     : cristina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/MoviesManager/css/movies.css"> 

        <title>Nuevo Usuario</title>
    </head>
    <header class="header">Insertar Usuario </header>
    <section class="content">
        <c:if test="${mm.status !=null}">
            <div class="${ (mm.errors)?'error':'info'}">${mm.status}</div>
        </c:if>
        <form action="Login" method="POST">
            <div class="col-md-8">
                <table aling = "center" border="1" class = "table">
                    <div class="field">
                        <label class = "label" for="usuario">Usuario:</label>
                        <input type="text" id="usuario" name="m_usuario" value="${mm.usuario.usuario}" required>
                    </div> 
                    <div class="field">
                        <label class = "label" for="pass">Contraseña:</label>
                        <input type="password" id="pass" name="m_pass" value="${mm.usuario.password}" required>
                    </div>
                    <div class="field">
                        <label class = "label" for="pass">Confirme Contraseña:</label>
                        <input type="password" id="pass" name="m_pass2" value="" required>
                    </div>
                    <div class="field">
                        <label class = "label">Estado:</label>
                        <select type="text" name="m_estado" id="estado"><br/>
                            <option value="Activado">Activado</option>
                            <option value="Desactivado">Desactivado</option>
                        </select>
                    </div>
                    <div class="field">
                        <label class = "label">Rol:</label>
                        <select type="text" name="m_rol" id="rol"><br/>
                            <option value="Administrador">Administrador</option>
                            <option value="Usuario">Usuario</option>
                        </select>
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
