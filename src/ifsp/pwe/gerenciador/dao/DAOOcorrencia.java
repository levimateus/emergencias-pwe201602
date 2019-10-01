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
import java.text.ParseException;
import java.util.Collection;
import java.util.List;

import ifsp.pwe.gerenciador.beans.*;
import ifsp.pwe.gerenciador.dao.*;

/**
 *
 * @author Aluno
 */
public class DAOOcorrencia {
    private Connection connection;
    public DAOOcorrencia() throws ClassNotFoundException{
        this.connection = new ConnectionFactory().getConnection();
    }
    public int insereOcorrencia(Ocorrencia ocorrencia) throws ClassNotFoundException{
        
        //consulta
        String query = "INSERT INTO ocorrencia"
                + "(ocorrencia_estado, "
                + "ocorrencia_nivel, "
                + "ocorrencia_descricao, "
                + "ocorrencia_comentarios, "
                + "ocorrencia_registro_dt, "
                + "ocorrencia_data, "
                + "rua_id, "
                + "funcionario_id, "
                + "sensor_id, "
                + "ocorrencia_veiculo_tipo)"
                + "VALUES("
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);

            //estado
            stmt.setString(1, ocorrencia.getOcorrenciaEstado());
            //nivel
            stmt.setInt(2, ocorrencia.getOcorrenciaNivel());
            //descrição
            stmt.setString(3, ocorrencia.getOcorrenciaDescricao());
            //comentários
            stmt.setString(4, ocorrencia.getOcorrenciaComentarios());
            
            //data de registro da ocorrencia
            stmt.setString(5, (ocorrencia.getOcorrenciaRegistroData()));
            //data da ocorrencia
            stmt.setString(6, (ocorrencia.getOcorrenciaData()));
            
            //id da rua
            stmt.setInt(7, ocorrencia.getRuaId());
            
            //id do funcionário
            stmt.setInt(8, ocorrencia.getFuncionarioId());
            //id do sensor
            stmt.setInt(9, ocorrencia.getSensorId());
       
            stmt.setString(10, (ocorrencia.getOcorrencia_veiculo_tipo()));
            
             //executa transação
            boolean execute = stmt.execute();
            if(execute == true){
            stmt.close();   //fecha conexção com o banco de dados
                return 1;
            }else{
            stmt.close();   //fecha conexção com o banco de dados
                return 0;
            }
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
    }
    
    public int insereOcorrenciaAlarme(SensorAlarme alarme) throws ClassNotFoundException, ParseException{
        //Trata dados da Ocorrencia
        String estado = new String("Andamento"); //Estado da ocorrencia
        int rua_id = alarme.getRua(); //rua id
        int alarme_id = alarme.getSensorAlarmeId(); //alarme id
        String tipoAlarme = new String(); //Variavel auxiliar para tipo de alarme
        String veiculoTipo = new String();  //Variavel auxiliar
        int nivel = 0; //Variavel auxiliar
        String dataRegistro = new String("06/12/2016"); //Data de registro

        switch(alarme.getSensorAlarmeTipo()){
            case 1:
                nivel = 3;//Nivel de alto risco
                tipoAlarme = new String("fumaca"); 
                veiculoTipo = new String("bombeiro"); // Veiculo tipo
                break;
            case 2:
                nivel = 1;//Nivel de baixo risco
                tipoAlarme = new String("movimento");
                veiculoTipo = new String("viatura"); // Veiculo tipo
                break;
            case 3:
                nivel = 1;//Nivel de baixo risco
                tipoAlarme = new String("acidente");
                veiculoTipo = new String("ambulancia"); // Veiculo tipo
                break;
            case 4:
                nivel = 4;//Nivel de altissimo risco
                tipoAlarme = new String("panico");
                veiculoTipo = new String("bombeiro"); // Veiculo tipo
                break;
        }
        String descricao = new String("O sensor: "+alarme.getSensorAlarmeId()+" ativou uma ocorrencia do tipo: "+tipoAlarme); //Descrição da ocorrencia

        //consulta
        String query = "INSERT INTO ocorrencia"
                + "(ocorrencia_estado, "
                + "ocorrencia_nivel, "
                + "ocorrencia_descricao, "
                + "ocorrencia_comentarios, "
                + "ocorrencia_registro_dt, "
                + "ocorrencia_data, "
                + "rua_id, "
                + "funcionario_id, "
                + "sensor_id, "
                + "ocorrencia_veiculo_tipo)"
                + "VALUES("
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?, "
                + "?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);

            //estado
            stmt.setString(1, estado);
            //nivel
            stmt.setInt(2, nivel);
            //descrição
            stmt.setString(3, descricao);
            //comentários
            stmt.setString(4, "");
            
            //data de registro da ocorrencia
            stmt.setString(5, dataRegistro);
            //data da ocorrencia
            stmt.setString(6, "");
            
            //id da rua
            stmt.setInt(7, rua_id);
            
            //id do funcionário
            stmt.setInt(8, 0); //Sem funcionario por enquanto
            //id do sensor
            stmt.setInt(9, alarme_id);
       
            stmt.setString(10, veiculoTipo);
            
             //executa transação
            boolean execute = stmt.execute();
            if(execute == true){
            stmt.close();   //fecha conexção com o banco de dados
                return 1;
            }else{
            stmt.close();   //fecha conexção com o banco de dados
                return 0;
            }
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
    }
    
    public int removeOcorrencia(int cod) throws ClassNotFoundException{
        int nlinhas;
        
        nlinhas = this.consulta(cod);
        if(nlinhas == 0) return 0;
               
        
        String query = "DELETE FROM ocorrencia WHERE ocorrencia_id = "+cod;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.execute();
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        return 1;
    }
    
    public int atualizaDadosOcorrencia(Ocorrencia ocorrencia) throws ClassNotFoundException{
     
        //consulta
        int linhas;
        linhas = this.consulta(ocorrencia.getOcorrenciaId());
        
        if(linhas == 0){
            return 0;
        }
        
        String query = "UPDATE ocorrencia "
                + "SET "
                + "ocorrencia_estado        = ?, "
                + "ocorrencia_nivel         = ?, "
                + "ocorrencia_descricao     = ?, "
                + "ocorrencia_comentarios   = ?, "
                + "ocorrencia_registro_dt   = ?, "
                + "ocorrencia_data          = ?, "
                + "rua_id                   = ?, "
                + "funcionario_id           = ?, "
                + "sensor_id                = ?, "
                + "ocorrencia_veiculo_tipo  = ? "
                + "WHERE ocorrencia_id = "+ocorrencia.getOcorrenciaId();

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            //estado
            stmt.setString(1, ocorrencia.getOcorrenciaEstado());
            //nivel
            stmt.setInt(2, ocorrencia.getOcorrenciaNivel());
            //descrição
            stmt.setString(3, ocorrencia.getOcorrenciaDescricao());
            //comentários
            stmt.setString(4, ocorrencia.getOcorrenciaComentarios());
            //data de registro
            stmt.setString(5, (ocorrencia.getOcorrenciaRegistroData()));
            //data
            stmt.setString(6, (ocorrencia.getOcorrenciaData()));
            //id da rua
            stmt.setInt(7, ocorrencia.getRuaId()); 
            //id do funcionário
            stmt.setInt(8, ocorrencia.getFuncionarioId());
            //id do sensor
            stmt.setInt(9, ocorrencia.getSensorId());
            //Tipo de veiculo
            stmt.setString(10, (ocorrencia.getOcorrencia_veiculo_tipo()));
          
            stmt.execute(); //executa transação
            stmt.close();   //fecha conexção com o banco de dados
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return 1;
    }
    
    public Ocorrencia consultaOcorrencia(int cod) throws ClassNotFoundException{
        int numLinhas;
        Ocorrencia ocorrencia;
        String query;
        ResultSet resultado;
        
        
        numLinhas = this.consulta(cod);
        
        if(numLinhas == 0){
            return null;
        }
        
        query = "SELECT * FROM ocorrencia WHERE ocorrencia_id = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, cod);
            resultado = stmt.executeQuery();
            
            
            ocorrencia = new Ocorrencia();
        
            while(resultado.next()){
                ocorrencia.setOcorrenciaId(resultado.getInt("ocorrencia_id"));
                ocorrencia.setOcorrenciaEstado(resultado.getString("ocorrencia_estado"));
                ocorrencia.setOcorrenciaNivel(resultado.getInt("ocorrencia_nivel"));
                ocorrencia.setOcorrenciaDescricao(resultado.getString("ocorrencia_descricao"));
                ocorrencia.setOcorrenciaComentarios(resultado.getString("ocorrencia_comentarios"));
                ocorrencia.setOcorrenciaRegistroData(resultado.getString("ocorrencia_registro_dt"));
                ocorrencia.setOcorrenciaData(resultado.getString("ocorrencia_data"));
                ocorrencia.setRuaId(resultado.getInt("rua_id"));
                ocorrencia.setFuncionarioId(resultado.getInt("funcionario_id"));
                ocorrencia.setSensorId(resultado.getInt("sensor_id"));  
                ocorrencia.setOcorrencia_veiculo_tipo(resultado.getString("ocorrencia_veiculo_tipo"));  
            }
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
            
        }
        
        return ocorrencia;
    }
    
    public ArrayList listaOcorrencias() throws ClassNotFoundException{
        ArrayList<Integer>codigos = new ArrayList<Integer>();
        String query = "SELECT ocorrencia_id FROM ocorrencia ORDER BY ocorrencia_data";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);         
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                codigos.add(resultado.getInt("ocorrencia_id"));
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
        
        String query = "SELECT COUNT(*) FROM ocorrencia AS numRows WHERE ocorrencia_id = ?";
        
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
    
    public int ultimaOcorrencia() throws ClassNotFoundException{
        int id_inteiro;
        ResultSet resultado;
        
        String query = "SELECT ocorrencia_id FROM ocorrencia where ocorrencia_id is not null ORDER BY ocorrencia_id DESC limit 1";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);

            resultado = stmt.executeQuery();
            
            resultado.next(); //utilizado pois o cursor inicia antes da posição válida
            
            String id = resultado.getString("ocorrencia_id");
            id_inteiro = Integer.parseInt(id);
            
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return id_inteiro;
    } 
    
    /**
     * Recuperar todas as ocorrencias cadastradas
     * @return Collection
     * @throws SQLException
     * @throws java.text.ParseException
     */

    public Collection<Ocorrencia> RecuperaOcorrencias() throws SQLException, ParseException{
        
        String sql = "SELECT * FROM ocorrencia;";
        ResultSet result;
        List<Ocorrencia> ocorrencias = new ArrayList();
        try(Statement stmt = connection.createStatement()){ 
            result = stmt.executeQuery(sql);
            while(result.next()){
                String id = result.getString("ocorrencia_id");
                String estado = result.getString("ocorrencia_estado");
                String nivel = result.getString("ocorrencia_nivel");
                String descricao = result.getString("ocorrencia_descricao");
                String data = result.getString("ocorrencia_registro_dt");
                String rua = result.getString("rua_id");
                int id_inteiro = Integer.parseInt(id);
                int nivel_int = Integer.parseInt(nivel);
                int rua_int = Integer.parseInt(rua);
                Ocorrencia var = new Ocorrencia(id_inteiro,estado,nivel_int,descricao,data,rua_int);
                ocorrencias.add(var);
            }
            return ocorrencias;
        }
       
    }
}
