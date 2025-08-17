<%-- 
    Document   : register.jsp
    Created on : Aug 16, 2025, 11:53:16 PM
    Author     : AN THANH
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký</title>
</head>
<body>
    <h2>Form Đăng ký</h2>
    <form action="register" method="post">
        <label>Username:</label>
        <input type="text" name="username" required><br>

        <label>Password:</label>
        <input type="password" name="password" required><br>

        <label>Họ và tên:</label>
        <input type="text" name="name" required><br>

        <label>Phone:</label>
        <input type="text" name="phone"><br>

        <label>Email:</label>
        <input type="email" name="email" required><br>
        
        <label>Address:</label>
        <input type="text" name="diachi" required><br>

        <input type="submit" value="Đăng ký">
    </form>

    <p style="color:green;">
        ${message}
    </p>
    <p style="color:red;">
        ${errorMessage}
    </p>
</body>
</html>


