/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Users;


public class UsersDao {
    public  static boolean checkMail(String email){
        Connection connect = DBConnection.getConnect();
        String sql = "SELECT *FROM userS WHERE user_email = '"+email+"'";
        PreparedStatement ps ;
        try {
            ps = connect.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                connect.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    // thêm tài khoản 
    public static boolean insertUser(Users u){
        Connection connect = DBConnection.getConnect();
        String sql = "INSERT INTO users VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setLong   (1, u.getUserID());
            ps.setString(2, u.getUserFullName());
            ps.setString(3, u.getUserEmail());
            ps.setString(4, u.getUserPass());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    
    public Users Login(String email , String pass){
        Connection con = DBConnection.getConnect();
        String sql = "select * from users where "
                + "user_email = '"+email+"'"
                + "and user_pass = '"+pass+"'";
        PreparedStatement ps ;
        try {
            ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Users u = new Users();
                u.setUserEmail(rs.getString("user_email"));
                con.close();
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static int CountUsers() throws SQLException{
        int a = 0;
        Connection con =  DBConnection.getConnect();
        String sql = "SELECT COUNT(*) FROM users";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            a = rs.getInt("");
        }
        return a;
    }
    
  
}
