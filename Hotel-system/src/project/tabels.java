package project;

import java.sql.*;
import javax.swing.JOptionPane;

public class tabels {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();
//String CreateTable ="  create table users(name varchar(200),email varchar(200),password varchar(50),securityQuestion varchar(500),answer varchar(200),address varchar(200),status varchar(20))";
st.executeUpdate("DROP TABLE IF EXISTS customer;");   
st.executeUpdate("DROP TABLE IF EXISTS room;");     

st.executeUpdate(
"Create table room(\n" +
"roomNo mediumint NOT NULL,\n" +
"roomType varchar(40),\n" +
"bed varchar(40),\n" +
"price mediumint,\n" +
" status varchar(20),\n" +
" primary key (roomNo)\n" +
");");


 

st.executeUpdate(
"CREATE TABLE customer (\n" +
"    id INT NOT NULL auto_increment,\n" +
"    name VARCHAR(60),\n" +
"    mobileNumber VARCHAR(20),\n" +
"    nationality VARCHAR(50),\n" +
"    gender VARCHAR(30),\n" +
"    email VARCHAR(100),\n" +
"    idProof INT,\n" +
"    address VARCHAR(500),\n" +
"    checkIn VARCHAR(50),\n" +
"    roomNo MEDIUMINT,\n" +
"    bed VARCHAR(40),\n" +
"    roomType VARCHAR(200),\n" +
"    pricePerDay INT(10),\n" +
"    numberofDaysStay INT(10),\n" +
"    totalAmount VARCHAR(200),\n" +
"    checkout VARCHAR(50),\n" +
"    PRIMARY KEY (id),\n" +
"    CONSTRAINT roomNo FOREIGN KEY (roomNo)\n" +
"        REFERENCES room (roomNo)\n" +
")AUTO_INCREMENT = 1;");

JOptionPane.showMessageDialog(null, "Table Created Successfully");
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
