<%@ page import="com.example.shopson.model.bean.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shopson.model.helper.ProductsVendor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" , initial-scale=1.0">
    <title>Vendor Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
    <style>
        /* Additional styles specific to this page */
        .table img {
            max-width: 100px;
            max-height: 100px;
            object-fit: cover;
            border-radius: 8px;
        }

        .btn-primary {
            background-color: #3490dc;
            color: #fff;
            padding: 8px 16px;
            border-radius: 4px;
            text-decoration: none;
            display: inline-block;
            margin-right: 8px;
        }

        .btn-danger {
            background-color: #e3342f;
            color: #fff;
            padding: 8px 16px;
            border-radius: 4px;
            text-decoration: none;
            display: inline-block;
        }
    </style>
</head>
<body style="width: 100vw; height: 100vh;">

<%
    String username = (String) session.getAttribute("username");
%>

<div class="mx-auto h-full py-10 flex justify-center">
    <div class="flex p-4 w-[20%]">
        <div class="sm:col-span-2 lg:col-span-2 bg-gray-800 text-white p-4 rounded-lg shadow-md h-full">
            <ul class="space-y-4">
                <h1 class="text-2xl font-bold">Hello <%= username%></h1>
                <li><a href="?action=getAllProduct" class="nav-link active">List Products</a></li>
                <li><a href="?action=addProduct" class="nav-link">Add Product</a></li>
                <li><a href="${pageContext.request.contextPath}/auth?action=logout" class="nav-link">Log out</a></li>
            </ul>
        </div>
    </div>

    <!-- Main Content -->
    <div class="sm:col-span-1 lg:col-span-10 bg-white p-8 pt-0 rounded-lg shadow-md h-full overflow-y-hidden flex-1 w-[80%] h-[100vh]">
            <div id="content" class="mt-2">
                <%@ include file="vendorContent.jsp" %>
            </div>
    </div>
</div>

</body>
</html>
