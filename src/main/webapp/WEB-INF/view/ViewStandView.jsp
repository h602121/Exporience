<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>List of Stands</title>
        <link rel="stylesheet" href="css/StandList.css">
    </head>

    <body>
        <div class="header">
            <h1>EXPORIENCE</h1>
        </div>

        <div class="my_stand_header">
            <h3>${stand.name}</h3>
        </div>


        <div>


            <div class="stand">
                <div class="stand_header">
                    <div class="stand_header_text">
                        <h2>${stand.name}</h2>
                    </div>
                </div>

                <p>${stand.stand_description}</p>
                <p>Your current average rating: ${avg_rating}</p>

            </div>

        </div>
        <div class="add_user_container">
            <a href="addexhibitor">
                <button class="button" role="button">Add user</button>
            </a>
        </div>


    </body>

</html>
