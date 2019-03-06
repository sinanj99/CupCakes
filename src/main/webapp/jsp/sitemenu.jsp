<%-- 
    Document   : sitemenu
    Created on : 05-03-2019, 11:42:39
    Author     : Obaydah Mohamad
--%>
<%@page import="Data.User"%>
<% User user = (User) session.getAttribute("user");%>

<div class="top-nav">
    <ul class="top-nav-ul">
        <li class="top-nav-li"><a href="/CupCakesProject/index.jsp">Forside</a></li>
        
        <%
            if(user != null){
        %>
        	<li class="top-nav-li top-nav-li-right top-nav-li-hover"><a href="/CupCakesProject/FrontController?command=logout">Log ud</a></li>
        	<li class="top-nav-li top-nav-li-right top-nav-li-hover"><a href="/CupCakesProject/myorders.jsp">Mine ordre</a></li>
        	<li class="top-nav-li top-nav-li-right top-nav-li-hover"><a href="/CupCakesProject/products.jsp">Gå til shop</a></li>
            <li class="top-nav-li top-nav-li-right">Din balance er: <%= user.getBalance() %></li>
            <li class="top-nav-li top-nav-li-right">Hej <%= user.getUsername() + "!" %></li>
        <%
        	}else{
        %>
	        <li class="top-nav-li top-nav-li-right top-nav-li-hover"><a href="/CupCakesProject/register.jsp">Opret bruger</a></li>
	        <li class="top-nav-li top-nav-li-right top-nav-li-hover"><a href="/CupCakesProject/login.jsp">Log Ind</a></li>
		<%
            }
        %>
    </ul>
</div>
