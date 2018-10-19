<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Usuário</title>
    </head>
    <body>
        <%@include file='/Templates/header.jsp'%>
        <%@include file='/Templates/navbar-default.jsp'%>
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
            Cargo:<br>
            <input type="radio" name="cargo" value="policial">&nbsp;Policial&nbsp;&nbsp;&nbsp; 
            
            <input type="radio" name="cargo" value="bombeiro">&nbsp;Bombeiro&nbsp;&nbsp;&nbsp; 
            
            <input type="radio" name="cargo" value="paramedico">&nbsp;Paramedico&nbsp;&nbsp;&nbsp; 
            
            <input type="radio" name="cargo" value="atendente">&nbsp;Atendente <br><br>
            
            Data de Nascimento: <input class="form-control" type="text" name="dt_nascimento">
            
            <input type="hidden" name="tarefa" value="NovoUsuario">
            <br><br>
            <input class="btn btn-warning" type="submit" value="Cadastrar Funcionário">
            <br><br>
        </form>
    </body>
</html>
 
  
