/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.gerenciador.servlets;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ifsp.pwe.gerenciador.dao.*;

/**
 *
 * @author Guilherme
 */
public class ExcluirContato implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String contato = req.getParameter("id_contato");
        int id = Integer.parseInt(contato);
        try {
            int removeUsuario = new DAOUsuario().removeUsuario(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExcluirContato.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "/WEB-INF/paginas/ExcluirSucesso.jsp";
    }
    
}
