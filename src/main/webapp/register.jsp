<%-- 
    Document   : register
    Created on : 05-03-2019, 11:50:08
    Author     : Obaydah Mohamad
--%>
<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>
    <!--Body Start-->
    <h1>Register ...</h1>
    <form action="FrontController" method="get">
        <input type="text" name="username" placeholder="Brugernavn ..."><br>
        <input type="password" name="password" placeholder="Adgangskode ..."><br>
        <input type="submit" name="submit" value="Log ind"><br>
        <input type="hidden" name="command" value="register">
    </form>
<%
    if (request.getSession().getAttribute("registerResult") != null
            && request.getSession().getAttribute("registerResult") == "registerDuplicate") {
%>
<p style="color: red">Brugernavn er allerede brugt</p>
<%
} else if (request.getSession().getAttribute("registerResult") != null
        && request.getSession().getAttribute("registerResult") == "registerInvalidPassword") {
%>
<p style="color: red">Adgangskoden opfylder ikke kravene. Adgangskoden skal mindst have l�ngden 8, indeholde 
    mindst et tal og m� ikke indeholde mellemrum </p>
    <%
    } else if (request.getSession().getAttribute("registerResult") != null
            && request.getSession().getAttribute("registerResult") == "registerInvalidUsername") {
    %>
<p style="color: red">Brugernavn opfylder ikke kravene. Brugernavnet skal v�re l�ngden 3-15 og m� ikke
    indeholde mellemrum eller andre specielle tegn end '-' og '_'</p>
    <%
        }
    %>

<!--Body End-->
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>