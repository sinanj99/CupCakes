<%-- 
    Document   : index
    Created on : 05-03-2019, 11:18:11
    Author     : Obaydah Mohamad
--%>
<%
    User user = (User) request.getSession().getAttribute("user");
    if (user == null) {
        response.sendRedirect("/CupCakesProject/register.jsp");
    }
%>

<%@page import="Data.User"%>
<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu2.jsp'></jsp:include>

<!--Body Start-->

<h1>Velkommen ...</h1>

<!--Body End-->
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>
