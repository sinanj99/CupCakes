<%-- 
    Document   : login
    Created on : 05-03-2019, 11:48:34
    Author     : Obaydah Mohamad
--%>
<%@page import="Data.User"%>
<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu2.jsp'></jsp:include>
<%
    User user = (User) request.getSession().getAttribute("user");
    if (user != null) {
        response.sendRedirect("/CupCakesProject/index.jsp");
    }
%>
<!--Body Start-->       

<div class="section section1">
    <div class="div divlogin">
      <form action="FrontController" method="get">
        <h1>Log In</h1>
        <input class="input" type="text" name="username" placeholder="Username">
        <input class="input" type="password" name="password" placeholder="Password">
        <input class="button" type="submit" value="Log In">
        <input type="hidden" name="command" value="login">
      </form>
  </div>
    
<% 
    if(request.getSession().getAttribute("loginResult") != null && request.getSession().getAttribute("loginResult") == "loginFailed")
    {
%>   
<p style="color: red">Login failed, please try again!</p>
<%
    }

    request.getSession().invalidate();
%>    
<!--Body End-->
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>