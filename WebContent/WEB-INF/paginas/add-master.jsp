<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Master</title>
    </head>
    <body>
        <%@include file='/Templates/header.jsp'%>
        <%@include file='/Templates/navbar-master.jsp'%>
           <form action="Controller" method="POST">
            
            Nome: <input class="form-control" type="text" name="nome">
            
            Sobrenome: <input class="form-control" type="text" name="sobrenome">
            
            E-mail: <input class="form-control" type="text" name="email">
            
            CPF: <input class="form-control" type="text" name="cpf">
            
            Endereço:<input class="form-control" type="text" name="endereco">
            
            Login: <input class="form-control" type="text" name="login">
            
            Senha para acesso: <input class="form-control" type="text" name="senha">
            
            Nível: <input class="form-control" type="text" name="nivel">
            
            <br>
            Cargo:&nbsp;&nbsp;&nbsp;
            <input type="radio" checked="checked" name="cargo" value="master">&nbsp;Master<br> <br>
            
            Data de Nascimento: <input class="form-control" type="text" name="dt_nascimento">
            
            <input type="hidden" name="tarefa" value="NovoUsuario">
            <br><br>
            <input class="btn btn-primary" type="submit" value="Cadastrar Master">
            <br><br>
        </form>
    </body>
</html>
 
  
