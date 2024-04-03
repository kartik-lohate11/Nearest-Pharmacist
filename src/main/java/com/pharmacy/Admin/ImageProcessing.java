package com.pharmacy.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(value = "/ImageProcessing")
@MultipartConfig(maxFileSize = 16177215)
public class ImageProcessing extends HttpServlet  {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");

        Part file = req.getPart("image");
        String name = req.getParameter("storename");
        if(file!=null){
            InputStream fileInputStream = file.getInputStream();
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");
//                String qur = "insert into images(id,img) value(?,?)";
//                PreparedStatement preparedStatement = con.prepareStatement(qur);
//                preparedStatement.setInt(1,1);
//                preparedStatement.setBlob(2,fileInputStream);
//                preparedStatement.executeUpdate();
//                System.out.println("Data Inserted..");

//                String qur = "select img from images where id = ?";
//                String path = "D:\\SERVLET\\pharmacy\\src\\main\\webapp\\Images\\"+"kartik.jpg";
//                PreparedStatement preparedStatement = con.prepareStatement(qur);
//                preparedStatement.setInt(1,1);
//                ResultSet resultSet = preparedStatement.executeQuery();
//                if(resultSet.next()){
//                    byte[] imgData = resultSet.getBytes(1);
//                    OutputStream outputStream = new FileOutputStream(path);
//                    outputStream.write(imgData);
//                    resp.sendRedirect("TemWork2.jsp");
//                }
                String qur = "update MedicalStore set image=? where storeName=?";

                PreparedStatement preparedStatement = con.prepareStatement(qur);
                preparedStatement.setString(2,name);
                preparedStatement.setBlob(1,fileInputStream);
                int isUpdate = preparedStatement.executeUpdate();
                if(isUpdate>0){
                    System.out.println("Images is Updated of "+name);
                }else{
                    System.out.println("data not updated");
                }
                con.close();
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Some Error..");
            }
        }else {
            System.out.println("Some error ...");
        }

    }
}
