/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author osama
 */
public class hashing_pass {
     public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();
       
PasswordAuthentication hasher = new PasswordAuthentication();
        
try {
    for (int i = 1; i <= 50; i++) {
                 ResultSet rs = Select.getData("select password from users where user_id='" +i+ "'");
                 
                 if (rs.next()) {
                     System.out.println(rs.getString(1));
//                Thread.sleep(500);
                String Hashed_pass = hasher.hash(rs.getString(1));
                 st.executeUpdate("UPDATE users\n" +
                 "SET password='"+Hashed_pass+"'  where user_id="+i+";");
//                 Thread.sleep(500);

                }
            }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
// st.executeUpdate("DROP TABLE IF EXISTS users;");  
//JOptionPane.showMessageDialog(null, "Table Created Successfully");

//        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {

            try {
                con.close();
                st.close();
            } catch (Exception e) {
            }
        }
    }
    
}
