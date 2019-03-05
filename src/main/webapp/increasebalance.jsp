<%-- 
    Document   : increasebalance
    Created on : 05-03-2019, 17:11:41
    Author     : sinanjasar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Insert money</h1>
        <form method="get" action="FrontController">
            <input type="text" name="newbalance" placeholder="Indtast beløb ...">
            <input type="submit" name="add" value="Tilføj">
            <input type="hidden" name="command" value="increasebalance">
        </form>
    </body>
</html>
