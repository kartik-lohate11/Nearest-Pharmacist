package com.pharmacy.serv;

import com.pharmacy.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(value = "/FeedBack")
public class FeedBack extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hello servlet Invoked");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String mail = req.getParameter("email");
        String subject = req.getParameter("subject");
        String message = req.getParameter("message");

        boolean send = sendMessage(mail,mail,subject,message);

        if(send){
            System.out.println("FeedBack send..");
            User user = new User();
            String from = "kartiklohte1112@gmail.com";
            String sub = "Thank You for Your Feedback!";
            String text = "We greatly appreciate you taking the time to share your thoughts with us. Your feedback is invaluable in helping us improve our website and provide a better experience for all our users.";
            System.out.println(text);

            boolean verified = user.sendMail(mail,from,sub,text);
            
            if(verified){
                System.out.println("send mail");
            }else {
                System.out.println("Send not mail");
            }
            resp.sendRedirect("index.jsp");
        }else {
            System.out.println("FeedBack Not Send..");
        }

    }

    private boolean sendMessage(String name, String mail, String subject, String message) {
        boolean send = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");
            String qur = "insert into Feedback(name,gmail,subject,message) value(?,?,?,?)";

            PreparedStatement preparedStatement = con.prepareStatement(qur);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,mail);
            preparedStatement.setString(3,subject);
            preparedStatement.setString(4,message);

            int i = preparedStatement.executeUpdate();

            if(i!=0){
                System.out.println("Data Inserted..");
                send = true;
            }else {
                System.out.println("Data Not Inserted..");
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return send;
    }

}
