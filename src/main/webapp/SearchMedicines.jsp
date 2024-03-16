<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Medical Store Search</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f1f1f1;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            max-width: 800px;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .search-container {
            text-align: center;
            margin-bottom: 20px;
        }

        input[type="text"] {
            width: 60%;
            padding: 10px;
            border-radius: 5px 0 0 5px;
            border: 1px solid #ccc;
            border-right: none;
        }

        button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 0 5px 5px 0;
            cursor: pointer;
        }

        .med-section {
            margin-bottom: 20px;
            display: inline-block;
        }

        .med-section h2 {
            color: #4CAF50;
        }

        .med-list {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        .med-item {
            background-color: #e6f7ff;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
        }

        .vertical-div {
            width: 2px;
            background-color: #ccc;
            height: 100px;
            margin: 0 auto;
            display: inline-block;
        }

        @media (max-width: 600px) {
            input[type="text"] {
                width: 50%;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <h1> Search by Medicin name</h1>
    <div class="search-container">
        <form action="" method="post">
           <input type="text" id="searchInput" placeholder="Search for medicines..." name="searchInput">
           <button type="button">Search</button>
        </form>
    </div>

    <div class="med-section">
        <h2>Section 1</h2>
        <ul class="med-list">
            <li class="med-item">Medical Store 1 - Paracetamol</li>
            <li class="med-item">Medical Store 2 - Ibuprofen</li>
            <li class="med-item">Medical Store 3 - Aspirin</li>
            <li class="med-item">Medical Store 4 - Antibiotics</li>
            <li class="med-item">Medical Store 5 - Antacids</li>
        </ul>
    </div>

    <div class="vertical-div"></div>

    <div class="med-section">
        <h2>Section 2</h2>
        <ul class="med-list">
            <li class="med-item">Medical Store 6 - Vitamin C</li>
            <li class="med-item">Medical Store 7 - Antihistamines</li>
            <li class="med-item">Medical Store 8 - Insulin</li>
            <li class="med-item">Medical Store 9 - Antidepressants</li>
            <li class="med-item">Medical Store 10 - Bandages</li>
        </ul>
    </div>
</div>
</body>
</html>
