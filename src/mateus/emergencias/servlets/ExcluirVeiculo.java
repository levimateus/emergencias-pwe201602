/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mateus.emergencias.servlets;

import mateus.emergencias.dao.*;
import mateus.emergencias.beans.*;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
public class ExcluirVeiculo implements Tarefa {
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String veiculo = req.getParameter("id_veiculo");
        int id = Integer.parseInt(veiculo);
        try {
            int removeVeiculo = new DAOVeiculo().removeVeiculo(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExcluirFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collection <Veiculo> veiculos = null;
        try {
            veiculos = new DAOVeiculo().RecuperaVeiculos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChamarURLs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ExcluirVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        req.setAttribute("veiculos",veiculos);
        return "/WEB-INF/paginas/veiculos.jsp";
    }
}
