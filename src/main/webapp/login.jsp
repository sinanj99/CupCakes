<%-- 
    Document   : login
    Created on : 05-03-2019, 11:48:34
    Author     : Obaydah Mohamad
--%>
<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>

<!--Body Start-->

<style type="text/css">
        body{
            background-color: silver;
            background-image: url("images/cupcakes4.jpg")
        }
        h1{
            background-color: purple;
            color: blue;
            
            border-bottom: 8px solid black;
            border-top: 8px solid black;
            
            font-size: 60px;
            text-align: center;
            
            margin-top: 0;
        }
        form{
            background-color: brown;
            padding: 20px;
            padding-left: 50px;
            border-color: black;
            border-width: 5px;
            border-style: dashed;
            border-radius: 20px;
            
            width: 200px;
            position: absolute;
            top: 245px;
            left: 40%;
        }
</style>        

<h1>Login ...</h1>

<form action="FrontController" method="get">
	<input type="text" name="username" placeholder="Brugernavn ..."><br>
	<input type="password" name="password" placeholder="Adgangskode ..."><br>
	<input type="submit" name="submit" value="Log ind"><br>
	<input type="hidden" name="command" value="login">
</form>
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