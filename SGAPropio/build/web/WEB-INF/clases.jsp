<%-- 
    Document   : clases
    Created on : 03-sep-2018, 19:10:55
    Author     : jaime
--%>

<%@page import="model.Asignatura"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clases y asignaturas</title>
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
                <table class="table table-dark table-bordered table-sm">
                    <tr>
                        <th scope="row">
                            Asignaturas del grupo ${grupoobj.grupo}
                        </th>  
                        <c:forEach items="${sessionScope.arrAsignaturas}" var="as"> 
                            <td>${as.nombre}</td>
                        </c:forEach>
                    </tr>
                    
                </table>
            </div>
        </div>
    </body>
</html>
