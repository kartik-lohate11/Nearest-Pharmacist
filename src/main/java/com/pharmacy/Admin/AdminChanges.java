package com.pharmacy.Admin;

import com.pharmacy.bean.MedicalStoreData;
import com.pharmacy.bean.MedicanData;

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
import java.sql.ResultSet;

@WebServlet(value = "/AdminChanges")
public class AdminChanges extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hello AdminChanges servlet Invoked");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        String requestType = req.getParameter("request");

        if(requestType.equals("insert")){
            String medicineName = req.getParameter("medicineName");
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            boolean verifyMedican = verifyMedican(medicineName); //this verify medican has or not in parent table if not then insert it
            if(verifyMedican){
                boolean isInsert = InsertMedican(medicineName,quantity,session);
                resp.sendRedirect("AdminDashboard.jsp");
            }else{
                System.out.println("Some error in medican verificatio..");
            }
        }else if(requestType.equals("delete")){
            String mediName = req.getParameter("medicineName");
            // delete the specific medican
            boolean isDeleted = deleteAdminMedican(mediName,session);
            if(isDeleted){
                System.out.println("Medican deleter");
                resp.sendRedirect("AdminDashboard.jsp");
            }else{
                System.out.println("Medican Not deleter or not present");
            }
        }else if(requestType.equals("update")){
            String name = req.getParameter("medicineName");
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            boolean update = updateQuantity(name,quantity,session);
            if(update){
                System.out.println("Quantity Updated");
                resp.sendRedirect("AdminDashboard.jsp");
            }else{
                System.out.println("Medican Not Present..");
            }

        }else{
            System.out.println("Request Invalid");
        }
    }

    private boolean updateQuantity(String medicineName, int quantity, HttpSession session) {
        boolean update = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");

            // Update query
            String updateQuery = "UPDATE store_medicine SET quantity = ? WHERE store_id = ? AND medicine_id = ?";

            MedicalStoreData adminStore = (MedicalStoreData) session.getAttribute("medicalStoreData");
            MedicanData medicanData = new MedicanData();
            int medicineId = medicanData.getMedicalId(medicineName);
            int storeId = adminStore.getStoreId();

            PreparedStatement updateStatement = con.prepareStatement(updateQuery);
            updateStatement.setInt(1, quantity);
            updateStatement.setInt(2, storeId);
            updateStatement.setInt(3, medicineId);

            int rowsAffected = updateStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Medicine quantity updated successfully");
                update = true;
            } else {
                System.out.println("No medicine found for the given store and medicine id");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some error occurred");
        }

        return update;
    }

    private boolean deleteAdminMedican(String medicineName, HttpSession session) {
        boolean deleted = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");
            String deleteQuery = "DELETE FROM store_medicine WHERE store_id=? and medicine_id=?";

            MedicalStoreData adminStore = (MedicalStoreData) session.getAttribute("medicalStoreData");
            MedicanData medicanData = new MedicanData();
            int medicanId = medicanData.getMedicalId(medicineName);
            int storeId = adminStore.getStoreId();

            PreparedStatement preparedStatement = con.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, storeId);
            preparedStatement.setInt(2,medicanId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Medicine '" + medicineName + "' deleted successfully");
                deleted = true;
            } else {
                System.out.println("Medicine '" + medicineName + "' not found");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some error occurred");
        }
        return deleted;
    }

    private boolean InsertMedican(String medicineName, int quantity, HttpSession session) {
        boolean isInsert = false;
        MedicalStoreData adminStore = (MedicalStoreData) session.getAttribute("medicalStoreData");
        MedicanData medicanData = new MedicanData();
        int medicanId = medicanData.getMedicalId(medicineName);
        int storeId = adminStore.getStoreId();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");
            String qur = "insert into store_medicine value(?,?,?)";

            PreparedStatement preparedStatement = con.prepareStatement(qur);
            preparedStatement.setInt(1,storeId);
            preparedStatement.setInt(2,medicanId);
            preparedStatement.setInt(3,quantity);

            int i = preparedStatement.executeUpdate();

            if(i!=0){
                System.out.println("Data Inserted..");
                isInsert = true;
            }else {
                System.out.println("Data Not Inserted..");
            }
             con.close();
        }catch (Exception e){
            e.printStackTrace();
        }

            return isInsert;
    }

    public boolean verifyMedican(String medicineName) {
        boolean storeMedican = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temProjectWork", "root", "root");
            String qur = "select name from MedicanInfo where name=?";

            PreparedStatement preparedStatement;

            preparedStatement = con.prepareStatement(qur);
            preparedStatement.setString(1,medicineName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(!resultSet.next()){
                String qur1 = "insert into MedicanInfo(name) value(?)";
                preparedStatement = con.prepareStatement(qur1);
                preparedStatement.setString(1,medicineName);
                preparedStatement.executeUpdate();
                System.out.println("Medican Stored");
            }else{
                System.out.println("Medican Allready Present ");
            }
            storeMedican = true;
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("some erroe");
        }
        return storeMedican;
    }
}
