
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Users;
import javax.servlet.http.HttpSession; 
import model.Cart;


public class OutsignServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        Cart cart = (Cart) session.getAttribute("cart");
        users = null;
        cart = null;
        session.setAttribute("user", users);
        session.setAttribute("cart", cart);
        response.sendRedirect("/ShopNew/index.jsp"); 
    }
}
