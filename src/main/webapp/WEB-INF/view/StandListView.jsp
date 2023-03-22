


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Stands</title>
    <link rel="stylesheet" href="css/Standard.css">
    <link rel="stylesheet" href="css/StandList.css">
</head>

<body>
<div class="header">
    <h1>EXPORIENCE</h1>
</div>
<h3>List of Stands</h3>

<div>
<%--    <form method="post">--%>
        <c:forEach var="stand" items="stands">
            <div>
                <h2>#${stand.name}</h2>
                <p>${stand.stand_description}</p>
                <p class="rating">3.5 stars</p>
            </div>
            <input type="submit" value="Bestill"/>
        </c:forEach>


<%--    </form>--%>
</div>
<%--<div class="stand">--%>
<%--    <h2>Stand 1</h2>--%>
<%--    <p>Description of Stand 1.</p>--%>
<%--    <p class="rating">4.5 stars</p>--%>
<%--</div>--%>
<%--<div class="stand">--%>
<%--    <h2>Stand 2</h2>--%>
<%--    <p>Description of Stand 2.</p>--%>
<%--    <p class="rating">3.8 stars</p>--%>
<%--</div>--%>
<%--<div class="stand">--%>
<%--    <h2>Stand 3</h2>--%>
<%--    <p>Description of Stand 3.</p>--%>
<%--    <p class="rating">5 stars</p>--%>
<%--</div>--%>

</body>

</html>
