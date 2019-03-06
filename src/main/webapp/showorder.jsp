<%-- 
    Document   : showorder
    Created on : 05-03-2019, 14:59:17
    Author     : Obaydah Mohamad
--%>
<%@page import="java.lang.reflect.Parameter"%>
<%@page import="Data.OrdersDAO"%>
<%@page import="Data.User"%>
<%@page import="Data.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    User user = (User) session.getAttribute("user");
    if(user == null) response.sendRedirect("/CupCakesProject/login.jsp");
    String orderId = request.getParameter("id"); 
%>
<!DOCTYPE html>
<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>
<!--Body Start-->

<h1>Vis ordre</h1>

<!--Body End-->
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>