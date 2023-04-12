<%--
  Created by IntelliJ IDEA.
  User: tmsol
  Date: 11.04.2023
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="css/Standard.css">
        <link rel="stylesheet" href="css/SpectatorLoginView.css">


        <meta name="viewport" content="width=device-width, initial-scale=0.7">
    </head>

    <body>


        <a href="home"><h1>EXPORIENCE</h1></a>



        <p>Admin Login </p>

        <c:if test="${error_message != null}">
            <p style="color: red">${error_message}</p>
        </c:if>


        <form class="login" method="post">
            <div class="container">
                <div>


                    <label class="label" for="username">Username:</label><br></br>
                    <input class="input" type="text" id="username" name="username"
                           placeholder="email@hotmail.com"><br></br>

                    <label class="label">Password:</label><br></br>
                    <input class="input" type="password" id="password" name="password" placeholder="Password"><br></br>

                    <div class="button-container">
                        <button class="button" type="submit" value="Login">Login</button>
                    </div>

                    <br>
                </div>


            </div>
        </form>


    </body>

</html>

