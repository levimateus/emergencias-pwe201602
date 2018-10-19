<%-- 
    Document   : home-cliente
    Created on : 18/09/2016, 10:16:21
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%@include file='/Templates/header.jsp'%>
        <%@include file='/Templates/navbar-atendente.jsp'%>
        <div class="container">
            <div class="row">
                <div class="jumbotron">
                    <h1>Bem-vindo Atendente!</h1>
                    <p>Seu Login: ${usuarioLogado.login} </p>
                    <p>Você já pode começar as suas atividades.</p>
                </div>
            </div>
        </div>
    </body>
</html>
