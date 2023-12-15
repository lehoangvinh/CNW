<%@ page import="com.example.shopson.model.bo.ProductBO" %>
<%@ page import="com.example.shopson.model.bean.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.shopson.model.helper.ProductHelper" %><%--
  Created by IntelliJ IDEA.
  User: VINH
  Date: 12/12/2023
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vinh Shop</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css">
    <link href="https://cdn.tailwindcss.com" rel="stylesheet">

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
        }

        header {
            position: fixed;
            top: 0;
            width: 100%;
            color: #fff;
            text-align: center;
            z-index: 1000;
        }

        main {
            margin-top: 60px;
            /* Adjust based on header height */
            padding: 20px;
        }

    </style>
</head>
<body>
<!-- HEADER -->

<header>

    <!-- navbar -->
    <%
        if(session.getAttribute("username") != null) {
        String username = (String) session.getAttribute("username");
        int role = (int) session.getAttribute("role");
    %>
    <nav class="flex justify-between bg-gray-900 text-white w-screen">
        <div class="px-5 xl:px-12 py-6 flex w-full items-center">
            <a class="text-3xl font-bold font-heading" href="#">
                <!-- <img class="h-9" src="logo.png" alt="logo"> -->
                Son Beauty Shop
            </a>
            <!-- Nav Links -->
            <ul class="hidden md:flex px-4 mx-auto font-semibold font-heading space-x-12">
                <li><a class="hover:text-gray-200" href="#">Home</a></li>
                <li><a class="hover:text-gray-200" href="#">Category</a></li>
                <li><a class="hover:text-gray-200" href="#">Collections</a></li>
                <li><a class="hover:text-gray-200" href="#contact" onclick="scrollToContact()">Contact Us</a></li>
            </ul>
            <!-- Header Icons -->
            <div class="hidden xl:flex items-center space-x-5 items-center">
                <a class="flex items-center hover:text-gray-200" href="${pageContext.request.contextPath}/cart.jsp">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24"
                         stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                              d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z"/>
                    </svg>
                    <span class="flex absolute -mt-5 ml-4">
              <span class="animate-ping absolute inline-flex h-3 w-3 rounded-full bg-pink-400 opacity-75"></span>
                <span class="relative inline-flex rounded-full h-3 w-3 bg-pink-500">
                </span>
              </span>
                </a>
                <!-- Sign In / Register      -->
                <a class="flex items-center hover:text-gray-200 gap-2" href="${pageContext.request.contextPath}/auth?action=logout">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 hover:text-gray-200" fill="none"
                         viewBox="0 0 24 24" stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                              d="M5.121 17.804A13.937 13.937 0 0112 16c2.5 0 4.847.655 6.879 1.804M15 10a3 3 0 11-6 0 3 3 0 016 0zm6 2a9 9 0 11-18 0 9 9 0 0118 0z"/>
                    </svg>
                    <p>Log out</p>
                </a>

            </div>
        </div>
        <!-- Responsive navbar -->
        <a class="xl:hidden flex mr-6 items-center" href="#">
            <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 hover:text-gray-200" fill="none"
                 viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                      d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z"/>
            </svg>
            <span class="flex absolute -mt-5 ml-4">
          <span class="animate-ping absolute inline-flex h-3 w-3 rounded-full bg-pink-400 opacity-75"></span>
          <span class="relative inline-flex rounded-full h-3 w-3 bg-pink-500">
          </span>
        </span>
        </a>
        <a class="navbar-burger self-center mr-12 xl:hidden" href="#">
            <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 hover:text-gray-200" fill="none"
                 viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16"/>
            </svg>
        </a>
    </nav>
    <%
    } else {
    %>
    <nav class="flex justify-between bg-gray-900 text-white w-screen">
        <div class="px-5 xl:px-12 py-6 flex w-full items-center">
            <a class="text-3xl font-bold font-heading" href="#">
                <!-- <img class="h-9" src="logo.png" alt="logo"> -->
                Son Beauty Shop
            </a>
            <!-- Nav Links -->
            <ul class="hidden md:flex px-4 mx-auto font-semibold font-heading space-x-12">
                <li><a class="hover:text-gray-200" href="#">Home</a></li>
                <li><a class="hover:text-gray-200" href="#">Category</a></li>
                <li><a class="hover:text-gray-200" href="#">Collections</a></li>
                <li><a class="hover:text-gray-200" href="#contact" onclick="scrollToContact()">Contact Us</a></li>
            </ul>
            <!-- Header Icons -->
            <div class="hidden xl:flex items-center space-x-5 items-center">
                <a class="flex items-center hover:text-gray-200" href="${pageContext.request.contextPath}/login.jsp">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24"
                         stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                              d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z"/>
                    </svg>
                    <span class="flex absolute -mt-5 ml-4">
              <span class="animate-ping absolute inline-flex h-3 w-3 rounded-full bg-pink-400 opacity-75"></span>
                <span class="relative inline-flex rounded-full h-3 w-3 bg-pink-500">
                </span>
              </span>
                </a>
                <!-- Sign In / Register      -->
                <a class="flex items-center hover:text-gray-200 gap-2" href="${pageContext.request.contextPath}/login.jsp">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 hover:text-gray-200" fill="none"
                         viewBox="0 0 24 24" stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                              d="M5.121 17.804A13.937 13.937 0 0112 16c2.5 0 4.847.655 6.879 1.804M15 10a3 3 0 11-6 0 3 3 0 016 0zm6 2a9 9 0 11-18 0 9 9 0 0118 0z"/>
                    </svg>
                    <p>Sign In</p>
                </a>

            </div>
        </div>
        <!-- Responsive navbar -->
        <a class="xl:hidden flex mr-6 items-center" href="#">
            <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 hover:text-gray-200" fill="none"
                 viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                      d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0 0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z"/>
            </svg>
            <span class="flex absolute -mt-5 ml-4">
          <span class="animate-ping absolute inline-flex h-3 w-3 rounded-full bg-pink-400 opacity-75"></span>
          <span class="relative inline-flex rounded-full h-3 w-3 bg-pink-500">
          </span>
        </span>
        </a>
        <a class="navbar-burger self-center mr-12 xl:hidden" href="#">
            <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 hover:text-gray-200" fill="none"
                 viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16"/>
            </svg>
        </a>
    </nav>
    <%
        }
    %>
</header>
<%--Introduce--%>

<div class="container mx-auto mt-8" style="margin-top: 80px;">
    <div class="max-w-3xl mx-auto bg-white p-8 rounded-md shadow-lg">
        <h1 class="text-4xl font-bold text-gray-800 mb-6">Welcome to Son Beauty Shop</h1>

        <p class="text-gray-600 mb-4">
            Discover a world of vibrant and beautiful lip colors at Son Beauty Shop. We offer a wide range of
            high-quality lipsticks, lip glosses, and lip liners to enhance your beauty and confidence.
        </p>

        <p class="text-gray-600 mb-4">
            Our carefully curated collection includes products from top beauty brands, ensuring that you get the latest
            trends and timeless classics all in one place.
        </p>

        <p class="text-gray-600 mb-4">
            Whether you're looking for a bold statement lip or a subtle everyday shade, we have the perfect color for
            every occasion. Shop with us and elevate your makeup game.
        </p>

        <div class="mt-6">
            <a href="#"
               class="inline-block px-6 py-3 text-white bg-pink-500 rounded-full hover:bg-pink-600 transition duration-300">Explore
                Our Collection</a>
        </div>
    </div>

    <%--end introduce--%>
    <main style="justify-content: center" id="product">
        <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 justify-items-center items-center gap-4 mt-[60px]"
             style="justify-content: center">
            <%
                ProductBO productBO = new ProductBO();
                List<ProductHelper> products = productBO.getAllProducts();
                for (ProductHelper product : products) {
                    String imageURL = product.getImage().substring(product.getImage().indexOf("\\CNW_war"));
            %>
            <div class="flex flex-grow-1 flex-col justify-center p-10 bg-white rounded-lg shadow-2xl mb-4"
                 style="width: 450px; max-width: 100%; height: 100%">
                <div class="prod-title">
                    <p class="text-2xl font-semibold text-gray-900"><%= product.getProduct_name()%>
                    </p>
                    <p class="mt-2 text-sm text-gray-600"><%= product.getDescription()%>
                    </p>
                    <p class="mt-2 text-sm text-gray-600">By <%= product.getVendor_name()%>
                    </p>
                </div>

                <div class="prod-info grid gap-10" style="margin-top: auto;">
                    <div class="prod-img w-[300px] h-[200px]">
                        <%--                        <img src="https://scontent.fdad3-6.fna.fbcdn.net/v/t39.30808-6/410582435_768661115280481_6661891773556069927_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=3635dc&_nc_ohc=X4LUQvAoCtUAX-bz5hy&_nc_ht=scontent.fdad3-6.fna&oh=00_AfBZWkN1rzpCUesVjbRdg95o53Sv0J3Med92CtmGA-uEpw&oe=657D6186"--%>
                        <%--                             alt="${product.getProductName()}" class="w-[300px] h-[200px] object-center"--%>
                        <%--                             style="width: 300px; height: 200px;"/>--%>
                        <img src="<%= imageURL%>"
                             alt="${product.getProductName()}" class="w-[300px] h-[200px] object-center"
                             style="width: 300px; height: 200px;"/>
                    </div>
                    <div class="flex flex-col md:flex-row justify-between items-center text-gray-900">
                        <p class="font-bold text-xl"><%= product.getPrice()%> $</p>
                        <a
                                href="${pageContext.request.contextPath}/cart?action=addItemToCart&product_id=<%= product.getId()%>"
                                class="px-6 py-2 transition ease-in duration-200 uppercase rounded-full hover:bg-gray-800 hover:text-white border-2 border-gray-900 focus:outline-none">
                            Add to cart
                        </a>
                    </div>
                </div>
            </div>

            <%
                }
            %>
        </div>
    </main>

    <%--    contact--%>
    <div class="container mx-auto mt-8" id="contact">
        <div class="max-w-3xl mx-auto bg-white p-8 rounded-md shadow-lg">
            <h1 class="text-4xl font-bold text-gray-800 mb-6">Contact Son Beauty Shop</h1>

            <p class="text-gray-600 mb-4">
                We would love to hear from you! If you have any questions, feedback, or inquiries, please feel free to
                reach out to us.
            </p>

            <form action="#" method="post">
                <div class="mb-4">
                    <label for="name" class="block text-gray-700 text-sm font-bold mb-2">Your Name</label>
                    <input type="text" id="name" name="name"
                           class="w-full px-4 py-2 border rounded-md focus:outline-none focus:border-pink-500">
                </div>

                <div class="mb-4">
                    <label for="email" class="block text-gray-700 text-sm font-bold mb-2">Your Email</label>
                    <input type="email" id="email" name="email"
                           class="w-full px-4 py-2 border rounded-md focus:outline-none focus:border-pink-500">
                </div>

                <div class="mb-4">
                    <label for="message" class="block text-gray-700 text-sm font-bold mb-2">Your Message</label>
                    <textarea id="message" name="message" rows="4"
                              class="w-full px-4 py-2 border rounded-md focus:outline-none focus:border-pink-500"></textarea>
                </div>

                <button type="submit"
                        class="bg-pink-500 text-white px-6 py-3 rounded-full hover:bg-pink-600 transition duration-300">
                    Send Message
                </button>
            </form>
        </div>
    </div>

    <%--FOOTER--%>

    <!-- component -->
    <footer class="text-gray-600 body-font bg-gray-300 w-full">
        <div class="container px-5 py-24 mx-auto flex md:items-center lg:items-start md:flex-row md:flex-nowrap flex-wrap flex-col">
            <div class="w-64 flex-shrink-0 md:mx-0 mx-auto text-center md:text-left md:mt-0 mt-10">
                <a class="flex title-font font-medium items-center md:justify-start justify-center text-gray-900">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" stroke="currentColor" stroke-linecap="round"
                         stroke-linejoin="round" stroke-width="2"
                         class="w-10 h-10 text-white p-2 bg-indigo-500 rounded-full" viewBox="0 0 24 24">
                        <path d="M12 2L2 7l10 5 10-5-10-5zM2 17l10 5 10-5M2 12l10 5 10-5"></path>
                    </svg>
                    <span class="ml-3 text-xl">Footer</span>
                </a>
            </div>
            <div class="flex-grow flex flex-wrap md:pr-20 -mb-10 md:text-left text-center order-first">
                <div class="lg:w-1/4 md:w-1/2 w-full px-4">
                    <h2 class="title-font font-medium text-gray-900 tracking-widest text-sm mb-3">CATEGORIES</h2>
                    <nav class="list-none mb-10">
                        <li>
                            <a class="text-gray-600 hover:text-gray-800">First Link</a>
                        </li>
                        <li>
                            <a class="text-gray-600 hover:text-gray-800">Second Link</a>
                        </li>
                        <li>
                            <a class="text-gray-600 hover:text-gray-800">Third Link</a>
                        </li>
                        <li>
                            <a class="text-gray-600 hover:text-gray-800">Fourth Link</a>
                        </li>
                    </nav>
                </div>
            </div>
        </div>
    </footer>

    <script>
        function scrollToContact() {
            var contactSection = document.getElementById("contact");

            if (contactSection) {
                contactSection.scrollIntoView({behavior: "smooth"});
            }
        }
    </script>
    <!-- Does this resource worth a follow? -->


</body>
</html>
