/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Nguye
 */
import connect.DBConnect; 
import connect.DBConnection;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import model.Category; 
public class CategoryDao {
    public ArrayList<Category> getListCategory() throws SQLException{
        Connection con = DBConnection.getConnect();
        String sql = "SELECT * FROM category"; 
        PreparedStatement ps = con.prepareCall(sql);         
        ResultSet rs = ps.executeQuery();         
        ArrayList<Category> list = new ArrayList<>(); 
        while(rs.next()){
            Category category = new Category();             
            category.setCategoryID(rs.getInt("category_id"));             
            category.setCategoryName(rs.getString("category_name"));             
            list.add(category); 
        }
        return list;
    }
    
    public static void main(String[] args) throws SQLException {         
        CategoryDao dao = new CategoryDao();
        for (Category ds : dao.getListCategory()) {             
            System.out.println(ds.getCategoryID() + " - " + ds.getCategoryName());         
        }     
    }
}
