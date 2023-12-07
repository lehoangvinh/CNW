package com.example.shopson.controller;

import com.example.shopson.model.bean.AuthHelper;
import com.example.shopson.model.bo.AuthBO;
import jakarta.servlet.RequestDispatcher;
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("login.jsp");
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
            else if (isLogin.getRole_id() == 2)
                response.sendRedirect("vendor/index.jsp");
            else if (isLogin.getRole_id() == 3)
                response.sendRedirect("customer/index.jsp");
            else
                response.sendRedirect("login.jsp");

        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
