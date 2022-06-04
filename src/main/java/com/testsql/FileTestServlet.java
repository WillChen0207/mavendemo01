package com.testsql;

import java.io.IOException;
import java.io.Serial;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/addProduct")
@MultipartConfig(
        fileSizeThreshold = 1024*1024,
        location = "E:\\wwwroot\\127.0.0.1\\mavendemo01\\attachment",
        maxFileSize = 1024*1024*5,
        maxRequestSize = 1024*1024*5
)
public class FileTestServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final String INTEGER = null;
    static String driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/testsql?useSSL=false&serverTimezone=UTC";
    static final String username = "root";
    static final String password = "root";

    public FileTestServlet() {
        super();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        int pid = addProduct(product);
        Collection <Part> parts=request.getParts();
        for(Part part:parts) {
            System.out.println(part.getHeader("content-disposition"));
            if(part.getSubmittedFileName()!=null && !part.getSubmittedFileName().equals("")) {
                String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
                String filename = timestamp + part.getSubmittedFileName();
                String suffix = part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf('.'));
                String type = part.getContentType();
                long size = part.getSize();
                String filename_hash = fileNameFormat(filename);
                System.out.println(filename_hash.length());
                part.write(filename_hash);
                addImageByProduct(filename_hash,suffix,type,size,pid);
            }
        }
    }

    private void addImageByProduct(String name,String suffix,String type,long size,int pid) {
        try {
            String sql = "{call image_insert_wish_product_id(?,?,?,?,?)}";
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            CallableStatement cstmt = connection.prepareCall(sql);
            cstmt.setString(1,name);
            cstmt.setString(2,suffix);
            cstmt.setString(3,type);
            cstmt.setLong(4,size);
            cstmt.setInt(5, pid);
            cstmt.execute();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private int addProduct(String product) {
        int pid = 0;

        try {
            String sql = "{call product_insert(?,?)}";
            CallableStatement cstmt = DBUtil.getConnection().prepareCall(sql);
            cstmt.setString(1,product);
            cstmt.registerOutParameter(2,Types.INTEGER);
            cstmt.execute();
            pid =cstmt.getInt(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pid;

    }


    private String fileNameFormat(String filename) {
        String suffix = filename.substring(filename.lastIndexOf('.'));
        String filename_hash = DigestUtils.sha256Hex(filename)+suffix;
        return filename_hash;
    }

}
