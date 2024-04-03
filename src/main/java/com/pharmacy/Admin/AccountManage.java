package com.pharmacy.Admin;

import com.pharmacy.bean.MedicalStoreData;
import com.pharmacy.bean.MedicanData;
import com.pharmacy.bean.User;

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
import java.sql.ResultSet;
import java.util.ArrayList;

import static com.pharmacy.PharmacyMain.generateOTP;

@WebServlet(value = "/AccountManage")
@MultipartConfig(maxFileSize = 16177215)
public class AccountManage extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hello AccountManage servlet Invoked");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        String fromType = req.getParameter("formtype");
        System.out.println("type = "+fromType);

        if(fromType.equals("loginAccount")){
            // Admin Login Verification
            String storeName = req.getParameter("store_name");
            String password = req.getParameter("password");
            String gmail = req.getParameter("email");
            Administrator administrator = new Administrator(storeName,password,gmail);
            MedicalStoreData adminStore = adminStoreData(storeName,password,gmail);
            session.setAttribute("administrator",administrator);
            session.setAttribute("medicalStoreData",adminStore);
            System.out.println("Admin verified");
            // if get admin and it's StoreData the move to AdminDashboard
            resp.sendRedirect("AdminDashboard.jsp");
        }else if(fromType.equals("createAccount")){
            // Store The Data of Admin and it's Store Data.
            System.out.println("Store Admin Details");
            String storeName = req.getParameter("storeName");
            String gmail = req.getParameter("gmail");
            String password = req.getParameter("password");
            String  phone = req.getParameter("phone");
            String latitude = req.getParameter("lat");
            String longitude = req.getParameter("longt");

            Part storeImage = req.getPart("image");
            InputStream fileInputStream = storeImage.getInputStream();

            String address = req.getParameter("address");
            String about = "it is very best Medical To provide all medican.";
            Administrator administrator = new Administrator(storeName,password,gmail);
            MedicalStoreData medicalStoreData = new MedicalStoreData(storeName,address,phone,latitude,longitude,about);

            if(storeImage==null){
                System.out.println("image is NUll");
            }
            // send Otp to Admin Valid mail address..
            String otp = generateOTP();
            User user = new User();
            String from = "kartiklohte1112@gmail.com";
            String sub = "Sending Mail Verify This !";
            String text = "This is MyPharmacy welcome to you Your Verification code is  ";
            text+=otp;
            System.out.println(text);

            boolean verified = user.sendMail(gmail,from,sub,text);
            if(verified){
                System.out.println("Mail send Succesfully");
                session.setAttribute("otp",otp);
            }else{
                System.out.println("Mail not send..");
            }
            session.setAttribute("storeImage",fileInputStream);
            session.setAttribute("administrator",administrator);
            session.setAttribute("medicalStoreData",medicalStoreData);

            System.out.println("Name = "+medicalStoreData.getName()+" and lati = "+medicalStoreData.getLongitude());
            System.out.println("Data get");
            resp.sendRedirect("AdminOTP.html");
        }else{
            System.out.println("some Not get");
        }

    }

    // Admin Verification The get it's Store Data.
    private MedicalStoreData adminStoreData(String storeName, String password, String gmail) {
        MedicalStoreData adminStore = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");
            String qur = "select id from Admin where storeName=?";
            PreparedStatement preparedStatement = con.prepareStatement(qur);
            preparedStatement.setString(1,storeName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                System.out.println("Admin Logined");
                MedicanData storeData = new MedicanData();
                ArrayList<MedicalStoreData> arrayList = new ArrayList<>();
                arrayList = storeData.medicalStore(storeName);
                adminStore = arrayList.get(0);
                System.out.println("Storeid = "+adminStore.getStoreId());
            } else{
                System.out.println("Medical Store Not Found..");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Admin Not Fount");
        }
         return adminStore;
    }
}
