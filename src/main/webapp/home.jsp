<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="model.User" %>

<%
    // 🔐 Session protection
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    // 🌍 Language handling
    String lang = (String) session.getAttribute("lang");
    if (lang == null) lang = "en";

    ResourceBundle bundle =
        ResourceBundle.getBundle("i18n.messages", new Locale(lang));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><%= bundle.getString("title") %></title>

<link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/home.css">
</head>

<body>

<!-- 🔹 NAVBAR -->
<nav class="navbar">
    <div class="logo"><%= bundle.getString("title") %></div>

    <ul class="nav-links">
        <li><a href="home.jsp"><%= bundle.getString("home") %></a></li>
        <li><a href="#about"><%= bundle.getString("about") %></a></li>
        <li><a href="#contact"><%= bundle.getString("contact") %></a></li>
    </ul>

    <div class="nav-right">

        <!-- 🌍 Language Selector -->
        <form action="LanguageServlet" method="post" style="margin-right:15px;">
            <select name="lang" onchange="this.form.submit()">
                <option value="en" <%= "en".equals(lang) ? "selected" : "" %>>English</option>
                <option value="hi" <%= "hi".equals(lang) ? "selected" : "" %>>हिंदी</option>
                <option value="kn" <%= "kn".equals(lang) ? "selected" : "" %>>ಕನ್ನಡ</option>
            </select>
        </form>

        <!-- 🔐 Logout -->
        <form action="LogoutServlet" method="post">
            <button class="logout-btn">
                <%= bundle.getString("logout") %>
            </button>
        </form>

    </div>
</nav>

<!-- 🔹 HERO SECTION -->
<section class="hero">
    <h1>
        <%= bundle.getString("welcome") %>,
        <span><%= user.getName() %></span> 👋
    </h1>
    <p><%= bundle.getString("priority") %></p>
</section>

<!-- 🔹 QUICK CHECK -->
<section class="quick-check">
    <h2><%= bundle.getString("scan") %></h2>

    <p><%= bundle.getString("paste_help") %></p>

    <form action="DetectThreatServlet" method="post">
    
    
        <textarea name="inputText"
                  placeholder="<%= bundle.containsKey("placeholder")
        ? bundle.getString("placeholder")
        : "Paste the message here..." %>"

                  required></textarea>
        <br>
        <button type="submit">
            <%= bundle.getString("check") %>
        </button>
    </form>
</section>

<!-- 🔹 ABOUT -->
<section class="about" id="about">
    <div class="about-container">

        <div class="about-text">
            <h2><%= bundle.getString("about_title") %></h2>
            <p><%= bundle.getString("about_text") %></p>
        </div>

        <div class="about-image">
            <img src="images/about.webp" alt="Online Safety">
        </div>

    </div>
</section>

<!-- 🔹 CONTACT -->
<section class="contact" id="contact">
    <h2><%= bundle.getString("contact_title") %></h2>
    <p><%= bundle.getString("email") %>: support@aiguardian.com</p>
    <p><%= bundle.getString("location") %>: Bengaluru, India</p>
</section>

<!-- 🔹 FOOTER -->
<p>
<%= bundle.containsKey("footer")
    ? bundle.getString("footer")
    : "© 2025 AI Guardian. All rights reserved." %>
</p>


</body>
</html>
