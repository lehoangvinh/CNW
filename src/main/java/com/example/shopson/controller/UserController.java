package com.example.shopson.controller;

import com.example.shopson.model.bo.CartOrderBO;
import com.example.shopson.model.bo.CartOrderItemBO;
import com.example.shopson.model.bo.ProductBO;
import com.example.shopson.model.helper.ProductHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cart")
public class UserController extends HttpServlet{
    ProductBO productBO = new ProductBO();
    CartOrderBO cartOrderBO = new CartOrderBO();
    CartOrderItemBO cartOrderItemBO = new CartOrderItemBO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        int cart_order_id = (int) req.getSession().getAttribute("cart_order_id");

        int user_id = (int) req.getSession().getAttribute("user_id");
        int product_id = Integer.parseInt(req.getParameter("product_id"));

        if("addItemToCart".equals(action)) {
            cartOrderItemBO.addCartOrderItem(cart_order_id, product_id, user_id);
            resp.sendRedirect("index.jsp");
        }
        else{
            resp.sendRedirect("err.jsp");
        }
//        if("addItemToCart".equals(action)){
//            ProductHelper productHelper = productBO.getProductById(Integer.parseInt(req.getParameter("id")));
//            addToCart(req, resp, productHelper);
//        }
    }

    private void addToCart(HttpServletRequest req, HttpServletResponse resp, ProductHelper productHelper) throws IOException {

    }
}
