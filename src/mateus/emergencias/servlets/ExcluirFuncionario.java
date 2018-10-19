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
public class ExcluirFuncionario implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String contato = req.getParameter("id_func");
        int id = Integer.parseInt(contato);
        try {
            int removeUsuario = new DAOUsuario().removeUsuario(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExcluirFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        Collection <Usuario> funcionarios = null;
        try {
            funcionarios = new DAOUsuario().RecuperaUsuarios();
        } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(ChamarURLs.class.getName()).log(Level.SEVERE, null, ex);
            }
        req.setAttribute("funcionarios",funcionarios);
        return "/WEB-INF/paginas/funcionarios.jsp";
    }
    
}
