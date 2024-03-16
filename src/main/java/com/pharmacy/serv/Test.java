package com.pharmacy.serv;

import com.pharmacy.bean.User;
import com.pharmacy.bean.UserData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static com.pharmacy.PharmacyMain.generateOTP;


@WebServlet(value = "/userVerification")
public class Test extends HttpServlet {
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hello servlet Invoked");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

         User user = new User();
         HttpSession session = req.getSession();

         String name = req.getParameter("username");
         String gmail = req.getParameter("gmail");
         String password = req.getParameter("password");
         String address = req.getParameter("address");
         String phone = req.getParameter("phone");

         String otp = generateOTP();

         // assign userdata to UserData Class
         UserData udata = new UserData(name,gmail,address,phone,password,otp);

         String from = "kartiklohte1112@gmail.com";
         String sub = "Sending Mail Verify This !";
         String text = "i am kartik lohate your OTP is ";
         text+=otp;
         System.out.println(text);

         boolean verified = user.sendMail(gmail,from,sub,text);

         if(verified) {
             System.out.print("Email Send SuccesFully..");
             session.setAttribute("userInfo",udata);
             resp.sendRedirect("otpVerify.html");
         }else {
             System.out.print("Some Error");
         }

     }

}
