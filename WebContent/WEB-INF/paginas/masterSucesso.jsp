<%-- 
    Document   : CadastroDistribuidorSucesso
    Created on : 27/09/2016, 20:47:01
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Distribuidora de Doces</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@include file='/Templates/header.jsp'%>
        <%@include file='/Templates/navbar-master.jsp'%>
        <div class="container">
            <div class="row">
                <div class="jumbotron">
                    <h1>Cadastrado com sucesso!</h1>
                    <p><a class="btn btn-primary btn-lg" href="VerPagina?action=home-master" role="button">Home</a></p>
                    <p><a class="btn btn-primary btn-lg" href="VerPagina?action=funcionarios" role="button">Gerenciar Funcionários</a></p>
                </div>
            </div>
        </div>
    </body>
</html>