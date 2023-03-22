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





</body>

</html>

