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

<p>Exhibitor Login </p>

<div id="form-login" method="post" action="/spectatorlogin">

    <div id="column_container">
        <div id="login-label">
            <label class="login_text" for="username">Username</label>
            <input placeholder="exhibitor@hvl.no" class="login_field" name="username" id="username" type="text"/>
        </div>

        <label class="login_text" for="password">Password</label>
        <input placeholder="Password" class="login_field" name="password" id="password" type="password"/>

    </div>

</div>

<div id="create-user" method="post" action="/createspectator">

    <div class="buttons">

        <div class="action_buttons">

            <a href="/exhibitormain">
                <button class="button" type="submit" value="Login">Login</button>
            </a>


            <div class="divider_buttons"></div>
            <a href="/createexhibitor">
                <button class="button" type="submit" value="Create User">Create user</button>
            </a>
        </div>

    </div>
</div>


</form>


</body>

</html>

