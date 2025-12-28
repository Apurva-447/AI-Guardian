<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
    String lang = (String) session.getAttribute("lang");
    if (lang == null) lang = "en";

    ResourceBundle bundle =
        ResourceBundle.getBundle("i18n.messages", new Locale(lang));
%>

<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detect Threat | AI Guardian</title>
</head>
<body>

<h2>AI Threat Detection</h2>

<form action="DetectThreatServlet" method="post">
    <textarea name="inputText" rows="6" cols="50"
        placeholder="Paste suspicious message / call description here..."
        required></textarea>
    <br><br>
    <button type="submit">Analyze</button>
</form>

<br>
<a href="dashboard.jsp">⬅ Back to Dashboard</a>

</body>
</html>
