/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.gerenciador.servlets;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ifsp.pwe.gerenciador.beans.*;
import ifsp.pwe.gerenciador.dao.*;

/**
 *
 * @author Luis
 */
public class FinalizaOcorrencia implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        int ocorrencia_id = Integer.parseInt(req.getParameter("ocorrenciaId"));
        System.out.println(ocorrencia_id);
        String estado = req.getParameter("estado");
        int nivel = Integer.parseInt(req.getParameter("nivel"));
        String tipoveiculo = req.getParameter("tipoveiculo");
        String descricao = req.getParameter("descricao");
        String comentario = req.getParameter("comentario");
        String registro_dt = req.getParameter("registro_dt");
        String data = req.getParameter("data");
        int rua_id = Integer.parseInt(req.getParameter("rua_id"));
        int funcionario_id = Integer.parseInt(req.getParameter("funcionario_id"));
        int sensor_id = Integer.parseInt(req.getParameter("sensor_id"));
        
        Ocorrencia ocorrencia = new Ocorrencia(estado, nivel, tipoveiculo, descricao, comentario, registro_dt, data, rua_id, funcionario_id, sensor_id);
        ocorrencia.setOcorrenciaId(ocorrencia_id);
        int teste = 0;
        //Atualiza ocorrência
        try {
            teste = new DAOOcorrencia().atualizaDadosOcorrencia(ocorrencia);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FinalizaOcorrencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("ocorrencia",ocorrencia);//Atribui a ocorrencia ao objeto "ocorrencia"  
        
        //Seleciona o veiculo associado a ocorrencia
        try {
            Veiculo veiculo = new DAOVeiculo().consultaVeiculoOcorrencia(ocorrencia.getOcorrenciaId());  
            //Atualiza Dados Do veiculo mais próximo
            if(veiculo != null){
                 veiculo.setVeiculoEstado("disponivel"); //Veiculo volta a ficar disponivel
                int atualizaVeiculo = new DAOVeiculo().atualizaDadosVeiculo(veiculo);
                req.setAttribute("veiculo",veiculo);//Atribui o veiculo ao objeto "veiculo"
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovaOcorrencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Atualiza dados do sensor
        try {
            //Recebe sensor da ocorrencia
            SensorAlarme alarme = new DAOSensorAlarme().consultaSensorAlarme(ocorrencia.getSensorId());
            alarme.setSensorAlarmeEstado(false); // Reseta dados sensor
            int atualizaAlarme = new DAOSensorAlarme().atualizaDadosSensorAlarme(alarme);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FinalizaOcorrencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Atualiza os dados da rua da ocorrencia
        Rua ruaOcorrencia; 
        try {
            ruaOcorrencia = new DAORua().consultaRua(ocorrencia.getRuaId()); // Atribui a rua da Ocorrencia
            //Atualiza dados da rua da ocorrencia
                ruaOcorrencia.setRuaStatus(1);//Status Rua Livre
            int atualizaRua = new DAORua().atualizaDadosRua(ruaOcorrencia);

            req.setAttribute("ruaEvac",ruaOcorrencia);//Atribui a rua da ocorrencia ao objeto "ruaEvac"
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FinalizaOcorrencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "/WEB-INF/paginas/DadosOcorrenciaFinal.jsp";
    }
}
