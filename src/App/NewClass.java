/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class NewClass {
    
    public static void main (String[] args){
        try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM user";
            
            Statement stat = con.createStatement();
            
            ResultSet rs = stat.executeQuery(query);
            while(rs.next()){
                String uID = rs.getString("userID");
                String name = rs.getString("username");
                String pass = rs.getString("password");
                
                System.out.println("user ID: "+ uID);                
                System.out.println("user name: "+ name);
                System.out.println("user pass: "+ pass);

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
