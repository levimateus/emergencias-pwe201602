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
        <title>Ocorrências</title>
    </head>
    <body>
        <%@include file='/Templates/header.jsp'%>
        <%@include file='/Templates/navbar-master.jsp'%>
        
        <div class="alert alert-info" role="alert">
            <p>Ocorrências no sistema!</p>
        </div>
        <table class="table table-striped">
            <tr>
                <td>Id</td>
                <td>Estado</td>
                <td>Nível</td>
                <td>Descrição<td>
                <td>Data Registro<td>
                <td>Rua ID<td>
            </tr>
            <c:forEach items="${ocorrencias}" var="ocorrencia">
                <tr>
                    <td>${ocorrencia.ocorrenciaId}</td>
                    <td>${ocorrencia.ocorrenciaEstado}</td>
                    <td>${ocorrencia.ocorrenciaNivel}</td>
                    <td>${ocorrencia.ocorrenciaDescricao}<td>
                    <td>${ocorrencia.ocorrenciaRegistroData}<td>
                    <td>${ocorrencia.ruaId}<td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
