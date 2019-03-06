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
        <%
            for (Order o : OrdersDAO.getAllOrders()) {
        %>
    <li><a href="/CupCakesProject/showorder.jsp?id=<%=o.getId()%>">Ordrenr: <%=o.getId()%> - Dato: <%=o.getDatePlaced()%></li>    
        <%
            }
        %>
</body>
</html>
