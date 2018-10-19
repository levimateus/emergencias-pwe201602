<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nova Ocorrencia</title>
    </head>
    <body>
        <%@include file='/Templates/header.jsp'%>
        <%@include file='/Templates/navbar-atendente.jsp'%>
        <form action="Controller" method="POST">
            Estado <input class="form-control" type="text" name="estado">
            
            Nível <input class="form-control" type="text" name="nivel">
            
            Descrição: <input class="form-control" type="text" name="descricao">
            
            Data de Registro:<input class="form-control" type="text" name="registro_dt">
            
            Id da Rua: <input class="form-control" type="text" name="rua_id">
            
            Tipo de veiculo necessário: <input class="form-control" type="text" name="tipoveiculo">
            
            <input type="hidden" name="tarefa" value="NovaOcorrencia">
            <br><br>
            <input class="btn btn-warning" type="submit" value="Cadastrar Ocorrencia">
            <br><br>
        </form>
    </body>
</html>
 
  
