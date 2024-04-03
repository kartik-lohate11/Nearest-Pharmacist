package com.pharmacy.serv;

import com.pharmacy.bean.ApiDataGet;
import com.pharmacy.bean.MedicalStoreData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@WebServlet(value = "/UserLocation")
public class UserLocation extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("hello StoreUserData servlet Invoked");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String state = req.getParameter("state");
        String city = req.getParameter("city");
        String lat = req.getParameter("latitude");
        String longt = req.getParameter("longitude");

        if(lat==null || longt==null){
            out.print("<h1>Please Verify Your Location</h1>");
            resp.sendRedirect("SetUserLocation.html");
        }
        System.out.println("User = "+state+" , "+city+" and "+lat+","+longt);

        // Update ArrayList With Distance & time Between User And Required Medical Store
        HttpSession session = req.getSession();

        session.setAttribute("userLatitude",lat);
        session.setAttribute("userLongitude",longt);
        String userLocation = lat+","+longt;

        ArrayList<MedicalStoreData> arrayList = (ArrayList<MedicalStoreData>) session.getAttribute("arrayList");
        arrayList = getDistanceAndTime(arrayList,userLocation);
        Collections.sort(arrayList, new Comparator<MedicalStoreData>() {
            @Override
            public int compare(MedicalStoreData o1, MedicalStoreData o2) {
                return Long.compare(o1.getDistance(),o2.getDistance());
            }
        });
        resp.sendRedirect("ListofPhary.jsp");

    }

    private ArrayList<MedicalStoreData> getDistanceAndTime(ArrayList<MedicalStoreData> arrayList,String userLocation) {

        for(MedicalStoreData arr:arrayList){
            String medicalLocation = arr.getLatitude()+","+arr.getLongitude();
            ApiDataGet apiDataGet = new ApiDataGet();
            apiDataGet.SolveApi(userLocation,medicalLocation);
            long dis = apiDataGet.getDistance();
            long dur = apiDataGet.getDuration();
            String statue = apiDataGet.getPrintStatus();

            arr.setDistance(dis);
            arr.setDuration(dur);
            arr.setPresentStatus(statue);
        }

        return  arrayList;
    }
}
