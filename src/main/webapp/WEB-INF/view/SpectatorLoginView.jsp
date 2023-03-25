<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <link rel="stylesheet" href="css/SpectatorLoginView.css">
    <link rel="stylesheet" href="css/Standard.css">

    <meta name="viewport" content="width=device-width, initial-scale=0.7">
</head>

<body>

<div class="header">
    <h1>EXPORIENCE</h1>
</div>

<p>Spectator Login </p>

<c:if test="${error_message != null}">
    <p style="color: red">${error_message}</p>
</c:if>
<form id="form-login" method="post" action="/spectatorlogin">

    <div class="container">
           <label class="login_text" for="username">Username:</label>
                <input class="login_field" type="text" id="username" name="username">

                <label class="login_text" for="password">Password:</label>
                <input class="login_field" type="password" id="password" name="password">

        <div class="box">
            <button class="button" type="submit" value="Login">Login</button>
        </div>

    <a href="/createspectator">

        <p class="create_account">Do you need an account, create one here!</p>
    </a>

    <a href="/">
    <button class="back-button" type="submit" >Back</button><br></div><br>
    </a>>

    <div class="container">
        <a href="/" class="back_button">&larr; Tilbake</a>
    </div>




</body>

</html>

