<%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 5/22/2017
  Time: 11:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<style>
    /* Full-width input fields */
    input[type=text], input[type=password] {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    /* Set a style for all buttons */
    button {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
    }

    /* Extra styles for the cancel button */
    .cancelbtn {
        padding: 14px 20px;
        background-color: #f44336;
    }

    /* Float cancel and signup buttons and add an equal width */
    .cancelbtn, .signupbtn {
        float: left;
        width: 50%;
    }

    /* Add padding to container elements */
    .container {
        padding: 16px;
    }

    /* Clear floats */
    .clearfix::after {
        content: "";
        clear: both;
        display: table;
    }

    /* Change styles for cancel button and signup button on extra small screens */
    @media screen and (max-width: 300px) {
        .cancelbtn, .signupbtn {
            width: 100%;
        }
    }
</style>
<body>

<h2>Signup Form</h2>
${message}
<br>
${signup}<br>
<h1 style="color: red;">
    Error Messages :
    <form:errors path="student.*"></form:errors>
</h1>


<form action="/sigup.html" method="post" style="border:1px solid #ccc">
    <div class="container">
        <label><b>UserName</b></label>
        <input type="text" placeholder="Enter UserName" name="username" required>
        <label><b>Address</b></label>
        <input type="text" placeholder="Enter Address" name="address" required>
        <label><b>Mobile</b></label>
        <input type="text" placeholder="Enter Modile" name="mobile" required>

        <label><b>BirthDate</b></label>
        <input type="text" placeholder="Enter BirthDate" name="birthDate" required>

        <label><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>

        <label><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" name="repeat_password" required>
        <input type="checkbox" checked="checked"> Remember me
        <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

        <div class="clearfix">

            <button type="submit" name="buttonsign" value="Sign Up" class="signupbtn">Sign Up</button>
        </div>
    </div>
</form>
<form action="/" method="get">
    <div class="clearfix">
    <button type="submit" name="buttonsign" value="Cancel" class="cancelbtn">Cancel</button>
    </div>

</form>

</body>
</html>
