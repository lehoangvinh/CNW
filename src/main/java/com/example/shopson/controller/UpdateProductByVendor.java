package com.example.shopson.controller;


import com.example.shopson.model.bean.Category;
import com.example.shopson.model.bo.CategoryBO;
import com.example.shopson.model.bo.ProductBO;
import com.example.shopson.model.bo.VendorBO;
import com.example.shopson.model.helper.ProductsVendor;
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

@WebServlet(name = "UpdateProductByVendor", urlPatterns = "/update-product-by-vendor")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class UpdateProductByVendor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("product_id");
        if (productId != null && !productId.isEmpty()) {
            try {
                int productIdInt = Integer.parseInt(productId);
                VendorBO vendorBO = new VendorBO();
                ProductsVendor productVendor = vendorBO.getProductVendorById(productIdInt);
                req.setAttribute("productVendor", productVendor);
                CategoryBO categoryBO = new CategoryBO();
                List<Category> categories = categoryBO.getAllCategories();
                req.setAttribute("categories", categories);
                req.getRequestDispatcher("update-product.jsp").forward(req, resp);
            } catch (NumberFormatException e) {
                // Xử lý nếu product_id không phải là một số nguyên hợp lệ
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product_id");
            }
        } else {
            // Xử lý nếu không có product_id được cung cấp
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing product_id");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lấy thông tin sản phẩm từ form
        HttpSession session = req.getSession();
        int vendor_id = (Integer) session.getAttribute("vendor_id");
        String productName = req.getParameter("product_name");
        float price = Float.parseFloat(req.getParameter("price"));
        String description = req.getParameter("description");
        String productId = req.getParameter("id");
        int productIdInt = Integer.parseInt(productId);

        InputStream imageInputStream = req.getPart("image").getInputStream();
        int category = Integer.parseInt(req.getParameter("category_value"));

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
        boolean checkUpdate = productBO.updateProduct(productIdInt,productName, price, description, vendor_id, imagePath.toString(), category);
        if (checkUpdate)
        {
            resp.sendRedirect(req.getContextPath() + "/vendor/index.jsp");
        }else {
            // Nếu có lỗi, gửi thông báo lỗi và giữ người dùng ở trang /add-product-by-vendor
            String errorMessage = "Failed to update the product. Please try again.";
            req.setAttribute("errorMessage", errorMessage);
            resp.sendRedirect(req.getContextPath() + "/update-product-by-vendor?product_id="+productIdInt);
        }

    }
}
