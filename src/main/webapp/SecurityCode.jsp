<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Security Code Verification</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f0f5f9;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        #otp-container {
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }
        h2 {
            margin-bottom: 20px;
            text-align: center;
            color: #333;
        }
        input {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        input[type="text"] {
            text-align: center;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .error {
            color: red;
            font-size: 14px;
        }
        .form-group {
          margin-bottom: 20px;
        }
          input[type="password"] {
          width: 100%;
          padding: 10px;
          border-radius: 5px;
          border: 1px solid #ccc;
          box-sizing: border-box;
        }
    </style>
</head>
<body>
<div id="otp-container">
    <h2>Security Code Verification</h2>
    <p>Enter The 6 digit of gmail Verification code</p>
    <form action="UpdateForgetPassword" method="post" onsubmit="return validateOTP()">
        <input type="text" id="otp" name="otp" placeholder="Enter OTP" required>
        <span class="error" id="otp-error"></span>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <span class="error"></span>
        </div>
        <div class="form-group">
            <label for="con_password">Confirm Password:</label>
            <input type="password" id="con_password" name="con_password" required>
            <span class="error"></span>
        </div>
        <input type="submit" value="Sumbit Here..">
    </form>

</div>

<script>

    let ispassword = document.getElementById("password").value;
    let iscon_password = document.getElementById("con_password").value;

    function setError(id, message) {
        document.getElementById(id + "-error").textContent = message;
    }

    function clearValidation() {
        var errorElements = document.getElementsByClassName("error");
        for (var i = 0; i < errorElements.length; i++) {
            errorElements[i].textContent = "";
        }
    }

    function validateOTP() {
        clearValidation();
        var verified = true;

        var otp = document.getElementById("otp").value;

        // OTP validation
        if (otp.length !== 6 || isNaN(otp)) {
            setError("otp", "Enter a valid 6-digit OTP");
            verified = false;
        }

        // password validation
      if ((ispassword.length < 6 || ispassword.length > 15) && ispassword !== "") {
        verified = false;
        setError("password", "Password must be between 6 and 15 characters");
      }

      if ((iscon_password.length < 6 || iscon_password.length > 15) && iscon_password !== "") {
        verified = false;
        setError("con_password", "Password must be between 6 and 15 characters");
      } else if (iscon_password !== ispassword && iscon_password !== "") {
        verified = false;
        setError("con_password", "Password is different");
      }

        return verified;
    }
</script>
</body>
</html>
