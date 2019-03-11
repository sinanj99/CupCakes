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
<jsp:include page='/jsp/sitemenu2.jsp'></jsp:include>   
<%
    User user = (User) request.getSession().getAttribute("user");
    if (user == null) {
        response.sendRedirect("/CupCakesProject/register.jsp");
    }
%>

<!DOCTYPE html>

<%
/*
<div class="section images">
    <form>
        <h1>Choose A Topping</h1>
        <!-- container start -->
        <div class="container">
            <!-- outer box -->
            <div class="outerbox outerbox1">
                <!-- inner box -->
                <div class="boxinbox box1">
                    <h3>Blueberry</h3>
                </div>
                <!-- inner box -->
                <div class="boxinbox box2">
                    <p>Blueberry, very nice.</p>
                </div>
                <!-- inner box -->
                <div class="boxinbox box3">
                    <input class="button" type="radio" name="topping" value="Blueberry" class="btn btn-dark">
                </div>
            </div>
            <!-- outer box -->
            <div class="outerbox outerbox2">
                <!-- inner box -->
                <div class="boxinbox box1">
                    <h3>Blue Cheese</h3>
                </div>
                <!-- inner box -->
                <div class="boxinbox box2">
                    <p>Blue cheese, one of the less popular toppings.</p>
                </div>
                <!-- inner box -->
                <div class="boxinbox box3">
                    <input type="radio" name="topping" value="Blue cheese" class="btn btn-dark">
                </div>
            </div>
            <!-- outer box -->
            <div class="outerbox outerbox3">
                <!-- inner box -->
                <div class="boxinbox box1">
                    <h3>Chocolate</h3>
                </div>
                <!-- inner box -->
                <div class="boxinbox box2">
                    <p>Chocolate topping, a classic</p>
                </div>
                <!-- inner box -->
                <div class="boxinbox box3">
                    <input class="btn btn-dark" type="radio" name="topping" value="Chocolate" class="btn btn-dark">
                </div>
            </div>

        </div>

        <div class="container">
            <!-- outer box -->
            <div class="outerbox outerbox4">
                <!-- inner box -->
                <div class="boxinbox box1">
                    <h3>Crispy</h3>
                </div>
                <!-- inner box -->
                <div class="boxinbox box2">
                    <p>Fresh and delicious ajvar, perfect on chocolate bottom. Favorite choice of customers.</p>
                </div>
                <!-- inner box -->
                <div class="boxinbox box3">
                    <input type="radio" value="Crispy" class="btn btn-dark">
                </div>
            </div>
            <!-- outer box -->
            <div class="outerbox outerbox5">
                <!-- inner box -->
                <div class="boxinbox box1">
                    <h3>Lemon</h3>
                </div>
                <!-- inner box -->
                <div class="boxinbox box2">
                    <p>Fresh and delicious ajvar, perfect on chocolate bottom. Favorite choice of customers.</p>
                </div>
                <!-- inner box -->
                <div class="boxinbox box3">
                    <input type="radio" value="Choose" class="btn btn-dark">
                </div>
            </div>
            <!-- outer box -->
            <div class="outerbox outerbox6">
                <!-- inner box -->
                <div class="boxinbox box1">
                    <h3>Orange</h3>
                </div>
                <!-- inner box -->
                <div class="boxinbox box2">
                    <p>Fresh and delicious ajvar, perfect on chocolate bottom. Favorite choice of customers.</p>
                </div>
                <!-- inner box -->
                <div class="boxinbox box3">
                    <input type="radio" value="Choose" class="btn btn-dark">
                </div>
            </div>

        </div>
        <div class="container">
            <!-- outer box -->
            <div class="outerbox outerbox7">
                <!-- inner box -->
                <div class="boxinbox box1">
                    <h3>Rum/raisin</h3>
                </div>
                <!-- inner box -->
                <div class="boxinbox box2">
                    <p>Fresh and delicious ajvar, perfect on chocolate bottom. Favorite choice of customers.</p>
                </div>
                <!-- inner box -->
                <div class="boxinbox box3">
                    <input type="radio" value="Choose" class="btn btn-dark">
                </div>
            </div>
            <!-- outer box -->
            <div class="outerbox outerbox8">
                <!-- inner box -->
                <div class="boxinbox box1">
                    <h3>Raspberry</h3>
                </div>
                <!-- inner box -->
                <div class="boxinbox box2">
                    <p>Fresh and delicious ajvar, perfect on chocolate bottom. Favorite choice of customers.</p>
                </div>
                <!-- inner box -->
                <div class="boxinbox box3">
                    <input type="radio" value="Choose" class="btn btn-dark">
                </div>
            </div>
            <!-- outer box -->
            <div class="outerbox outerbox9">
                <!-- inner box -->
                <div class="boxinbox box1">
                    <h3>Strawberry</h3>
                </div>
                <!-- inner box -->
                <div class="boxinbox box2">
                    <p>Fresh and delicious ajvar, perfect on chocolate bottom. Favorite choice of customers.</p>
                </div>
                <!-- inner box -->
                <div class="boxinbox box3">
                    <input type="radio" value="Choose" class="btn btn-dark">
                </div>
            </div>

        </div>
        <h1>Choose A Bottom</h1>
        <div class="container">
            <!-- outer box -->
            <div class="outerbox outerbox10">
                <!-- inner box -->
                <div class="boxinbox box1">
                    <h3>Ajvar</h3>
                </div>
                <!-- inner box -->
                <div class="boxinbox box2">
                    <p>Fresh and delicious ajvar, perfect on chocolate bottom. Favorite choice of customers.</p>
                </div>
                <!-- inner box -->
                <div class="boxinbox box3">
                    <input type="radio" value="Choose" class="btn btn-dark">
                </div>
            </div>
            <!-- outer box -->
            <div class="outerbox outerbox11">
                <!-- inner box -->
                <div class="boxinbox box1">
                    <h3>Almond</h3>
                </div>
                <!-- inner box -->
                <div class="boxinbox box2">
                    <p>Fresh and delicious ajvar, perfect on chocolate bottom. Favorite choice of customers.</p>
                </div>
                <!-- inner box -->
                <div class="boxinbox box3">
                    <input type="radio" value="Choose" class="btn btn-dark">
                </div>
            </div>
            <!-- outer box -->
            <div class="outerbox outerbox12">
                <!-- inner box -->
                <div class="boxinbox box1">
                    <h3>Chocolate</h3>
                </div>
                <!-- inner box -->
                <div class="boxinbox box2">
                    <p>Fresh and delicious ajvar, perfect on chocolate bottom. Favorite choice of customers.</p>
                </div>
                <!-- inner box -->
                <div class="boxinbox box3">
                    <input type="radio" value="Choose" class="btn btn-dark">
                </div>
            </div>

        </div>

        <div class="container">
            <!-- outer box -->
            <div class="outerbox outerbox13">
                <!-- inner box -->
                <div class="boxinbox box1">
                    <h3>Pistachio</h3>
                </div>
                <!-- inner box -->
                <div class="boxinbox box2">
                    <p>Fresh and delicious ajvar, perfect on chocolate bottom. Favorite choice of customers.</p>
                </div>
                <!-- inner box -->
                <div class="boxinbox box3">
                    <input type="radio" value="Choose" class="btn btn-dark">
                </div>
            </div>
            <!-- outer box -->
            <div class="outerbox outerbox14">
                <!-- inner box -->
                <div class="boxinbox box1">
                    <h3>Vanilla</h3>
                </div>
                <!-- inner box -->
                <div class="boxinbox box2">
                    <p>Fresh and delicious ajvar, perfect on chocolate bottom. Favorite choice of customers.</p>
                </div>
                <!-- inner box -->
                <div class="boxinbox box3">
                    <input type="radio" value="Choose" class="btn btn-dark">
                </div>
            </div>
            <!-- outer box -->
            <div class="outerbox outerbox15">
                <!-- inner box -->
                <div class="boxinbox box1">
                    <h3>Nutmeg</h3>
                </div>
                <!-- inner box -->
                <div class="boxinbox box2">

                </div>
                <!-- inner box -->
                <div class="boxinbox box3">
                    <input type="radio" value="Choose" class="btn btn-dark">
                </div>
            </div>

        </div>

        <input class="button" type="submit" value="Add To Cart">
    </form>
</div>
*/
%>

<body class="productsbackground">
    <section class="containerproducts">
        <form class="formproducts" method="get" action="FrontController">
            <h1>Bunde</h1>
            <select class="inputproducts" required name="bottom">
                <%
                    for (Bottom b : CupCakeDAO.bottoms()) {
                %>

                <option value="<%=b.getFlavour()%>"><%= b.getFlavour() + " " + b.getPrice()%></option>

                <%
                    }
                %>
            </select>
            <br><br><h1>Toppe</h1>
            <select class="inputproducts" required name="topping">
                <%
                    for (Topping t : CupCakeDAO.toppings()) {
                %>

                <option value="<%=t.getFlavour()%>"><%= t.getFlavour() + " " + t.getPrice()%></option>
                <%
                    }
                %>
            </select>

            <section>

                <br><br><input type="number" value="qty" name="qty" min="1" max="500" class="qty" required placeholder="Antal ..."><br><br>

                <input class="button" type="submit" value="Tilføj" name="add">
            </section>

            <input type="hidden" name="command" value="shop">
            <%
            %>
        </form>
        <form class="formproducts" style="overflow-y: scroll" method="get" action="FrontController">
            <h1>Kurv</h1>

            <%            if (request.getSession().getAttribute("shoppingcart") == null) {

            %>
            <h4 style="color: white"> Din kurv er tom! </h4>
            <% }
            %>
            <%
                float fullPrice = 0;
                if (request.getSession().getAttribute("shoppingcart") != null) {
                    ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("shoppingcart");
            %>

            <table class="table table-striped" style="color: white;" border="1">
                <thead>
                    <tr>
                        <th>Top</th>
                        <th>Bund</th>
                        <th>Antal</th>
                        <th>Pris</th>
                    </tr>
                </thead>
                <tbody>
                    <%                for (LineItems lt : cart.getItems()) {
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
                </tbody>
            </table><br>

            <input class="button" type="submit" style="margin-top: 40px;" value="Betal" name="checkout">
            <input type="hidden" name="command" value="checkout">
        </form>
    </section>
    <%
        }
    %>

</body>
</html>
