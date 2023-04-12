<%--
  Created by IntelliJ IDEA.
  User: tmsol
  Date: 27.03.2023
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>

    <link rel="stylesheet" href="css/Standard.css">
    <link rel="stylesheet" href="css/CreateNewUserSpectator.css">


    <meta name="viewport" content="width=device-width, initial-scale=0.7">
</head>

<body>

<div class="header">
    <h1>EXPORIENCE</h1>
</div>

<p>Add exhibitor to your stand</p>

<c:if test="${redirectMessage != null}">
    <p style="color: red">${redirectMessage}</p>
</c:if>
<form class="add-container" method="post">

    <div>

        <label class="label" for="firstname">Exhibitor Email</label>
        <input placeholder="email@hotmail.no" class="input" name="email" id="firstname" type="text"/>

        <button class="button" type="submit" value="Register">Add</button>

    </div>

</form>

</body>

</html>

