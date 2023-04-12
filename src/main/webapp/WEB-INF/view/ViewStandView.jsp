<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
<h3>My stand</h3>


<div>


        <div class="stand">
            <div class="stand_header">
                <div class="stand_header_text">
                    <h2>${stand.name}</h2>
                </div>
            </div>

            <p>${stand.stand_description}</p>
         <div class="spacer">

         </div>

        </div>
        <div class="add-member">
        <a href="addexhibitor">
            <button class="button" >Add member to stand</button>
        </a>
        </div>

</div>

</body>

</html>
