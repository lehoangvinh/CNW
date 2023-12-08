<%--
  Created by IntelliJ IDEA.
  User: VINH
  Date: 12/8/2023
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shopson.model.bean.Vendor" %>
<%@ page import="com.example.shopson.model.bean.User" %>
<%@ page import="com.example.shopson.model.bean.Product" %>
<%@ page import="java.util.ArrayList" %>

<%
  String action = request.getParameter("action");

  if ("getAllVendors".equals(action)) {
    List<User> listVendors = (List<User>) request.getAttribute("listVendors");
%>
<h2>All Vendors</h2>
<ul>
  <% for (User user : listVendors) { %>
  <li><%= user.getId() %></li>
    <li><%= user.getUsername() %></li>
    <li><%= user.getPassword() %></li>
    <li><%= user.getFullname() %></li>
    <li><%= user.getPhone_number() %></li>
  <% } %>
</ul>
<%
  } else if ("getAllProducts".equals(action)) {
    // Handle products content
    List<Product> listProducts = (List<Product>) request.getAttribute("listProducts");
%>

<h2>All Products</h2>
<ul>
  <% for (Product product : listProducts) { %>
  <li><%= product.getId() %></li>
  <li><%= product.getProduct_name() %></li>
  <li><%= product.getDescription() %></li>
  <li><%= product.getVendor_id() %></li>
  <li><%= product.getImage() %></li>
    <li><%= product.getCategory_id() %></li>
<%--  TODO: get vendor and product--%>
  <% } %>
</ul>
<%
  }

