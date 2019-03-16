<%-- 
    Document   : register
    Created on : 05-03-2019, 11:50:08
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

    

    <script type="text/javascript">
        function checkInfo()
        {
            var username = document.getElementById("uname");
            var password = document.getElementById("pword");

            if (username.value.trim() == "")
            {
                username.style.border = "solid 2px red";
                password.style.border = "";

                document.getElementById("usernameLength").style.visibility = "hidden";
                document.getElementById("usernameEmpty").style.visibility = "visible";

                document.getElementById("passwordEmpty").style.visibility = "hidden";
                document.getElementById("passwordLength").style.visibility = "hidden";
                


                // return false, således at useren ikke bliver sendt videre til næste page
                return false;
            } else if (username.value.trim().length < 3 || username.value.trim().length > 15)
            {
                username.style.border = "solid 2px red";
                password.style.border = "";

                document.getElementById("usernameEmpty").style.visibility = "hidden";
                document.getElementById("usernameLength").style.visibility = "visible";

                document.getElementById("passwordEmpty").style.visibility = "hidden";
                document.getElementById("passwordLength").style.visibility = "hidden";

                return false;
            }
            else if (password.value.trim() == "")
            {
                username.style.border = "";
                password.style.border = "solid 2px red";

                document.getElementById("usernameEmpty").style.visibility = "hidden";
                document.getElementById("usernameLength").style.visibility = "hidden";

                document.getElementById("passwordEmpty").style.visibility = "visible";
                document.getElementById("passwordLength").style.visibility = "hidden";

                return false;
            } else if (password.value.trim().length < 8)
            {
                username.style.border = "";
                password.style.border = "solid 2px red";

                document.getElementById("usernameEmpty").style.visibility = "hidden";
                document.getElementById("usernameLength").style.visibility = "hidden";

                document.getElementById("passwordEmpty").style.visibility = "hidden";
                document.getElementById("passwordLength").style.visibility = "visible";
                return false;
            } else
            {
                return true;
            }
        }

    </script>



    <div class="section section3">
        <form action="login.jsp" method="get">
            <h1>The Best And Cheapest Cupcakes In The World</h1>
            <input class="button" type="submit" value="Log In">
        </form>
    </div>

    <div class="section section2">
        <div class="div">
            <form onsubmit="return checkInfo();" action="FrontController" method="get">
            <% if(request.getSession().getAttribute("registerResult") != "registerSuccesful")
            {%>
                <h1>Not Already A Member?</h1>
                <p>Fill Out The Form Below To Sign Up!</p>
            <%
                if (request.getSession().getAttribute("registerResult") == null
                   && request.getSession().getAttribute("registerResult") != "registerDuplicate")
                {
            %>
            <input class="input" type="text" name="username" id="uname" placeholder="Username">
            <%
                } else if (request.getSession().getAttribute("registerResult") != null
                        && request.getSession().getAttribute("registerResult") == "registerDuplicate") {
            %>
            <input class="inputfail" type="text" name="username" id="uname" placeholder="Username is taken!">
            <% } else if (request.getSession().getAttribute("registerResult") != null
                    && request.getSession().getAttribute("registerResult").equals("registerInvalidUsername")) {
            %>
            <input class="inputfail" type="text" name="username" id="uname" placeholder="Invalid username!">
            <label id="invalidusername" style="color: red; visibility: visbiel;"> Invalid username, cant hold spaces and other specail characters 
             other than - or _ </label> 
            <% } %>
            
            <label id="usernameEmpty" style="color: red; visibility: hidden;"> Invalid, the field username can not be left blank </label> 
            <label id="usernameLength" style="color: red; visibility: hidden;"> Invalid, username must contain between 3-15 characters </label>
            
            <%
            if (request.getSession().getAttribute("registerResult") == null
                    || request.getSession().getAttribute("registerResult") != "registerInvalidPassword") {
            %>
             <input class="input" type="password" name="password" id="pword" placeholder="Password">
            <%
            } else if (request.getSession().getAttribute("registerResult") != null
                    && request.getSession().getAttribute("registerResult").equals("registerInvalidPassword")) {
            %>
            <input class="input" type="text" name="username" id="uname" placeholder="Username">
            <input class="inputfail" type="password" name="password" id="pword" placeholder="Invalid password! ">
            <label id="invalidpass" style="color: red; visibility: visible;"> Invalid password, must contain atleast 1 digit and no spaces </label>
            <% } %>
            
            <label id="passwordEmpty" style="color: red; visibility: hidden;"> Invalid, the field password can not be left blank </label> 
            <label id="passwordLength" style="color: red; visibility: hidden;"> Invalid, password too short. Must contain at least 8 characters </label>
            
            <input class="input" type="email" name="email" placeholder="Email">
            
            <input class="button button2" type="submit" value="Sign up">
            <input type="hidden" name="command" value="register">
            <% } else { %>
            <h1>Registration succesful!</h1>
            <% } %>
            
            <!--
            <p style="color: red">Adgangskoden opfylder ikke kravene. Adgangskoden skal mindst have længden 8, indeholde 
                mindst et tal og må ikke indeholde mellemrum </p>
         
            <p style="color: red">Brugernavn opfylder ikke kravene. Brugernavnet skal være længden 3-15 og må ikke
                indeholde mellemrum eller andre specielle tegn end '-' og '_'</p>
            -->
        </form>
            <%request.getSession().invalidate();
            %>
    </div>
</div>

<!--
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
-->


<!--Body End-->
<jsp:include page='/jsp/sitefoot.jsp'></jsp:include>