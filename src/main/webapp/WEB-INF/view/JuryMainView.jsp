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

            <div class="ratingselector-button">
                <a href="standlist">
                    <button class="button" role="button">Give ratings</button>
                </a>
            </div>

            <div class="winner-button">
                <a href="seewinner">
                    <button class="button" type="submit" role="button">See Winner</button>
                </a>
            </div>

            <div class="myvotes-button">
                <a href="myratings">
                    <button class="button" role="button">My Votes</button>
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
