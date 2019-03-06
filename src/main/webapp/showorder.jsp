<%-- 
    Document   : showorder
    Created on : 05-03-2019, 14:59:17
    Author     : Obaydah Mohamad
--%>
<%@page import="Data.LineItems"%>
<%@page import="java.lang.reflect.Parameter"%>
<%@page import="Data.OrdersDAO"%>
<%@page import="Data.User"%>
<%@page import="Data.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    User user = (User) session.getAttribute("user");
    if(user == null) response.sendRedirect("/CupCakesProject/login.jsp");
    int orderId = Integer.parseInt(request.getParameter("id"));
    Order order = OrdersDAO.getOrder(orderId);
    if(!order.getUsername().equals(user.getUsername())) response.sendRedirect("/CupCakesProject/myorders.jsp");
%>
<!DOCTYPE html>
<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>
<!--Body Start-->

<h1>Ordre <%= order.getId() %></h1>
<table>
	<tr>
		<th>Antal</th>
		<th>Topping</th>
		<th>Bottom</th>
		<th>Pris</th>
	</tr>
<%
    float price = 0;
    for(LineItems li : order.getLineitems()){
        price += li.getCup().getTotalPrice();
%>
	<tr>
		<td><%= li.getQuantity() %></td>
		<td><%=  li.getCup().getCupCakeTopping().getFlavour() %></td>
		<td><%=  li.getCup().getCupCakeBottom().getFlavour() %></td>
		<td><%=  li.getCup().getTotalPrice() * li.getQuantity() %></td>
	</tr>
<%}%>
        <tr>
            <td colspan="4">Totalpris: <%= price %></td>
        </tr>
</table>


<!--Body End-->
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>