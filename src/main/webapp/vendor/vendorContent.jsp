<%@ page import="com.example.shopson.model.bo.UserBO" %>
<%@ page import="com.example.shopson.model.bean.User" %>
<%@ page import="com.example.shopson.model.bo.VendorBO" %>
<%@ page import="com.example.shopson.model.bo.CategoryBO" %>
<%@ page import="com.example.shopson.model.bean.Category" %>
<%@ page import="com.example.shopson.model.bo.ProductBO" %>
<%@ page import="com.example.shopson.model.helper.ProductHelper" %><%--
  Created by IntelliJ IDEA.
  User: VINH
  Date: 12/10/2023
  Time: 10:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
</head>
<body class="font-sans bg-gray-100 h-[100vh]">
<%
    String action = request.getParameter("action");

    CategoryBO categoryBO = new CategoryBO();
    List<Category> categories = (List<Category>) categoryBO.getAllCategories();

    if ("addProduct".equals(action)) {
        // Handle users content
%>
<div class="sm:col-span-1 lg:col-span-10 bg-white p-8 rounded-lg shadow-md">
    <h1 class="text-3xl font-bold mb-6">Add Product</h1>
    <form method="post" action="../add-product-by-vendor" enctype="multipart/form-data">
        <div class="mb-6">
            <label for="product_name" class="block text-sm font-medium text-gray-600">Product Name</label>
            <input name="product_name" type="text" id="product_name"
                   class="form-input mt-1 block w-full border-2 border-gray-300 p-2 rounded-md" required>
        </div>
        <div class="mb-6">
            <label for="price" class="block text-sm font-medium text-gray-600">Price</label>
            <input name="price" type="text" id="price"
                   class="form-input mt-1 block w-full border-2 border-gray-300 p-2 rounded-md" required>
        </div>
        <div class="mb-6">
            <label for="description" class="block text-sm font-medium text-gray-600">Description</label>
            <textarea name="description" id="description"
                      class="form-input mt-1 block w-full border-2 border-gray-300 p-2 rounded-md"
                      required></textarea>
        </div>
        <div class="mb-6">
            <label for="image" class="block text-sm font-medium text-gray-600">Image</label>
            <input name="image" type="file" id="image"
                   class="form-input mt-1 block w-full border-2 border-gray-300 p-2 rounded-md" required>
        </div>
        <div class="mb-6">
            <label for="category_name" class="block text-sm font-medium text-gray-600">Category Name</label>
            <select name="category_value" id="category_name"
                    class="form-select mt-1 block w-full border-2 border-gray-300 p-2 rounded-md" required>
                <% for (Category category : categories) { %>
                <option value="<%= category.getId() %>"><%= category.getCategory_name() %>
                </option>
                <% } %>
            </select>
        </div>
        <button type="submit" class="btn btn-primary py-2 px-4 rounded-md">Add</button>
    </form>
</div>

<%
    //        response.sendRedirect("add-product.jsp");
} else if ("updateProduct".equals(action)) {
    int id = Integer.parseInt(request.getParameter("product_id"));
    ProductBO productBO = new ProductBO();
    ProductHelper product = (ProductHelper) productBO.getProductById(id);
    String imageURL = product.getImage().substring(product.getImage().indexOf("\\CNW_war"));
%>
<div class="sm:col-span-1 lg:col-span-10 bg-white p-8 pt-0 rounded-lg shadow-md">
    <h1 class="text-3xl font-bold mb-6">Update Product</h1>
    <form method="post" action="${pageContext.request.contextPath}/update-product-by-vendor?id=<%= id%>" enctype="multipart/form-data">
        <div class="mb-6">
            <label for="product_name" class="block text-sm font-medium text-gray-600">Product Name</label>
            <input name="product_name" type="text" class="form-input mt-1 block w-full border-2 border-gray-300 p-2 rounded-md" value="<%= product.getProduct_name()%>" required>
        </div>
        <div class="mb-6">
            <label for="price" class="block text-sm font-medium text-gray-600">Price</label>
            <input name="price" type="text" class="form-input mt-1 block w-full border-2 border-gray-300 p-2 rounded-md" value="<%= product.getPrice()%>" required>
        </div>
        <div class="mb-6">
            <label for="description" class="block text-sm font-medium text-gray-600">Description</label>
            <textarea name="description" class="form-input mt-1 block w-full border-2 border-gray-300 p-2 rounded-md" required><%= product.getDescription()%></textarea>
        </div>
        <div class="mb-6">
            <label for="image" class="block text-sm font-medium text-gray-600">Image</label>
            <!-- visually hidden file input -->
            <input type="file" name="image" id="imageInput" class="hidden" value="">
            <!-- label to trigger file input -->
            <label for="imageInput" class="cursor-pointer" onclick="document.getElementById('imageInput');">
                <img style="width: 100px;" src="<%= imageURL%>" alt="${product.getProductName()}" class="cursor-pointer">
            </label>
        </div>
        <div class="mb-6">
            <label for="category_name" class="block text-sm font-medium text-gray-600">Category Name</label>
            <select name="category_value" class="form-select mt-1 block w-full border-2 border-gray-300 p-2 rounded-md" required>
                <% for (Category category : categories) { %>
                <option value="<%= category.getId() %>" <%= category.getId() == product.getCategory_id() ? "selected" : "" %>><%= category.getCategory_name() %></option>
                <% } %>
            </select>
        </div>
        <button type="submit" class="btn btn-primary py-2 px-4 rounded-md bg-blue-500 text-white hover:bg-blue-700">Update</button>
    </form>
</div>


<%
}else if ("logout".equals(action)) {
    session.invalidate();
    response.sendRedirect("../index.jsp");
} else if("deleteProduct".equals(action)) {
    int id = Integer.parseInt(request.getParameter("product_id"));
    ProductBO productBO = new ProductBO();
    productBO.deleteProduct(id);
    response.sendRedirect(request.getContextPath()+"/vendor/index.jsp");

} else {
%>
<div class="sm:col-span-1 lg:col-span-10 bg-white p-8 rounded-lg shadow-md h-full overflow-y-auto">

    <h1 class="text-3xl font-bold mb-6">List Products</h1>
    <table class="table-auto w-full">
        <thead>
        <tr>
            <th class="px-4 py-2">Product Name</th>
            <th class="px-4 py-2">Price</th>
            <th class="px-4 py-2">Description</th>
            <th class="px-4 py-2">Image</th>
            <th class="px-4 py-2">Category</th>
            <th class="px-4 py-2">Action</th>
        </tr>
        </thead>
        <tbody>
        <%
            int vendor_id = (int) session.getAttribute("vendor_id");
            VendorBO vendorBO = new VendorBO();
            List<ProductsVendor> productsVendorList =  vendorBO.getProductsCustomByVendorId(vendor_id);
            for (ProductsVendor product : productsVendorList
            ) {
        %>

        <tr>
            <td class="border px-4 py-2"><%= product.getProductName()%>
            </td>
            <td class="border px-4 py-2"><%= product.getPrice()%>
            </td>
            <td class="border px-4 py-2"><%= product.getDescription()%>
            </td>
            <td class="border px-4 py-2">
            <img style="width: 100px;" src="${pageContext.request.contextPath}/<%= product.getImage()%>" alt="${product.getProductName()}">

<%--                <img src="<%= product.getImage()%> ? <%= product.getImage()%> : <%= "../staticfiles/img/product/son.png"%>" class="max-w-full" alt="Product Image">--%>
            </td>
            <td class="border px-4 py-2 w-[300px]"><%= product.getCategoryName()%>
            </td>

            <td class="border px-4 py-2">
                <a href="?action=updateProduct&product_id=<%= product.getId()%>"
                   class="inline-block px-4 py-2 bg-blue-500 text-white rounded-md hover:bg-blue-700">Update</a>
                <a href="?action=deleteProduct&product_id=<%= product.getId()%>"
                   class="inline-block px-4 py-2 bg-red-500 text-white rounded-md hover:bg-red-700">Delete</a>
            </td>
        </tr>
        <%
            }
        %>

        <!-- Add more product rows here -->
        </tbody>
    </table>
</div>
<%
    }
%>
</body>
</html>
