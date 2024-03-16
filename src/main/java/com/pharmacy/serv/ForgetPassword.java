package com.pharmacy.serv;

import com.pharmacy.PharmacyMain;
import com.pharmacy.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/ForgetPassword")
public class ForgetPassword extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hello StoreUserData servlet Invoked");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        String gmail = req.getParameter("email");
        String mainMail = "kartiklohte1112@gmail.com";
        String securityCode = PharmacyMain.generateOTP();
        String from = "kartiklohte1112@gmail.com";
        String sub = "Sending Mail gmail Address Verify...!";
        String text = "You Forget Your Password.. so Get Your Security Code "+securityCode+"to modify your password";

        User user = new User();
        boolean isSendCode = user.sendMail(gmail,mainMail,sub,text);

        if(isSendCode){
            session.setAttribute("mail",gmail);
            session.setAttribute("securityCode",securityCode);
            System.out.println("send Security Code...");
            resp.sendRedirect("SecurityCode.jsp");
        }else{
            System.out.println("not some error");
        }


    }
}
