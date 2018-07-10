/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UPLC
 */
public class SaveData {
    static Statement stm, stm2;
    public static boolean save(int serial, String brand, String model, String imei, int price){
        DBConnect.closeConnection();
        stm = DBConnect.createConnection("MainDB.db");
        String sql;
        sql = "INSERT INTO RECORD VALUES(" +serial + ", \"" +brand +"\", \"" +model +"\", \"" +imei + "\", " +price +")";
        try {
            System.out.println(sql);
            stm.executeUpdate(sql);
            stm.close();
            System.out.println("Success!");
        } catch (SQLException ex) {
            Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    public static boolean saveEmployee(int id, String name, String userName, String doB, String pass){
        //DBConnect.closeConnection();
        stm2 = DBConnect.createConnection("MainDB.db");
        String sql;
        sql = "INSERT INTO EmpRecord VALUES(" +id + ", \"" +name +"\", \"" +userName +"\", \"" +doB + "\", \"" +pass +"\")";
        try {
            System.out.println(sql);
            stm2.executeUpdate(sql);
            stm2.close();
            System.out.println("Success!");
        } catch (SQLException ex) {
            Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
