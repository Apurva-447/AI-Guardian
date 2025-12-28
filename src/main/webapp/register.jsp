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
<title>Register | AI Guardian</title>
<link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/auth.css">
</head>
<body>

<div class="auth-box">
    <h2>User Registration</h2>

    <form action="RegisterServlet" method="post">
        <input type="text" name="name" placeholder="Full Name" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>
        <input type="text" name="phone" placeholder="Phone Number" required>
        <input type="Email" name="guardianEmail" placeholder="Email of trusted family member" required>
        <button type="submit">Register</button>
    </form>

    <p style="text-align:center;">
        Already have an account?
        <a href="login.jsp">Login</a>
    </p>
</div>

</body>
</html>
