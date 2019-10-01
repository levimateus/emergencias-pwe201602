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
public class NovaOcorrencia implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String estado = req.getParameter("estado");
        int nivel = Integer.parseInt(req.getParameter("nivel"));
        String descricao = req.getParameter("descricao");
        String registro_dt = req.getParameter("registro_dt");
        String tipoveiculo = req.getParameter("tipoveiculo");
        int rua_id = Integer.parseInt(req.getParameter("rua_id"));
        Ocorrencia ocorrencia = new Ocorrencia(estado, nivel, descricao, registro_dt, rua_id, tipoveiculo);
        int teste = 0;
        int ocorrenciaId = 0;
        //Insere ocorrencia
        try {
            teste = new DAOOcorrencia().insereOcorrencia(ocorrencia); //Insere a ocorrencia no banco
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovaOcorrencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Busca Id da ocorrencia
        try {
            ocorrenciaId = new DAOOcorrencia().ultimaOcorrencia();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovaOcorrencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        ocorrencia.setOcorrenciaId(ocorrenciaId);
        req.setAttribute("ocorrencia",ocorrencia);//Atribui a ocorrencia ao objeto "ocorrencia"  
        
        //Seleciona o veiculo mais proximo e adequado a ocorrencia
        try {
            Veiculo veiculo = new DAOVeiculo().VeiculoMaisProximo(ocorrencia); 
            //Atribui os dados da ocorrencia ao veiculo
            veiculo.setOcorrenciaId(ocorrencia.getOcorrenciaId());
                //System.out.println("Ocorrencia Idocorrencia "+ocorrencia.getOcorrenciaId());
                //System.out.println("Veiculo Idocorrencia "+veiculoMaisProx.getOcorrenciaId());
            veiculo.setVeiculoEstado("Em campo");
            int atualizaVeiculo = new DAOVeiculo().atualizaDadosVeiculo(veiculo);
            req.setAttribute("veiculo",veiculo);//Atribui o veiculo ao objeto "veiculo"
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovaOcorrencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Seleciona a melhor rua para evacuação
        try {
            Rua ruaOcorrencia = new DAORua().consultaRua(ocorrencia.getRuaId()); // Atribui a rua da Ocorrencia
            Rua rua = new Rua(); //Instanciamento da rua de evacuação
            try {
                rua = new DAORua().evacuacao(ruaOcorrencia);
                //Atualiza dados da rua da ocorrencia baseado no nivel da ocorrencia
                if(ocorrencia.getOcorrenciaNivel() >= 3){   
                    ruaOcorrencia.setRuaStatus(3);//Status Rua Bloqueada
                }else{
                    ruaOcorrencia.setRuaStatus(2);//Status Rua Congestionada
                }
                int atualizaRua = new DAORua().atualizaDadosRua(ruaOcorrencia); 
                
                req.setAttribute("ruaEvac",rua);//Atribui a rua de evacuação ao objeto "ruaEvac"
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NovaOcorrencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovaOcorrencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "/WEB-INF/paginas/DadosOcorrencia.jsp";
    }
}
