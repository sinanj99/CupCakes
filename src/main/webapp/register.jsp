<%-- 
    Document   : register
    Created on : 05-03-2019, 11:50:08
    Author     : Obaydah Mohamad
--%>
<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>
    <!--Body Start-->
    <html>
        <head>
            
        </head>
    <body>
        <h1>Register ...</h1>
        <form action="FrontController" method="get">
            <input type="text" name="username" placeholder="Brugernavn ..."><br>
            <input type="password" name="password" placeholder="Adgangskode ..."><br>
            <input type="submit" name="submit" value="Log ind"><br>
            <input type="hidden" name="command" value="register">
        </form>
    <%
        if (request.getSession().getAttribute("registerFailed") != null
                && request.getSession().getAttribute("registerFailed") == "registerDuplicate") {
    %>
    <p style="color: red">Brugernavn er allerede brugt</p>
    <%
        }
    %>
</body>
    </html>


<!--Body End-->
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>