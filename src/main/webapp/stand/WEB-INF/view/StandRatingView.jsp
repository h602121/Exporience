<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.expo.Model.Entity.Stand" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Stand Rating</title>
        <link rel="stylesheet" href="css/Standard.css">
    </head>

    <body>
        <h1>Stand Rating</h1>

        <div class="stand">
            <div class="stand_header">
                <div class="stand_header_text">
                    <h2>${stand.getName()}</h2>
                </div>
            </div>

            <p>${stand.getStand_description()}</p>

            <p>QR Code:</p>
            <div class="qr-code">
                <img src="${stand.generateQRCodeUrl()}">
            </div>

            <form method="post">
                <h3>Rate the Stand:</h3>

                <div class="rating">
                    <span>Presentasjon:</span>
                    <div class="stars">
                        <input type="radio" name="presentation" id="presentation_1" value="1" />
                        <label for="presentation_1"></label>

                        <input type="radio" name="presentation" id="presentation_2" value="2" />
                        <label for="presentation_2"></label>

                        <input type="radio" name="presentation" id="presentation_3" value="3" />
                        <label for="presentation_3"></label>

                        <input type="radio" name="presentation" id="presentation_4" value="4" />
                        <label for="presentation_4"></label>

                        <input type="radio" name="presentation" id="presentation_5" value="5" />
                        <label for="presentation_5"></label>
                    </div>
                </div>

                <div class="rating">
                    <span>Panel:</span>
                    <div class="stars">
                        <input type="radio" name="panel" id="panel_1" value="1" />
                        <label for="panel_1"></label>

                        <input type="radio" name="panel" id="panel_2" value="2" />
                        <label for="panel_2"></label>

                        <input type="radio" name="panel" id="panel_3" value="3" />
                        <label for="panel_3"></label>

                        <input type="radio" name="panel" id="panel_4" value="4" />
                        <label for="panel_4"></label>

                        <input type="radio" name="panel" id="panel_5" value="5" />
                        <label for="panel_5"></label>
                    </div>
                </div>

                <div class="rating">
                    <span>Innhold:</span>
                    <div class="stars">
                        <input type="radio" name="content" id="content_1" value="1" />
                        <label for="content_1"></label>

                        <input type="radio" name="content" id="content_2" value="2" />
                        <label for="content_2"></label>

                        <input type="radio" name="content" id="content_3" value="3" />
                        <label for="content_3"></label>

                        <input type="radio" name="content" id="content_4" value="4" />
                        <label for="content_4"></label>
                        <input type="radio" name="content" id="content_5" value="5" />
                        <label for="content_5"></label>
                    </div>
                </div>
    
                <div class="rating">
                    <span>Interaksjon:</span>
                    <div class="stars">
                        <input type="radio" name="interaction" id="interaction_1" value="1" />
                        <label for="interaction_1"></label>
    
                        <input type="radio" name="interaction" id="interaction_2" value="2" />
                        <label for="interaction_2"></label>
    
                        <input type="radio" name="interaction" id="interaction_3" value="3" />
                        <label for="interaction_3"></label>
    
                        <input type="radio" name="interaction" id="interaction_4" value="4" />
                        <label for="interaction_4"></label>
    
                        <input type="radio" name="interaction" id="interaction_5" value="5" />
                        <label for="interaction_5"></label>
                    </div>
                </div>
    
                <button type="submit">Submit</button>
            </form>
    
        </div>
    
    </body>
    
