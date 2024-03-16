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
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(value = "/LoginUser")
public class LoginUser extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hello StoreUserData servlet Invoked");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        String gmail = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println("realName = "+gmail+" and password = "+password);

        UserData isUser = userVerfication(gmail,password);
        if(isUser!=null){
            session.setAttribute("userInfo",isUser);
            out.println("<html><head></head><body>" +
                    "<h1>You Logined succesfully welcome  "+isUser.getName()+"</h1></body></html>");
        }else{
            System.out.println("user not registed");
            out.println("<html><head></head><body>" +
                    "<h1>You Not Logined first Create a account..</h1></body></html>");
        }
     }
     public UserData userVerfication(String gmail,String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");
            String qur = "select Username,Gmail,Password,PhoneNo,address from UserDatas";
          //  String igmail="hello@gmail.com",ipassword="23445566";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(qur);

            while (resultSet.next()){
                if(resultSet.getString(2).equals(gmail) && resultSet.getString(3).equals(password)){
                  String name = resultSet.getString(1);
                  String phone = resultSet.getString(4);
                  String address = resultSet.getString(5);

                  UserData user = new UserData(name,gmail,address,phone,password,"#nologin");
                  System.out.println("name = "+user.getName()+" and password = "+user.getPassword());
                  System.out.println("Data Storted");

                  return user;
                }
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
     }
    }
