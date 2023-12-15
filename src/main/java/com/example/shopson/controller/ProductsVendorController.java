package com.example.shopson.controller;

import com.example.shopson.model.bo.VendorBO;
import com.example.shopson.model.helper.ProductsVendor;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/products-vendor")
public class ProductsVendorController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int vendorId = (Integer) session.getAttribute("vendor_id");
        VendorBO vendorBO = new VendorBO();

        List<ProductsVendor> productsVendorList = vendorBO.getProductsCustomByVendorId(vendorId);
        req.setAttribute("productsVendorList", productsVendorList);

        RequestDispatcher rd = req.getRequestDispatcher("vendor/index.jsp");
        rd.forward(req, resp);
    }
}
