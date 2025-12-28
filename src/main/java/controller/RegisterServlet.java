package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String guardianEmail = request.getParameter("guardianEmail");
        User user = new User(name, email, password, phone, guardianEmail);
        UserDAO dao = new UserDAO();

        boolean success = dao.registerUser(user);

        if (success) {
            response.sendRedirect("login.jsp");
        } else {
            response.getWriter().println("Registration Failed!");
        }
    }
}
