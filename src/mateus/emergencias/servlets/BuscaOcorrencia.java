/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mateus.emergencias.servlets;

import mateus.emergencias.beans.*;
import mateus.emergencias.dao.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis
 */
public class BuscaOcorrencia implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        int ocorrencia_id = Integer.parseInt(req.getParameter("ocorrencia_id"));
        
        Ocorrencia ocorrencia = new Ocorrencia();

        //Insere ocorrencia
        try {
            ocorrencia = new DAOOcorrencia().consultaOcorrencia(ocorrencia_id); //Insere a ocorrencia no banco
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BuscaOcorrencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        ocorrencia.setOcorrenciaId(ocorrencia_id);
        req.setAttribute("ocorrencia",ocorrencia);
        System.out.println(ocorrencia.getOcorrencia_veiculo_tipo());
        return "/WEB-INF/paginas/FinalizaOcorrenciaStepFinal.jsp";
    }
}
