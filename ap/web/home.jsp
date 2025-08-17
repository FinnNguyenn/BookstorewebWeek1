
<%@page contentType="text/html" pageEncoding="UTF-8"%>\
<%@ page import="model.Account" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang chủ</title>
</head>
<body>
<%
    Account acc = (Account) session.getAttribute("account");
    if (acc != null) {
%>
    <h2>Xin chào <%= acc.getUsername() %>!</h2>
    <a href="login.jsp">Đăng xuất</a>
<% } else { %>
    <h2>Bạn chưa đăng nhập.</h2>
    <a href="login.jsp">Quay lại đăng nhập</a>
<% } %>
</body>
</html>
