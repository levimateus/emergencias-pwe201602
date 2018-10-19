<%-- 
    Document   : home-distribuidor
    Created on : 18/09/2016, 10:16:09
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%@include file='/Templates/header.jsp'%>
        <%@include file='/Templates/navbar-master.jsp'%>
        <div class="container">
            <div class="row">
                <div class="jumbotron">
                    <h1>Bem-vindo!</h1>
                    <p>Seu Login: ${usuarioLogado.login} </p>
                    <p>Você já pode começar as suas atividades.</p>
                </div>
            </div>
        </div>
    </body>
</html>
