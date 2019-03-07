<%-- 
    Document   : register
    Created on : 05-03-2019, 11:50:08
    Author     : Obaydah Mohamad
--%>
<jsp:include page='/jsp/sitehead.jsp'></jsp:include>
<jsp:include page='/jsp/sitemenu.jsp'></jsp:include>
    <!--Body Start-->
    
    <script type="text/javascript">
        function checkInfo()
        {
            var username = document.getElementById("uname");
            var password = document.getElementById("pword");
            
            if(username.value.trim() == "")
            {
                alert("The field username can not be left blank");
                // return false, således at useren ikke bliver sendt videre til næste page
                return false;
            }
            else if(username.value.trim().length<3 || username.value.trim().length>15)
            {
                alert("Username is of invalid length! Username must be betweem 3-15 digits");
                return false;
            }
            else if(password.value.trim() == "")
            {
                alert("The field password can not be left blank");
                return false;
            }
            else if(password.value.trim().length<8)
            {
                alert("Password to short, must contain atleast 8 digits");
                return false;
            }
            else
            {
                return true;
            }
        }
        
    </script>
    
    <h1>Register ...</h1>
    <form onsubmit="return checkInfo();" action="FrontController" method="get">
        <input type="text" name="username" id="uname" placeholder="Brugernavn ..."><br>
        <input type="password" name="password" id="pword" placeholder="Adgangskode ..."><br>
        <input type="submit" name="submit" value="Log ind"><br>
        <input type="hidden" name="command" value="register">
    </form>
    
<%--
    if (request.getSession().getAttribute("registerResult") != null
            && request.getSession().getAttribute("registerResult") == "registerDuplicate") {
--%>
<!--<p style="color: red">Brugernavn er allerede brugt</p>-->
<%--
} else if (request.getSession().getAttribute("registerResult") != null
        //&& request.getSession().getAttribute("registerResult") == "registerInvalidPassword") {
--%>
<!--<p style="color: red">Adgangskoden opfylder ikke kravene. Adgangskoden skal mindst have længden 8, indeholde 
    mindst et tal og må ikke indeholde mellemrum </p>-->
    <%--
    } else if (request.getSession().getAttribute("registerResult") != null
            && request.getSession().getAttribute("registerResult") == "registerInvalidUsername") {
    --%>
<!--<p style="color: red">Brugernavn opfylder ikke kravene. Brugernavnet skal være længden 3-15 og må ikke
    indeholde mellemrum eller andre specielle tegn end '-' og '_'</p>-->
    <%--
        }
    --%>
    

<!--Body End-->
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>