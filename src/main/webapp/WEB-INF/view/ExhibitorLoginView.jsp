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

        <p>Exhibitor Login </p>

        <form class="login" method="post">
            <div class="container">
                <div>


                    <label class="label" for="username">Username:</label><br></br>
                    <input class="input" type="text" id="username" name="username" placeholder="email@hotmail.com"><br></br>

                    <label class="label"for="input-field">Password:</label><br></br>
                    <input id="input-field" class="input" type="password" id="password" name="password" placeholder="Password"><br></br>

                    <div class="button-container">
                        <button class="button" type="submit" value="Login">Login</button>
                        <a href="createexhibitor">
                            <button class="button" type="button">Create user</button>
                        </a>
                    </div>

                    <br></br>
                </div>



            </div>
        </form>


    </body>

</html>

