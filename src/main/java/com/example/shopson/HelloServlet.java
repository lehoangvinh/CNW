package com.example.shopson;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World! This is a servlet.";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        String path = "http://localhost:8080/ShopSon_war_exploded/";
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<a href='" + path + "login.jsp'>login</a></br>");
        out.println("<a href='" + path + "register.jsp'>register</a></br>");

        out.println("</br>");
        out.println("<h2>Vendor</h2>");
        out.println("<a href='" + path + "vendor/" + "index.jsp'>index</a></br>");
        out.println("<a href='" + path + "vendor/" + "add-product-form.jsp'>add-product-form</a></br>");

        out.println("</br>");
        out.println("<h2>Customer</h2>");
        out.println("<a href='" + path + "customer/" + "index.jsp'>son_shop customer</a></br>");

        out.println("<a href='" + path + "customer/" + "shop-cart.jsp'>shop-cart</a></br>");

        out.println("<a href='" + path + "customer/" + "shop-cart-fix.jsp'>shop-cart-fix</a></br>");

        out.println("<a href='" + path + "customer/" + "shop.jsp'>shop</a></br>");
        out.println("<a href='" + path + "customer/" + "product-details.jsp'>product-details</a></br>");
        out.println("<a href='" + path + "customer/" + "main.jsp'>main</a></br>");
        out.println("<a href='" + path + "customer/" + "index.jsp'>index</a></br>");
        out.println("<a href='" + path + "customer/" + "contact.jsp'>contact</a></br>");
        out.println("<a href='" + path + "customer/" + "checkout.jsp'>checkout</a></br>");
        out.println("<a href='" + path + "customer/" + "cart-order.jsp'>cart-order</a></br>");
        
        out.println("<a href='" + path + "customer/" + "blog-details.jsp'>blog-details</a></br>");
        out.println("<a href='" + path + "customer/" + "blog.jsp'>blog</a></br>");

        out.println("<h2>Admin</h2>");
        out.println("<a href='" + path + "admin/" + "todo_list.jsp'>todo_list</a></br>");
        out.println("<a href='" + path + "admin/" + "responsive_table.jsp'>responsive_table</a></br>");
        out.println("<a href='" + path + "admin/" + "panels.jsp'>panels</a></br>");
        out.println("<a href='" + path + "admin/" + "morris.jsp'>morris</a></br>");
        out.println("<a href='" + path + "admin/" + "lock_screen.jsp'>lock_screen</a></br>");
        out.println("<a href='" + path + "admin/" + "index.jsp'>index</a></br>");
        out.println("<a href='" + path + "admin/" + "general.jsp'>general</a></br>");
        out.println("<a href='" + path + "admin/" + "gallery.jsp'>gallery</a></br>");
        out.println("<a href='" + path + "admin/" + "form_component.jsp'>form_component</a></br>");
        out.println("<a href='" + path + "admin/" + "chartjs.jsp'>chartjs</a></br>");
        out.println("<a href='" + path + "admin/" + "calendar.jsp'>calendar</a></br>");
        out.println("<a href='" + path + "admin/" + "buttons.jsp'>buttons</a></br>");
        out.println("<a href='" + path + "admin/" + "blank.jsp'>blank</a></br>");
        out.println("<a href='" + path + "admin/" + "basic_table.jsp'>basic_table</a></br>");
        
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
