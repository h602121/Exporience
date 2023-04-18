<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.expo.Model.Entity.Stand" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>List of Stands</title>
        <link rel="stylesheet" href="css/StandList.css">
    </head>

    <body>

        <a href="home"><h1>EXPORIENCE</h1></a>

        <h3>List of Stands</h3>

        <div>
            <c:forEach var="stand" items="${stands}">
                <div class="stand">
                    <div class="stand_header">
                        <div class="stand_header_text">
                            <h2><a href="/expo-0.0.2/stand/${stand.getId()}">${stand.getName()}</a></h2>
                        </div>
                    </div>

                    <p>${stand.getStand_description()}</p>

                    <p>QR Code:</p>
                    <div class="qr-code">
                        <img src="${stand.generateQRCodeUrl()}">
                    </div>
                </div>
            </c:forEach>
        </div>

    </body>

</html>
