
package controller;

import dao.AdminDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.admin;


public class LoginAdminServlet extends HttpServlet {
    private final AdminDao adDao = new AdminDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        admin ad = adDao.LoginAdmin(email, pass);
        HttpSession session = request.getSession();
        String url="";
        if(ad != null ){
            session.setAttribute("admin", ad);
            url="/indexadmin.jsp";
        }
        else{
            session.setAttribute("error", "email hoặc mật khẩu không đúng");
            url = "/loginadmin.jsp";
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
