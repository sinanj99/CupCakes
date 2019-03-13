<%-- 
    Document   : sitemenu2
    Created on : 11-03-2019, 09:51:51
    Author     : sinanjasar
--%>
<%@page import="Data.User"%>
<% User user = (User) session.getAttribute("user");%>

    <div id="nav">

        <% if (user != null && user.getIsAdmin() == 1) {
        %>

        <a class="left" href="/CupCakesProject/index.jsp">Front page</a>
        <a class="left"href="/CupCakesProject/FrontController?command=logout">Log out</a>
        <a class="right"href="/CupCakesProject/allorders.jsp">All orders</a>

        <%
        } else if (user != null) {
        %>
        <a class="left" href="/CupCakesProject/index.jsp">Front page</a>
        <a class="right" href="/CupCakesProject/FrontController?command=logout">Log out</a>
        <a class="right" href="/CupCakesProject/myorders.jsp">My Orders</a>
        <a class="right" href="/CupCakesProject/products.jsp">Shop</a>
        <a class="right" href="/CupCakesProject/increasebalance.jsp">Insert money</a>
        <p>Your balance is: <%= user.getBalance()%></p>
        <p>Hi <%= user.getUsername()%>!</p>
        <%
        } else {
        %>
        <a class="left" href="#">Contact</a>
        <a class="left"href="#">Help</a>
        <a class="right"href="#">About</a>
        <%
            }
        %>
    </div>
