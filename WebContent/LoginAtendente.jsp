<%-- 
    Document   : LoginCliente
    Created on : 20/09/2016, 01:01:48
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Cliente</title>
    </head>
    <body>
        <%@include file='/Templates/header.jsp'%>
        <%@include file='/Templates/navbar-default.jsp'%>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-success">
                    <div class="panel-heading">
                        <h3 class="panel-title">Login Atendente</h3>
                    </div>
                    <div class="panel-body">
                        <form action="Controller" method="POST">
                            <fieldset>
                                <div class="form-group">
                                     <label for="cnpj">Login:</label>
                                     <input class="form-control" type="text" name="login">
                                </div>
                                <div class="form-group">
                                     <label for="senha">Senha:</label>
                                     <input class="form-control" type="password" name="senha">
                                </div>
                                <input type="hidden" name="tarefa" value="Login">
                                <input class="btn btn-success" type="submit" value="Fazer login!">
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>
