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
public class DAORua {
    private Connection connection;
    public DAORua() throws ClassNotFoundException{
        this.connection = new ConnectionFactory().getConnection();
    }
    public void insereRua(Rua rua) throws ClassNotFoundException{
       
        //consulta
        String query = "INSERT INTO rua"
                + "(rua_nome,"
                + "rua_status,"
                + "regiao_id)"
                
                + "VALUES(?,"
                + "?,"
                + "?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            //Nome da rua
            stmt.setString(1, rua.getRuaNome());
            //stauts da rua
            stmt.setInt(2, rua.getRuaStatus());
            //id da região
            stmt.setInt(3, rua.getRegiaoId());
            
            stmt.execute(); //executa transação
            stmt.close();   //fecha conexção com o banco de dados
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
    }
    
    public int removeRua(int cod) throws ClassNotFoundException{
        int nlinhas;
        
        nlinhas = this.consulta(cod);
        if(nlinhas == 0) return 0;
                
        String query = "DELETE FROM rua WHERE rua_id = "+cod;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.execute();
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        return 1;
    }
    
    public int atualizaDadosRua(Rua rua) throws ClassNotFoundException{
        //consulta
        int linhas;
        linhas = this.consulta(rua.getRuaId());
        
        if(linhas == 0){
            return 0;
        }
        
        String query = "UPDATE rua "
                + "SET "
                + "rua_nome     = ?, "
                + "rua_status   = ?, "
                + "regiao_id    = ? "
                + "WHERE rua_id = "+rua.getRuaId();

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            //nome
            stmt.setString(1, rua.getRuaNome());
            //quantidade de ocorrencias
            stmt.setInt(2, rua.getRuaStatus());
            //periculosidade
            stmt.setInt(3, rua.getRegiaoId());
            
            stmt.execute(); //executa transação
            stmt.close();   //fecha conexção com o banco de dados
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return 1;
    }
    
    public Rua consultaRua(int cod) throws ClassNotFoundException{
        int numLinhas;
        Rua rua;
        String query;
        ResultSet resultado;
        
        
        numLinhas = this.consulta(cod);
        
        if(numLinhas == 0){
            return null;
        }
        
        query = "SELECT * FROM rua WHERE rua_id = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, cod);
            resultado = stmt.executeQuery();
            
            
            rua = new Rua();
        
            while(resultado.next()){
                rua.setRuaId(resultado.getInt("rua_id"));
                rua.setRuaNome(resultado.getString("rua_nome"));
                rua.setRuaStatus(resultado.getInt("rua_status"));
                rua.setRegiaoId(resultado.getInt("regiao_id"));
                rua.setRuaLoc_x(resultado.getInt("rua_loc_x"));
                rua.setRuaLoc_y(resultado.getInt("rua_loc_y"));
            }
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
            
        }
        
        return rua;
    }
    
    public ArrayList listaRuas() throws ClassNotFoundException{
        ArrayList<Integer>codigos = new ArrayList<Integer>();
        String query = "SELECT rua_id FROM rua ORDER BY rua_nome";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);         
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                codigos.add(resultado.getInt("rua_id"));
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
        
        String query = "SELECT COUNT(*) FROM rua AS numRows WHERE rua_id = ?";
        
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
    
    public Rua evacuacao(Rua rua) throws ClassNotFoundException{
        ArrayList<Integer> todasRuasCods = new ArrayList<>();
        todasRuasCods = this.listaRuas();
        Rua ruaAux = new Rua();
        Rua ruaMaixProx = new Rua();
        int X = 0; //Diferença entre as coordenadas X de 2 pontos
        int Y = 0; //Diferença entre as coordenadas Y de 2 pontos
        float distancia = 0;
        float menorDistancia = 0;
        float var = Float.MAX_VALUE; //Variável auxiliar
        System.out.println(todasRuasCods);
        System.out.println("X: "+rua.getRuaLoc_x()+" Y: "+rua.getRuaLoc_y());
        for(int codRua: todasRuasCods){
            ruaAux = this.consultaRua(codRua);
            if(ruaAux.getRuaStatus() == 1 && ruaAux.getRuaId() != rua.getRuaId()){
                X = (ruaAux.getRuaLoc_x() - rua.getRuaLoc_x());
                Y = (ruaAux.getRuaLoc_y() - rua.getRuaLoc_y());
                distancia = (int) Math.sqrt((X * X) + (Y * Y));
                //System.out.println("Rua id: "+ruaAux.getRuaId()+" distancia : "+distancia);
                if(distancia < var){
                    menorDistancia = distancia;
                    ruaMaixProx = ruaAux;
                    var = distancia;
                }
            }
        }
        System.out.println("Rua mais proxima: "+ruaMaixProx.getRuaId());
        return ruaMaixProx;
    }
    
    public Collection<Rua> RecuperaRuasOcorrencias() throws SQLException{
        
        String sql = "select ocorrencia.rua_id, rua.regiao_id from ocorrencia\n" +
        "inner join rua on ocorrencia.rua_id = rua.rua_id;";
        ResultSet result;
        List<Rua> ruas = new ArrayList();
        try(Statement stmt = connection.createStatement()){ 
            result = stmt.executeQuery(sql);
            while(result.next()){
                String id_rua = result.getString("rua_id");
                String id_regiao = result.getString("regiao_id");
                int id_rua_int = Integer.parseInt(id_rua);
                int id_regiao_int = Integer.parseInt(id_regiao);
                Rua var = new Rua(id_rua_int,id_regiao_int);
                ruas.add(var);
            }
            return ruas;
        }
       
    }
}
