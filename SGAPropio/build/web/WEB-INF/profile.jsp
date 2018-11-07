<%-- 
    Document   : profile
    Created on : 21-ago-2018, 19:09:36
    Author     : jaime
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>-->
        <!-- Latest compiled JavaScript -->
        <!--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/rec/css/profile.css"/>
    </head>
    <body class="bg">
        <div class="container-fluid">
            <jsp:include page="navbar.jsp"/>
            <div class="row">
                <section class="col-md-offset-3 col-md-2" id="profile-pic">
                    <img src="http://via.placeholder.com/250x250" alt="">
                </section>
                <section class="col-md-4" id="profile-info">
                    <ul class="atributos">
                        <li>${userobj.nombre}</li>
                        <li><%= session.getAttribute("tipo").toString() %> / <%= session.getAttribute("login").toString() %></li><br/>
                        <li>${userobj.genero}, ${userobj.edad} años</li><br/>
                    <%
                        if(session.getAttribute("tipo").toString().equalsIgnoreCase("Alumno")){
                    %>
                        <!--TODO: Datos de tabla GRUPOS-->
                    <%
                        }else if(session.getAttribute("tipo").toString().equalsIgnoreCase("Profesor")){
                    %>
                        <!--TODO: Datos de tabla TUTORIZA-->
                    <%
                        }
                    %>
                    </ul>

                </section>
            </div>
        </div>
    </body>
</html>
