
package controller;

import dao.UsersDao;
import java.io.IOException; 
import javax.servlet.RequestDispatcher; 
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
import javax.servlet.http.HttpSession; 
import model.Users; 



public class UsersServlet extends HttpServlet {

    UsersDao usersDao = new UsersDao();
    @Override 
   protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       
   }
   @Override     
   protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
       String command = request.getParameter("command");
       String url = "";
       Users users = new Users();
       HttpSession session = request.getSession();
       switch(command){
           case "insert":
               int x = (int) new java.util.Date().getTime();
               users.setUserID(x);
               users.setUserFullName(request.getParameter("fullname"));
               users.setUserEmail(request.getParameter("email"));
               users.setUserPass(request.getParameter("Password"));
               usersDao.insertUser(users);
               url="/index.jsp";
               break;
           case "Login":
               users = usersDao.Login(request.getParameter("email"), request.getParameter("pass"));
               if(users != null ){
                   session.setAttribute("user", users);
                   url = "/index.jsp";
               }
               else{
                   session.setAttribute("error", "email hoặc mật khẩu không đúng");
                   url = "/Login.jsp";
               }
               break;
           
       }
       RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
       rd.forward(request, response);
   }
}
