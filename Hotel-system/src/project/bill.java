package project;

import java.io.File;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author osama
 */
public class bill {
    public static void print_bill(int id)
    {
    
            try{
                if((new File("E:\\"+id+".pdf")).exists()){
                    
                    Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler E:\\"+id+".pdf");
                }else{
                    JOptionPane.showMessageDialog(null, "File is not Exists");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
    
    
    
    
    
    
    }
    
}
