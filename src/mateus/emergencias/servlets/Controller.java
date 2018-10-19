package mateus.emergencias.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //receber uma requisição
        String tarefa = req.getParameter("tarefa");
        
        if(tarefa==null){
            throw new IllegalArgumentException("você esqueceu de passar a tarefa");
        }
        
        //a partir da requisição recebida, definir qual tarefa eu vou executar
        tarefa = "mateus.emergencias.servlets." + tarefa;
        
        //chamar a execução da tarefa

	        try {
	            Class<?> tipo = Class.forName(tarefa);
	            Tarefa instancia = (Tarefa) tipo.newInstance();
	            String pagina = instancia.executa(req, resp);
            
	            RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
	            requestDispatcher.forward(req, resp);
            
	        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
	            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
    }
}
