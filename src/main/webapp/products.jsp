<%-- 
    Document   : products
    Created on : 05-03-2019, 13:09:44
    Author     : sinanjasar
--%>

<%@page import="Data.ShoppingCart"%>
<%@page import="Data.User"%>
<%@page import="Data.Topping"%>
<%@page import="Data.Bottom"%>
<%@page import="Data.CupCakeDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>   

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bottoms</h1>
        <form method="get" action="FrontController">
            <select required name="bottom">
                <%
                    for (Bottom b : CupCakeDAO.bottoms()) {
                %>

                <option value="<%b.getFlavour();%>"><%= b.getFlavour() + " " + b.getPrice()%></option>

                <%
                    }
                %>
            </select>
            <input type="number" value="qty" placeholder="Antal ...">
            <h1>Toppings</h1>
            <select required name="topping">
                <%
                    for (Topping t : CupCakeDAO.toppings()) {
                %>

                <option value="<%t.getFlavour();%>"><%= t.getFlavour() + " " + t.getPrice()%></option>
                <%
                    }
                %>
            </select>
            <input type="number" value="qty" placeholder="Antal ..."><br><br>
            <input type="submit" value="Tilføj til kurv" name="add">
            <input type="submit" value="Betal" name="checkout">
            <input type="hidden" name="command" value="shop">
            <%
            %>
        </form>
        <%
            if(request.getSession().getAttribute("shoppingcart") != null)
            {
                out.print("krishna");
            }
        %>
    </body>
</html>
