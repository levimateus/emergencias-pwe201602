/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mateus.emergencias.servlets;

import mateus.emergencias.beans.*;
import mateus.emergencias.dao.*;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
public class BuscaVeiculo implements Tarefa {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String busca = req.getParameter("busca");
        Collection <Veiculo> veiculos = null;
            try {
                veiculos = new DAOVeiculo().BuscaVeiculos(busca);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ChamarURLs.class.getName()).log(Level.SEVERE, null, ex);
            }
           req.setAttribute("veiculos",veiculos);
           return "/WEB-INF/paginas/veiculos.jsp";    
    }
    
}
