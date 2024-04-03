<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Store Medicine</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0ff;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #333;
            text-align: center;
        }

        .description {
            background-color: #e6f7ff;
            border: 1px solid #b3d9ff;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
        }

        .description p {
            color: #007bff;
            margin: 0;
        }

        form {
            margin-top: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #666;
        }

        input[type="text"],
        input[type="number"],
        button {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            background-color: #007bff;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Admin - Store Medicine</h1>
    <div class="description">
        <p>Please ensure that the medicine name is accurate and available in your store before storing it.</p>
    </div>
    <form action="AdminChanges" method="post">
        <label for="medicineName">Medicine Name:</label>
        <input type="text" id="medicineName" name="medicineName" required>
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" required>
        <input type="text" value="insert" name="request" hidden="hidden">
        <button type="submit">Store Medicine</button>
    </form>
</div>
</body>
</html>
