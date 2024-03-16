<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #f0f5f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        #login-container {
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            border-top-left-radius: 0px;
            border-bottom-left-radius: 0px;
            width: 500px;
        }
        h2 {
            margin-bottom: 30px;
            text-align: center;
            color: #333;
        }
        #gmail,
        #password {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        #submit-btn {
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
        }
        #submit-btn:hover {
            background-color: #0056b3;
        }
        #forget-password {
            text-align: right;
            margin-bottom: 10px;
        }
        #forget-password a {
            color: #007bff;
            text-decoration: none;
        }
        #register-heading {
            text-align: center;
            color: white;
            margin-bottom: 20px;
            font-size: 35px;
        }
        #register-container {
            background-color: #007bff;
            padding: 20px;
            border-radius: 10px;
            color: #fff;
            text-align: center;
            width: 250px; /* Adjust width as needed */
            height: 42%;
            margin-left: 20px; /* Add margin for spacing */
            border-top-right-radius: 0px;
            border-bottom-right-radius: 0px;
        }
        #register-btn{
            width: 100%;
            padding: 12px;
            border: none;
            border-radius: 5px;
            background-color: white;
            color: black;
            cursor: pointer;
            margin-top: 10px;
        }
        #register-btn:hover {
            background-color:#ccc;
        }
        .set{
            height:100px;
        }
        #register-container p{
            font-size: 20px;
        }
        .error{
            color: red;
        }
        a{
            text-decoration: none;
        }
    </style>
</head>
<body>
<div id="register-container">
    <div class="set">
        <span id="register-heading"></span></div>
    <p>Sign up now to access exclusive features!</p>
    <button id="register-btn"><a href="Registraction.jsp">Register</a></button>
</div>
<div id="login-container">
    <h2>Login</h2>
        <form action="LoginUser" method="Post" autocomplete="off" onsubmit="return validateForm()">
        <input type="email" id="gmail" name="email" placeholder="Gmail" required>
        <span class="error"></span>
        <input type="password" id="password" name="password" placeholder="Password" required>
        <span class="error"></span>
        <div id="forget-password">
            <a href="Forget_Password.html">Forget Password ?</a>
        </div>
        <input type="submit" id="submit-btn" value="Login">
    </form>
</div>

<script src="https://unpkg.com/typed.js@2.1.0/dist/typed.umd.js"></script>

<!-- Element to contain animated typing -->

<!-- Load library from the CDN -->
<script src="https://unpkg.com/typed.js@2.1.0/dist/typed.umd.js"></script>

<!-- Setup and start animation! -->
<script>
    var typed = new Typed('#register-heading', {
      strings: ['Not registered yet ?'],
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
        let verified = true;
        let i = 0;

        let mail = document.getElementById("gmail").value;
        let ispassword = document.getElementById("password").value;
        let register = document.getElementById("register-container");

        if (mail.length > 40 || parseInt(mail[0]) || mail[0]=='$' || mail[0]=='/') {
            verified = false;
            register.style.height = "45%";
            setError("gmail", "Your email is Invaild");
          } else {
            for (i = 0; i < gmail.length; i++) {
              if (mail[i] == "*" || mail[i]=='$' || mail[i]=='/') {
                verified = false;
                register.style.height = "45%";
                setError("gmail", "Your email is too long");
              }
            }
          }

          if ((ispassword.length < 6 || ispassword.length > 15) && ispassword !== "") {
            verified = false;
            register.style.height = "45%";
            setError("password", "Password must be between 6 and 15 characters");
          }

            return verified;
      }
</script>


</body>
</html>