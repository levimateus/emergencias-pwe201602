<%-- 
    Document   : logout
    Created on : 23/08/2016, 20:47:22
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Distribuidora de Doces</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@include file='/Templates/header.jsp'%>
        <%@include file='/Templates/navbar-default.jsp'%>
        <div class="container">
            <div class="row">
                <div class="jumbotron">
                    <h1>Você foi desconectado!</h1>
                    <p>Obrigado pelo acesso!</p>
                    <p>
                        <a class="btn btn-primary btn-lg" href="index.jsp" role="button">Home</a>
                        <a class="btn btn-warning btn-lg" href="NovoUsuario.jsp" role="button">Cadastro</a>
                        <a class="btn btn-success btn-lg" href="LoginAtendente.jsp" role="button">Login Atendente</a>
                        <a class="btn btn-danger btn-lg" href="LoginCampo.jsp" role="button">Login Campo</a>
                        <a class="btn btn-primary btn-lg" href="LoginMaster.jsp" role="button">Login Master</a>
                    </p>
                </div>
            </div>
        </div>
    </body>
</html>
