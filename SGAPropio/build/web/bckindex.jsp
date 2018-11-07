<%-- 
    Document   : index
    Created on : 09-jul-2018, 19:10:07
    Author     : jaime
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Backup</title>
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
            <section class="main row col-xs-4 col-xs-offset-4 borde">
                <!--<div class="borde">-->
                    <form name="login_form" action="<%=request.getContextPath()%>/controller/servletControlador?accion=login"
                        method="post" onsubmit="return validarForm(this);">
                    <!--<form name="login:form" action="?accion=login" method="post" onsubmit="return validarForm(this);"
                        method="post" onsubmit="return validarForm(this);">-->
                        <label id="form_element">Nombre: </label>
                        <input type="text" name="username" value="Escribir usuario" 
                            onfocus="if(this.value == 'Escribir usuario') { this.value = ''; }"
                            onfocusout="if(this.value == ''){this.value = 'Escribir usuario';}"/><br/>
                        <label id="form_element">Contraseña: </label>
                        <input type="password" name="password"/><br/><br/>
                        <input type="submit" value="Enviar" class="btn btn-primary">

                    </form>
                <!--</div>-->
            </section>
            <div class="row col-xs-4 colx-xs-offset-4 error">
                <div>
                    <p style = "color:red;">${mensaje}</p>
                </div>
            </div>
        </div>
        
    </body>
</html>
