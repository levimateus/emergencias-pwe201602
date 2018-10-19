/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mateus.emergencias.servlets;

import mateus.emergencias.dao.*;
import mateus.emergencias.beans.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis
 */
public class NovaOcorrenciaAlarme implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        ArrayList<Integer> alarmesAtivados = new ArrayList<>(); //Lista dos alarmes ativos
        SensorAlarme alarmeAux = new SensorAlarme(); //Alarme auxiliar para a inserção
        Ocorrencia ocorrencia = new Ocorrencia();  
        int teste = 0;
        int ocorrenciaId = 0;
        
        try {
            alarmesAtivados = new DAOSensorAlarme().listaAlarmesAtivados();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovaOcorrenciaAlarme.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int alarmeId: alarmesAtivados){
            try {
                alarmeAux = new DAOSensorAlarme().consultaSensorAlarme(alarmeId);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NovaOcorrenciaAlarme.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Insere ocorrencia
            try {
                teste = new DAOOcorrencia().insereOcorrenciaAlarme(alarmeAux); //Insere a ocorrencia no banco
                //Busca Id da ocorrencia
                try {
                    ocorrenciaId = new DAOOcorrencia().ultimaOcorrencia();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NovaOcorrencia.class.getName()).log(Level.SEVERE, null, ex);
                }
                ocorrencia.setOcorrenciaId(ocorrenciaId);
                ocorrencia = new DAOOcorrencia().consultaOcorrencia(ocorrenciaId);
                //Seleciona o veiculo mais proximo e adequado a ocorrencia
                try {
                    Veiculo veiculo = new DAOVeiculo().VeiculoMaisProximo(ocorrencia); 
                        //System.out.println(veiculo.getVeiculoPlaca());
                    req.setAttribute("veiculo",veiculo);//Atribui o veiculo ao objeto "veiculo"
                    //Atribui os dados da ocorrencia ao veiculo
                    veiculo.setOcorrenciaId(ocorrencia.getOcorrenciaId());
                        //System.out.println("Ocorrencia Idocorrencia "+ocorrencia.getOcorrenciaId());
                        //System.out.println("Veiculo Idocorrencia "+veiculoMaisProx.getOcorrenciaId());
                    veiculo.setVeiculoEstado("Em campo");
                    int atualizaVeiculo = new DAOVeiculo().atualizaDadosVeiculo(veiculo);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NovaOcorrenciaAlarme.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Seleciona a melhor rua para evacuação
                try {
                    Rua ruaOcorrencia = new DAORua().consultaRua(ocorrencia.getRuaId()); // Atribui a rua da Ocorrencia
                    Rua rua = new Rua(); //Instanciamento da rua de evacuação
                    try {
                        rua = new DAORua().evacuacao(ruaOcorrencia);
                        System.out.println("Rua para evacuação"+rua.getRuaId());
                        //Atualiza dados da rua da ocorrencia baseado no nivel da ocorrencia
                        if(ocorrencia.getOcorrenciaNivel() >= 3){   
                            ruaOcorrencia.setRuaStatus(3);//Status Rua Bloqueada
                        }else{
                            ruaOcorrencia.setRuaStatus(2);//Status Rua Congestionada
                        }
                        int atualizaRua = new DAORua().atualizaDadosRua(ruaOcorrencia); 

                        req.setAttribute("ruaEvac",rua);//Atribui a rua de evacuação ao objeto "ruaEvac"
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(NovaOcorrenciaAlarme.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NovaOcorrenciaAlarme.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NovaOcorrenciaAlarme.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(NovaOcorrenciaAlarme.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    

        return "/WEB-INF/paginas/HomeAtendente.jsp";
    }
}
