package com.example.shopson.controller;

import com.example.shopson.model.bean.CartOrder;
import com.example.shopson.model.bean.CartOrderItems;
import com.example.shopson.model.bean.Product;
import com.example.shopson.model.bo.CartOrderBO;
import com.example.shopson.model.bo.CartOrderItemsBO;
import com.example.shopson.model.bo.ProductBO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//anotation /customer/shop-cart
@WebServlet("/customer/shop-cart")
public class ShopCartController {
    CartOrderItemsBO cartOrderItemsBO = new CartOrderItemsBO();
    CartOrderBO cartOrderBO = new CartOrderBO();
    ProductBO productBO = new ProductBO();
    private static final long serialVersionUID = 1L;

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,  java.io.IOException {
            //lấy list các cart order có trang thái paid_status = false theo user id
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("user_id");

            CartOrder cartOrder = cartOrderBO.getCartOrderNotPaidByUserId(userId);

            //lấy list các cart order items theo cart order id
            List<CartOrderItems> cartOrderItemsList = cartOrderItemsBO.getAllCartOrderItemsByCartOrderId(cartOrder.getId());

            //lấy list các product theo cart order items
            List<Product> productList = new ArrayList<>();
            for (CartOrderItems cartOrderItems : cartOrderItemsList) {
                int productId = cartOrderItems.getProduct_id();
                 Product product = productBO.getProductById(productId);
                 productList.add(product);
            }
            request.setAttribute("productList", productList);
            request.setAttribute("cartOrderItemsList", cartOrderItemsList);
            request.getRequestDispatcher("/customer/shop-cart.jsp").forward(request, response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,  java.io.IOException {

        }

}
