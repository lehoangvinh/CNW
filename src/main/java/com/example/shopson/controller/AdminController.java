package com.example.shopson.controller;

import com.example.shopson.model.bean.Product;
import com.example.shopson.model.bean.User;
import com.example.shopson.model.bean.Vendor;
import com.example.shopson.model.bo.ProductBO;
import com.example.shopson.model.bo.UserBO;
import com.example.shopson.model.bo.VendorBO;
import com.example.shopson.model.helper.ProductHelper;
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
import java.util.Date;

@WebServlet("/adminController")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class AdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserBO userBO = new UserBO();
    private final VendorBO vendorBO = new VendorBO();
    private final ProductBO productBO = new ProductBO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // doGet completed
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if (action.equals("getAllUsers")) {
            // Show all
            request.setAttribute("listUsers", userBO.getAllUsers());
            RequestDispatcher rd = request.getRequestDispatcher("admin/users.jsp");
            rd.forward(request, response);
            /// done
        } else if (action.equals("getAllVendors")) {
            // Show all
            request.setAttribute("listVendors", vendorBO.getAllVendors());
            RequestDispatcher rd = request.getRequestDispatcher("admin/vendors.jsp");
            rd.forward(request, response);
        } else if (action.equals("getAllProducts")) {
            // Show all
            request.setAttribute("listProducts", productBO.getAllProducts());
            RequestDispatcher rd = request.getRequestDispatcher("admin/products.jsp");
            rd.forward(request, response);
        }  else if (action.equals("deleteVendor")) {
            // Delete
            int id = Integer.parseInt(request.getParameter("id"));
            boolean res = vendorBO.deleteVendor(id);
            if (res) {
                userBO.updateRole(id, 3);
                response.sendRedirect("admin/index.jsp?action=getAllVendors");
            } else {
                response.sendRedirect("admin/err.jsp");
            }
        } else if (action.equals("deleteProduct")) {
            // Delete
            int id = Integer.parseInt(request.getParameter("id"));
            boolean res = productBO.deleteProduct(id);
            if (res) {
                response.sendRedirect("admin/index.jsp?action=getAllProducts");
            } else {
                response.sendRedirect("admin/err.jsp");
            }
        } else if (action.equals("addUser")) {
            // Add
            response.sendRedirect("admin/addUserForm.jsp");
        } else if (action.equals("addVendor")) {
            // Add
            response.sendRedirect("admin/addVendorForm.jsp");
        } else if (action.equals("addProduct")) {
            // Add
            response.sendRedirect("admin/addProductForm.jsp");
        }
        //start edit
        else if (action.equals("editVendor")) {
            // Edit
            int id = Integer.parseInt(request.getParameter("id"));
            User user = userBO.getUserById(id);
            request.setAttribute("vendorToEdit", user);

            RequestDispatcher rd = request.getRequestDispatcher("admin/editVendor.jsp");
            rd.forward(request, response);
        } else if (action.equals("editUser")) {
            int id = Integer.parseInt(request.getParameter("id"));
            User user = userBO.getUserById(id);
            request.removeAttribute("userToEdit");
            request.setAttribute("userToEdit", user);
            RequestDispatcher rd = request.getRequestDispatcher("admin/editUser.jsp");
            rd.forward(request, response);
        } else if (action.equals("editProduct")) {
            int id = Integer.parseInt(request.getParameter("id"));
            ProductHelper product = productBO.getProductById(id);
            request.removeAttribute("productToEdit");
            request.setAttribute("productToEdit", product);

            RequestDispatcher rd = request.getRequestDispatcher("admin/editProduct.jsp");
            rd.forward(request, response);

        }
        else if(action.equals("deleteProduct")){
            int id = Integer.parseInt(request.getParameter("id"));
            boolean res = productBO.deleteProduct(id);
            if(res)
                response.sendRedirect("admin/index.jsp?action=getAllProducts");
            else{
                response.sendRedirect("admin/err.jsp");
            }
        }
        else if(action.equals("deleteVendor")){
            int id = Integer.parseInt(request.getParameter("id"));
            boolean res = vendorBO.deleteVendor(id);

            if(res){
                userBO.updateRole(id,3);
                response.sendRedirect("admin/index.jsp?action=getAllVendors");
            }

            else{
                response.sendRedirect("admin/err.jsp");
            }
        }
        else if(action.equals("deleteUser")){
            int id = Integer.parseInt(request.getParameter("id"));
            boolean res = userBO.deleteUser(id);
            if(res)
                response.sendRedirect("admin/index.jsp?action=getAllUsers");
            else{
                response.sendRedirect("admin/err.jsp");
            }
        }
        else if(action.equals("logout")){
            session.invalidate();
            response.sendRedirect("index.jsp");
        }else {
            // Show all
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("addVendor")) {
            addVendor(request, response);
            response.sendRedirect("admin/index.jsp?action=getAllVendors");
        } else if (action.equals("addProduct")) {
            // Update
            addProduct(request, response);
            response.sendRedirect("admin/index.jsp?action=getAllProducts");
        }else if(action.equals("addUser")){
            addUser(request,response);
            response.sendRedirect("admin/index.jsp?action=getAllUsers");

        }
        else if(action.equals("updateProduct")){

            int id = Integer.parseInt(request.getParameter("id"));
            String product_name = (String) request.getParameter("productName");
            Float price = Float.parseFloat(request.getParameter("price"));
            String description = (String) request.getParameter("description");
            int vendor_id = Integer.parseInt(request.getParameter("vendor"));
            int category_id = Integer.parseInt(request.getParameter("category"));
//            String image = (String) request.getParameter("image");

            InputStream imageInputStream = request.getPart("image").getInputStream();

            // Thực hiện lưu ảnh vào thư mục upload
            String uploadPath = getServletContext().getRealPath("/") + "upload";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String imageName = System.currentTimeMillis() + ".jpg";
            Path imagePath = Paths.get(uploadPath, imageName);
            Files.copy(imageInputStream, imagePath, StandardCopyOption.REPLACE_EXISTING);


            boolean res = productBO.updateProduct(id, product_name, price, description, vendor_id, imagePath.toString(), category_id);
            if(res)
                response.sendRedirect("admin/index.jsp?action=getAllProducts");
            else{
                response.sendRedirect("admin/err.jsp");
            }
        }
        else if(action.equals("updateVendor")){
            updateVendor(request, response);
            response.sendRedirect("admin/index.jsp?action=getAllVendors");
        }
        else if(action.equals("updateUser")){
            updateUser(request, response);
            response.sendRedirect("admin/index.jsp?action=getAllUsers");
        }
        else {
            // Show all
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String phone_number = request.getParameter("phone_number");
        String address = request.getParameter("address");
        userBO.addUser(username, fullname, phone_number,address);
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_name = (String) request.getParameter("productName");
        Float price = Float.parseFloat(request.getParameter("price"));
        String description = (String) request.getParameter("description");
        int vendor_id = Integer.parseInt(request.getParameter("vendor"));
        int category_id = Integer.parseInt(request.getParameter("category"));

        String productName = String.valueOf(System.currentTimeMillis());

        InputStream imageInputStream = request.getPart("image").getInputStream();

        // Thực hiện lưu ảnh vào thư mục upload
        String uploadPath = getServletContext().getRealPath("/") + "upload";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }


        String imageName = productName + "_" + System.currentTimeMillis() + ".jpg";
        Path imagePath = Paths.get(uploadPath, imageName);
        Files.copy(imageInputStream, imagePath, StandardCopyOption.REPLACE_EXISTING);


        productBO.addProduct(product_name, price, description, vendor_id, imagePath.toString(), category_id);
    }

    private void addVendor(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String phone_number = request.getParameter("phone_number");
        userBO.addVendor(username, fullname, phone_number);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String phone_number = request.getParameter("phone_number");
        String address = request.getParameter("address");
        userBO.updateUser(id,username,fullname,phone_number,address);
    }
    private void updateVendor(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String phone_number = request.getParameter("phone_number");
        vendorBO.updateVendor(id,fullname);
        userBO.updateUser(id,username,fullname,phone_number);
    }
}
