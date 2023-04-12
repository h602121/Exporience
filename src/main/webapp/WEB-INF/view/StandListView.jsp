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
        <h3>List of Stands</h3>

        <c:if test="${error_rating_message != null}">
            <p style="color: red">${error_rating_message}</p>
        </c:if>


        <div>



            <c:forEach var="stand" items="${stands}">
            <div class="stand">
                <div class="stand_header">
                <div class="stand_header_text">

                    <h2>${stand.name}

                        <button class="info-btnn">i</button>
                        <div class="info-content">
                            <p>Poster: <br></br>Evaluate visual design, messaging,
                                and impact based on clarity, creativity, and relevance. <br></br>

                                Content: <br></br>Evaluate relevance, accuracy, organization, coherence,
                                and quality based on research, clarity, usefulness, and credibility.<br></br>

                                Presentation: <br></br>Evaluate engagement, key message delivery,
                                objectives achievement, organization, visuals, delivery, audience interaction, and impact.<br></br></p>
                        </div>



                    </h2> 
                </div>
            </div>


            <p>${stand.stand_description}</p>


            <form id="form-login" method="post">

                <p>Poster</p>
                <div class="radio_buttons">
                    <input type="radio" id="poster_one" name="poster_presentation" value="1">
                    <label for="poster_one">1</label>
                    <input type="radio" id=${stand.qrCode} name="poster_presentation" value="2">
                    <label for=${stand.qrCode}>2</label>
                    <input type="radio" id="poster_three" name="poster_presentation" value="3">
                    <label for="poster_three">3</label>
                    <input type="radio" id="poster_four" name="poster_presentation" value="4">
                    <label for="poster_four">4</label>
                    <input type="radio" id="poster_five" name="poster_presentation" value="5">
                    <label for="poster_five">5</label>
                </div>
                <p>Content</p>
                <div class="radio_buttons">
                    <input type="radio" id="content_one" name="content_presentation" value="1">
                    <label for="content_one">1</label>
                    <input type="radio" id="content_two" name="content_presentation" value="2">
                    <label for="content_two">2</label>
                    <input type="radio" id="content_three" name="content_presentation" value="3">
                    <label for="content_three">3</label>
                    <input type="radio" id="content_four" name="content_presentation" value="4">
                    <label for="content_four">4</label>
                    <input type="radio" id="content_five" name="content_presentation" value="5">
                    <label for="content_five">5</label>
                </div>
                <p>Presentation</p>
                <div class="radio_buttons">
                    <input type="radio" id="presentation_one" name="rating_presentation" value="1">
                    <label for="presentation_one">1</label>
                    <input type="radio" id="presentation_two" name="rating_presentation" value="2">
                    <label for="presentation_two">2</label>
                    <input type="radio" id="presentation_three" name="rating_presentation" value="3">
                    <label for="presentation_three">3</label>
                    <input type="radio" id="presentation_four" name="rating_presentation" value="4">
                    <label for="presentation_four">4</label>
                    <input type="radio" id="presentation_five" name="rating_presentation" value="5">
                    <label for="presentation_five">5</label>
                </div>
                <input type="hidden" value="${stand.qrCode}" name="stand_id">
                <div class="submit-button">
                    <input class="button" type="submit" value="Submit"/>
                </div>

            </form>
        </div>
        </c:forEach>

        </div>

    </body>

    <script>
        var infoBtn = document.querySelectorAll('.info-btnn');
        var infoContent = document.querySelectorAll('.info-content');

        infoBtn.forEach(function (btn,i){
            btn.addEventListener('click', function() {
                infoContent[i].classList.toggle('show');
            });
        })

    </script>

</html>
