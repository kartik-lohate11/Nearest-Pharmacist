<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Technical Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f5f5f5;
        }
        .error-container {
            text-align: center;
            padding: 20px;
            border-radius: 10px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #e74c3c;
        }
        p {
            color: #333;
            margin-bottom: 20px;
        }
        button {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            background-color: #3498db;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
<div class="error-container">
    <h1>Technical Error</h1>
    <p>Sorry, we encountered a technical error. Please try again later or Verify Your Internet Network</p>
    <button onclick="index.jsp">Go to Another Page</button>
</div>
</body>
</html>
