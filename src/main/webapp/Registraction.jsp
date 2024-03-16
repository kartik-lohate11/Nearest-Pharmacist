<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Registration Form</title>
    <style>
        body {
          font-family: Arial, sans-serif;
          background-color: #f4f4f4;
          margin: 0;
          padding: 0;
          display: flex;
          justify-content: center;
          align-items: center;
          height: 100vh;
        }

        .container {
          display: flex;
          justify-content: space-between;
          align-items: stretch; /* Ensures both children stretch to equal height */
          width: 800px; /* Adjust as needed */
        }

        .welcome-container {
          background-color: #007bff;
          color: #fff;
          border-radius: 10px;
          padding: 20px;
          text-align: center;
          width: 45%; /* Adjust as needed */
          border-top-right-radius: 0px;
          border-bottom-right-radius: 0px;
        }

        .registration-container {
          background-color: #fff;
          padding: 20px;
          border-radius: 10px;
          box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
          width: 45%; /* Adjust as needed */
          border-bottom-left-radius: 0px;
          border-top-left-radius: 0px;
        }

        .form-group {
          margin-bottom: 20px;
        }

        label {
          display: block;
          margin-bottom: 5px;
          font-weight: bold;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="tel"] {
          width: 100%;
          padding: 10px;
          border-radius: 5px;
          border: 1px solid #ccc;
          box-sizing: border-box;
        }

        input[type="submit"],
        input[type="reset"] {
          background-color: #007bff;
          color: #fff;
          border: none;
          padding: 10px 20px;
          border-radius: 5px;
          cursor: pointer;
          margin-right: 10px;
        }

        input[type="submit"]:hover,
        input[type="reset"]:hover {
          background-color: #0056b3;
        }

        .error {
          color: red;
        }

        #element{
          font-size: 40px;
        }
        .data{
          overflow: hidden;
          margin-top: 50px;
        }
       .set{
        height:100px;
       }
    </style>
</head>
<body>
<div class="container">
    <div class="welcome-container">
        <div class="set">
            <span id="element"></span> </div>
        <p class="data">We are excited to have you join us! Please fill out the registration form below to get started.</p>
    </div>
    <div class="registration-container">
        <h2>Registration Form</h2>
        <form action="userVerification" method="post" onclick="return validateForm()" autocomplete="off">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required />
                <span class="error"></span>
            </div>
            <div class="form-group">
                <label for="gmail">Gmail:</label>
                <input type="email" id="gmail" name="gmail" required/>
                <span class="error"></span>
            </div>
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
            <div class="form-group">
                <label for="phone">Phone No:</label>
                <input type="tel" id="phone" name="phone" required>
                <span class="error"></span>
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required/>
                <span class="error"></span>
            </div>
            <input type="submit" value="Register" />
            <input type="reset" value="Reset" />
        </form>
    </div>
</div>

<script src="https://unpkg.com/typed.js@2.1.0/dist/typed.umd.js"></script>

<!-- Element to contain animated typing -->

<!-- Load library from the CDN -->
<script src="https://unpkg.com/typed.js@2.1.0/dist/typed.umd.js"></script>

<!-- Setup and start animation! -->
<script>
    var typed = new Typed('#element', {
      strings: ['Welcome to Our <br> WebSite...'],
      typeSpeed: 40,
      loop:true
    });
</script>

<script>
    function setError(id, isError) {
      let element = document.getElementById(id);
      element.nextElementSibling.innerHTML = isError;
    }

    function clearValidation() {
      let element = document.getElementsByClassName("error");
      for (let i of element) {
        i.innerHTML = "";
      }
    }

    function validateForm() {
      clearValidation();

      let name = document.getElementById("username").value;
      let mail = document.getElementById("gmail").value;
      let ispassword = document.getElementById("password").value;
      let iscon_password = document.getElementById("con_password").value;
      let isphone = document.getElementById("phone").value;
      let address = document.getElementById("address").value;

      let isValid = true;

      for (var i = 0; i < name.length; i++) {
        if (
          parseInt(name[i]) ||
          name[i] == "@" ||
          name[i] == "#" ||
          name[i] == "!" ||
          name[i] == "*" ||
          name[i] == "^"
        ) {
          isValid = false;
          setError("username", "Please enter a valid username");
          break;
        }
      }

      // gmail validation
      if (mail.length > 40 || parseInt(mail[0])) {
        isValid = false;
        setError("gmail", "Your email is Invaild");
      } else {
        for (i = 0; i < gmail.length; i++) {
          if (mail[i] == "*") {
            isValid = false;
            setError("gmail", "Your email is too long");
          }
        }
      }

      // password validation
      if ((ispassword.length < 6 || ispassword.length > 15) && ispassword !== "") {
        isValid = false;
        setError("password", "Password must be between 6 and 15 characters");
      }

      if ((iscon_password.length < 6 || iscon_password.length > 15) && iscon_password !== "") {
        isValid = false;
        setError("con_password", "Password must be between 6 and 15 characters");
      } else if (iscon_password !== ispassword && iscon_password !== "") {
        isValid = false;
        setError("con_password", "Password is different");
      }

      // Phone number validation
      if (isphone.length != 10 && isphone != "") {
        isValid = false;
        setError("phone", "Invalid phone number");
      } else {
        for (let i = 0; i < isphone.length; i++) {
          if (!parseInt(isphone[i])) {
            isValid = false;
            setError("phone", "Invalid phone number");
            break;
          }
        }
      }

      if (address.length < 15 && address.length !== 0) {
        isValid = false;
        setError("address", "Address to short");
      }

      return isValid;
    }
</script>
</body>
</html>
