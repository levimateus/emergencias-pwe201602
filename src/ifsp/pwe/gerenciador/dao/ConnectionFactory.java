/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifsp.pwe.gerenciador.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme
 */
public class ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException{
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/emergenciasdb", "mateus", "password");
        }
        catch(SQLException excecao){
            JOptionPane.showMessageDialog(null, "Erro no banco");
            throw new RuntimeException(excecao);
        }
    }
}
