/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mateus.emergencias.servlets;

import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mateus.emergencias.beans.*;
import mateus.emergencias.dao.*;

/**
 *
 * @author Guilherme
 */
public class BuscaFuncionario implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String busca = req.getParameter("busca");
           Collection <Usuario> funcionarios = null;
        try {
            funcionarios = new DAOUsuario().BuscaFuncionario(busca);
        } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(ChamarURLs.class.getName()).log(Level.SEVERE, null, ex);
            }
        req.setAttribute("funcionarios",funcionarios);
        return "/WEB-INF/paginas/funcionarios.jsp";
    }
    
}
