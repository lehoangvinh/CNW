package com.example.shopson.controller;


import com.example.shopson.model.bo.ProductBO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/delete-product-by-vendor")
public class DeleteProductByVendorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("product_id");
        if (productId != null && !productId.isEmpty()) {
            try {
                // Chuyển product_id sang kiểu int
                int productIdInt = Integer.parseInt(productId);

                // Gọi phương thức xóa sản phẩm từ DAO hoặc Service của bạn
                // Ví dụ: ProductBO.deleteProduct(productIdInt);
                ProductBO productBO = new ProductBO();
                boolean checkDelete = productBO.deleteProduct(productIdInt);
                // Redirect người dùng sau khi xóa sản phẩm
                if(checkDelete){
                    resp.sendRedirect(req.getContextPath() + "/vendor/index.jsp");
                }
                else{
                    resp.sendRedirect(req.getContextPath() + "/vendor/err.jsp");
                }

            } catch (NumberFormatException e) {
                // Xử lý nếu product_id không phải là một số nguyên hợp lệ
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid product_id");
            }
        } else {
            // Xử lý nếu không có product_id được cung cấp
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing product_id");
        }
    }
}
