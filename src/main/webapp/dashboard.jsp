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
    Object user = session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/dashboard.css">
</head>
<body>
<div class="container">
<h2>Welcome to AI Guardian 🎉</h2>
<p>Login successful ✅</p>

<a href="detect.jsp">Detect Threat</a><br><br>
<a href="emergency.jsp">Emergency Contacts</a><br><br>
<a href="logout.jsp">Logout</a>
</div>
</body>
</html>
