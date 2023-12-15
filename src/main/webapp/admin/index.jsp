<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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

<!-- Sidebar -->
<div class="mx-auto h-full py-10 flex justify-center">
    <div class="flex p-4 w-[20%] min-h-full">
        <div class="sm:col-span-2 lg:col-span-2 bg-gray-800 text-white p-4 rounded-lg shadow-md h-full">
            <div class="max-w-2xl mx-auto">

                <aside class="w-64" aria-label="Sidebar">
                    <div class="px-3 py-4 overflow-y-auto rounded bg-gray-50 dark:bg-gray-800">
                        <ul class="space-y-2">
                            <h1 class="text-2xl font-bold">Hello <%= username%></h1>

                            <li>
                                <button type="button"
                                        class="flex items-center w-full p-2 text-base font-normal text-gray-900 transition duration-75 rounded-lg group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700"
                                        aria-controls="dropdown-user" data-collapse-toggle="dropdown-user">
                                    <svg class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
                                         fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M10 9a3 3 0 100-6 3 3 0 000 6zm-7 9a7 7 0 1114 0H3z"
                                              clip-rule="evenodd"></path>
                                    </svg>
                                    <span class="flex-1 ml-3 text-left whitespace-nowrap"
                                          sidebar-toggle-item>User</span>
                                    <svg sidebar-toggle-item class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20"
                                         xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                              d="M5.293 7.293a1 1 0 011.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z"
                                              clip-rule="evenodd"></path>
                                    </svg>
                                </button>
                                <ul id="dropdown-user" class="hidden py-2 space-y-2">
                                    <li>
                                        <a href="?action=getAllUsers"
                                           class="flex items-center w-full p-2 text-base font-normal text-gray-900 transition duration-75 rounded-lg group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700 pl-11">View All User</a>
                                    </li>
                                    <li>
                                        <a href="?action=addUser"
                                           class="flex items-center w-full p-2 text-base font-normal text-gray-900 transition duration-75 rounded-lg group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700 pl-11">Add User</a>
                                    </li>
                                </ul>
                            </li>

                                <li>
                                    <button type="button"
                                            class="flex items-center w-full p-2 text-base font-normal text-gray-900 transition duration-75 rounded-lg group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700"
                                            aria-controls="dropdown-vendor" data-collapse-toggle="dropdown-vendor">
                                        <svg class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
                                             fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                            <path fill-rule="evenodd" d="M10 9a3 3 0 100-6 3 3 0 000 6zm-7 9a7 7 0 1114 0H3z"
                                                  clip-rule="evenodd"></path>
                                        </svg>
                                        <span class="flex-1 ml-3 text-left whitespace-nowrap"
                                              sidebar-toggle-item>Vendor</span>
                                        <svg sidebar-toggle-item class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20"
                                             xmlns="http://www.w3.org/2000/svg">
                                            <path fill-rule="evenodd"
                                                  d="M5.293 7.293a1 1 0 011.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z"
                                                  clip-rule="evenodd"></path>
                                        </svg>
                                    </button>
                                    <ul id="dropdown-vendor" class="hidden py-2 space-y-2">
                                        <li>
                                            <a href="?action=getAllVendors"
                                               class="flex items-center w-full p-2 text-base font-normal text-gray-900 transition duration-75 rounded-lg group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700 pl-11">View All Vendors</a>
                                        </li>
                                        <li>
                                            <a href="?action=addVendor"
                                               class="flex items-center w-full p-2 text-base font-normal text-gray-900 transition duration-75 rounded-lg group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700 pl-11">Add Vendor</a>
                                        </li>

                                    </ul>
                                </li>
                            <li>
                                <button type="button"
                                        class="flex items-center w-full p-2 text-base font-normal text-gray-900 transition duration-75 rounded-lg group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700"
                                        aria-controls="dropdown-product" data-collapse-toggle="dropdown-product">
                                    <svg class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 group-hover:text-gray-900 dark:text-gray-400 dark:group-hover:text-white"
                                         fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                              d="M10 2a4 4 0 00-4 4v1H5a1 1 0 00-.994.89l-1 9A1 1 0 004 18h12a1 1 0 00.994-1.11l-1-9A1 1 0 0015 7h-1V6a4 4 0 00-4-4zm2 5V6a2 2 0 10-4 0v1h4zm-6 3a1 1 0 112 0 1 1 0 01-2 0zm7-1a1 1 0 100 2 1 1 0 000-2z"
                                              clip-rule="evenodd"></path>
                                    </svg>
                                    <span class="flex-1 ml-3 text-left whitespace-nowrap"
                                          sidebar-toggle-item>Product</span>
                                    <svg sidebar-toggle-item class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20"
                                         xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                              d="M5.293 7.293a1 1 0 011.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z"
                                              clip-rule="evenodd"></path>
                                    </svg>
                                </button>
                                <ul id="dropdown-product" class="hidden py-2 space-y-2">
                                    <li>
                                        <a href="?action=getAllProducts"
                                           class="flex items-center w-full p-2 text-base font-normal text-gray-900 transition duration-75 rounded-lg group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700 pl-11">View All Product</a>
                                    </li>
                                    <li>
                                        <a href="?action=addProduct"
                                           class="flex items-center w-full p-2 text-base font-normal text-gray-900 transition duration-75 rounded-lg group hover:bg-gray-100 dark:text-white dark:hover:bg-gray-700 pl-11">Add product</a>
                                    </li>

                                </ul>
                            </li>
                            <li>
                                <a href="?action=logout"
                                   class="flex items-center p-2 text-base font-normal text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700">
                                    <svg class="flex-shrink-0 w-6 h-6 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
                                         fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd"
                                              d="M3 3a1 1 0 00-1 1v12a1 1 0 102 0V4a1 1 0 00-1-1zm10.293 9.293a1 1 0 001.414 1.414l3-3a1 1 0 000-1.414l-3-3a1 1 0 10-1.414 1.414L14.586 9H7a1 1 0 100 2h7.586l-1.293 1.293z"
                                              clip-rule="evenodd"></path>
                                    </svg>
                                    <span class="flex-1 ml-3 whitespace-nowrap">Log out</span>
                                </a>
                            </li>

                        </ul>
                    </div>
                </aside>

                <script src="https://unpkg.com/flowbite@1.3.4/dist/flowbite.js"></script>
            </div>

        </div>
    </div>
    <div class="sm:col-span-1 lg:col-span-10 bg-white p-8 pt-0 rounded-lg shadow-md h-full overflow-y-hidden flex-1 w-[80%] h-[100vh]">
        <div id="content" class="mt-2">
            <%-- Include your dynamic content based on the action parameter --%>
            <%@ include file="adminContent.jsp" %>
        </div>
    </div>
</div>

<!-- Main Content -->


</body>
</html>
