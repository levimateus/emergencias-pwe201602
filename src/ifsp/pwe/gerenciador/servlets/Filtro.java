/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.gerenciador.servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import ifsp.pwe.gerenciador.beans.*;

/**
 *
 * @author giova
 */

public class Filtro implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String url = req.getRequestURI();
        String usuario = getUsuario(req);
        System.out.println("Usuario: " + usuario + " acessando a url " + url);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
    
    public String getUsuario(HttpServletRequest req){
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioLogado");
        if(usuario==null){
           return "deslogado";
        }
        return usuario.getNome();
    }
    
}
