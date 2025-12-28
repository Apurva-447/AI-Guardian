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
<title>Admin Dashboard | AI Guardian</title>
<link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/dashboard.css">

</head>
<body>
<div class="container">
<h2>Admin Dashboard – All Alerts</h2>

<table border="1" cellpadding="8">
<tr>
    <th>User Email</th>
    <th>Input Text</th>
    <th>Risk</th>
    <th>Score</th>
    <th>Time</th>
</tr>

<%
    List<String[]> alerts = (List<String[]>) request.getAttribute("alerts");
    if (alerts != null) {
        for (String[] a : alerts) {
%>
<tr>
    <td><%= a[0] %></td>
    <td><%= a[1] %></td>
    <td><%= a[2] %></td>
    <td><%= a[3] %></td>
    <td><%= a[4] %></td>
</tr>
<%
        }
    }
%>

</table>

<br>
<a href="dashboard.jsp">Back to User Dashboard</a>
 <a href="LogoutServlet" class="btn logout">Logout</a>
</div>
</body>
</html>
