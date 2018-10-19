<%-- 
    Document   : home-cliente
    Created on : 18/09/2016, 10:16:21
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                    <h2>Dados atualizados da ocorrência</h2>
                    <fieldset>
                        <p>Estado: ${ocorrencia.ocorrenciaEstado} </p>
                        <p>Nível: ${ocorrencia.ocorrenciaNivel} </p>
                        <p>Data de Registro: ${ocorrencia.ocorrenciaRegistroData} </p>
                        <p>Rua: ${ocorrencia.ruaId} </p>
                        <p>Descrição: ${ocorrencia.ocorrenciaDescricao} </p>
                    </fieldset>
                    <hr>
                    <h2>Dados atualizados da rua da ocorrência</h2>
                    <p>Região ID: ${ruaEvac.regiaoId}</p>
                    <p>Rua ID: ${ruaEvac.ruaId}</p>
                    <p>Rua Nome: ${ruaEvac.ruaNome}</p>
                    <p>Rua Status: ${ruaEvac.ruaStatus}</p>
                    <p>Coord X: ${ruaEvac.ruaLoc_x}</p>
                    <p>Coord Y: ${ruaEvac.ruaLoc_y}</p>
                    <hr>
                    <h2>Dados atualizados do veiculo da Ocorrencia</h2>
                    <fieldset>
                        <p>Veículo ID ${veiculo.veiculoId}</p>
                        <p>Veículo Tipo: ${veiculo.veiculoTipo}</p>
                        <p>Veículo Estado: ${veiculo.veiculoEstado}</p>
                        <p>Veículo Placa: ${veiculo.veiculoPlaca}</p>
                        <p>Veículo Rua: ${veiculo.ruaId}</p>
                    </fieldset>
                    
                </div>
            </div>
        </div>
    </body>
</html>
