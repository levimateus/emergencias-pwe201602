<%-- 
    Document   : index
    Created on : 20/09/2016, 01:05:45
    Author     : Guilherme 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Sistema de Emergências</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@include file='/Templates/header.jsp'%>
        <%@include file='/Templates/navbar-default.jsp'%>
        <div class="container">
        <div class="row">
                
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-warning">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-sign-in fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div><h4>Cadastre-se!</h4></div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <center>
                                <a href="NovoUsuario.jsp"><button class="btn btn-warning">Novo Cadastro</button></a>
                            </center>
                        </div>
                        </a>
                    </div>
                </div>
                
                 <div class="col-lg-3 col-md-6">
                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-users fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div><h4>Login Atendente!</h4></div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <center>
                                <a href="LoginAtendente.jsp"><button class="btn btn-success">Login Atendente</button></a>
                            </center>
                        </div>
                    </div>
                </div>
                
                 <div class="col-lg-3 col-md-6">
                    <div class="panel panel-danger">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa fa-user-plus fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div><h4>Login Campo!</h4></div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <center>
                                <a href="LoginCampo.jsp"><button class="btn btn-danger">Login Campo</button></a>
                            </center>
                        </div>
                    </div>
                </div>
            
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-user fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div><h4>Login Master!</h4></div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <center>
                                <a href="LoginMaster.jsp"><button class="btn btn-primary">Login Master</button></a>
                            </center>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

