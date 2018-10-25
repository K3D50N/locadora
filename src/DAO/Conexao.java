package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexao {

    public static Connection AbrirConexao() {
        Connection con = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/locadora";
            con = DriverManager.getConnection(url, "root", "123");
        
        } catch (Exception e){
            JOptionPane.showConfirmDialog(null, "Erro na conexão com o Banco",
                    "video Locadora", JOptionPane.ERROR_MESSAGE);
            e.getMessage();
        }
        return con;
    }
    
    public static void FecharConexao(Connection con) {
        try{
            con.close();
        
        } catch (Exception e) {
            System.out.println("e.getMessage");
        }
    }
}
