<%-- 
    Document   : navbar-cliente
    Created on : 18/09/2016, 10:01:25
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" >
    <div class="container" style="padding-top: 15px;">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav ">
                <li>
                  <a href="VerPagina?action=home-master">Home</a>
                </li>
                <li>
                  <a href="VerPagina?action=funcionarios">Gerenciar Funcionários</a>
                </li>
                <li>
                  <a href="VerPagina?action=veiculos">Gerenciar Veículos</a>
                </li>
                <li>
                  <a href="VerPagina?action=ver-ocorrencias">Visualizar ocorrências</a>
                </li>
                <li>
                  <a href="VerPagina?action=add-master">Novo Master</a>
                </li>
            </ul>
            <div class="pull-right">
                <form action="Controller" method="POST">
                    <input type="hidden" name="tarefa" value="Logout">
                    <button class="btn btn-danger" type="submit">Logout</button>
                </form>
            </div>
        </div>
    </div>
</nav><br><br><br><br>
<div class="container">
