/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Nguye
 */
public class DBConnection {
    private static Connection con;

    public static Connection getConnect() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ShopNewPhuc;Username=sa;Password=123456");
        } catch (Exception e) {
            System.out.print("Connection failed");
        }
        return con;
    }

    public static String testConnect() {
        try {
            con = getConnect();
            return "Successful Connection";
        } catch (Exception e) {
            return " Connection failed";
        }
    }
    
    
    
}
