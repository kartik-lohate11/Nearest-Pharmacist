<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.pharmacy.bean.MedicanData" %>
<%@ page import="com.pharmacy.bean.MedicalStoreData" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Medical Store Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 1200px; /* Adjusted max-width */
            margin: 20px auto;
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            display: flex;
            flex-wrap: wrap;
        }
        .info-section {
            flex: 1;
            margin-right: 20px;
            margin-bottom: 20px;
            padding: 20px;
            border-radius: 8px;
        }
        .map-section {
            flex: 2; /* Adjusted flex value */
            margin-bottom: 20px;
            border-radius: 8px;
            overflow: hidden;
        }
        h1, h2 {
            color: #34495e;
        }
        .section {
            margin-bottom: 10px;
        }
        .section h2 {
            color: #2980b9; /* Adjusted section heading color */
            margin-bottom: 5px;
        }
        .section p {
            color: #555;
        }
        #map {
            width: 100%;
            height: 600px; /* Adjusted map height */
            border-radius: 8px;
        }
        #result {
            display: none;
            margin-top: 10px;
            font-weight: bold;
            color: #2ecc71; /* Adjusted result text color */
        }
    </style>
    <link href="https://maps-gl.nextbillion.io/maps/api/css" rel="stylesheet" />
</head>
<body>
<%
ArrayList<MedicalStoreData> arrayList = (ArrayList<MedicalStoreData>) session.getAttribute("arrayList");
    int i = Integer.parseInt(request.getParameter("idx"));
    MedicalStoreData medicalStoreData = arrayList.get(i);
    %>
    <div class="container">
        <div class="info-section">
            <h1>Near PharmAssist</h1>
            <div class="section">
                <h2>Name:</h2>
                <p><%=medicalStoreData.getName()%></p>
            </div>
            <div class="section">
                <h2>Address:</h2>
                <p><%=medicalStoreData.getAddress()%></p>
            </div>
            <div class="section">
                <h2>Phone No.:</h2>
                <p>+91 <%=medicalStoreData.getPhoneNo()%></p>
            </div>
            <div class="section">
                <h2>About:</h2>
                <p><%=medicalStoreData.getAbout()%></p>
            </div>
            <div class="section">
                <h2>Reach Distance and Time of Pharmacist:</h2>
                <p><%= medicalStoreData.getPresentStatus()%></p> <!-- Using static content as the dynamic code is not supported here -->
            </div>
        </div>
        <div class="map-section">
            <div id="map"></div>
        </div>
    </div>

    <script src="https://maps-gl.nextbillion.io/maps/api/js"></script>
    <script>
        // JavaScript for embedding the map
        <%
           String lat = (String)session.getAttribute("userLatitude");
           String longt = (String)session.getAttribute("userLongitude");
        %>
        var origin = <%=lat%>+","+<%=longt%>;
        var destination = <%=medicalStoreData.getLatitude()%>+","+<%=medicalStoreData.getLongitude()%>;
        var apiKey = "b98e9dd2f9414231bae19340b76feff0";

        (function() {
            var loc = {
                lat: <%=medicalStoreData.getLatitude()%>,
                lng: <%=medicalStoreData.getLongitude()%>
            };
            nextbillion.apiKey = apiKey;
            var map = new nextbillion.maps.Map(document.getElementById('map'), {
                zoom: 11,
                center: loc,
            });

            var count = 0;
            var color = ["green", "red"];
            while (count < 2) {
                var lat, lng;
                if (count === 0) {
                   // set User Location
                    lat = <%=lat%>;
                    lng = <%=longt%>;
                } else {
                // set medical Store Location
                    lat = <%=medicalStoreData.getLatitude()%>;
                    lng = <%=medicalStoreData.getLongitude()%>;
                }
                addMarker({
                    lat: parseFloat(lat),
                    lng: parseFloat(lng)
                }, map,color[count]);
                count++;
            }
        })();

        function addMarker(loc, map,color) {
            return new nextbillion.maps.Marker({
                position: loc,
                map: map,
                icon: color,
                content: "1",
            });
        }

    </script>
</body>
</html>
