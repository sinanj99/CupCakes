<%-- 
    Document   : increasebalance
    Created on : 05-03-2019, 17:11:41
    Author     : sinanjasar
--%>

<%@page import="Data.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu2.jsp'></jsp:include>

<%
    User user = (User) request.getSession().getAttribute("user");
    if (user == null) {
        response.sendRedirect("/CupCakesProject/login.jsp");
    }
%>
<div class="masterdiv background-cupcake">
    <h1>Magical Money Generator</h1>
    <form method="get" action="FrontController">
        <%
            if (request.getSession().getAttribute("balanceResult") == null) {
        %>
        <input class="inputproducts" style="margin-bottom: 20px;" type="text" name="newbalance" placeholder="Insert amount ...">
        <%
        } else if (request.getSession().getAttribute("balanceResult") != null
                && (request.getSession().getAttribute("balanceResult") == "invalidInput"
                || request.getSession().getAttribute("balanceResult") == "negativeInput")) {
        %>
        <input class="inputproductsfail" style="margin-bottom: 20px;" type="text" name="newbalance" placeholder="Positive integers only!">
        <%
            session.removeAttribute("balanceResult");
            }
        %>
        <input class="button" type="submit" name="add" value="Add">
        <input type="hidden" name="command" value="increasebalance">
    </form>
</div>
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>