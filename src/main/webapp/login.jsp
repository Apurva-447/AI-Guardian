<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%
    String lang = (String) session.getAttribute("lang");
    if (lang == null) lang = "en";

    ResourceBundle bundle =
        ResourceBundle.getBundle("i18n.messages", new Locale(lang));
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login | AI Guardian</title>
<link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/auth.css">
</head>
<body>

<div class="auth-box">
    <h2 style="text-align:center;">Login</h2>
<% if (request.getParameter("error") != null) { %>
    <p style="color:red; text-align:center;">
        ❌ Invalid email or password
    </p>
<% } %>

    <form action="LoginServlet" method="post">
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>

    <p style="text-align:center;">
        New user?
        <a href="register.jsp">Register</a>
    </p>
</div>

</body>
</html>
