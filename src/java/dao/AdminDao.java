
package dao;

import java.sql.Connection;
import connect.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.admin;

public class AdminDao {
    public admin LoginAdmin(String email , String pass){
        Connection con = DBConnection.getConnect();
        String sql = "select * from adminPhuc where "
                + "admin_email ='"+email+"'"
                + "and admin_pass = '"+pass+"'";
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                admin ad = new admin();
                ad.setAdminEmail(rs.getString("admin_email"));
                ad.setAdminFullName(rs.getString("admin_fullname"));
                ad.setAdminImg(rs.getString("admin_img"));
                ad.setAdminPass(rs.getString("admin_pass"));
                return ad;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
