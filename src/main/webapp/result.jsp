<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%
    String lang = (String) session.getAttribute("lang");
    if (lang == null) lang = "en";

    ResourceBundle bundle =
        ResourceBundle.getBundle("i18n.messages", new Locale(lang));
    String risk = (String) request.getAttribute("risk");
%>

<html>
<head>
    <title>Detection Result | AI Guardian</title>
    <link rel="stylesheet" href="css/result.css">
</head>
<body>

<div class="result-container">

    <h2>Message Analysis Result</h2>

    <div class="result-box">
        <strong>Message:</strong><br>
        ${text}
    </div>

    <div class="result-box">
        <strong>Risk Level:</strong>
        <span class="${risk.toLowerCase()}">${risk}</span>
    </div>

    <div class="result-box">
        <strong>Threat Score:</strong> ${score}
    </div>

    <% if ("YES".equals(request.getAttribute("emergency"))) { %>
        <div class="emergency">
            ⚠ Emergency email has been sent to the guardian
        </div>
    <% } %>
<!-- 🛡️ SAFETY TIPS BASED ON RISK -->
<div class="tips-box">

    <h3>
<%= bundle.containsKey("tips_title")
    ? bundle.getString("tips_title")
    : "Safety Advice" %>
</h3>


    <% if ("LOW".equals(risk)) { %>
        <p>• <%= bundle.getString("tip_low_1") %></p>

    <% } else if ("MEDIUM".equals(risk)) { %>
        <p>• <%= bundle.getString("tip_med_1") %></p>
        <p>• <%= bundle.getString("tip_med_2") %></p>
        <p>• <%= bundle.getString("tip_med_3") %></p>

    <% } else if ("HIGH".equals(risk)) { %>
        <p>⚠️ <%= bundle.getString("tip_high_1") %></p>
        <p>• <%= bundle.getString("tip_high_2") %></p>
        <p>• <%= bundle.getString("tip_high_3") %></p>
        <p>• <%= bundle.getString("tip_high_4") %></p>
    <% } %>

</div>

    <form action="home.jsp">
        <button class="back-btn">Check Another Message</button>
    </form>

</div>

</body>
</html>
