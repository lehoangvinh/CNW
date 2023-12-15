<%@ page import="com.example.shopson.model.helper.ProductHelper" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shopson.model.bo.ProductBO" %>
<%@ page import="com.example.shopson.model.bo.CartOrderItemBO" %>
<%@ page import="com.example.shopson.model.bo.CartOrderBO" %>
<%@ page import="com.example.shopson.model.bean.CartOrder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
    <style>
        @layer utilities {
            input[type="number"]::-webkit-inner-spin-button,
            input[type="number"]::-webkit-outer-spin-button {
                -webkit-appearance: none;
                margin: 0;
            }
        }

        .product-image {
            width: 100%;
            height: auto;
            max-width: 10rem; /* Adjust the max-width as needed */
        }

        .product-info {
            flex: 1;
        }
    </style>
</head>
<body class="bg-gray-100">


    <%
    ProductBO productBO = new ProductBO();
    CartOrderBO cartOrderBO = new CartOrderBO();
    CartOrderItemBO cartOrderItemBO = new CartOrderItemBO();
    int id = request.getSession().getAttribute("user_id") == null ? 0 : (int) request.getSession().getAttribute("user_id");
    String username = request.getSession().getAttribute("username") == null ? "" : (String) request.getSession().getAttribute("username");
    int cart_order_id = request.getSession().getAttribute("cart_order_id") == null ? 0 : (int) request.getSession().getAttribute("cart_order_id");

    CartOrder cartOrder = cartOrderBO.getCartOrderById(cart_order_id);

    List<ProductHelper> listProducts = cartOrderItemBO.getCartOrderItemByCartOrderId(cart_order_id);
    if (!listProducts.isEmpty()) {
     float total_price = 0F;
%>
<h1 class="mb-10 text-center text-2xl font-bold">Cart Items</h1>
<div class="h-screen flex justify-center items-center bg-gray-100 w-full">
    <div class="mx-auto flex md:flex-row gap-4 p-4 bg-white rounded-lg shadow-md">
        <div class="flex-1">
            <% for (ProductHelper productHelper : listProducts) {
                String imageURL = productHelper.getImage().substring(productHelper.getImage().indexOf("\\CNW_war"));
                total_price+= productHelper.getPrice();
            %>
            <div class="mb-6">
                <div class="flex justify-between p-6 bg-white rounded-lg shadow-md">
                    <%--                    <img src="https://images.unsplash.com/photo-1515955656352-a1fa3ffcd111?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"--%>
                    <%--                         alt="product-image" class="product-image"/>--%>
                    <img style="width: 100px;" src="<%= imageURL%>" alt="${productHelper.getProductName()}"
                         class="cursor-pointer">

                    <div class="ml-4 flex-1">
                        <div class="mt-5">
                            <h2 class="text-lg font-bold text-gray-900"><%= productHelper.getProduct_name() %>
                            </h2>
                            <p class="mt-1 text-xs text-gray-700"><%= productHelper.getCategory_name() %>
                            </p>
                        </div>
                        <div class="mt-4 flex justify-between space-x-6">
                            <div class="flex items-center border-gray-100">
                                <input class="p-2 h-8 w-[50px] border bg-white text-center text-xs outline-none" type="text"
                                       value="<%= productHelper.getPrice() %> $" readonly/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
        <!-- Sub total -->
        <div class="mt-6  w-1/3">
            <div class="rounded-lg border bg-white p-6 shadow-md">
                <div class="mb-2 flex justify-between">
                    <p class="text-gray-700">Subtotal</p>
<%--                    <p class="text-gray-700"><%= cartOrder.getTotal_price()%> $</p>--%>
                    <p class="text-gray-700"><%= total_price%> $</p>
                </div>
                <div class="flex justify-between">
                    <p class="text-gray-700">Shipping</p>
                    <p class="text-gray-700">$0</p>
                </div>
                <hr class="my-4"/>
                <div class="flex justify-between">
                    <p class="text-lg font-bold">Total</p>
                    <div>
                        <p class="mb-1 text-lg font-bold"><%= total_price%>$</p>
                        <p class="text-sm text-gray-700">including VAT</p>
                    </div>
                </div>
                <button class="mt-6 w-full rounded-md bg-blue-500 py-1.5 font-medium text-blue-50 hover:bg-blue-600">
                    Check out
                </button>
                <button onclick="window.history.back();"
                        class="mt-6 w-full rounded-md bg-red-700 py-1.5 font-medium text-blue-50 hover:bg-red-400">
                    Cancel
                </button>
            </div>
        </div>
    </div>
</div>

    <%

} else {
%>
    <%
        response.sendRedirect("index.jsp");
    }
%>

