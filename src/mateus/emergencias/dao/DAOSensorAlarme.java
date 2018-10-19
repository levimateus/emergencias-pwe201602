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

/**
 *
 * @author Aluno
 */
public class DAOSensorAlarme {
    private Connection connection;
    public DAOSensorAlarme() throws ClassNotFoundException{
        this.connection = new ConnectionFactory().getConnection();
    }
    public void insereSensorAlarme(SensorAlarme sensor) throws ClassNotFoundException{
       
        //consulta
        String query = "INSERT INTO sensor"
                + "(sensor_estado,"
                + "sensor_tipo,"
                + "rua)"
                
                + "VALUES(?,"
                + "?,"
                + "?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            //Nome da sensor
            stmt.setBoolean(1, sensor.isSensorAlarmeEstado());
            //quantidade de ocorrencias
            stmt.setInt(2, sensor.getSensorAlarmeTipo());
            //periculosidade
            stmt.setFloat(3, sensor.getRua());
            
            stmt.execute(); //executa transação
            stmt.close();   //fecha conexção com o banco de dados
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
    }
    
    public int removeSensorAlarme(int cod) throws ClassNotFoundException{
        int nlinhas;
        
        nlinhas = this.consulta(cod);
        if(nlinhas == 0) return 0;
                
        
        String query = "DELETE FROM sensor WHERE sensor_id = "+cod;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.execute();
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        return 1;
    }
    
    public int atualizaDadosSensorAlarme(SensorAlarme sensor) throws ClassNotFoundException{
        
        //consulta
        int linhas;
        linhas = this.consulta(sensor.getSensorAlarmeId());
        
        if(linhas == 0){
            return 0;
        }
        
        String query = "UPDATE sensor "
                + "SET "
                + "sensor_estado   = ?, "
                + "sensor_tipo     = ?, "
                + "rua      = ? "
                + "WHERE sensor_id = "+sensor.getSensorAlarmeId();

        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            //estado
            stmt.setBoolean(1, sensor.isSensorAlarmeEstado());
            //tipo
            stmt.setInt(2, sensor.getSensorAlarmeTipo());
            //rua
            stmt.setInt(3, sensor.getRua());
            
            stmt.execute(); //executa transação
            stmt.close();   //fecha conexção com o banco de dados
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        return 1;
    }
    
    public SensorAlarme consultaSensorAlarme(int cod) throws ClassNotFoundException{
        int numLinhas;
        SensorAlarme sensor;
        String query;
        ResultSet resultado;
        
        numLinhas = this.consulta(cod);
        
        if(numLinhas == 0){
            return null;
        }
        
        query = "SELECT * FROM sensor WHERE sensor_id = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, cod);
            resultado = stmt.executeQuery();
            
            
            sensor = new SensorAlarme();
        
            while(resultado.next()){
                sensor.setSensorAlarmeId(resultado.getInt("sensor_id"));
                sensor.setSensorAlarmeEstado(resultado.getBoolean("sensor_estado"));
                sensor.setSensorAlarmeTipo(resultado.getInt("sensor_tipo"));
                sensor.setRua(resultado.getInt("rua"));
            }
            stmt.close();
            
        }catch(SQLException u){
            throw new RuntimeException(u);
            
        }
        
        return sensor;
    }
    
    public ArrayList listaSensorAlarmes() throws ClassNotFoundException{
        ArrayList<Integer>codigos = new ArrayList<Integer>();
        String query = "SELECT sensor_id FROM sensor ORDER BY sensor_nome";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);         
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                codigos.add(resultado.getInt("sensor_id"));
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
        
        String query = "SELECT COUNT(*) FROM sensor AS numRows WHERE sensor_id = ?";
        
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
    
    public ArrayList listaAlarmesAtivados() throws ClassNotFoundException{
        ArrayList<Integer>codigos = new ArrayList<Integer>();
        String query = "SELECT sensor_id FROM sensor where sensor_estado = 1";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(query);         
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                codigos.add(resultado.getInt("sensor_id"));
            }
            stmt.close();
            
            
        }catch(SQLException u){
            throw new RuntimeException(u);
        }
        
        return codigos;
    }
    
}
