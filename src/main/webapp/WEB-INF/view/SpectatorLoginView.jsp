<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="css/Standard.css">
        <link rel="stylesheet" href="css/SpectatorLoginView.css">


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


        <form class="login" method="post">
            <div class="container">
                <div>


                    <label for="username">Username:</label><br></br>
                    <input type="text" id="username" name="username" placeholder="name@hotmail.com"><br></br>

                    <label for="password">Password:</label><br></br>
                    <input type="password" id="password" name="password" placeholder="Password"><br></br>

                    <button class="button" type="submit" value="Login">Login</button>
                    <br></br>
                </div>

                <p class="forgot_password">Forgot password?</p>


            </div>
        </form>

        <a href="createspectator">

            <p class="create_account">Do you need an account, create one here!</p>
        </a>

    </body>

</html>

