<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <!-- Include your CSS files here -->
</head>
<body>
<!-- Sidebar -->
<div id="sidebar">
    <ul>
        <li><a href="admin?action=getAllVendors">Get All Vendors</a></li>
        <li><a href="admin?action=getAllProducts">Get All Products</a></li>
    </ul>
</div>

<!-- Main Content -->
<div id="content">
    <%-- You can include your dynamic content here based on the action parameter --%>
    <%@ include file="adminContent.jsp" %>
</div>

<!-- Include your JS files here -->
</body>
</html>
