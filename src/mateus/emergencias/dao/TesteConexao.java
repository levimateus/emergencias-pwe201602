/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mateus.emergencias.dao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme
 */
public class TesteConexao {
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        Connection connection = new ConnectionFactory().getConnection();
        JOptionPane.showMessageDialog(null, "Conectado com sucesso");
        connection.close();
    }
}
