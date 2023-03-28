<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
    <head>

        <link rel="stylesheet" href="css/Standard.css">
        <link rel="stylesheet" href="css/CreateUser.css">


        <meta name="viewport" content="width=device-width, initial-scale=0.7">
    </head>

    <body>

        <div class="header">
            <h1>EXPORIENCE</h1>
        </div>

        <p>Create Exhbititor</p>

        <c:if test="${redirectMessage != null}">
            <p style="color: red">${redirectMessage}</p>
        </c:if>

        <form id="form-createUserSpectator" method="post">

            <div class="container">
                <div>

                    <label class="label" >FirstName</label>
                    <input   class="input" placeholder="FirstName"  name="firstName"  type="text"/>

                    <label class="label" >LastName</label>
                    <input   class="input" placeholder="LastName"  name="lastName"  type="text"/>

                    <label class="label">Phonenumber</label>
                    <input  class="input" placeholder="phonenumber"  name="phonenumber"  type="text"/>

                    <label class="label" >Email</label>
                    <input   class="input"placeholder="Email"  name="email"  type="text"/>

                    <label class="label" >Password</label>
                    <input  class="input" placeholder="Password"  name="password"  type="password"/>

                    <label class="label" >Confirm Password</label>
                    <input  class="input" placeholder="Confirm Password"  name="confirmPassword"  type="password"/>


                    <button class="button" type="submit" value="Register">Register</button>
                </div>
            </div>

        </form>

    </body>

</html>

