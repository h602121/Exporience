<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Stands</title>
    <link rel="stylesheet" href="css/StandList.css">
</head>
<body>
    <a href="/exhibitormain"><h1>EXPORIENCE</h1></a>
    <h3>List of Stands</h3>
    <div>
        <c:forEach var="vote" items="${votes}">
            <div class="stand">
                <div class="stand_header">
                    <div class="stand_header_text">
                        <h2>${vote.stand.name}</h2>
                    </div>
                </div>
                <p>${vote.stand.stand_description}</p>
                <p>Presentasjon</p>
                <div class="radio_buttons" id="presentasjon_${vote.stand.id}">
                    <c:forEach var="i" begin="1" end="5">
                        <input type="radio" name="presentasjon_${vote.stand.id}" value="${i}" disabled="disabled" ${i == vote.presentasjon ? 'checked="checked"' : ''}/> ${i}
                    </c:forEach>
                </div>
                <p>Panel</p>
                <div class="radio_buttons" id="panel_${vote.stand.id}">
                    <c:forEach var="i" begin="1" end="5">
                        <input type="radio" name="panel_${vote.stand.id}" value="${i}" disabled="disabled" ${i == vote.panel ? 'checked="checked"' : ''}/> ${i}
                    </c:forEach>
                </div>
                <p>Innhold</p>
                <div class="radio_buttons" id="innhold_${vote.stand.id}">
                    <c:forEach var="i" begin="1" end="5">
                        <input type="radio" name="innhold_${vote.stand.id}" value="${i}" disabled="disabled" ${i == vote.innhold ? 'checked="checked"' : ''}/> ${i}
                    </c:forEach>
                </div>
                <p>Interaksjon</p>
                <div class="radio_buttons" id="interaksjon_${vote.stand.id}">
                    <c:forEach var="i" begin="1" end="5">
                        <input type="radio" name="interaksjon_${vote.stand.id}" value="${i}" disabled="disabled" ${i == vote.interaksjon ? 'checked="checked"' : ''}/> ${i}
                    </c:forEach>
                </div>
                <p>Total</p>
                <div class="radio_buttons" id="total_${vote.stand.id}">
                    <c:forEach var="i" begin="1" end="5">
                        <input type="radio" name="total_${vote.stand.id}" value="${i}" disabled="disabled" ${i == vote.total ? 'checked="checked"' : ''}/> ${i}
                        </c:forEach>
                        </div>
                        <p></p>
                        </div>
                        </c:forEach>
                        </div>
                        
                        </body>
                        </html>
