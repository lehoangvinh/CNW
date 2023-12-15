package com.example.shopson.controller;


import com.example.shopson.model.bean.Category;
import com.example.shopson.model.bo.CategoryBO;
import com.example.shopson.model.bo.ProductBO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@WebServlet("/add-product-by-vendor")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class AddProductByVendorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryBO categoryBO = new CategoryBO();
        List<Category> categories = categoryBO.getAllCategories();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("add-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int vendor_id = (Integer) session.getAttribute("vendor_id");
        // Lấy thông tin sản phẩm từ form
        String productName = req.getParameter("product_name");
        float price = Float.parseFloat(req.getParameter("price"));
        String description = req.getParameter("description");
        int category = Integer.parseInt(req.getParameter("category_value"));

        InputStream imageInputStream = req.getPart("image").getInputStream();

        // Thực hiện lưu ảnh vào thư mục upload
        String uploadPath = getServletContext().getRealPath("/") + "upload";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }


        String imageName = productName + "_" + System.currentTimeMillis() + ".jpg";
        Path imagePath = Paths.get(uploadPath, imageName);
        Files.copy(imageInputStream, imagePath, StandardCopyOption.REPLACE_EXISTING);


        ProductBO productBO = new ProductBO();
        boolean checkAddProduct = productBO.addProduct(productName, price, description, vendor_id, imagePath.toString(), category);

        if(checkAddProduct)
        {
            resp.sendRedirect(req.getContextPath() + "/products-vendor");
        }else {
            // Nếu có lỗi, gửi thông báo lỗi và giữ người dùng ở trang /add-product-by-vendor
            String errorMessage = "Failed to add the product. Please try again.";
            req.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/add-product.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
