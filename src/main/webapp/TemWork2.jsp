<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pharmacy.bean.MedicanData" %>
<%@ page import="java.sql.*" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Medical Search</title>
    <style>
        body {
     font-family: Arial, sans-serif;
     background-color: #f0f6fc;
     margin: 0;
     padding: 0;
 }

 .container {
     background-color: #00204a;
     padding: 20px;
     box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
     color: white;
     text-align: center;
     margin-bottom: 20px;
 }

 h1 {
     margin-top: 0;
 }

 .input-container {
     margin-top: 20px;
     display: flex;
     justify-content: center;
     align-items: center;
 }

 #category {
     width: 150px;
     height: 38px;
     border-radius: 7px;
     background-color: white;
     margin-right: 10px;
 }

 .input-container input[type="text"] {
     padding: 10px;
     border-radius: 5px;
     border: none;
     width: 300px;
     margin-right: 10px;
 }

 .btn-search {
     background-color: #ffffff;
     color: #00204a;
     border: none;
     padding: 10px 20px;
     font-size: 16px;
     cursor: pointer;
     border-radius: 5px;
     transition: background-color 0.3s, color 0.3s;
 }

 .btn-search:hover {
     background-color: #00bbf0;
     color: #ffffff;
 }

 .section {
    background-color: #00204a; /* Darker background color */
    padding: 30px;
    margin-bottom: 30px;
    color: #ffffff;
    text-align: center;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); /* Add shadow for depth */
}

.section h2 {
    margin-top: 0;
    font-size: 24px; /* Increase font size */
}

.section p {
    margin-bottom: 20px;
    font-size: 18px; /* Increase font size */
}

.btn-search {
    background-color: #333333; /* Dark button color */
    color: #ffffff;
    border: none;
    padding: 15px 30px; /* Increase padding */
    font-size: 16px;
    cursor: pointer;
    border-radius: 5px;
    transition: background-color 0.3s, color 0.3s;
}

.btn-search:hover {
    background-color: #444444; /* Darker color on hover */
}

 .additional-section {
     background-color: #7c73e6;
     border: 1px solid #ced4da;
     padding: 20px;
     margin-bottom: 20px;
 }

 .additional-section h2 {
     font-size: 24px;
     text-align: center;
     margin-top: 0;
 }

 .additional-section p,
 .additional-section ul {
     margin: 10px 0;
 }

 /* Responsive layout */
 @media only screen and (max-width: 600px) {
     .container {
         padding: 10px;
     }

     .input-container {
         flex-direction: column;
         align-items: stretch;
     }

     #category {
         width: 100%;
         margin-bottom: 10px;
     }

     .input-container input[type="text"] {
         width: 100%;
         margin: 0;
         margin-bottom: 10px;
     }

     .btn-search {
         width: 100%;
     }


    </style>
</head>
<body>
<div class="container">
    <h1>Search with Multiple Options..</h1>
    <div class="input-container">
        <form action="SerachedMedicalData" method="post">
            <select id="category" name="category">
                <option value="medical_store">Medical Store Name</option>
                <option value="medicine">medicine Name</option>
            </select>
            <input type="text" id="srch" placeholder="Enter your search term..." name="search">
            <button class="btn-search">Search</button>
        </form>
    </div>
</div>
    <div class="section">
        <form action="SerachedMedicalData" method="post">
        <h2>Find Nearby Medical Stores</h2>
            <input type="text" name="category" value="all" hidden="hidden">
        <p>Locate all medical stores in your vicinity with ease. We provide comprehensive information to ensure you find what you need, when you need it.</p>
        <button class="btn-search">Find Now</button>
        </form>
    </div>
    <div class="additional-section">
        <h2>Be Healthy...</h2>
        <p>Achieving a healthy body encompasses a holistic approach that integrates physical, mental, and emotional well-being. It involves maintaining a balanced diet rich in nutrients, engaging in regular exercise to promote cardiovascular health, strength, and flexibility, as well as prioritizing adequate rest and sleep. Mental health is equally crucial, with strategies such as mindfulness, stress management, and seeking support when needed playing vital roles. Cultivating healthy habits and avoiding harmful substances contribute significantly to overall well-being. Ultimately, nurturing a healthy body not only enhances physical vitality but also fosters a positive outlook and resilience in facing life's challenges.</p>
    </div>
    <div class="additional-section">
        <h2> Everyone must follow some rules for Obtaining Medication </h2>
        <ul>
            <li>Prescription Requirement</li>
            <li>Licensed Pharmacies</li>
            <li>Identification</li>
            <li>Age Restrictions</li>
            <li>Controlled Substances</li>
            <li>Consultation with Healthcare Professionals</li>
        </ul>
    </div>
<form action="MoveFiles" method="post">
    <input type="text" value="no" hidden="hidden">
    <button class="btn-search">Find Now</button>
</form>
</body>
</html>
