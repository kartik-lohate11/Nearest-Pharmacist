package com.pharmacy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class PharmacyMain {

    public static String generateOTP(){
        Random random = new Random();
        int otp = random.nextInt(999999);
        return  String.format("%6d",otp);
    }

    public static void main(String[] args) {

//        User user = new User();
//        String from = "kartiklohte1112@gmail.com";
//        String to = "kartiklohteofficial@gmail.com";
//        String sub = "Sending Mail Verify This !";
//        String text = "i am kartik lohate your OTP is ";
//
//        String otp = generateOTP();
//        System.out.print("Otp = "+otp);
//        text+=otp;
//
//       // System.out.println(text);
//
//        boolean verified = user.sendMail(to,from,sub,text);
//
//        if(verified) {
//            System.out.print("Email Send SuccesFully..");
//        }else {
//            System.out.print("Some Error Verifiy This..");
//        }

        System.out.println(generateOTP());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");
            String qur = "insert into UserDatas(Username,Gmail,Password,PhoneNo,address) values(?,?,?,?,?)";
            String stqur = "select Username,Password from UserDatas";

//            String name="kartik lohate",gmail="kartik2gmail.com",password = "12345678",phone = "9988776655",address = "bhopal787";
//            PreparedStatement preparedStatement = con.prepareStatement(qur);
//            preparedStatement.setString(1,name);
//            preparedStatement.setString(2, gmail);
//            preparedStatement.setString(3,password);
//            preparedStatement.setString(4,phone);
//            preparedStatement.setString(5,address);
//
//            preparedStatement.executeUpdate();

//            Statement statement = con.createStatement();
//            ResultSet res = statement.executeQuery(stqur);
//            while ((res.next())){
//                System.out.println("name = "+res.getString(1)+" and password = "+res.getString(2));
//            }
            Solve();

//            System.out.println("data Inserted");
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void Solve(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");
            //  String qur = "select Gmail,Password from UserDatas where Gmail=? and Password=?";
//            String qur = "select Username,Gmail,Password,PhoneNo,address from UserDatas";
            String gmail="hello@gmail.com",password="kartik2003";
            String qur = "update UserDatas set Password = ?where Gmail = ?";

            PreparedStatement preparedStatement = con.prepareStatement(qur);
            preparedStatement.setString(1,password);
            preparedStatement.setString(2,gmail);
            int isUpdate = preparedStatement.executeUpdate();
            if(isUpdate>0){
                System.out.println("user data is updateed");
            }else{
                System.out.println("data not updated");
            }
            System.out.println("data updated..");

//            Statement statement = con.createStatement();
//            ResultSet resultSet = statement.executeQuery(qur);


//            while (resultSet.next()){
//                if(resultSet.getString(2).equals(gmail) && resultSet.getString(3).equals(password)){
//                    String name = resultSet.getString(1);
//                    String phone = resultSet.getString(4);
//                    String address = resultSet.getString(5);
//
//                    UserData user = new UserData(name,gmail,address,phone,password,"#nologin");
//                    System.out.println("name = "+user.getName()+" and password = "+user.getPassword()+" address = "+user.getAddress());
//                    System.out.println("Data Storted");
//                }
//            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
