
package controller;

import dao.BillDao; 
import dao.BillDetailDao; 
import java.io.IOException; 
import java.sql.Timestamp; 
import java.util.Date; 
import java.util.Map; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 
import model.Bill; 
import model.BillDetail; 
import model.Cart; 
import model.Item; 
import model.Users;



public class CheckoutServlet extends HttpServlet {
    private final BillDao billDao = new BillDao();
    private final BillDetailDao billDetailDao = new BillDetailDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String payment = request.getParameter("payment");
        String address = request.getParameter("address");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Users users = (Users) session.getAttribute("user");
        try {
            int ID =  (int) new Date().getTime();
            Bill bill  =  new Bill();
            BillDetail billDetail = new BillDetail();
            bill.setBillID(ID);
            bill.setAddress(address);
            bill.setPayment(payment);
            bill.setUserID(users.getUserID());
            bill.setTotal(cart.total());
            bill.setDate(BillDao.thoigian());
            billDao.insertBill(bill);
            
            billDetail.setBillDetailID(ID);
            billDetail.setBillID(ID);
            for(Map.Entry<Integer,Item> list : cart.getCartItems().entrySet()){
               billDetail.setProductID(users.getUserID());
               billDetail.setPrice((int) list.getValue().getProduct().getProductPrice());
               billDetail.setQuantity(list.getValue().getQuantity());
            }
            billDetailDao.insertBillDetail(billDetail);
            cart = new Cart();
            session.setAttribute("cart", cart);  
        } catch (Exception e) {
        }
        response.sendRedirect("/ShopNew/index.jsp"); 
    }


}
