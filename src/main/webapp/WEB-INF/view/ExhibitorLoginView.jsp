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

        <form id="form-login" method="post" action="/exhibitorlogin">

            <p>Exhibitor Login </p>

            <div id="column_container">
                <div id="login-label">
                    <label class="login_text" for="username">Username</label>
                    <input placeholder="exhibitor@hvl.no" class="login_field" name="username" id="username"
                           type="text"/>
                </div>

                <label class="login_text" for="password">Password</label>
                <input placeholder="Password" class="login_field" name="password" id="password" type="password"/>

            </div>


            <button class="button" type="submit" value="Login">Login</button>


        </form>

        <a href="/createexhibitor">
            <button class="button" type="submit" value="Create User">Create user</button>
        </a>

    </body>

</html>

