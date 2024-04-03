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

        String gmail = req.getParameter("gmail");
        String password = req.getParameter("password");
        System.out.println("realName = "+gmail+" and password = "+password);

        UserData isUser = userVerfication(gmail,password);
        if(isUser!=null){
            session.setAttribute("userInfo",isUser);
            resp.sendRedirect("index.jsp");
        }else{
            System.out.println("user not registed");
            out.println("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "<meta charset=\"UTF-8\">\n" +
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "<title>User Not Found</title>\n" +
                    "<style>\n" +
                    "    body {\n" +
                    "        font-family: Arial, sans-serif;\n" +
                    "        margin: 0;\n" +
                    "        padding: 0;\n" +
                    "        background-color: #f9f9f9;\n" +
                    "        color: #333;\n" +
                    "    }\n" +
                    "    \n" +
                    "    .container {\n" +
                    "        max-width: 600px;\n" +
                    "        margin: 50px auto;\n" +
                    "        padding: 20px;\n" +
                    "        background-color: #fff;\n" +
                    "        border-radius: 10px;\n" +
                    "        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
                    "        text-align: center;\n" +
                    "    }\n" +
                    "    \n" +
                    "    h1 {\n" +
                    "        color: #3c9cdb;\n" +
                    "        margin-bottom: 20px;\n" +
                    "    }\n" +
                    "    \n" +
                    "    p {\n" +
                    "        margin-bottom: 20px;\n" +
                    "    }\n" +
                    "    \n" +
                    "    a {\n" +
                    "        text-decoration: none;\n" +
                    "        color: #fff;\n" +
                    "        background-color: #3c9cdb;\n" +
                    "        padding: 10px 20px;\n" +
                    "        border-radius: 5px;\n" +
                    "        transition: background-color 0.3s ease;\n" +
                    "    }\n" +
                    "    \n" +
                    "    a:hover {\n" +
                    "        background-color: #2975a7;\n" +
                    "    }\n" +
                    "</style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<div class=\"container\">\n" +
                    "    <h1>User Not Found</h1>\n" +
                    "    <p>The email or password you entered is incorrect. Please check your credentials and try again.</p>\n" +
                    "    <a href=\"Login.html\">Back to Login Page</a>\n" +
                    "</div>\n" +
                    "</body>\n" +
                    "</html>\n");
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
