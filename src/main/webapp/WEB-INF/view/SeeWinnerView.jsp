<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>List of Stands</title>
  <link rel="stylesheet" href="css/StandList.css">
</head>

  <body>

    <a href="home"><h1>EXPORIENCE</h1></a>
    <c:if test="${error_message != null}">
      <p style="color: red">${error_message}</p>
  </c:if>

    <h3>Winners</h3>

    <div>
      <h4>Current Winner:</h4>
      <p>Name of stand: ${winner.getStand().getName()}</p>
      <p>Winner Date: ${winner.getWinnerDate()}</p>
      <p>Winner Time: ${winner.getWinnerTime()}</p>
      
</div>


    <hr>

    <div>
      <h4>Previous Winners:</h4>
<c:forEach var="stand" items="${allWinners}">
  <p>Name of stand: ${stand.name}</p>
  <p>Description of stand: ${stand.stand_description}</p>
</c:forEach>

    </div>

</body>
</html>
