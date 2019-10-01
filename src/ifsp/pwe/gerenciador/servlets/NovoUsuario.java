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
 * @author Guilherme
 */
public class NovoUsuario implements Tarefa{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        String email = req.getParameter("email");
        String cpf = req.getParameter("cpf");
        String endereco = req.getParameter("endereco");
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        String nivel = req.getParameter("nivel");
        String cargo = req.getParameter("cargo");
        String nascimento = req.getParameter("dt_nascimento");
        Usuario usuario = new Usuario(nome,sobrenome,email,cpf,endereco,login,senha,nivel,cargo,nascimento);
        
        try {
            req.setAttribute("usuario",usuario);
            int teste = new DAOUsuario().adicionaUsuario(usuario);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NovoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        if("master".equals(cargo)){
            return "/WEB-INF/paginas/masterSucesso.jsp";
        }else{
            return "CadastroUsuarioSucesso.jsp";

        }
    }
}
