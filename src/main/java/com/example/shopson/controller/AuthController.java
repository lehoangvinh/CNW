package com.example.shopson.controller;

import com.example.shopson.model.bean.AuthHelper;
import com.example.shopson.model.bo.AuthBO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "AuthController", value = "/auth")
public class AuthController {
    private static final long serialVersionUID = 1L;
    private final AuthBO authBO = new AuthBO();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        AuthHelper isLogin = authBO.checkLogin(username, password);
        if (isLogin != null) {
            session.setAttribute("username", isLogin.getUsername());
            session.setAttribute("role", isLogin.getRole_id());
            RequestDispatcher rd = request.getRequestDispatcher("/admin.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
