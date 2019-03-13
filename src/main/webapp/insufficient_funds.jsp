<%-- 
    Document   : insufficient_funds
    Created on : 05-03-2019, 16:35:01
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
    <h1>You too broke</h1>
        <a href="/CupCakesProject/increasebalance.jsp">Indsæt penge</a>
        <a href="/CupCakesProject/products.jsp">Tilbage</a>
</div>
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>