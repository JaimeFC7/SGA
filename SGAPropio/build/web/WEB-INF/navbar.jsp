<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script>
            $(".navbar-nav li a").click(function (event) {
                var toggle = $(".navbar-toggle").is(":visible");
                if (toggle) {
                  $(".navbar-collapse").collapse('hide');
                }
            });
        </script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/rec/css/navbar.css"/>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <div class="user-info">
                        <form action="<%=request.getContextPath()%>/controller/servletControlador?accion=userinfo" name="profile_form" method="POST">
                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                            <span id="username">
                                <input type="submit" value="<%= (String)session.getAttribute("login")%>" class="btn btn-primary">
                            </span>
                        </form>
                    </div>
                </div>
                <div class="collapse navbar-collapse" id="navbar">
                    <ul class="nav navbar-nav">
                        <li>
                            <form action="<%=request.getContextPath()%>/controller/servletControlador?accion=inicio" name="welcome_form" method="POST">
                                <span id="inicio">
                                    <input type="submit" value="Inicio" class="btn btn-primary">
                                </span>
                            </form>
                        </li>
                        <% if(session.getAttribute("tipo").toString().equalsIgnoreCase("Alumno")){ %>
                        <li>
                            <a href="<%=request.getContextPath()%>/controller/servletControlador?accion=grupo">
                                Zona de clase
                            </a>
                        </li>
                        <% }else if(session.getAttribute("tipo").toString().equalsIgnoreCase("Profesor")){ %>
                        <li>
                            <a href="#">Zona del tutor</a>
                        </li>
                        <li>
                            <a href="#">Asignaturas</a>
                        </li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </nav>
    </body>
</html>