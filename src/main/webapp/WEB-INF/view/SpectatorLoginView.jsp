<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
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

        <div id="column_container">
            <div id="login-label">
                <label class="login_text" for="username">Username</label>
                <input placeholder="spectator@hvl.no" class="login_field" name="username" id="username" type="text"/>
            </div>

            <label class="login_text" for="password">Password</label>
            <input placeholder="Password" class="login_field" name="password" id="password" type="password"/>

        </div>

</form>




    <div class="buttons">

        <div class="action_buttons">

<%--            <a href="/spectatormain">--%>
<%--            <button class="button" type="submit" value="Login">Login</button>--%>
<%--            </a>--%>


            <div class="divider_buttons"></div>
            <a href="/createspectator">
            <button class="button" type="submit" value="Create User">Create user</button>
            </a>
        </div>

    </div>


</body>

</html>

