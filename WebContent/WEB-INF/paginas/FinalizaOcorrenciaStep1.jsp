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
        <%@include file='/Templates/navbar-campo.jsp'%>
        <div class="container">
            <div class="row">
                <div class="jumbotron">
                    <h1>Busque a ocorrência</h1>
                    <form action="Controller" method="POST">
                        Id da ocorrência: <input class="form-control" type="text" name="ocorrencia_id">
                        <input type="hidden" name="tarefa" value="BuscaOcorrencia">
                        <br><br>
                        <input class="btn btn-warning" type="submit" value="Buscar Ocorrencia">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
