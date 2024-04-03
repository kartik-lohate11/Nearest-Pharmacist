package com.pharmacy.bean;

import com.pharmacy.Admin.AdminMedicinInfo;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;

public class MedicanData {

    // Fatch All medican
   public ArrayList<String> getAllMedicanNames(){
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");
            String qur = "select name from MedicanInfo";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(qur);

            while (resultSet.next()){
                String name = resultSet.getString(1);
                arrayList.add(name);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("some erroe");
        }
        return arrayList;
    }

    public int getMedicalId(String medicin){
       int i=0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");
            String qur = "select * from MedicanInfo where name=?";

            PreparedStatement preparedStatement = con.prepareStatement(qur);
            preparedStatement.setString(1,medicin);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                i = resultSet.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("some erroe");
        }

       return i;
    }

    // fatch The all medicalStore Data into arrayList
    public ArrayList<MedicalStoreData> medicalStoreData() {
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
                imageFatched(name);
                MedicalStoreData medicalStoreData = new MedicalStoreData(name,address,phone,lat,longt,about);
                arrayList.add(medicalStoreData);
            }
            System.out.println("data Fatched");

        }catch (Exception e){
            e.printStackTrace();
        }
        return arrayList;
    }

    // get one required medical store
    public ArrayList<MedicalStoreData> medicalStore(String medicalStore) {
        System.out.println("One Medical Store Data");
        ArrayList<MedicalStoreData> arrayList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");

            String qur = "select * from MedicalStore";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(qur);
            while (resultSet.next()){
                if(medicalStore.equals(resultSet.getString(2))) {
                    int storeid = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String mail = resultSet.getString(3);
                    String address = resultSet.getString(4);
                    String phone = resultSet.getString(5);
                    String lat = resultSet.getString(6), longt = resultSet.getString(7);
                    String about = resultSet.getString(8);
                    imageFatched(name);
                    MedicalStoreData medicalStoreData = new MedicalStoreData(name, address, phone, lat, longt, about);
                    medicalStoreData.setStoreId(storeid);
                    arrayList.add(medicalStoreData);
                }
            }
            System.out.println("data Fatched");

        }catch (Exception e){
            e.printStackTrace();
        }
        return arrayList;
    }

    // get all avilable medical store at the respect of medican
    public  ArrayList<MedicalStoreData> getRequiredMedicalStore(String medican) {
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
                imageFatched(name); // fatch The stores Images
                MedicalStoreData medicalStoreData = new MedicalStoreData(name,address,phone,lat,longt,about);
                arrayList.add(medicalStoreData);
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return arrayList;
    }
 private boolean imageFatched(String storename){
       boolean isTrue = false;
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");
           String qur = "select image from MedicalStore where storeName = ?";
           String path = "D:\\SERVLET\\pharmacy\\src\\main\\webapp\\Images\\"+storename+".jpg";
           PreparedStatement preparedStatement = con.prepareStatement(qur);
           preparedStatement.setString(1,storename);
           ResultSet resultSet = preparedStatement.executeQuery();
           if(resultSet.next()){
               byte[] imgData = resultSet.getBytes(1);
               OutputStream outputStream = new FileOutputStream(path);
               outputStream.write(imgData);
               isTrue = true;
           }
       }catch (Exception e){
           e.printStackTrace();
       }

       return isTrue;
 }

 // get Admin Medicin Data..
    public ArrayList<AdminMedicinInfo> getAdminMedicinInfo(int id){
       ArrayList<AdminMedicinInfo> arrayList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");
            String qur = "select MedicanInfo.name,store_medicine.quantity from MedicalStore join store_medicine on store_medicine.store_id = MedicalStore.userId join MedicanInfo on MedicanInfo.id=store_medicine.medicine_id where MedicalStore.userId=?";
            PreparedStatement preparedStatement = con.prepareStatement(qur);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString(1);
                int quen = resultSet.getInt(2);
                AdminMedicinInfo adminMedicinInfo = new AdminMedicinInfo(name,quen);
                arrayList.add(adminMedicinInfo);
            }
            System.out.println("Admin Medinic Data fatched");
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
            return arrayList;
    }

}
