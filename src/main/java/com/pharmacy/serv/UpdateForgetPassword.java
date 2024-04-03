package com.pharmacy.serv;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(value = "/UpdateForgetPassword")
public class UpdateForgetPassword extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hello UpdateForgetPassword servlet Invoked");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();
        String mail = (String) session.getAttribute("mail");
        String securityCode = (String) session.getAttribute("securityCode");

        String userCode = req.getParameter("otp");
        String password = req.getParameter("password");

        if(userCode.equals(securityCode)){
            System.out.println("You can change Password");
            boolean isChange = changePassword(mail,password);
            out.println("<html><head></head><body>" +
                    "<h1>Your Data Stored.."+mail+" new password = "+password+"</h1></body></html>");
        }else{
            System.out.println("security code is InValid");
            out.println("<html><head></head><body>" +
                    "<h1>Your Data not Stored.. some error </h1></body></html>");
        }
    }
    static boolean changePassword(String gmail,String password){
        boolean change = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");
            String qur = "update UserDatas set Password = ?where Gmail = ?";

            PreparedStatement preparedStatement = con.prepareStatement(qur);
            preparedStatement.setString(1,password);
            preparedStatement.setString(2,gmail);
            int isUpdate = preparedStatement.executeUpdate();
            if(isUpdate>0){
                change = true;
                System.out.println("user data is updated");
            }else{
                System.out.println("data not updated");
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("some error..");
        }

        return change;
    }
}
