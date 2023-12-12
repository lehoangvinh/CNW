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

@WebServlet("/customer/add-to-cart")
public class AddToCartController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,  java.io.IOException {

        try(PrintWriter out = response.getWriter()) {
            ProductBO productBO = new ProductBO();

            int product_id = Integer.parseInt(request.getParameter("id"));
            Product product = productBO.getProductById(product_id);

//            CartOrderItems  cartOrderItem = new CartOrderItems(
//                    id,
//                    (int) product.getPrice(),
//                1 * product.getPrice(),
//                1,
//                product.getId()
//            );
//
//            HttpSession session = request.getSession();
//
//            ArrayList<CartOrderItems> cartList = (ArrayList<CartOrderItems>) session.getAttribute("cartList");
//            if(cartList == null) {
//                cartList = new ArrayList<CartOrderItems>();
//            }
//            cartList.add(cartOrderItem);
//            session.setAttribute("cartList", cartList);
//            out.println("Add to cart successfully");

            HttpSession session = request.getSession();
            //lấy list các cart order theo user id
            int userId = (int) session.getAttribute("user_id");

            //lấy cartOrder theo user id và paid_status = false
            CartOrderBO cartOrderBO = new CartOrderBO();
            CartOrder cartOrder = cartOrderBO.getCartOrderNotPaidByUserId(userId);

            if(cartOrder == null) {
                //tạo mới cartOrder
                cartOrderBO.addCartOrder(java.time.LocalDate.now(), 0, false, userId);
                cartOrder = cartOrderBO.getCartOrderNotPaidByUserId(userId);

            }

            session.setAttribute("cart_order", cartOrder);

            //lấy danh sách các CartOrderItems theo cartOrder_id

            CartOrderItemsBO cartOrderItemsBO = new CartOrderItemsBO();

            List<CartOrderItems> cartOrderItemsList = cartOrderItemsBO.getAllCartOrderItemsByCartOrderId(cartOrder.getId());

            //thêm sản phẩm vào giỏ hàng
            CartOrderItems cartOrderItems = cartOrderItemsBO.getCartOrderItemsByProductIdAndCartOrderId(product_id, cartOrder.getId());
            if(cartOrderItems == null) {
                //tạo mới cartOrderItems từ product_d
                cartOrderItems = new CartOrderItems(
                        1,
                        1 * product.getPrice(),
                        cartOrder.getId(),
                        product.getId()
                );
                cartOrderItemsBO.addCartOrderItems(cartOrderItems);
                cartOrderItemsList.add(cartOrderItems);
            } else {
                //cập nhật cartOrderItems
                cartOrderItems.setQuantity(cartOrderItems.getQuantity() + 1);
                cartOrderItems.setSub_total_price(cartOrderItems.getQuantity() * product.getPrice());
                cartOrderItemsBO.updateCartOrderItems(cartOrderItems.getId(), cartOrderItems);
                //update lại cartOrderItemsList
                for (CartOrderItems cartOrderItems1 : cartOrderItemsList) {
                    if(cartOrderItems1.getId() == cartOrderItems.getId()) {
                        cartOrderItems1.setQuantity(cartOrderItems.getQuantity());
                        cartOrderItems1.setSub_total_price(cartOrderItems.getSub_total_price());
                    }
                }
            }

            session.setAttribute("cart_order_items_list", cartOrderItemsList);

            //kiểm tra xem sản phẩm đã có trong giỏ hàng chưa









        }
    }
}
