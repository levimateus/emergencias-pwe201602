/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifsp.pwe.gerenciador.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ifsp.pwe.gerenciador.beans.*;
import ifsp.pwe.gerenciador.dao.*;
import ifsp.pwe.gerenciador.servlets.*;
/**
 *
 * @author Guilherme
 */
@WebServlet(name = "VerPagina", urlPatterns = {"/VerPagina"})
public class ChamarURLs extends HttpServlet {
    
    /**
     * Metodo responsavel por chamar os menus e realizar direcionamentos
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("action"); //Pego a acao do menu e verifico pra qual pagina devera ser enviado
         switch (acao) {
            case "home-atendente":
            {
                //request.setAttribute("doces",doces);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/paginas/HomeAtendente.jsp");
                dispatcher.forward(request,response);
                break;
            }
            case "home-campo":
            {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/paginas/HomeCampo.jsp");
                dispatcher.forward(request,response);
                break;
            }
            case "registro-ocorrencia":
            {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/paginas/NovaOcorrenciaAtend.jsp");
                dispatcher.forward(request,response);
                break;
            }
            case "registro-ocorrencia-alarme":
            {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/paginas/VerificaAlarme.jsp");
                dispatcher.forward(request,response);
                break;
            }
            case "finaliza-step1":
            {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/paginas/FinalizaOcorrenciaStep1.jsp");
                dispatcher.forward(request,response);
                break;
            }
            case "home-master":
             {
                 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/paginas/HomeMaster.jsp");
                 dispatcher.forward(request,response);
                 break;
             }
            case "funcionarios":
            {
                Collection <Usuario> funcionarios = null;
                    try {
                        funcionarios = new DAOUsuario().RecuperaUsuarios();
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(ChamarURLs.class.getName()).log(Level.SEVERE, null, ex);
                    }
                request.setAttribute("funcionarios",funcionarios);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/paginas/funcionarios.jsp");
                dispatcher.forward(request,response);
                break;
            }
            case "veiculos":
            {
                Collection <Veiculo> veiculos = null;
                    try {
                        veiculos = new DAOVeiculo().RecuperaVeiculos();
                    } catch (ClassNotFoundException | SQLException ex) {
                        Logger.getLogger(ChamarURLs.class.getName()).log(Level.SEVERE, null, ex);
                    }
                request.setAttribute("veiculos",veiculos);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/paginas/veiculos.jsp");
                dispatcher.forward(request,response);
                break;
            }
            case "ver-ocorrencias":
            {
                Collection <Ocorrencia> ocorrencias = null;
                    try {
                        ocorrencias = new DAOOcorrencia().RecuperaOcorrencias();
                    } catch (ClassNotFoundException | SQLException | ParseException ex) {
                        Logger.getLogger(ChamarURLs.class.getName()).log(Level.SEVERE, null, ex);
                    }
                request.setAttribute("ocorrencias",ocorrencias);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/paginas/ver-ocorrencias.jsp");
                dispatcher.forward(request,response);
                break;
            }
            case "add-master":
            {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/paginas/add-master.jsp");
                dispatcher.forward(request,response);
                break;
            }
            case "ver-regioes":
            {
                Collection <Regiao> regioes = null;
                try {
                    regioes = new DAORegiao().RecuperaRegioes();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ChamarURLs.class.getName()).log(Level.SEVERE, null, ex);
                }
                Collection <Rua> ruas = null;
                try {
                    ruas = new DAORua().RecuperaRuasOcorrencias();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(ChamarURLs.class.getName()).log(Level.SEVERE, null, ex);
                }
                int regiao1 = 0;
                int regiao2 = 0;
                int regiao3 = 0;
                int regiao4 = 0;
                for (Rua rua : ruas){
                    if(rua.regiaoId == 1){
                        regiao1++;
                    }
                    if(rua.regiaoId == 2){
                        regiao2++;
                    }
                    if(rua.regiaoId == 3){
                        regiao3++;
                    }
                    if(rua.regiaoId == 4){
                        regiao4++;
                    }
                }
                for (Regiao regiao : regioes){
                    if(regiao.getRegiaoId() == 1){
                        regiao.ocorrencia = regiao1;
                        try {
                            new DAORegiao().atualizaOcorrencia(regiao.getRegiaoId(),regiao.ocorrencia);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(ChamarURLs.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(ChamarURLs.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if(regiao.getRegiaoId() == 2){
                        regiao.ocorrencia = regiao2;
                        try {
                            new DAORegiao().atualizaOcorrencia(regiao.getRegiaoId(),regiao.ocorrencia);
                        } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(ChamarURLs.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if(regiao.getRegiaoId() == 3){
                        regiao.ocorrencia = regiao3;
                        try {
                            new DAORegiao().atualizaOcorrencia(regiao.getRegiaoId(),regiao.ocorrencia);
                        } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(ChamarURLs.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if(regiao.getRegiaoId() == 4){
                        regiao.ocorrencia = regiao4;
                        try {
                            new DAORegiao().atualizaOcorrencia(regiao.getRegiaoId(),regiao.ocorrencia);
                        } catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(ChamarURLs.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                request.setAttribute("regioes",regioes);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/paginas/ver-regioes.jsp");
                dispatcher.forward(request,response);
                break;
            }
             default:
                 break;
         }
     
    }
  
}