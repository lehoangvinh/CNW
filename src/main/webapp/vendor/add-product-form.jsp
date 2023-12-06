<%--
  Created by IntelliJ IDEA.
  User: lequangnhat
  Date: 12/5/23
  Time: 10:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="description" content="Ashion Template">
    <meta name="keywords" content="Ashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ashion | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cookie&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700;800;900&display=swap"
          rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="../staticfiles/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="../staticfiles/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="../staticfiles/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="../staticfiles/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="../staticfiles/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="../staticfiles/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="../staticfiles/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="../staticfiles/css/style.css" type="text/css">
    <link rel="stylesheet" href="../staticfiles/css/add-product-form.css">
</head>
<body>
<!-- Page Preloder -->

<!-- Offcanvas Menu Begin -->
<div class="offcanvas-menu-wrapper">
    <div class="offcanvas__close">+</div>
    <ul class="offcanvas__widget">
        <li><span class="icon_search search-switch"></span></li>
        <li><a href="#"><span class="icon_heart_alt"></span>
            <div class="tip">2</div>
        </a></li>
        <li><a href="#"><span class="icon_bag_alt"></span>
            <div class="tip">2</div>
        </a></li>
    </ul>
    <div class="offcanvas__logo">
        <a href="../customer/index.jsp"><img src="../staticfiles/img/logo.png" alt=""></a>
    </div>
    <div id="mobile-menu-wrap"></div>
    <div class="offcanvas__auth">
        <a href="../login.jsp">Login</a>
        <a href="#">Register</a>
    </div>
</div>


<div class="container-add-form">
    <h1>Add Lipstick</h1>
    <form class="add-product-form" action="#" method="post">
        <div class="add-form-control">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" class="form-input" required>
        </div>

        <div class="add-form-control">
            <label for="description">Description:</label>
            <textarea id="description" name="description" class="form-input" required></textarea>
        </div>

        <div class="add-form-control">

            <label for="price">Price:</label>
            <input type="number" id="price" name="price" class="form-input" step="0.01" required>
        </div>

        <div class="add-form-control">

            <label for="color">Color:</label>
            <select name="" id="color">
                <option value=""></option>
                <option value=""></option>
                <option value=""></option>
            </select>
        </div>

        <div class="add-form-control">

            <label for="vendor_id">Vendor ID:</label>
            <input type="text" id="vendor_id" name="vendor_id" class="form-input" required>
        </div>

        <div class="add-form-control">
            <label for="image">Image URL:</label>
            <input type="url" id="image" name="image" class="form-input" required>
        </div>

        <button type="submit" class="submit-button">Add Product</button>
    </form>
</div>

</body>
</html>
