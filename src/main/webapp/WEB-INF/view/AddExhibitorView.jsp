<%--
  Created by IntelliJ IDEA.
  User: tmsol
  Date: 27.03.2023
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
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

<p>Create Stand</p>

<c:if test="${redirectMessage != null}">
    <p style="color: red">${redirectMessage}</p>
</c:if>
<form id="form-createUserSpectator" method="post">

    <div id="column_container">

        <label for="firstname">Stand Name</label>
        <input placeholder="FirstName" class="createUser_field" name="email" id="firstname" type="text"/>

        <button class="button" type="submit" value="Register">Register</button>

    </div>

</form>

</body>

</html>

