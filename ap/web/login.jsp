<%-- 
    Document   : login
    Created on : Aug 16, 2025, 9:40:47 PM
    Author     : AN THANH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="<%=request.getContextPath()%>/login" method="post">
    <tr>
     <td>UserName</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
        <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <input type="submit" value="Submit" />
        </form>
    </body>
</html>
