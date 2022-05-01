/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fees_management_system;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Asus
 */
public class DBconnection {
    
    public static Connection getconnection(){
        Connection con=null;
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management", "root", "1234");   
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
        
    }
    
}
