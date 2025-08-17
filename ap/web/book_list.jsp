<%-- 
    Document   : book_list
    Created on : Aug 17, 2025, 10:46:16 PM
    Author     : AN THANH
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, model.Books" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book List</title>
</head>
<body>
    <h2>Book List</h2>

    <form action="BookServlet" method="get">
        <input type="hidden" name="action" value="search">
        <input type="text" name="keyword" placeholder="Enter book title...">
        <input type="submit" value="Search">
    </form>

    <p><a href="BookServlet?action=new">Add New Book</a></p>
    <p><a href="<%=request.getContextPath()%>/View/home.jsp">Back to Home</a></p>

    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>ID</th><th>Title</th><th>Author</th><th>Publisher</th><th>Price</th><th>Stock Quantity</th><th>Actions</th>
        </tr>
        <%
            List<Books> list = (List<Books>) request.getAttribute("listBooks");
            if (list != null) {
                for (Books b : list) {
        %>
        <tr>
            <td><%= b.getId() %></td>
            <td><%= b.getTitle() %></td>
            <td><%= b.getAuthor() %></td>
            <td><%= b.getPublisher() %></td>
            <td><%= b.getPrice() %></td>
            <td><%= b.getStockQuantity() %></td>
            <td>
                <a href="BookServlet?action=view&id=<%= b.getId() %>">View</a> | 
                <a href="BookServlet?action=edit&id=<%= b.getId() %>">Edit</a> | 
                <a href="BookServlet?action=delete&id=<%= b.getId() %>" onclick="return confirm('Delete this book?');">Delete</a>
            </td>
        </tr>
        <% }} %>
    </table>
</body>
</html>
