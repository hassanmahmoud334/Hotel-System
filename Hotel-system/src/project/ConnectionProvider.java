package project;

import java.sql.Connection;

import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConnectionProvider {

    public static Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hotel", "root", "123456");
           
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
            
        }
    }
}
