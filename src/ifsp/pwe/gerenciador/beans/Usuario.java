/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifsp.pwe.gerenciador.beans;


/**
 *
 * @author Aluno
 */
public class Usuario {
    int funcId;
    String nome;
    String sobrenome;
    String email;
    String cpf;
    String endereco;
    String login;
    String senha;
    String nivel;
    String cargo;
    String nascimento;

    public int getFuncId() {
        return funcId;
    }

    public void setFuncId(int funcId) {
        this.funcId = funcId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    
    public Usuario(String nome,String sobrenome,String email,String cpf,String endereco,String login,
            String senha,String nivel,String cargo,String nascimento){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.cpf = cpf;
        this.endereco = endereco;
        this.login = login;
        this.senha = senha;
        this.nivel = nivel;
        this.cargo = cargo;
        this.nascimento = nascimento;
    }
    
    public Usuario(int id, String loginNome,String cargo){
        this.funcId = id;
        this.login = loginNome;
        this.cargo = cargo;
    }
    public Usuario(){
        
    }
    
    public Usuario(int id_inteiro,String nome,String sobrenome, String login, String cargo){
        this.funcId = id_inteiro;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.login = login;
        this.cargo = cargo;
    }
    
  
   

    
}
