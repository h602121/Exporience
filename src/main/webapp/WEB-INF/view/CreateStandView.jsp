<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

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

        <p>Create Stand</p>

        <c:if test="${redirectMessage != null}">
            <p style="color: red">${redirectMessage}</p>
        </c:if>
        <form class="add-container" method="post">

                <div>

                <label class="label" for="firstname">Stand Name</label>
                <input class="input" placeholder="FirstName" class="createUser_field" name="name" id="firstname" type="text"/>

                <label class="label" for="lastname">Stand Description</label>
                <input class="input" placeholder="LastName" class="createUser_field" name="stand_description" id="lastname" type="text"/>


                <button class="button" type="submit" value="Register">Register</button>
            </div>


        </form>






    </body>

</html>

