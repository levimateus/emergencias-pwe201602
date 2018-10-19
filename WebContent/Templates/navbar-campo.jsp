<%-- 
    Document   : navbar
    Created on : 02/08/2016, 09:05:40
    Author     : pedro.augusto
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
                  <a href="VerPagina?action=home-campo">Home</a>
                </li>
                <li>
                  <a href="VerPagina?action=finaliza-step1">Finalizar ocorrência</a>
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


