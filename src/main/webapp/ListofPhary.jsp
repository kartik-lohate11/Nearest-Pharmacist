<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pharmacy.bean.MedicanData" %>
<%@ page import="com.pharmacy.bean.MedicalStoreData" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Medical Stores Near You</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
            color: #00000b;
        }
        h1 {
            text-align: center;
            color: #002d4a;
            margin-top: 20px;
        }
        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            gap: 20px;
            padding: 20px;
        }
        .card {
            background-color: #ffffff;
            border-radius: 12px;
            padding: 20px;
            width: 350px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .card h2 {
            margin-top: 0;
            color: #006294;
        }
        .card p {
            margin: 5px 0;
            color: #00000b;
        }
        @media (max-width: 768px) {
            .container {
                flex-direction: column;
                align-items: center;
            }
            .card {
                width: 90%;
            }
        }
        footer {
            background-color: #00a1ea;
            color: #ffffff;
            text-align: center;
            padding: 20px 0;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
        a{
                text-decoration: none;
            }
        .card {
    background-color: #ffffff;
    border-radius: 12px;
    padding: 20px;
    width: 350px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    position: relative; /* Required for absolute positioning of image */
}

.pharmacy-image {
    width: 100%; /* Ensure image fills the card width */
    height: auto; /* Maintain aspect ratio */
    border-radius: 12px 12px 0 0; /* Rounded corners only at the top */
}

.card:hover .pharmacy-image {
    transform: scale(1.1); /* Scale up image on hover */
    transition: transform 0.3s ease; /* Smooth transition effect */
}

.card h2 {
    margin-top: 10px; /* Adjust margin for better spacing */
    color: #006294;
}

.card p {
    margin: 5px 0;
    color: #00000b;
}
    </style>
</head>
<body>
<%
    MedicanData medicanData = new MedicanData();
    ArrayList<MedicalStoreData> arrayList = (ArrayList<MedicalStoreData>) session.getAttribute("arrayList");
    int i = 0;
    %>

    <h1>All Pharmacies Nearby</h1>
    <p style="text-align: center;">These are all available medical stores near you.</p>


    <div class="container">
        <% for(MedicalStoreData arr : arrayList){ %>
        <a href="MedicalStore.jsp?idx=<%=i%>">
        <div class="card">
            <img src="Images\<%=arr.getName()%>.jpg" alt="Pharmacy Image" class="pharmacy-image">
                <h2><%=arr.getName()%></h2>
                <p> <b>Address:</b> <%=arr.getAddress()%></p>
                <p>Rating: 4.5</p>
                <p>Status: Open</p>
                <p style="display:inline-block;">Medican Status:<p style="color:green; display:inline-block;">  Available</p> </p>
                <p>Distance & Time : <%=arr.getPresentStatus()%></p>
        </div>
        <%
        i++; } %>
        </a>
    </div>
    <footer>
        <p>&copy; 2024 All rights reserved.</p>
        <p>For inquiries, contact us at <a href="mailto:info@example.com" style="color: #ffffff;">info@example.com</a></p>
    </footer>

</body>
</html>
