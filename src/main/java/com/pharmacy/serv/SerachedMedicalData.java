package com.pharmacy.serv;

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
import java.util.ArrayList;

@WebServlet(value = "/SerachedMedicalData")
public class SerachedMedicalData extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("SerachedMedicalData servlet Invoked");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String category = req.getParameter("category");
        String search = req.getParameter("search");
        MedicanData medicanData = new MedicanData();
        HttpSession session = req.getSession();
        ArrayList<MedicalStoreData> arrayList = new ArrayList<>();

        if(category.equals("medical_store")){
            arrayList = medicanData.medicalStore(search);
        }else if(category.equals("medicine")){
           arrayList = medicanData.getRequiredMedicalStore(search);
        }else if(category.equals("all")){
            arrayList = medicanData.medicalStoreData();
        }
        session.setAttribute("arrayList",arrayList);
        resp.sendRedirect("SetUserLocation.html");
      }
}
