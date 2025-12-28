package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LanguageServlet")
public class LanguageServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String lang = request.getParameter("lang");
        HttpSession session = request.getSession();
        session.setAttribute("lang", lang);

        response.sendRedirect("home.jsp");
    }
}
