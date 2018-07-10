/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zaid
 */
public class ShowData {
    
    private Connection conn;
    private Statement stm;
    ResultSet rs;
    
    public ShowData(){
        this.conn = null;
        this.stm = null;
    }
    
    
    
    public ResultSet display(String tableName){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:MainDB.db");
            stm = conn.createStatement();
            String sql = "SELECT * FROM " + tableName;
            rs = stm.executeQuery(sql);
            //stm.close();
            System.out.println(sql);
        } catch (Exception ex) {
            Logger.getLogger(ShowData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
