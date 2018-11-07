<%-- 
    Document   : welcome
    Created on : 15-ago-2018, 16:44:33
    Author     : jaime
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>-->
        <!-- Latest compiled JavaScript -->
        <!--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/rec/css/news.css"/>
    </head>
    <body class="bg">
        <div class="container-fluid">
            <jsp:include page="navbar.jsp"/>
            <div class="row">
                <section class="col-md-offset-1 col-md-3" id="img1">
                    <img src="http://via.placeholder.com/250x250" alt="">
                </section>
                <section class="col-md-7" id="parr1">
                    <h3>Titulo 1</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dignissimos eveniet quia nesciunt cum laboriosam, itaque odio nostrum nemo obcaecati, deleniti ad iusto officiis veritatis quam debitis fuga. Facere, aspernatur cum.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eaque, tempora veritatis dolorum molestiae ducimus quo corporis sapiente reiciendis necessitatibus dolores amet velit ipsam aspernatur ipsum reprehenderit facere mollitia delectus similique.</p>
                </section>
            </div>
            <br>
            <div class="row">
                <section class="col-md-offset-1 col-md-7" id="parr2">
                    <h3>Titulo 2</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dignissimos eveniet quia nesciunt cum laboriosam, itaque odio nostrum nemo obcaecati, deleniti ad iusto officiis veritatis quam debitis fuga. Facere, aspernatur cum.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eaque, tempora veritatis dolorum molestiae ducimus quo corporis sapiente reiciendis necessitatibus dolores amet velit ipsam aspernatur ipsum reprehenderit facere mollitia delectus similique.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis, doloribus, quia itaque enim non officiis laborum, distinctio temporibus aliquid quos assumenda earum velit voluptatum similique perspiciatis ad optio incidunt corrupti!</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci nisi fuga beatae quis dolor rerum eveniet assumenda, velit natus amet quos ducimus debitis at, aliquid necessitatibus ex perferendis a? Perferendis.</p>
                </section>
                <section class="col-md-3" id="img2">
                    <img src="http://via.placeholder.com/300x300" alt="">
                </section>
                
            </div>
            <br>
        </div>
            
                        <%
                if(session.getAttribute("tipo").toString().equalsIgnoreCase("Alumno")){
            %>
                <p>Alumno: ${userobj.nombre}</p>
            <%
                }else if(session.getAttribute("tipo").toString().equalsIgnoreCase("Profesor")){
            %>
                <p>Profesor: ${userobj.nombre}</p>
            <%
                }
            %>
    </body>
</html>
