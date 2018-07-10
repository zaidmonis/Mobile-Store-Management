/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UPLC
 */
public class DBConnect {
    private static Connection conn;
    private static Statement stm;
    public static Statement createConnection(String dbName){
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" +dbName);
            stm = conn.createStatement();
        }
        catch(Exception e){
            System.out.println("Error");
            System.out.print(e);
        }
        return stm;
    }
    public static void closeConnection(){
        try {
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
