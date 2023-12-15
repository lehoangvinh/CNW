package com.example.shopson.controller;

import com.example.shopson.model.bean.CartOrder;
import com.example.shopson.model.bean.Vendor;
import com.example.shopson.model.bo.CartOrderBO;
import com.example.shopson.model.bo.UserBO;
import com.example.shopson.model.bo.VendorBO;
import com.example.shopson.model.helper.AuthHelper;
import com.example.shopson.model.bo.AuthBO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/auth")
public class AuthController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final AuthBO authBO = new AuthBO();

    private final UserBO userBO = new UserBO();
    private final CartOrderBO cartOrderBO = new CartOrderBO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect(request.getContextPath()+ "/index.jsp");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        AuthHelper isLogin = authBO.checkLogin(username, password);
        if (isLogin != null) {
            session.setAttribute("username", isLogin.getUsername());
            session.setAttribute("role", isLogin.getRole_id());
            if (isLogin.getRole_id() == 1)
                response.sendRedirect("admin/index.jsp");
            else if (isLogin.getRole_id() == 2){
                int user_id = isLogin.getUser_id();
                VendorBO vendorBO = new VendorBO();
                Vendor vendor = vendorBO.getVendorById(user_id);
                session.setAttribute("vendor_id", vendor.getId());

//                response.sendRedirect(request.getContextPath() + "/products-vendor");
                response.sendRedirect("vendor/index.jsp");
            }
            else if (isLogin.getRole_id() == 3){
                int user_id = isLogin.getUser_id();
                CartOrder cartOrder = cartOrderBO.getCartOrderById(user_id);
                if(cartOrder == null){
                   throw new RuntimeException("Cart order is null");
                }
                session.setAttribute("cart_order_id", cartOrder.getId());
                session.setAttribute("user_id", user_id);
                response.sendRedirect("index.jsp");
            }

            else
                response.sendRedirect("login.jsp");

        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
