<%-- 
    Document   : login
    Created on : 05-03-2019, 11:48:34
    Author     : Obaydah Mohamad
--%>
<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>
<!--Body Start-->

<h1>Login ...</h1>

<form action="FrontController" method="get">
	<input type="text" name="username" placeholder="Brugernavn ..."><br>
	<input type="password" name="password" placeholder="Adgangskode ..."><br>
	<input type="submit" name="submit" value="Log ind"><br>
	<input type="hidden" name="command" value="login">
</form>

<!--Body End-->
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>