<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finalizar Ocorrencia</title>
    </head>
    <body>
        <%@include file='/Templates/header.jsp'%>
        <%@include file='/Templates/navbar-campo.jsp'%>
        <div class="container">
            <div class="row">
                <div class="jumbotron">
                    <form action="Controller" method="POST">
                        <h2>Dados da ocorrência ${ocorrencia.ocorrenciaId}</h2>
                        <br>ID <input class="form-control" type="text" name="ocorrenciaId" value="${ocorrencia.ocorrenciaId}">
                        <br>Estado <input class="form-control" type="text" name="estado" value="${ocorrencia.ocorrenciaEstado}">
                        <br>Nível <input class="form-control" type="text" name="nivel" value="${ocorrencia.ocorrenciaNivel}">
                        <br>Tipo de Veiculo: <input class="form-control" type="text" name="tipoveiculo" value="${ocorrencia.ocorrencia_veiculo_tipo}">
                        <br>Descrição: <input class="form-control" type="text" name="descricao" value="${ocorrencia.ocorrenciaDescricao}">
                        <br>Comentarios: <input class="form-control" type="text" name="comentario">
                        <br>Data de Registro:<input class="form-control" type="text" name="registro_dt" value="${ocorrencia.ocorrenciaRegistroData}"> 
                        <br>Data Finalização: <input class="form-control" type="text" name="data">
                        <br>Id da Rua: <input class="form-control" type="text" name="rua_id" value="${ocorrencia.ruaId}">
                        <br>Funcionario ID <input class="form-control" type="text" name="funcionario_id">
                        <br>Sensor ID <input class="form-control" type="text" name="sensor_id" value="${ocorrencia.ruaId}">
                        
                        <input type="hidden" name="tarefa" value="FinalizaOcorrencia">
                        <br><br>
                        <input class="btn btn-warning" type="submit" value="Finalizar Ocorrência">
                        <br><br>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
 
  
