package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 
import model.Cart; 
import dao.ProductDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import model.Cart;
import model.Item;
import model.Product;
public class CartServlet extends HttpServlet {
    private final ProductDao proDao = new ProductDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String url="";
        String command = request.getParameter("command");
        String proID = request.getParameter("productID");
        Cart cart = (Cart) session.getAttribute("cart");
        String categoryID = "";
        try {
            int idProduct = (int) Long.parseLong(proID);
            Product product = proDao.getProduct(idProduct);
            int category = product.getCategoryID();
            categoryID = Long.toString(category);
            switch(command){
                case "plus":
                    if(cart.getCartItems().containsKey(idProduct)){
                        cart.plusToCart(idProduct, new Item(product, cart.getCartItems().get(idProduct).getQuantity() ) );
                    }
                    else{
                        cart.plusToCart(idProduct, new Item(product, 1));
                    }
                    break;                      
                case "remove":
                    cart.removeToCart(idProduct);
                    break;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            url="/index.jsp";
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
        }
        session.setAttribute("cart", cart);
        
        url="/products.jsp?category="+categoryID;
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
