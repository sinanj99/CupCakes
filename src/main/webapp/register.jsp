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
                username.style.border = "solid 3px red";
                password.style.border ="";
                
                document.getElementById("usernameLength").style.visibility="hidden";
                document.getElementById("usernameEmpty").style.visibility="visible";
                
                document.getElementById("passwordEmpty").style.visibility="hidden";
                document.getElementById("passwordLength").style.visibility="hidden";
                
                
                // return false, således at useren ikke bliver sendt videre til næste page
                return false;
            }
            else if(username.value.trim().length<3 || username.value.trim().length>15)
            {
                username.style.border = "solid 3px red";
                password.style.border ="";
                
                document.getElementById("usernameEmpty").style.visibility="hidden";
                document.getElementById("usernameLength").style.visibility="visible";
                
                document.getElementById("passwordEmpty").style.visibility="hidden";
                document.getElementById("passwordLength").style.visibility="hidden";
                
                return false;
            }
            else if(password.value.trim() == "")
            {
                username.style.border = "";
                password.style.border ="solid 3px red";
                
                document.getElementById("usernameEmpty").style.visibility="hidden";
                document.getElementById("usernameLength").style.visibility="hidden";
                
                document.getElementById("passwordEmpty").style.visibility="visible";
                document.getElementById("passwordLength").style.visibility="hidden";
                
                return false;
            }
            else if(password.value.trim().length<8)
            {
                username.style.border = "";
                password.style.border ="solid 3px red";
                
                document.getElementById("usernameEmpty").style.visibility="hidden";
                document.getElementById("usernameLength").style.visibility="hidden";
                
                document.getElementById("passwordEmpty").style.visibility="hidden";
                document.getElementById("passwordLength").style.visibility="visible";
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
        <input type="text" name="username" id="uname" placeholder="Brugernavn ...">
        <label id="usernameEmpty" style="color: red; visibility: hidden;"> Invalid, the field username can not be left blank </label> 
        <label id="usernameLength" style="color: red; visibility: hidden;"> Invalid, username must contain betweem 3-15 digits </label> <br>
        <input type="password" name="password" id="pword" placeholder="Adgangskode ...">
        <label id="passwordEmpty" style="color: red; visibility: hidden;"> Invalid, the field password can not be left blank </label> 
        <label id="passwordLength" style="color: red; visibility: hidden;"> Invalid, password too short. Must contain atleast 8 digits </label> <br>
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