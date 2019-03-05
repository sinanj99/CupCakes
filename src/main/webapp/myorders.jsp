<%-- 
    Document   : myorders
    Created on : 05-03-2019, 13:36:48
    Author     : Obaydah Mohamad
--%>
<%@page import="Data.OrdersDAO"%>
<%@page import="Data.User"%>
<%@page import="Data.Order"%>
<% User user = (User) session.getAttribute("user");%>
<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>
<%if(user == null) response.sendRedirect("/CupCakesProject/login.jsp");%>
<!--Body Start-->

<h1>Dine ordre: </h1>
<ul>
    <%
        for(Order o : OrdersDAO.getOrders(user.getUsername())){
    %>
            <li><a href="/CupCakesProject/showorder.jsp?id=<%=o.getId()%>">Ordrenr: <%=o.getId()%> - Dato: <%=o.getDatePlaced()%></li>
    <%}%>
</ul>
<!--Body End-->
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>