
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UsersDao;


public class CheckEmailServlet extends HttpServlet {
    
    UsersDao usersDAO = new UsersDao();
    @Override     
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {     
    }     
    @Override     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {         
        if (usersDAO.checkMail(request.getParameter("username"))) {             
            response.getWriter().write("<img src=\"images/not-available.PNG\" />");         
        } 
        else {             
            response.getWriter().write("<img src=\"images/available.PNG\" />");         
        }     
    }


}
