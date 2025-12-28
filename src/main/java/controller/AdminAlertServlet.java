package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.AdminAlertDAO;

@WebServlet("/AdminAlertServlet")
public class AdminAlertServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("🔥 AdminAlertServlet HIT");

        HttpSession session = request.getSession(false);

        // 🔒 SECURITY CHECK
        if (session == null ||
            session.getAttribute("user") == null ||
            session.getAttribute("role") == null ||
            !"ADMIN".equals(session.getAttribute("role"))) {

            response.sendRedirect("login.jsp");
            return;
        }

        // 📊 FETCH ALERTS
        AdminAlertDAO dao = new AdminAlertDAO();
        request.setAttribute("alerts", dao.getAllAlerts());


        request.getRequestDispatcher("adminDashboard.jsp")
               .forward(request, response);
    }
}
