<%-- 
    Document   : confirmation
    Created on : 08-03-2019, 13:03:10
    Author     : sinanjasar
--%>
<%@page import="Data.shoppingCartDAO"%>
<%@page import="Data.User"%>
<%
    User user = (User) request.getSession().getAttribute("user");
    if (user == null) {
        response.sendRedirect("/CupCakesProject/register.jsp");
    }
%>
<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu2.jsp'></jsp:include>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <body class="productsbackground">
        <div class="w-100 h-100 justify-content-center align-items-center d-flex">
            <h1 style="">Your order has succesfully been placed!<br>
                Your order number is: <%=  shoppingCartDAO.getOrder(user) %> </h1>
        </div>
 
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>