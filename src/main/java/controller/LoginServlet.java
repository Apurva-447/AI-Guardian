package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.UserDAO;
import model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();
        User user = dao.loginUser(email, password);  // 🔐 DB CHECK

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);              // full user object
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("role", user.getRole());
            if ("ADMIN".equals(user.getRole())) {
                response.sendRedirect("AdminAlertServlet");
            } else {
                response.sendRedirect("home.jsp");
            }

        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
}
