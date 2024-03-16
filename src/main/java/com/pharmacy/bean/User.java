package com.pharmacy.bean;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class User {

    public boolean sendMail(String to, String from, String sub, String text) {

        boolean flag = false;
        final String user = "kartiklohte1112";
        final String password = "qqtg vqyr yjvo plei";

        Properties pr = new Properties();
        pr.put("mail.smtp.auth", true);
        pr.put("mail.smtp.starttls.enable", true);
        pr.put("mail.smtp.port", "587");
        pr.put("mail.smtp.host", "smtp.gmail.com");


        // create a session
        Session sec = Session.getInstance(pr, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        });

        try {
            Message msg = new MimeMessage(sec);
            msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            msg.setFrom(new InternetAddress(from));
            msg.setSubject(sub);
            msg.setText(text);

            Transport.send(msg);
            flag = true;

        }catch (Exception e){
            e.printStackTrace();
        }


        return flag;
    }
}