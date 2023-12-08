package com.example.shopson.controller;

import com.example.shopson.model.bean.Vendor;
import com.example.shopson.model.bo.ProductBO;
import com.example.shopson.model.bo.VendorBO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final VendorBO vendorBO = new VendorBO();
    private final ProductBO productBO = new ProductBO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if (action.equals("getAllVendors")) {
            session.setAttribute("table", "vendor");
            System.out.println("getALlVendor");
            session.setAttribute("listVendor", vendorBO.getAllVendors());

            RequestDispatcher rd = request.getRequestDispatcher("admin/index.jsp");
            rd.forward(request, response);
        } else if (action.equals("getAllProducts")) {
            session.setAttribute("table", "product");

            session.setAttribute("listProducts", productBO.getAllProducts());
            RequestDispatcher rd = request.getRequestDispatcher("admin/product.jsp");
            rd.forward(request, response);
        } else if (action.equals("add")) {
            // Add


        } else if (action.equals("delete")) {
            // Delete
//            deleteVendor(request, response);
        } else if (action.equals("search")) {
            // Search
        } else if (action.equals("sort")) {
            // Sort
        } else if (action.equals("statistic")) {
            // Statistics
//            List<VendorHelper> listVendorHelper = new ArrayList<>();
//            listVendorHelper = vendorBO.statistic();
//
//            request.setAttribute("listVendorHelper", listVendorHelper);
//            RequestDispatcher rd = request.getRequestDispatcher("/statistic.jsp");
//            rd.forward(request, response);

        } else {
            // Show all
            vendorBO.getAllVendors();
            request.setAttribute("listVendor", vendorBO.getAllVendors());
            RequestDispatcher rd = request.getRequestDispatcher("/admin/index.jsp");
            rd.forward(request, response);
//            forwardToHomePage(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("add")) {
            // Add
//            addVendor(request, response);
//            forwardToHomePage(request, response);

        } else if (action.equals("update")) {
            // Update
//            updateVendor(request, response);
//            forwardToHomePage(request, response);
        } else if (action.equals("delete")) {
            // Delete
//            deleteVendor(request, response);
        } else if (action.equals("search")) {
            // Search
        } else if (action.equals("sort")) {
            // Sort
        } else {
            // Show all
//            forwardToHomePage(request, response);

        }
    }
}
