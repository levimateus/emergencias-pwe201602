/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.gerenciador.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

import ifsp.pwe.gerenciador.beans.*;
import ifsp.pwe.gerenciador.dao.*;

/**
 *
 * @author Aluno
 */
public class DAORegiao {
    private Connection connection;
    public DAORegiao() throws ClassNotFoundException{
        this.connection = new ConnectionFactory().getConnection();
    }
    public void insereRegiao(Regiao regiao) throws ClassNotFoundException{
       
        //consulta
        String query = "INSERT INTO regiao"
                + "(regiao_nome,"
                + "regiao_qt_ocorrencia,"
                + "regiao_periculosidade)"
                
                + "VALUES(?,"
                + "?,"
                + "?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            //Nome da região
            stmt.setString(1, regiao.getRegiaoNome());
            //quantidade de ocorrencias
            stmt.setInt(2, regiao.getRegiaoQtOcorrencia());
            //periculosidade
            stmt.setFloat(3, regiao.getRegiaoPericulosidade());
            
            stmt.execute(); //executa transação
            stmt.close();   //fecha conexção com o banco de dados
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
    }
    
    public int removeRegiao(int cod) throws ClassNotFoundException{
        int nlinhas;
        
        nlinhas = this.consulta(cod);
        if(nlinhas == 0) return 0;
                
        String query = "DELETE FROM regiao WHERE regiao_id = "+cod;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.execute();
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        return 1;
    }
    
    public int atualizaDadosRegiao(Regiao regiao) throws ClassNotFoundException{
        
        //consulta
        int linhas;
        linhas = this.consulta(regiao.getRegiaoId());
        
        if(linhas == 0){
            return 0;
        }
        
        String query = "UPDATE regiao "
                + "SET "
                + "regiao_nome            = ?, "
                + "regiao_qt_ocorrencia   = ?, "
                + "regiao_periculosidade  = ? "
                + "WHERE regiao_id = "+regiao.getRegiaoId();

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            //nome
            stmt.setString(1, regiao.getRegiaoNome());
            //quantidade de ocorrencias
            stmt.setInt(2, regiao.getRegiaoQtOcorrencia());
            //periculosidade
            stmt.setFloat(3, regiao.getRegiaoPericulosidade());
            
            stmt.execute(); //executa transação
            stmt.close();   //fecha conexção com o banco de dados
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return 1;
    }
    
    public Regiao consultaRegiao(int cod) throws ClassNotFoundException{
        int numLinhas;
        Regiao regiao;
        String query;
        ResultSet resultado;
        
        
        numLinhas = this.consulta(cod);
        
        if(numLinhas == 0){
            return null;
        }
        
        query = "SELECT * FROM regiao WHERE regiao_id = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, cod);
            resultado = stmt.executeQuery();
            
            
            regiao = new Regiao();
        
            while(resultado.next()){
                regiao.setRegiaoId(resultado.getInt("regiao_id"));
                regiao.setRegiaoNome(resultado.getString("regiao_nome"));
                regiao.setRegiaoQtOcorrencia(resultado.getInt("regiao_qt_ocorrencia"));
                regiao.setRegiaoPericulosidade(resultado.getFloat("regiao_periculosidade"));
            }
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
            
        }
        
        return regiao;
    }
    
    public ArrayList listaRegiaos() throws ClassNotFoundException{
        ArrayList<Integer>codigos = new ArrayList<Integer>();
        String query = "SELECT regiao_id FROM regiao ORDER BY regiao_nome";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);         
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                codigos.add(resultado.getInt("regiao_id"));
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
        
        String query = "SELECT COUNT(*) FROM regiao AS numRows WHERE regiao_id = ?";
        
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
    
    public Collection<Regiao> RecuperaRegioes() throws SQLException{
        
        String sql = "SELECT * FROM regiao;";
        ResultSet result;
        List<Regiao> regioes = new ArrayList();
        try(Statement stmt = connection.createStatement()){ 
            result = stmt.executeQuery(sql);
            while(result.next()){
                String id = result.getString("regiao_id");
                String nome = result.getString("regiao_nome");
                int id_inteiro = Integer.parseInt(id);
                Regiao var = new Regiao(id_inteiro,nome);
                regioes.add(var);
            }
            return regioes;
        }
       
    }
    
    public void atualizaOcorrencia(int id, int ocorrencia) throws SQLException{
        
        String sql = "UPDATE regiao SET regiao_qt_ocorrencia = (?) WHERE regiao_id = "+id+";";
        try{ 
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1,ocorrencia);
                stmt.execute();
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
