<%-- 
    Document   : products
    Created on : 05-03-2019, 13:09:44
    Author     : sinanjasar
--%>

<%@page import="Data.LineItems"%>
<%@page import="Data.ShoppingCart"%>
<%@page import="Data.User"%>
<%@page import="Data.Topping"%>
<%@page import="Data.Bottom"%>
<%@page import="Data.CupCakeDAO"%>
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
    <body class="productsbackground">
        <section class="container">
        <form class="formproducts" method="get" action="FrontController">
            <h1 class="heading">Toppe</h1>
            <select class="input" required name="bottom">
                <%
                    for (Bottom b : CupCakeDAO.bottoms()) {
                %>

                <option value="<%=b.getFlavour()%>"><%= b.getFlavour() + " " + b.getPrice()%></option>

                <%
                    }
                %>
            </select>
            <h1 class="heading">Bunde</h1>
            <select class="input" required name="topping">
                <%
                    for (Topping t : CupCakeDAO.toppings()) {
                %>

                <option value="<%=t.getFlavour()%>"><%= t.getFlavour() + " " + t.getPrice()%></option>
                <%
                    }
                %>
            </select>
            
            <section>
                
            <br><br><input type="number" value="qty" name="qty" min="0" max="500" style="width: 60px;"required placeholder="Antal ..."><br><br>

            <input class="input" type="submit" value="Tilføj til kurv" name="add">
            
            </section>

            <input type="hidden" name="command" value="shop">
            <%
            %>
        </form>
        <%            float fullPrice = 0;
            if (request.getSession().getAttribute("shoppingcart") != null) {
                ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("shoppingcart");
        %>
        <form class="formproducts" style="overflow-y: scroll" method="get" action="FrontController">
        <h1 class="heading">Kurv</h1>
        <table class="table" border="1">
            <tr>
                <th>Top</th>
                <th>Bund</th>
                <th>Antal</th>
                <th>Pris</th>
            </tr>
            <%
                for (LineItems lt : cart.getItems()) {
                    float lineItemPrice = (lt.getCup().getCupCakeTopping().getPrice() + lt.getCup().getCupCakeBottom().getPrice()) * lt.getQuantity();
                    fullPrice += lineItemPrice;
            %>
            <tr>
                <td><%=lt.getCup().getCupCakeTopping().getFlavour()%></td>
                <td><%=lt.getCup().getCupCakeBottom().getFlavour()%></td>
                <td><%=lt.getQuantity()%></td>
                <td><%=lineItemPrice%></td>
            </tr>
            <%  }%>
            <tr><td colspan="4" align="center">Total pris: <%= fullPrice%> </td></tr>

        </table><br>
        
            <input class="input" type="submit" value="Placér ordre" name="checkout">
            <input type="hidden" name="command" value="checkout">
        </form>
        </section>
        <%
            }
        %>

    </body>
</html>
