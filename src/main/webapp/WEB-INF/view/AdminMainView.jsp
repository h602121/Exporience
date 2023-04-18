<%--
  Created by IntelliJ IDEA.
  User: tmsol
  Date: 11.04.2023
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="css/Standard.css">
        <link rel="stylesheet" href="css/SpectatorMainView.css">
        <meta name="viewport" content="width=device-width, initial-scale=0.7">
    </head>

    <body>

        <a href="home"><h1>EXPORIENCE</h1></a>

        <div class="buttons">
            <div class="winner-button">
                <a href="createjury">
                    <button class="button" type="submit" role="button">Add Jury</button>
                </a>
            </div>

            <div class="myvotes-button">
                <a href="viewratings">
                    <button class="button" role="button">View Stand Ratings</button>
                </a>
            </div>

            <div class="declarewinner-button">
                <a href="declarewinner">
                    <button class="button" role="button">Declare Winner</button>
                </a>
            </div>
            <div class="seewinners-button">
                <a href="seewinner">
                    <button class="button" role="button">See Winners</button>
                </a>
            </div>

            <div class="signout-button">
                <a href="${pageContext.request.contextPath}/signout">
                    <button class="button" role="button">Sign out</button>
                </a>
            </div>
        </div>
    </body>
</html>
