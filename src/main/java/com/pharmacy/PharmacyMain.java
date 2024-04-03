package com.pharmacy;

import com.pharmacy.Admin.AdminChanges;
import com.pharmacy.bean.MedicalStoreData;
import com.pharmacy.bean.MedicanData;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class PharmacyMain {

    public static String generateOTP(){
        Random random = new Random();
        int otp = random.nextInt(999999);
        return  String.format("%6d",otp);
    }

    public static void main(String[] args) {

//        ApiDataGet temWork = new ApiDataGet();
//        temWork.SolveApi();
        MedicanData medicanData = new MedicanData();
//        ArrayList<MedicalStoreData> arrayList = new ArrayList<>();
//        String medican = "paracetamol";
//        arrayList = getRequiredMedicalStore(medican);
        System.out.println(generateOTP());
//        System.out.println("Id = "+medicanData.getMedicalId("Ciprofloxacin"));
        AdminChanges adminChanges = new AdminChanges();
        System.out.println(" the = "+adminChanges.verifyMedican("paracetamol"));




//            while (resultSet.next()) {
//              String name = resultSet.getString(2);
//              String gmail = resultSet.getString(3);
//              String address = resultSet.getString(4);
//              String phone = resultSet.getString(5);
//              String longitude = resultSet.getString(6);
//              String latitude = resultSet.getString(7);
//              String about = resultSet.getString(8);
//
//              System.out.println("name = "+name+" and long = "+longitude+" and lat = "+longitude);
//            }

    }

    private static ArrayList<MedicalStoreData> getRequiredMedicalStore(String medican) {
        ArrayList<MedicalStoreData> arrayList = new ArrayList<>();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");

                String qur = "select * from MedicalStore join store_medicine on store_medicine.store_id = MedicalStore.userId join MedicanInfo on MedicanInfo.id=store_medicine.medicine_id where MedicanInfo.name=?";
                PreparedStatement preparedStatement = con.prepareStatement(qur);
                preparedStatement.setString(1,medican);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    String name = resultSet.getString(2);
                    String mail = resultSet.getString(3);
                    String address = resultSet.getString(4);
                    String phone = resultSet.getString(5);
                    String lat = resultSet.getString(6),longt = resultSet.getString(7);
                    String about = resultSet.getString(8);

                    MedicalStoreData medicalStoreData = new MedicalStoreData(name,address,phone,lat,longt,about);
                    arrayList.add(medicalStoreData);
                }

                con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return arrayList;
    }

    public static ArrayList<MedicalStoreData> medicalStoreData() {
        System.out.println("get Medical Store Data");
        ArrayList<MedicalStoreData> arrayList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");

            String qur = "select * from MedicalStore";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(qur);
            while (resultSet.next()){
                String name = resultSet.getString(2);
                String mail = resultSet.getString(3);
                String address = resultSet.getString(4);
                String phone = resultSet.getString(5);
                String lat = resultSet.getString(6),longt = resultSet.getString(7);
                String about = resultSet.getString(8);

                MedicalStoreData medicalStoreData = new MedicalStoreData(name,address,phone,lat,longt,about);
                arrayList.add(medicalStoreData);
            }
            for(MedicalStoreData medicalStoreData:arrayList){
                System.out.println("name = "+medicalStoreData.getName());
            }
            System.out.println("data Fatched");

        }catch (Exception e){
            e.printStackTrace();
        }
          return arrayList;
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
