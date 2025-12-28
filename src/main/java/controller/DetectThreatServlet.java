package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.AlertDAO;
import model.User;
import util.EmailService;

@WebServlet("/DetectThreatServlet")
public class DetectThreatServlet extends HttpServlet {

    // ✅ Handle POST (form submission)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String text = request.getParameter("inputText").toLowerCase();
        int score = 0;

        // 🔍 Rule-based AI keywords
        if (text.contains("otp")) score += 3;
        if (text.contains("bank")) score += 2;
        if (text.contains("urgent")) score += 2;
        if (text.contains("money")) score += 3;
        if (text.contains("link")) score += 2;
        if (text.contains("account")) score += 2;

        String risk;
        if (score >= 6) {
            risk = "HIGH";
        } else if (score >= 3) {
            risk = "MEDIUM";
        } else {
            risk = "LOW";
        }

        // 🔐 Session check (IMPORTANT)
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        // 🧠 Save alert
        AlertDAO dao = new AlertDAO();
        dao.saveAlert(user.getUserId(), text, risk, score);

        // 🚨 Guardian email for HIGH risk
        if ("HIGH".equals(risk)) {

            String msg =
                "AI Guardian Alert\n\n" +
                "High risk message detected.\n" +
                "Please contact the user immediately.";

            EmailService.sendGuardianEmail(
                user.getGuardianEmail(),
                msg
            );

            request.setAttribute("emergency", "YES");
        }

        // 📊 Send data to result page
        request.setAttribute("risk", risk);
        request.setAttribute("score", score);
        request.setAttribute("text", text);

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    // ✅ Handle GET safely (prevents 405 error)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("home.jsp");
    }
}
