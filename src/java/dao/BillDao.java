
package dao;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import connect.DBConnection; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.SQLException; 
import java.sql.Timestamp; 
import java.util.Date; 
import model.Bill; 
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class BillDao {
    public  static void insertBill(Bill bill) throws SQLException{
        Connection con = DBConnection.getConnect();
        String sql = "INSERT INTO bill1 VALUES(?,?,?,?,?,?)"; 
        PreparedStatement ps = con.prepareCall(sql);
        ps.setInt(1, bill.getBillID());
        ps.setInt(2, bill.getUserID());
        ps.setInt(3, bill.getTotal());
        ps.setString(4, bill.getPayment());
        ps.setString(5, bill.getAddress());
        ps.setString(6,bill.getDate());
        ps.executeUpdate();  
    }
    public static String thoigian(){
        Calendar c = Calendar.getInstance();
        String year = Integer.toString(c.get(Calendar.YEAR));
        String month = Integer.toString(c.get(Calendar.MONTH));
        String day = Integer.toString(c.get(Calendar.DAY_OF_MONTH));
        String hour = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
        String minute = Integer.toString(c.get(Calendar.MINUTE));
        String date ="ngày"+day+" thang"+month+" năm"+year+", "+hour+"giờ "+minute+"phút";
        return date;
    }
    public static void main(String ...agre) throws SQLException{
        Bill bill = new Bill(2, 2, 2, "a", "a", "a");
        insertBill(bill);
    }
    public int CountBill(){
        Connection con = DBConnection.getConnect();
        String sql = "select count(*) form bill1";
    }
 
    
}
