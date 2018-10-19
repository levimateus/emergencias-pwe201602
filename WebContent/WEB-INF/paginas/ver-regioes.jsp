<%-- 
    Document   : VerDoces
    Created on : 18/09/2016, 09:53:46
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Veículos</title>
    </head>
    <body>
        <%@include file='/Templates/header.jsp'%>
        <%@include file='/Templates/navbar-atendente.jsp'%>
        
        <div class="alert alert-info" role="alert">
            <p>Regiões no sistema!</p>
        </div>
      <br>
        <table class="table table-striped">
            <tr>
                <td>Id</td>
                <td>Nome</td>
                <td>Ocorrências</td>
            </tr>
            <c:forEach items="${regioes}" var="regiao">
                <tr>
                    <td>${regiao.regiaoId}</td>
                    <td>${regiao.regiaoNome}</td>
                    <td>${regiao.ocorrencia}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
