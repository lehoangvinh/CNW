<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shopson.model.bean.Vendor" %>
<%@ page import="com.example.shopson.model.bean.User" %>
<%@ page import="com.example.shopson.model.bean.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.shopson.model.helper.ProductHelper" %>
<%@ page import="com.example.shopson.model.bo.ProductBO" %>
<%@ page import="com.example.shopson.model.bo.VendorBO" %>
<%@ page import="com.example.shopson.model.bo.UserBO" %>
<%@ page import="com.example.shopson.model.bo.CategoryBO" %>
<%@ page import="com.example.shopson.model.bean.Category" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">

    <title>ADMIN</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #333;
        }

        h2 {
            color: #555;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<%
    String action = request.getParameter("action");
    if (action == null) {
        action = "getAllVendors";
    }
    if ("getAllVendors".equals(action)) {
        VendorBO userBO = new VendorBO();
        List<User> listVendors = userBO.getAllVendors(); %>
<h1 class="text-3xl font-bold mb-6">List Vendor</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <%--        <th>Password</th>--%>
        <th>Fullname</th>
        <th>Phone Number</th>
        <th class="py-2 px-4 text-center">EDIT</th>
        <th class="py-2 px-4 text-center">DELETE</th>
    </tr>
    <% for (User user : listVendors) { %>
    <tr>
        <td><%= user.getId() %>
        </td>
        <td><%= user.getUsername() %>
        </td>
        <%--        <td><%= user.getPassword() %>--%>
        <%--        </td>--%>
        <td><%= user.getFullname() %>
        </td>
        <td><%= user.getPhone_number() %>
        </td>
        <td class="py-2 px-4 text-center">
            <a href="?action=editVendor&id=<%= user.getId() %>"
               class="text-blue-500 hover:underline px-2 py-1 border border-blue-500 rounded transition duration-300 ease-in-out transform hover:bg-blue-500 hover:text-white">Edit</a>
        </td>
        <td class="py-2 px-4 text-center">
            <a href="${pageContext.request.contextPath}/adminController?action=deleteVendor&id=<%= user.getId() %>"
               class="text-red-500 hover:underline px-2 py-1 border border-red-500 rounded transition duration-300 ease-in-out transform hover:bg-red-500 hover:text-white">Delete</a>
        </td>
    </tr>
    <% } %>
</table>
<% } else if ("getAllProducts".equals(action)) {
    // Handle products content
    ProductBO producBO = new ProductBO();
    List<ProductHelper> listProducts = producBO.getAllProducts(); %>
<h1 class="text-3xl font-bold mb-6">List Products</h1>
<table class="table-auto w-full">
    <thead>
    <tr>
        <th class="px-4 py-2">Product Name</th>
        <th class="px-4 py-2">Vendor Name</th>
        <th class="px-4 py-2">Price</th>
        <th class="px-4 py-2">Description</th>
        <th class="px-4 py-2">Image</th>
        <th class="px-4 py-2">Category</th>
        <th class="px-4 py-2">Action</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (ProductHelper product : listProducts
        ) {
            String imageURL = product.getImage().substring(product.getImage().indexOf("\\CNW_war"));
    %>

    <tr>
        <td class="border px-4 py-2"><%= product.getProduct_name()%>
        </td>
        <td class="border px-4 py-2"><%= product.getVendor_name()%>
        </td>
        <td class="border px-4 py-2"><%= product.getPrice()%>
        </td>
        <td class="border px-4 py-2"><%= product.getDescription()%>
        </td>
        <td class="border px-4 py-2">
            <img style="width: 100px;" src="<%= imageURL%>"
                 alt="${product.getProductName()}">

        </td>
        <td class="border px-4 py-2 w-[300px]"><%= product.getCategory_name()%>
        </td>

        <td class="border px-4 py-2">
            <a href="?action=updateProduct&product_id=<%= product.getId()%>"
               class="inline-block px-4 py-2 bg-blue-500 text-white rounded-md hover:bg-blue-700">Update</a>
            <a href="${pageContext.request.contextPath}/adminController?action=deleteProduct&product_id=<%= product.getId()%>"
               class="inline-block px-4 py-2 bg-red-500 text-white rounded-md hover:bg-red-700">Delete</a>
        </td>
    </tr>
    <%
        }
    %>

    <!-- Add more product rows here -->
    </tbody>
</table>
<% } else if ("getAllUsers".equals(action)) {
    // Handle users content
    UserBO userBO = new UserBO();
    List<User> listUsers = userBO.getAllUsers(); %>
<h1 class="text-3xl font-bold mb-6">List Users</h1>

<table>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <%--        <th>Password</th>--%>
        <th>Fullname</th>
        <th>Phone Number</th>
        <%--        <th>Role ID</th>--%>
        <th class="py-2 px-4 text-center">EDIT</th>
        <th class="py-2 px-4 text-center">DELETE</th>
    </tr>
    <% for (User user : listUsers) { %>
    <tr>
        <td><%= user.getId() %>
        </td>
        <td><%= user.getUsername() %>
        </td>
        <%--        <td><%= user.getPassword() %>--%>
        <%--        </td>--%>
        <td><%= user.getFullname() %>
        </td>
        <td><%= user.getPhone_number() %>
        </td>
        <%--        <td><%= user.getRole_id() %>--%>
        <td class="py-2 px-4 text-center">
            <a href="?action=editUser&id=<%= user.getId() %>"
               class="text-blue-500 hover:underline px-2 py-1 border border-blue-500 rounded transition duration-300 ease-in-out transform hover:bg-blue-500 hover:text-white">Edit</a>
        </td>
        <td class="py-2 px-4 text-center">
            <a href="${pageContext.request.contextPath}/adminController?action=deleteUser&id=<%= user.getId() %>"
               class="text-red-500 hover:underline px-2 py-1 border border-red-500 rounded transition duration-300 ease-in-out transform hover:bg-red-500 hover:text-white">Delete</a>
        </td>
    </tr>
    <% } %>
</table>

<% } else if ("addVendor".equals(action)) {
%>
<form action="${pageContext.request.contextPath}/adminController?action=addVendor" method="post"
      class="max-w-md mx-auto p-6 bg-white rounded-md shadow-md">
    <h2 class="text-2xl font-bold mb-6">Add Vendor</h2>

    <div class="mb-4">
        <label for="username" class="block text-sm font-medium text-gray-600">Username:</label>
        <input type="text" id="username" name="username"
               class="form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300 p-2"
               required>
    </div>

    <div class="mb-4">
        <label for="fullname" class="block text-sm font-medium text-gray-600">Fullname:</label>
        <input type="text" id="fullname" name="fullname"
               class="form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300 p-2"
               required>
    </div>

    <div class="mb-6">
        <label for="phone_number" class="block text-sm font-medium text-gray-600">Phone Number:</label>
        <input type="number" id="phone_number" name="phone_number"
               class="form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300 p-2"
               required>
    </div>


    <div class="flex items-center justify-between">
        <input type="submit" value="Add Vendor"
               class="bg-blue-500 text-white py-2 px-4 rounded-md hover:bg-blue-700 cursor-pointer transition duration-300">
        <button onclick="window.history.back();"
                class="bg-gray-500 text-white py-2 px-4 rounded-md hover:bg-gray-700">
            Cancel
        </button>
    </div>
</form>


<%
} else if ("addProduct".equals(action)) {
    VendorBO vendorBO = new VendorBO();
    CategoryBO categoryBO = new CategoryBO();
    List<Vendor> vendors = (List<Vendor>) vendorBO.getListVendors();
    List<Category> categories = (List<Category>) categoryBO.getAllCategories();
%>
<form action="${pageContext.request.contextPath}/adminController?action=addProduct" enctype="multipart/form-data"
      method="post" class="max-w-md mx-auto p-6 bg-white rounded-md shadow-md">
    <h2 class="text-2xl font-bold mb-6">Add Product</h2>

    <div class="mb-4">
        <label for="name" class="block text-sm font-medium text-gray-600">Product name:</label>
        <input type="text" name="productName" id="name"
               class="p-2 form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
               required>
    </div>

    <div class="mb-4">
        <label for="price" class="block text-sm font-medium text-gray-600">Price:</label>
        <input type="text" name="price" id="price"
               class="p-2 form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
               required>
    </div>

    <div class="mb-4">
        <label for="description" class="block text-sm font-medium text-gray-600">Description:</label>
        <input type="text" name="description" id="description"
               class="p-2 form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
               required>
    </div>

    <div class="mb-4">
        <label for="vendor" class="block text-sm font-medium text-gray-600">Vendor:</label>
        <select name="vendor" id="vendor"
                class="p-2 form-select mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
                required>
            <% for (Vendor vendor : vendors) { %>
            <option value="<%= vendor.getId() %>"><%= vendor.getVendor_name() %>
            </option>
            <% } %>
        </select>
    </div>

    <div class="mb-4">
        <label for="category" class="block text-sm font-medium text-gray-600">Category:</label>
        <select name="category" id="category"
                class="p-2 form-select mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
                required>
            <% for (Category category : categories) { %>
            <option value="<%= category.getId() %>"><%= category.getCategory_name() %>
            </option>
            <% } %>
        </select>
    </div>

    <div class="mb-6">
        <label class="block text-sm font-medium text-gray-600">Image</label>
        <input name="image" type="file"
               class="form-input mt-1 block w-full border-2 border-gray-300 p-2 rounded-md" required>
    </div>

    <div class="flex items-center justify-between">
        <input type="submit" value="Add Product"
               class="bg-blue-500 text-white py-2 px-4 rounded-md hover:bg-blue-700 cursor-pointer transition duration-300">
        <button onclick="window.history.back();"
                class="bg-gray-500 text-white py-2 px-4 rounded-md hover:bg-gray-700">
            Cancel
        </button>
    </div>
</form>

<%
} else if ("addUser".equals(action)) {
%>
<form action="${pageContext.request.contextPath}/adminController?action=addUser" method="post"
      class="max-w-md mx-auto p-6 bg-white rounded-md shadow-md">
    <h2 class="text-2xl font-bold mb-6">Add User</h2>

    <div class="mb-4">
        <label for="username" class="block text-sm font-medium text-gray-600">Username:</label>
        <input type="text" name="username"
               class="p-2 form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
               required>
    </div>

    <div class="mb-4">
        <label for="fullname" class="block text-sm font-medium text-gray-600">Fullname:</label>
        <input type="text" name="fullname"
               class="p-2 form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
               required>
    </div>

    <div class="mb-4">
        <label for="phone_number" class="block text-sm font-medium text-gray-600">Phone Number:</label>
        <input type="number" name="phone_number"
               class="p-2 form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
               required>
    </div>

    <div class="mb-4">
        <label for="address" class="p-2  block text-sm font-medium text-gray-600">Address:</label>
        <textarea name="address" id="address" rows="4"
                  class="form-textarea mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
                  required></textarea>
    </div>

    <div class="flex items-center justify-end">
        <input type="submit" value="Add User"
               class="bg-blue-500 text-white py-2 px-4 rounded-md hover:bg-blue-700 cursor-pointer transition duration-300">
    </div>
</form>

<%
} else if ("updateProduct".equals(action)) {

    int id = Integer.parseInt(request.getParameter("product_id"));
    try {
        VendorBO vendorBO = new VendorBO();
        CategoryBO categoryBO = new CategoryBO();
        ProductHelper product = new ProductBO().getProductById(id);
        List<Vendor> vendors = vendorBO.getListVendors();
        List<Category> categories = categoryBO.getAllCategories();
        String imageURL = product.getImage().substring(product.getImage().indexOf("\\CNW_war"));
%>
<form action="${pageContext.request.contextPath}/adminController?action=updateProduct&id=<%= product.getId()%>"
      enctype="multipart/form-data"
      method="post" class="max-w-md mx-auto p-6 bg-white rounded-md shadow-md">

    <h2 class="text-2xl font-bold mb-6">Edit Product</h2>

    <div class="mb-4">
        <label for="name" class="block text-sm font-medium text-gray-600">Product name:</label>
        <input type="text" name="productName"
               class="p-2 form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
               value="<%= product.getProduct_name()%>"
               required>
    </div>

    <div class="mb-4">
        <label for="price" class="block text-sm font-medium text-gray-600">Price:</label>
        <input type="text" name="price"
               class="p-2 form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
               value="<%= product.getPrice()%>"
               required>
    </div>

    <div class="mb-4">
        <label for="description" class="block text-sm font-medium text-gray-600">Description:</label>
        <input type="text" name="description"
               class="p-2 form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
               value="<%= product.getDescription()%>"
               required>
    </div>

    <div class="mb-4">
        <label for="vendor" class="block text-sm font-medium text-gray-600">Vendor:</label>
        <select name="vendor"
                class="p-2 form-select mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
                required>
            <% for (Vendor vendor : vendors) { %>
            <option value="<%= vendor.getId() %>" <%= vendor.getId() == product.getVendor_id() ? "selected" : "" %>><%= vendor.getVendor_name() %>
            </option>
            <% } %>
        </select>
    </div>

    <div class="mb-4">
        <label for="category" class="block text-sm font-medium text-gray-600">Category:</label>
        <select name="category"
                class="p-2 form-select mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
                required>
            <% for (Category category : categories) { %>
            <option value="<%= category.getId() %>" <%= category.getId() == product.getCategory_id() ? "selected" : ""%>><%= category.getCategory_name() %>
            </option>
            <% } %>
        </select>
    </div>

    <div class="mb-6">
        <label class="block text-sm font-medium text-gray-600">Image</label>
        <!-- visually hidden file input -->
        <input type="file" name="image" id="imageInput" class="hidden" value="">
        <!-- label to trigger file input -->
        <label for="imageInput" class="cursor-pointer" onclick="document.getElementById('imageInput');">
            <img style="width: 100px;" src="<%= imageURL%>" alt="${product.getProductName()}" class="cursor-pointer">
        </label>
    </div>

    <div class="flex items-center justify-between">
        <input type="submit" value="Update Product"
               class="bg-blue-500 text-white py-2 px-4 rounded-md hover:bg-blue-700 cursor-pointer transition duration-300">
        <button onclick="window.history.back();"
                class="bg-gray-500 text-white py-2 px-4 rounded-md hover:bg-gray-700">
            Cancel
        </button>
    </div>
</form>
<%
    } catch (Exception e) {
        e.printStackTrace();
    }
} else if ("editVendor".equals(action)) {
    int id = Integer.parseInt(request.getParameter("id"));
    UserBO userBO = new UserBO();
    User user = userBO.getUserById(id);
%>
<div class="max-w-md mx-auto p-6 bg-white rounded-md shadow-md">
    <form action="${pageContext.request.contextPath}/adminController?action=updateVendor&id=<%= user.getId()%>"
          method="post">

        <h2 class="text-2xl font-bold mb-6">Edit Vendor</h2>

        <div class="mb-4">
            <label for="id" class="block text-sm font-medium text-gray-600">ID:</label>
            <input type="text" id="id" name="id" value="<%= id%>" readonly
                   class="form-input mt-1 block w-full border-gray-300 rounded-md p-2"/>
        </div>

        <div class="mb-4">
            <label for="username" class="block text-sm font-medium text-gray-600">Username:</label>
            <input type="text" name="username" value="<%= user.getUsername()%>" required
                   class="form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300 p-2">

        </div>

        <div class="mb-4">
            <label for="fullname" class="block text-sm font-medium text-gray-600">Fullname:</label>
            <input type="text" name="fullname" value="<%= user.getFullname()%>"
                   class="form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300 p-2"
                   required>
        </div>

        <div class="mb-6">
            <label for="phone_number" class="block text-sm font-medium text-gray-600">Phone Number:</label>
            <input type="number" name="phone_number" value="<%= user.getPhone_number()%>"
                   class="form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300 p-2"
                   required>
        </div>


        <div class="flex items-center justify-between">
            <input type="submit" value="Update"
                   class="bg-blue-500 text-white py-2 px-4 rounded-md hover:bg-blue-700"/>
            <button onclick="window.history.back();"
                    class="bg-gray-500 text-white py-2 px-4 rounded-md hover:bg-gray-700">
                Cancel
            </button>
        </div>

    </form>
</div>

<%
} else if ("editUser".equals(action)) {
    int id = Integer.parseInt(request.getParameter("id"));
    UserBO userBO = new UserBO();
    User user = userBO.getUserById(id);
%>
<div class="max-w-md mx-auto p-6 bg-white rounded-md shadow-md">
    <form action="${pageContext.request.contextPath}/adminController?action=updateUser&id=<%= user.getId()%>"
          method="post">

        <h2 class="text-2xl font-bold mb-6 text-center">Edit User</h2>

        <div class="mb-4">
            <label for="id" class="block text-sm font-medium text-gray-600">ID:</label>
            <input type="text" name="id" value="<%= id%>"
                   readonly
                   class="p-2 form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
                   required>
        </div>

        <div class="mb-4">
            <label for="username" class="block text-sm font-medium text-gray-600">Username:</label>
            <input type="text" name="username" value="<%= user.getUsername()%>"
                   class="p-2 form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
                   required>
        </div>

        <div class="mb-4">
            <label for="fullname" class="block text-sm font-medium text-gray-600">Fullname:</label>
            <input type="text" name="fullname" value="<%= user.getFullname()%>"
                   class="p-2 form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
                   required>
        </div>

        <div class="mb-4">
            <label for="phone_number" class="block text-sm font-medium text-gray-600">Phone Number:</label>
            <input type="number" name="phone_number" value="<%= user.getPhone_number()%>"
                   class="p-2 form-input mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300"
                   required>
        </div>

        <div class="mb-4">
            <label for="address" class="block text-sm font-medium text-gray-600">Address:</label>
            <input type="text" name="address" value="<%= user.getAddress()%>" required
                   class="form-textarea mt-1 block w-full border border-gray-300 rounded-md focus:outline-none focus:border-blue-500 transition duration-300 p-2"
            />
        </div>

        <div class="flex items-center justify-between">
            <input type="submit" value="Update"
                   class="bg-blue-500 text-white py-2 px-4 rounded-md hover:bg-blue-700"/>
            <button onclick="window.history.back();"
                    class="bg-gray-500 text-white py-2 px-4 rounded-md hover:bg-gray-700">
                Cancel
            </button>
        </div>

    </form>
</div>


<%
    } else if ("logout".equals(action)) {
        // Handle categories content
        session.invalidate();
        response.sendRedirect("../index.jsp");
    } else {

    }
%>
</body>
</html>
