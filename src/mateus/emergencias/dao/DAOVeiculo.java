/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mateus.emergencias.dao;

import mateus.emergencias.beans.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Aluno
 */
public class DAOVeiculo {
    private Connection connection;
    public DAOVeiculo() throws ClassNotFoundException{
        this.connection = new ConnectionFactory().getConnection();
    }
    public void insereVeiculo(Veiculo veiculo) throws ClassNotFoundException{
       
        //consulta
        String query = "INSERT INTO veiculo"
                + "(veiculo_tipo,"
                + "veiculo_estado,"
                + "veiculo_placa,"
                + "rua_id,"
                + "ocorrencia_id)"
                
                + "VALUES(?,"
                + "?,"
                + "?,"
                + "?,"
                + "?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            //tipo de veículo
            stmt.setString(1, veiculo.getVeiculoTipo());
            //estado de origem
            stmt.setString(2, veiculo.getVeiculoEstado());
            //placa
            stmt.setString(3, veiculo.getVeiculoPlaca());
            //id da rua
            stmt.setInt(4, veiculo.getRuaId());
            //id da ocorrencia
            stmt.setInt(5, veiculo.getOcorrenciaId());
                       
            stmt.execute(); //executa transação
            stmt.close();   //fecha conexção com o banco de dados
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
    }
    
    public int removeVeiculo(int cod) throws ClassNotFoundException{
        int nlinhas;
        
        nlinhas = this.consulta(cod);
        if(nlinhas == 0) return 0;
                
        String query = "DELETE FROM veiculo WHERE veiculo_id = "+cod;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.execute();
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        return 1;
    }
    
    public int atualizaDadosVeiculo(Veiculo veiculo) throws ClassNotFoundException{
        
        //consulta
        int linhas;
        linhas = this.consulta(veiculo.getVeiculoId());
        
        if(linhas == 0){
            return 0;
        }
        
        String query = "UPDATE veiculo "
                + "SET "
                + "veiculo_tipo      = ?, "
                + "veiculo_estado    = ?, "
                + "veiculo_placa     = ?, "
                + "rua_id            = ?, "
                + "ocorrencia_id     = ? "
                + "WHERE veiculo_id  = "+veiculo.getVeiculoId();

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            //tipo
            stmt.setString(1, veiculo.getVeiculoTipo());
            //estado
            stmt.setString(2, veiculo.getVeiculoEstado());
            //placa
            stmt.setString(3, veiculo.getVeiculoPlaca());
            //id da rua
            stmt.setInt(4, veiculo.getRuaId());
            //id da ocorrencia
            stmt.setInt(5, veiculo.getOcorrenciaId());
            
            stmt.execute(); //executa transação
            stmt.close();   //fecha conexção com o banco de dados
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return 1;
    }
    
    public Veiculo consultaVeiculo(int cod) throws ClassNotFoundException{
        int numLinhas;
        Veiculo veiculo;
        String query;
        ResultSet resultado;
       
        numLinhas = this.consulta(cod);
        
        if(numLinhas == 0){
            return null;
        }
        
        query = "SELECT * FROM veiculo WHERE veiculo_id = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, cod);
            resultado = stmt.executeQuery();
            
            
            veiculo = new Veiculo();
        
            while(resultado.next()){
                veiculo.setVeiculoId(resultado.getInt("veiculo_id"));
                veiculo.setVeiculoTipo(resultado.getString("veiculo_tipo"));
                veiculo.setVeiculoEstado(resultado.getString("veiculo_estado"));
                veiculo.setVeiculoPlaca(resultado.getString("veiculo_placa"));
                veiculo.setRuaId(resultado.getInt("rua_id"));
                veiculo.setOcorrenciaId(resultado.getInt("ocorrencia_id"));
            }
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
            
        }
        
        return veiculo;
    }
    
    public Veiculo consultaVeiculoOcorrencia(int cod) throws ClassNotFoundException{
        Veiculo veiculo;
        String query;
        ResultSet resultado;
        
        query = "SELECT * FROM veiculo WHERE ocorrencia_id = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, cod);
            resultado = stmt.executeQuery();
            
            
            veiculo = new Veiculo();
        
            while(resultado.next()){
                veiculo.setVeiculoId(resultado.getInt("veiculo_id"));
                veiculo.setVeiculoTipo(resultado.getString("veiculo_tipo"));
                veiculo.setVeiculoEstado(resultado.getString("veiculo_estado"));
                veiculo.setVeiculoPlaca(resultado.getString("veiculo_placa"));
                veiculo.setRuaId(resultado.getInt("rua_id"));
                veiculo.setOcorrenciaId(resultado.getInt("ocorrencia_id"));
            }
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
            
        }
        
        return veiculo;
    }
    
    public ArrayList listaVeiculos() throws ClassNotFoundException{
        ArrayList<Integer>codigos = new ArrayList<Integer>();
        String query = "SELECT veiculo_id FROM veiculo ORDER BY veiculo_tipo";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);         
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                codigos.add(resultado.getInt("veiculo_id"));
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
        String query = "SELECT COUNT(*) FROM veiculo AS numRows WHERE veiculo_id = ?";
        
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
    /*
    Parâmetro: Ocorrencia
    Retorno: Veículo mais próximo
    */
    public Veiculo VeiculoMaisProximo(Ocorrencia ocorrencia) throws ClassNotFoundException{ 
        ArrayList<Integer> TodosVeiculosCodigos = new ArrayList<>(); 
        TodosVeiculosCodigos = this.listaVeiculos(); //Array para armazenar todos os códigos dos veículos
        Veiculo veiculoMaisProx = new Veiculo();
        Veiculo veiculoAux = new Veiculo(); //Variável auxiliar
        Rua rua = new DAORua().consultaRua(ocorrencia.getRuaId());//Rua da Ocorrencia
        Rua ruaAux = new Rua(); //Variável auxiliar
        int X = 0; //Diferença entre as coordenadas X de 2 pontos
        int Y = 0; //Diferença entre as coordenadas Y de 2 pontos
        float distancia = 0;
        float menorDistancia = 0;
        float var = Float.MAX_VALUE; //Variável auxiliar
        //System.out.println(TodosVeiculosCodigos);
        //Percorre todos os Veiculos 
        for (Integer codigoVeiculo: TodosVeiculosCodigos) {
                //System.out.println("Passou laço");
            veiculoAux = this.consultaVeiculo(codigoVeiculo);
                //System.out.println("Veiculo aux"+veiculoAux.getVeiculoId());
            //Verifica se o veiculo está disponivel e se é do mesmo tipo que o necessário na ocorrência
            if("disponivel".equals(veiculoAux.getVeiculoEstado()) && veiculoAux.getVeiculoTipo().equals(ocorrencia.getOcorrencia_veiculo_tipo()) ){
                    //System.out.println("Entrou");
                ruaAux = new DAORua().consultaRua(veiculoAux.getRuaId()); // Recebo rua do veiculo auxiliar
                //Aplicação da formula da distancia entre 2 pontos
                X = (ruaAux.getRuaLoc_x() - rua.getRuaLoc_x());
                    //System.out.println("X Aux"+ruaAux.getRuaLoc_x());
                    //System.out.println("X Ocor"+rua.getRuaLoc_x());
                Y = (ruaAux.getRuaLoc_y() - rua.getRuaLoc_y());
                    //System.out.println("Y Aux"+ruaAux.getRuaLoc_y());
                    //System.out.println("Y Ocor"+rua.getRuaLoc_y());
                distancia = (int) Math.sqrt((X * X) + (Y * Y));
                    //System.out.println("distancia"+distancia);
                if(distancia < var){
                    menorDistancia = distancia;
                    veiculoMaisProx = veiculoAux;
                        //System.out.println("Veiculo mais proximo"+veiculoMaisProx.getVeiculoId());
                    var = distancia;
                }
            }
        }
        
        return veiculoMaisProx;
    }    

    /**
     * Recuperar todos os veiculos cadastrados
     * @return Collection
     * @throws SQLException
     */

    public Collection<Veiculo> RecuperaVeiculos() throws SQLException{
        
        String sql = "SELECT * FROM veiculo;";
        ResultSet result;
        List<Veiculo> veiculos = new ArrayList();
        try(Statement stmt = connection.createStatement()){ 
            result = stmt.executeQuery(sql);
            while(result.next()){
                String id = result.getString("veiculo_id");
                String tipo = result.getString("veiculo_tipo");
                String estado = result.getString("veiculo_estado");
                String placa = result.getString("veiculo_placa");
                String rua_id = result.getString("rua_id");
                int id_inteiro = Integer.parseInt(id);
                int id_rua_inteiro = Integer.parseInt(rua_id);
                Veiculo var = new Veiculo(id_inteiro,tipo,estado, placa, id_rua_inteiro);
                veiculos.add(var);
            }
            return veiculos;
        }
       
    }
    
    
    public Collection<Veiculo> BuscaVeiculos(String param) throws SQLException{
        
        String sql = "SELECT * FROM veiculo WHERE veiculo_tipo LIKE '%"+param+"%';";
        ResultSet result;
        List<Veiculo> veiculos = new ArrayList();
        try(Statement stmt = connection.createStatement()){ 
            result = stmt.executeQuery(sql);
            while(result.next()){
                String id = result.getString("veiculo_id");
                String tipo = result.getString("veiculo_tipo");
                String estado = result.getString("veiculo_estado");
                String placa = result.getString("veiculo_placa");
                String rua_id = result.getString("rua_id");
                int id_inteiro = Integer.parseInt(id);
                int id_rua_inteiro = Integer.parseInt(rua_id);
                Veiculo var = new Veiculo(id_inteiro,tipo,estado, placa, id_rua_inteiro);
                veiculos.add(var);
            }
            return veiculos;
        }
       
    }
}
