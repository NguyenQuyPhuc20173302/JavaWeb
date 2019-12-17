
package dao;


import connect.DBConnection;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import model.Product; 

public class ProductDao {
    
    // danh sách sản phẩm          
    public ArrayList<Product> getListProductByCategory(int category_id)  throws SQLException {         
            Connection connection = DBConnection.getConnect();
            String sql = "SELECT * FROM product WHERE category_id = '" + category_id + "'";         
            PreparedStatement ps = connection.prepareCall(sql);         
            ResultSet rs = ps.executeQuery();         
            ArrayList<Product> list = new ArrayList<>();         
            while (rs.next()) {             
                Product product = new Product();
                product.setProductID(rs.getInt("product_id"));             
                product.setProductName(rs.getString("product_name"));             
                product.setProductImage(rs.getString("product_image"));             
                product.setProductPrice(rs.getInt("product_price"));             
                product.setProductDescription(rs.getString("product_description"));             
                list.add(product);         
            }         
            return list;     
    }
    

    public static Product getProduct(int proID) throws SQLException{
        Connection con = DBConnection.getConnect();
        String sql = "SELECT * FROM product  WHERE product_id = '"+proID+"' ";
        
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        Product product = new Product();
        while(rs.next()){
            product.setProductID(rs.getInt("product_id"));
            product.setCategoryID(rs.getInt("category_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductImage(rs.getString("product_image"));
            product.setProductPrice(rs.getInt("product_price"));
            product.setProductDescription(rs.getString("product_description"));           
        }
        return product; 
    }
    
    public static Product getProduct(String proName) throws SQLException{
        Connection con = DBConnection.getConnect();
        String sql = "SELECT * FROM product  WHERE product_name = '"+proName+"' ";
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        Product product = new Product();
        while(rs.next()){
            product.setProductID(rs.getInt("product_id"));
            product.setCategoryID(rs.getInt("category_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductImage(rs.getString("product_image"));
            product.setProductPrice(rs.getInt("product_price"));
            product.setProductDescription(rs.getString("product_description"));           
        }
        return product;
    }
}
 
