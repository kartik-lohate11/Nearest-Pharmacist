<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Password Verification</title>
    <style>
        body {
          font-family: Arial, sans-serif;
          margin: 0;
          padding: 0;
          display: flex;
          justify-content: center;
          align-items: center;
          height: 100vh;
          background-color: #f2f2f2;
        }

        .container {
          max-width: 400px;
          padding: 20px;
          background-color: #fff;
          border-radius: 8px;
          box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .input-group {
          margin-bottom: 20px;
        }

        .input-group input {
          width: 100%;
          padding: 10px;
          border: 1px solid #ccc;
          border-radius: 5px;
        }

        .error-message {
          color: red;
          font-size: 14px;
          margin-top: 5px;
        }

        .btn {
          background-color: #007bff;
          color: #fff;
          border: none;
          padding: 10px 20px;
          border-radius: 5px;
          cursor: pointer;
        }

        .btn:hover {
          background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Password Verification</h2>
    <form action="NewPasswordCreate" method="post">
    <div class="input-group">
        <input type="password" id="password" name="password" placeholder="Enter Password">
        <div class="error-message" id="passwordError"></div>
    </div>
    <div class="input-group">
        <input type="password" id="confirmPassword" placeholder="Confirm Password">
        <div class="error-message" id="confirmPasswordError"></div>
    </div>
    <button class="btn" onclick="verifyPassword()">Verify Password</button>
    </form>
</div>

<script>
    function verifyPassword() {
      var password = document.getElementById("password").value;
      var confirmPassword = document.getElementById("confirmPassword").value;
      var passwordError = document.getElementById("passwordError");
      var confirmPasswordError = document.getElementById("confirmPasswordError");

      // Reset error messages
      passwordError.textContent = "";
      confirmPasswordError.textContent = "";

      // Check if password is empty
      if (password === "") {
        passwordError.textContent = "Password is required";
        return;
      }

      // Check if password meets minimum length requirement
      if (password.length < 8) {
        passwordError.textContent = "Password must be at least 8 characters long";
        return;
      }

      // Check if passwords match
      if (password !== confirmPassword) {
        confirmPasswordError.textContent = "Passwords do not match";
        return;
      }

      // If all checks pass, show success message
      alert("Password verified successfully!");
    }
</script>
</body>
</html>
