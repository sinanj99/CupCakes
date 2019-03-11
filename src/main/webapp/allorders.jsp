<%-- 
    Document   : allorders
    Created on : 06-03-2019, 16:23:57
    Author     : sinanjasar
--%>

<%@page import="Data.Order"%>
<%@page import="Data.OrdersDAO"%>
<%@page import="Data.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu2.jsp'></jsp:include>
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>
<%
    User user = (User) request.getSession().getAttribute("user");
    if (user == null) {
        response.sendRedirect("/CupCakesProject/login.jsp");
    }
%>
        <%
            for (Order o : OrdersDAO.getAllOrders()) {
        %>
        <li style="padding-top: 80px; text-align: center;"> <a href="/CupCakesProject/showorder.jsp?id=<%=o.getId()%>"> Ordrenr: <%=o.getId()%> - Dato: <%=o.getDatePlaced()%></a></li>    
        <%
            }
        %>

