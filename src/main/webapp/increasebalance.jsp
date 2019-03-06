<%-- 
    Document   : increasebalance
    Created on : 05-03-2019, 17:11:41
    Author     : sinanjasar
--%>

<%@page import="Data.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>

<%
    User user = (User) request.getSession().getAttribute("user");
    if (user == null) {
        response.sendRedirect("/CupCakesProject/login.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Magisk pengegenerator</h1>
        <form method="get" action="FrontController">
            <input type="text" name="newbalance" placeholder="Indtast beløb ...">
            <input type="submit" name="add" value="Tilføj">
            <input type="hidden" name="command" value="increasebalance">
            <%
                if (request.getSession().getAttribute("balanceResult") != null
                        && (request.getSession().getAttribute("balanceResult") == "invalidInput" 
                        || request.getSession().getAttribute("balanceResult") == "negativeInput")) {
            %>
            <p style="color: red">Indtast venligst et positivt heltal!</p>
            <%
                }
            request.getSession().removeAttribute("balanceResult");
            %>
        </form>
    </body>
</html>
