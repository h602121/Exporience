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

    <a href="home"><h1>EXPORIENCE</h1></a>


    <h3>List of Stands</h3>


<div>

  <c:forEach var="vote" items="${votes}">
    <div class="stand">
      <div class="stand_header">
        <div class="stand_header_text">
          <h2>${vote.stands.name}</h2>
        </div>
      </div>

      <p>${vote.stands.stand_description}</p>


      <p>Poster</p>
      <div class="radio_buttons">
        <p>${vote.votes.posterRating}</p>
      </div>
      <p>Content</p>
      <div class="radio_buttons">
        <p>${vote.votes.contentRating}</p>
      </div>
      <p>Presentation</p>
      <div class="radio_buttons">
        <p>${vote.votes.presentationRating}</p>
      </div>
      <div class="spacer">

      </div>


    </div>
  </c:forEach>

</div>

</body>

</html>
