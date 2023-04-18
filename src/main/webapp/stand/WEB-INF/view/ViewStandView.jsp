<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>List of Stands</title>
        <link rel="stylesheet" href="css/StandList.css">
    </head>

    <body>

        <a href="home"><h1>EXPORIENCE</h1></a>
        <h3>My stands</h3>
        <div>
            <c:forEach var="stand" items="${votes}">
                <div class="stand">
                    <div class="stand_header">
                        <div class="stand_header_text">
                            <h2>${stand.getName()}</h2>
                        </div>
                    </div>
                    <p>${stand.getStand_description()}</p>
                    <p></p>
                </div>
            </c:forEach>
        </div>
                        
    </body>
</html>
