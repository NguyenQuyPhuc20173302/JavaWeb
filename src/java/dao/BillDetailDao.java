
package dao;
import connect.DBConnection; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import model.BillDetail; 
public class BillDetailDao {
    public static void insertBillDetail(BillDetail bd) throws SQLException{
        Connection con = DBConnection.getConnect();
        String sql = "INSERT INTO bill_detail VALUES(?,?,?,?,?)";
        PreparedStatement ps = con.prepareCall(sql);
        ps.setInt(1, bd.getBillDetailID());
        ps.setInt(2, bd.getBillID());
        ps.setInt(3, bd.getProductID());
        ps.setInt(4, bd.getPrice());
        ps.setInt(5, bd.getQuantity());
        ps.executeUpdate();
    }
    public static void main(String ...agre) throws SQLException{
        BillDetail bd = new BillDetail(1, 1, 1, 1, 1);
        insertBillDetail(bd);
    }
    
    
    
    
}
