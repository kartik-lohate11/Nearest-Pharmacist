<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pharmacy.bean.MedicanData" %>
<%@ page import="com.pharmacy.bean.MedicalStoreData" %>
<%@ page import="com.pharmacy.Admin.Administrator" %>
<%@ page import="com.pharmacy.Admin.AdminMedicinInfo" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="Styleadmin.css">
    <link rel="stylesheet" type="text/css" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    <title>Admin Dashboard Panel</title>
</head>
<body>

<%


Administrator administrator = (Administrator) session.getAttribute("administrator");
MedicalStoreData adminStore = (MedicalStoreData) session.getAttribute("medicalStoreData");

MedicanData medicanData = new MedicanData();
int id = adminStore.getStoreId();
ArrayList<AdminMedicinInfo> arrayList = medicanData.getAdminMedicinInfo(id);
    int i = 1,count=0,qun=0;
    for (AdminMedicinInfo adminMedicinInfo:arrayList){ count++;
     qun+=adminMedicinInfo.getQuantity();
    }

%>


<nav>
    <div class="logo-name">
        <div class="logo-image">
            <img src="pngtree-medical-logo-vector-png-image_6713322.png" alt="">
        </div>
        <span class="logo_name">My Pharmacy</span>
    </div>

    <div class="menu-items">
        <ul class="nav-links">
            <li><a href="#">
                <i class="uil uil-estate"></i>
                <span class="link-name">Dahsboard</span>
            </a></li>
            <li><a href="InsertMedican.jsp">
                <i class="uil uil-files-landscapes"></i>
                <span class="link-name">Insert Medican</span>
            </a></li>
            <li><a href="DeleteMedicine.jsp">
                <i class="uil uil-chart"></i>
                <span class="link-name">Delete Medican</span>
            </a></li>
            <li><a href="UpdateQuantity.jsp">
                <i class="uil uil-chart"></i>
                <span class="link-name">Update Medican Quantity</span>
            </a></li>
        </ul>
        <ul class="logout-mode">
            <li><a href="index.jsp">
                <i class="uil uil-signout"></i>
                <span class="link-name">Logout</span>
            </a></li>
        </ul>
    </div>
</nav>

<section class="dashboard">
    <div class="top">
        <i class="uil uil-bars sidebar-toggle"></i>

        <div class="search-box" style="text-align: center;">
            <h1><%=administrator.getStoreName().toUpperCase()%></h1>
        </div>

        <img src="photo-1568602471122-7832951cc4c5.avif" alt="">
    </div>

    <div class="dash-content">
        <div class="overview">
            <div class="title">
                <i class="uil uil-tachometer-fast-alt"></i>
                <span class="text">Dashboard</span>
            </div>

            <div class="boxes">
                <div class="box box1">
                    <span class="text">Total Medican</span>
                    <span class="number"><%=count%></span>
                </div>
                <div class="box box2">
                    <span class="text">Total Quantity</span>
                    <span class="number"><%=qun%></span>
                </div>
                <div class="box box3">
                    <span class="text">Total Available Medicans</span>
                    <span class="number"><%=count*qun%></span>
                </div>
            </div>
        </div>

        <div class="activity">
            <div class="title">
                <i class="uil uil-clock-three"></i>
                <span class="text"> Available Medicines</span>
            </div>

            <div class="activity-data">

                <div class="data names">
                    <span class="data-title">Sl Number</span>
                    <% for (AdminMedicinInfo adminMedicinInfo:arrayList){ %>
                    <span class="data-list"><%=i%></span>
                    <% i++; } %>
                </div>
                <div class="data email">
                    <span class="data-title">Name </span>
                    <% for (AdminMedicinInfo adminMedicinInfo:arrayList){ %>
                    <span class="data-list"><%=adminMedicinInfo.getMedicinName()%></span>
                    <% } %>
                </div>
                <div class="data status">
                    <span class="data-title">Quantity</span>
                    <% for (AdminMedicinInfo adminMedicinInfo:arrayList){ %>
                    <span class="data-list"><%=adminMedicinInfo.getQuantity()%></span>
                    <% } %>
                </div>

            </div>
        </div>
    </div>
</section>

<script>
    const body = document.querySelector("body"),
      modeToggle = body.querySelector(".mode-toggle");
      sidebar = body.querySelector("nav");
      sidebarToggle = body.querySelector(".sidebar-toggle");

let getStatus = localStorage.getItem("status");
if(getStatus && getStatus ==="close"){
    sidebar.classList.toggle("close");
}

modeToggle.addEventListener("click", () =>{
    body.classList.toggle("dark");
    if(body.classList.contains("dark")){
        localStorage.setItem("mode", "dark");
    }else{
        localStorage.setItem("mode", "light");
    }
});

sidebarToggle.addEventListener("click", () => {
    sidebar.classList.toggle("close");
    if(sidebar.classList.contains("close")){
        localStorage.setItem("status", "close");
    }else{
        localStorage.setItem("status", "open");
    }
})
</script>
</body>
</html>