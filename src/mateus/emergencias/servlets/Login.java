/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mateus.emergencias.servlets;

import mateus.emergencias.dao.*;
import mateus.emergencias.beans.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Guilherme
 */
public class Login implements Tarefa {

    /**
     * Realizar o login do usuário, realizando o direcionamento correto de acordo
     * com o seu tipo (Cliente ou distribuidor)
     * @param req
     * @param resp
     */
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("login");        
        String senha = req.getParameter("senha");
        
        Usuario usuario = null;
        try {
            usuario = new DAOUsuario().validaLogin(login, senha);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(usuario==null){
            return ("/WEB-INF/paginas/usuarioInvalido.jsp");
        } 
        else 
        {
            HttpSession session = req.getSession();
            //se o cargo for de atendente terá uma área especifica
            String cargo = usuario.getCargo();
            if("atendente".equals(cargo)){
                session.setAttribute("usuarioLogado", usuario);
                return ("/WEB-INF/paginas/HomeAtendente.jsp");
            }else if("master".equals(cargo)){
                session.setAttribute("usuarioLogado", usuario);
                return ("/WEB-INF/paginas/HomeMaster.jsp");
            }
            //se não for atendente é bombeiro ou policial ou paramedico, outra home
            else{
                session.setAttribute("usuarioLogado", usuario);
                return ("/WEB-INF/paginas/HomeCampo.jsp");
            }
        }
    }
}
