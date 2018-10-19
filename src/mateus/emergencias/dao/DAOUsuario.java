/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mateus.emergencias.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import mateus.emergencias.beans.*;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class DAOUsuario {
    private Connection connection;
    public DAOUsuario() throws ClassNotFoundException{
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public int adicionaUsuario (Usuario usuario) throws SQLException{
         String sql = "INSERT INTO funcionario(func_nome,func_sobrenome,func_email, func_cpf, func_endereco, func_login, func_senha,func_nivel,func_cargo,func_nasc_dt) VALUES(?,?,?,?,?,?,?,?,?,?)";
         PreparedStatement stmt = connection.prepareStatement(sql);
         stmt.setString(1, usuario.getNome());
         stmt.setString(2, usuario.getSobrenome());
         stmt.setString(3, usuario.getEmail());
         stmt.setString(4, usuario.getCpf());
         stmt.setString(5, usuario.getEndereco());
         stmt.setString(6, usuario.getLogin());
         stmt.setString(7, usuario.getSenha());
         stmt.setString(8, usuario.getNivel());
         stmt.setString(9, usuario.getCargo());
         stmt.setString(10, usuario.getNascimento());

         
        boolean execute = stmt.execute();
        if(execute == true){
            return 1;
        }else{
            return 0;
        }
    }
    
    public int removeUsuario(int cod) throws ClassNotFoundException{
        int nlinhas;
        
        nlinhas = this.consulta(cod);
        if(nlinhas == 0) return 0;
                
        String query = "DELETE FROM funcionario WHERE func_id = "+cod;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.execute();
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        return 1;
    }
    
    public int atualizaDadosUsuario(Usuario usuario) throws ClassNotFoundException{
        //consulta
        int linhas;
        linhas = this.consulta(usuario.getFuncId());
        
        if(linhas == 0){
            return 0;
        }
        
        String query = "UPDATE funcionario "
                + "SET "
                + "func_nome      = ?, "
                + "func_sobrenome = ?, "
                + "func_email     = ?, "
                + "func_cpf       = ?, "
                + "func_endereco  = ?, "
                + "func_login     = ?, "
                + "func_senha     = ?, "
                + "func_nivel     = ?, "
                + "func_cargo     = ?, "
                + "func_nasc_dt   = ? "
                + "WHERE func_id = "+usuario.getFuncId();

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            //nome
            stmt.setString(1, usuario.getNome());
            //sobrenome
            stmt.setString(2, usuario.getSobrenome());
            //email
            stmt.setString(3, usuario.getEmail());
            //cpf
            stmt.setString(4, usuario.getCpf());
            //endereco
            stmt.setString(5, usuario.getEndereco());
            //login
            stmt.setString(6, usuario.getLogin());
            //senha
            stmt.setString(7, usuario.getSenha()); 
            //nivel
            stmt.setString(8, usuario.getNivel());
            //cargo
            stmt.setString(9, usuario.getCargo());
            //data de nascimento
            stmt.setString(10, (usuario.getNascimento()));
            
            stmt.execute(); //executa transação
            stmt.close();   //fecha conexção com o banco de dados
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return 1;
    }
    
    public Usuario consultaUsuario(int cod) throws ClassNotFoundException{
        int numLinhas;
        Usuario usuario;
        String query;
        ResultSet resultado;
        
        numLinhas = this.consulta(cod);
        
        if(numLinhas == 0){
            return null;
        }
        
        query = "SELECT * FROM funcionario WHERE func_id = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, cod);
            resultado = stmt.executeQuery();
            
            
            usuario = new Usuario();
        
            while(resultado.next()){
                usuario.setFuncId(resultado.getInt("func_id"));
                usuario.setNome(resultado.getString("func_nome"));
                usuario.setSobrenome(resultado.getString("func_sobrenome"));
                usuario.setEmail(resultado.getString("func_email"));
                usuario.setCpf(resultado.getString("func_cpf"));
                usuario.setEndereco(resultado.getString("func_endereco"));
                usuario.setLogin(resultado.getString("func_login"));
                usuario.setSenha(resultado.getString("func_senha"));
                usuario.setNivel(resultado.getString("func_nivel"));
                usuario.setCargo(resultado.getString("func_cargo"));
                usuario.setNascimento(resultado.getString("func_nasc_dt"));
            }
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
            
        }
        
        return usuario;
    }
    
    public ArrayList listaUsuarios() throws ClassNotFoundException{
        ArrayList<Integer>codigos = new ArrayList<Integer>();
        String query = "SELECT func_id FROM funcionario ORDER BY func_nome";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);         
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                codigos.add(resultado.getInt("func_id"));
            }
            stmt.close();
            
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        return codigos;
    }
    
    private String converteDataHora(Date data){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataFormatada = format.format(data);
        System.out.println();
        return dataFormatada;
    }
    
    private String converteDataSimples(Date data){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = format.format(data);
        return dataFormatada;
    }
 
    private int consulta(int cod) throws ClassNotFoundException{
        int linhas;
        ResultSet resultado;
        
        String query = "SELECT COUNT(*) FROM funcionario AS numRows WHERE func_id = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, cod);
            resultado = stmt.executeQuery();
            
            resultado.next(); //utilizado pois o cursor inicia antes da posição válida
            
            linhas = resultado.getInt(1);
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return linhas;
    }
   
    /**
     *
     * @param login
     * @param senha
     * @return
     */
    public Usuario validaLogin(String login, String senha){
        String sql = "SELECT * FROM funcionario";
            ResultSet rs;
                try (Statement stmt = connection.createStatement()) {
                    rs = stmt.executeQuery(sql);
                    Usuario usuario = null; 
                    while(rs.next()){
                        if(rs.getString("func_login").equals(login) && rs.getString("func_senha").equals(senha)){
                            String id = rs.getString("func_id");
                            String loginNome = rs.getString("func_login");
                            String cargo = rs.getString("func_cargo");
                            int id_inteiro = Integer.parseInt(id);
                            usuario  = new Usuario(id_inteiro,loginNome,cargo);
                            return usuario;
                        } 
                    }
                return usuario;
                }catch (SQLException u) { 
                    throw new RuntimeException(u); 
                }
    }
    
    /**
     * Recuperar todos os funcionarios cadastrados
     * @return Collection
     * @throws SQLException
     */

    public Collection<Usuario> RecuperaUsuarios() throws SQLException{
        
        String sql = "SELECT * FROM funcionario;";
        ResultSet result;
        List<Usuario> funcionarios = new ArrayList();
        try(Statement stmt = connection.createStatement()){ 
            result = stmt.executeQuery(sql);
            while(result.next()){
                String id = result.getString("func_id");
                String nome = result.getString("func_nome");
                String sobrenome = result.getString("func_sobrenome");
                String login = result.getString("func_login");
                String cargo = result.getString("func_cargo");
                int id_inteiro = Integer.parseInt(id);
                Usuario var = new Usuario(id_inteiro,nome,sobrenome, login, cargo);
                funcionarios.add(var);
            }
            return funcionarios;
        }
       
    }
    
    //busca funcionarios pelo nome
    public Collection<Usuario> BuscaFuncionario(String param) throws SQLException{
        
        String sql = "SELECT * FROM funcionario WHERE func_nome LIKE '%"+param+"%';";
        ResultSet result;
        List<Usuario> funcionarios = new ArrayList();
        try(Statement stmt = connection.createStatement()){ 
            result = stmt.executeQuery(sql);
            while(result.next()){
                String id = result.getString("func_id");
                String nome = result.getString("func_nome");
                String sobrenome = result.getString("func_sobrenome");
                String login = result.getString("func_login");
                String cargo = result.getString("func_cargo");
                int id_inteiro = Integer.parseInt(id);
                Usuario var = new Usuario(id_inteiro,nome,sobrenome, login, cargo);
                funcionarios.add(var);
            }
            return funcionarios;
        }
       
    }
}