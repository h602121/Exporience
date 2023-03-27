<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <link rel="stylesheet" href="css/CreateNewUserSpectator.css">
    <link rel="stylesheet" href="css/Standard.css">

    <meta name="viewport" content="width=device-width, initial-scale=0.7">
</head>

<body>

<div class="header">
    <h1>EXPORIENCE</h1>
</div>

<p>Create Spectator</p>

<c:if test="${redirectMessage != null}">
    <p style="color: red">${redirectMessage}</p>
</c:if>
<form id="form-createUserSpectator" method="post" action="createspectator">

    <div id="column_container">

        <label for="firstname">FirstName</label>
        <input placeholder="FirstName" class="createUser_field" name="firstName" id="firstname" type="text"/>

        <label for="lastname">LastName</label>
        <input placeholder="LastName" class="createUser_field" name="lastName" id="lastname" type="text"/>

        <label for="phonenumber">Phonenumber</label>
        <input placeholder="phonenumber" class="createUser_field" name="phonenumber" id="phonenumber" type="text"/>

        <label for="email">Email</label>
        <input placeholder="Email" class="createUser_field" name="email" id="email" type="text"/>

        <label for="password">Password</label>
        <input placeholder="Password" class="createUser_field" name="password" id="password" type="password"/>

        <label for="confirmpassword">Confirm Password</label>
        <input placeholder="Confirm Password" class="creatUser_field" name="confirmPassword" id="confirmpassword" type="password"/>


        <button class="button" type="submit" value="Register">Register</button>

    </div>

</form>






</body>

</html>

