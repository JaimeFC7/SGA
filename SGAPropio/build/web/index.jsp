<%-- 
    Document   : index
    Created on : 09-jul-2018, 19:10:07
    Author     : jaime
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/rec/css/index.css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/rec/funciones.js"></script> 
        
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body class="bg">
        <% 
            //Si hay una sesión anterior, redirige a la pagina de bienvenida
            if(session.getAttribute("login") != null && 
                    !session.getAttribute("login").equals("")){
                //response.sendRedirect("welcome.jsp"); 
            }     
        %>

        <div class="container">
            <div class="main row">
                <section class="col-xs-4 col-xs-offset-4 borde">
                    <form action="<%=request.getContextPath()%>/controller/servletControlador?accion=login" name="login_form" method="POST" onsubmit="return validarForm(this);">
                        <label for="" id="form_element">Nombre: </label>
                        <input type="text" name="username" value="Escribir usuario" onfocus="if(this.value == 'Escribir usuario') { this.value = ''; }" onfocusout="if(this.value == ''){this.value = 'Escribir usuario';}"><br>
                        <label for="" id="form_element">Contraseña: </label>
                        <input type="password" name="password"><br><br>
                        <input type="submit" value="Enviar" class="btn btn-primary">
                    </form>
                </section>
            </div>

            <div class="row">
                <div class="col-xs-6 col-xs-offset-3">
                    <p class="error">
                        ${mensaje}
                    </p>
                </div>
            </div>
        </div>
        
    </body>
</html>
