<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Top 3 stands</title>
    <link rel="stylesheet" href="css/Standard.css">
    <link rel="stylesheet" href="css/StandList.css">
</head>

<body>

<a href="home"><h1>EXPORIENCE</h1></a>

<h3>Top 3 stands</h3>


<div>

    <c:forEach var="score" items="${scores}">
        <div class="stand">
            <div class="stand_header">
                <div class="stand_header_text">
                    <h2>${score.stand.name}</h2>
                </div>
            </div>

            <p>${score.stand.stand_description}</p>


            <p>Avg Poster</p>
            <p>${score.posterAvg}</p>
            <p>Avg Content</p>
            <p>${score.contentAvg}</p>
            <p>Avg Presentation</p>
            <p>${score.presentationAvg}</p>

            <p>Avg Total</p>
            <p>${score.totalAvg}</p>

            <div class="spacer">

            </div>


        </div>
    </c:forEach>

</div>

</body>

</html>
