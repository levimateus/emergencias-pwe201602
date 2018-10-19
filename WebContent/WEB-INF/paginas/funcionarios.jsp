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
        <title>Funcionários</title>
    </head>
    <body>
        <%@include file='/Templates/header.jsp'%>
        <%@include file='/Templates/navbar-master.jsp'%>
        
        <div class="alert alert-info" role="alert">
            <p>Funcionários no sistema!</p>
        </div>
        <form action="Controller" method="POST">
            <div class="col-lg-6">
            <div class="input-group">
              <input name="busca" type="text" class="form-control" placeholder="Buscar...">
              <span class="input-group-btn">
                <input type="hidden" name="tarefa" value="BuscaFuncionario">
                <input class="btn btn-success" type="submit" value="Encontrar"></button>
              </span>
            </div><!-- /input-group -->
          </div><!-- /.col-lg-6 -->
      </form>
      <br><br><br>
        <table class="table table-striped">
            <tr>
                <td>Id</td>
                <td>Nome</td>
                <td>Sobrenome</td>
                <td>Login<td>
                <td>Cargo<td>
                <td>Excluir<td>
            </tr>
            <c:forEach items="${funcionarios}" var="funcionario">
                <tr>
                    <td>${funcionario.funcId}</td>
                    <td>${funcionario.nome}</td>
                    <td>${funcionario.sobrenome}</td>
                    <td>${funcionario.login}<td>
                    <td>${funcionario.cargo}<td>
                    <td> 
                        <form action="Controller" method="POST">
                            <input type="hidden" name="id_func" value="${funcionario.funcId}">
                            <input type="hidden" name="tarefa" value="ExcluirFuncionario">
                            <input class="btn btn-danger" type="submit" value="Excluir">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
