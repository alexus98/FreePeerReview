<%-- 
    Document   : valutazione
    Created on : 7-mag-2019, 16.32.16
    Author     : Alessandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="M1/style.css" media="screen">
        <title>FPW - Valutazioni</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <div class="row">
            <jsp:include page="aside.jsp"/>
            
            <main class="col-10 col-s-10">
                <div id="articolo">
                    <h1>La SQL Injection</h1>
                    <h3>Autori anonimi</h3>
                    <p id="sezImg"><img src="../images/imgArticolo.jpg" id="immagineArticolo" alt="img prova"></p>
                    <h3>Categorie: Servlet, JSP</h3>
                    <h3>Data: 5 Marzo 2019</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisci elit, sed do eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrum exercitationem ullamco laboriosam, nisi ut aliquid ex ea commodi consequatur. Duis aute irure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                </div>

                <div id="valutazione">
                    <h1>Valutazione</h1>
                    <form action="" method="post">
                        <p class="bold">Voto</p>
                        <label for="1">1</label>
                        <input type="radio" name="voto" id="1" value="1">

                        <label for="2">2</label>
                        <input type="radio" name="voto" id="2" value="2">

                        <label for="3">3</label>
                        <input type="radio" name="voto" id="3" value="3">

                        <label for="4">4</label>
                        <input type="radio" name="voto" id="4" value="4">

                        <label for="5">5</label>
                        <input type="radio" name="voto" id="5" value="5">



                        <p><label for="commentiOrganizzatori" class="bold">Commenti per gli organizzatori</label></p>
                        <p><textarea class="testo" id="commentiOrganizzatori"></textarea></p>

                        <p><label for="commentiAutori" class="bold">Commenti per gli autori</label></p>
                        <p><textarea class="testo" id="commentiAutori"></textarea></p>

                        <p class="centrato"><input type="submit" value="INVIA" class="bottone"></p>

                    </form>
                </div>
            </main>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
