package com.pharmacy.serv;

import com.pharmacy.bean.UserData;

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
import java.sql.SQLException;

@WebServlet(value = "/StoreUserData")
public class StoreUserData extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hello StoreUserData servlet Invoked");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        String isCode = req.getParameter("otp");

        UserData user = (UserData) session.getAttribute("userInfo");

        System.out.println("otp = "+user.getCode()+" and userOtp = "+isCode);

        if(user.getCode().equals(isCode)){
            try {
                boolean isStored = dataStored(user);
                if(isStored){
                    out.println("<html><head></head><body>" +
                            "<h1>Your Data Stored.."+user.getName()+"</h1></body></html>");
                }else {
                    out.println("<html><head></head><body>" +
                            "<h1>Your Data not Stored.."+user.getName()+"</h1></body></html>");
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }else{
            out.println("<html><head></head><body>" +
                    "<h1>SORRY But Your Otp is Invalid Check Again... "+user.getName()+"</h1></body></html>");

        }
    }
    public boolean dataStored(UserData user) throws ClassNotFoundException, SQLException {
        boolean isStored = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");
            String qur = "insert into UserDatas(Username,Gmail,Password,PhoneNo,address) values(?,?,?,?,?)";

            PreparedStatement preparedStatement = con.prepareStatement(qur);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2, user.getGmail());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getPhone());
            preparedStatement.setString(5,user.getAddress());

            preparedStatement.executeUpdate();
            System.out.println("data Inserted");
            isStored = true;
            con.close();
            System.out.println("name = "+user.getName()+" password = "+user.getPassword());

        }catch (Exception e){
            e.printStackTrace();
        }
        return isStored;
    }
}
