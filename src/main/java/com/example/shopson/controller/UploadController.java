package com.example.shopson.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;
import java.nio.file.Paths;

@WebServlet("/upload")
@MultipartConfig
public class UploadController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("login.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">

            // Get the filename and extension
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            // Save the image locally
            String relativePath = "src/main/webapp/WEB-INF/images";
            String uploadPath = (new File(relativePath)).getAbsolutePath();
            System.out.println("path " + uploadPath);
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }


            String filePath = uploadPath + File.separator + fileName;
            try (InputStream fileContent = filePart.getInputStream();
                 OutputStream os = new FileOutputStream(filePath)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fileContent.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("File uploaded to: " + filePath);

            // Optionally, you can store the file path in the database
            // Replace the following code with your actual database connection and insertion logic

            /*
            Connection con = YourDatabaseConnectionFactory.getConnection();
            try (PreparedStatement ps = con.prepareStatement("INSERT INTO your_table (description, image_link) VALUES (?, ?)")) {
                ps.setString(1, request.getParameter("description")); // Assuming you have a form field named "description"
                ps.setString(2, "images/" + fileName);
                ps.executeUpdate();
            } finally {
                con.close();
            }
            */
            request.setAttribute("imagePath", filePath);
            RequestDispatcher rd = request.getRequestDispatcher("/test.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirect to an error page
        }
    }
}
