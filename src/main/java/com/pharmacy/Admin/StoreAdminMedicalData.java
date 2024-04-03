package com.pharmacy.Admin;

import com.pharmacy.bean.MedicalStoreData;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(value = "/StoreAdminMedicalData")
@MultipartConfig(maxFileSize = 16177215)
public class StoreAdminMedicalData extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hello AccountManage servlet Invoked");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String isOtp = req.getParameter("otp");
        HttpSession session = req.getSession();

        String otp = (String) session.getAttribute("otp");
        if(isOtp.equals(otp)){
            System.out.println("Admin Verified");
            Administrator administrator = (Administrator) session.getAttribute("administrator");
            MedicalStoreData medicalStoreData = (MedicalStoreData) session.getAttribute("medicalStoreData");
            InputStream image = (InputStream) session.getAttribute("storeImage");
            boolean a = adminDataStored(administrator);
            boolean b = medicalDataStored(medicalStoreData,image,administrator.getGmail());
            if(a && b){
                System.out.println("Data Stored...");
            }else{
                System.out.println("Data Not Stored..");
            }
        }else{
            System.out.println("Otp Invalid");
        }
    }

    private boolean medicalDataStored(MedicalStoreData medicalStoreData, InputStream image,String gmail) {
        boolean isStored = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");

            String name = medicalStoreData.getName();
            String address = medicalStoreData.getAddress();
            String phone = medicalStoreData.getPhoneNo();
            String about = medicalStoreData.getAbout();
            String latitude = medicalStoreData.getLatitude();
            String longitude = medicalStoreData.getLongitude();

            String qur = "insert into MedicalStore(storeName,gmail,address,phoneNo,longitude,latitude,aboutStore,image) value(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(qur);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,gmail);
            preparedStatement.setString(3,address);
            preparedStatement.setString(4,phone);
            preparedStatement.setString(5,latitude);
            preparedStatement.setString(6,longitude);
            preparedStatement.setString(7,about);
            preparedStatement.setBlob(8,image);

            int i = preparedStatement.executeUpdate();

            if(i!=0){
                System.out.println("Medical Data Store..");
                isStored = true;
            }else{
                System.out.println("Medical Data Not Stored..");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
            return isStored;
    }

    private boolean adminDataStored(Administrator administrator) {
        boolean isStored = false;
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");

                String name = administrator.getStoreName();
                String password = administrator.getPassword();

                String qur = "insert into Admin(storeName,password) value(?,?)";
                PreparedStatement preparedStatement = con.prepareStatement(qur);
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,password);
                int i =  preparedStatement.executeUpdate();

                if(i!=0){
                    isStored = true;
                    System.out.println("Admin data Stored");
                }else{
                    System.out.println("Admin data not Stored");
                }

            }catch (Exception e){
            e.printStackTrace();
            System.out.println("Admin Error..");
        }

        return isStored;
    }

}
