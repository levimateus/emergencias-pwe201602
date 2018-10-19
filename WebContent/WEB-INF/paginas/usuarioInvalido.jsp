<%-- 
    Document   : usuarioInvalido
    Created on : 23/08/2016, 20:43:39
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuário Inválido</title>
    </head>
    <body>
        <%@include file='/Templates/header.jsp'%>
        <%@include file='/Templates/navbar-default.jsp'%>
        <div class="container">
            <div class="row">
                <div class="jumbotron">
                    <h1>Ops...Usuário Inválido</h1>
                    <p>Parece que o Login e/ou a senha estão incorretos.</p>
                    <p>
                        <a class="btn btn-primary btn-lg" href="index.jsp" role="button">Home</a>
                        <a class="btn btn-warning btn-lg" href="NovoUsuario.jsp" role="button">Cadastro</a>
                        <a class="btn btn-success btn-lg" href="LoginAtendente.jsp" role="button">Login Atendente</a>
                        <a class="btn btn-danger btn-lg" href="LoginCampo.jsp" role="button">Login Campo</a>
                    </p>
                </div>
            </div>
        </div>
    </body>
</html>
