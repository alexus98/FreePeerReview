<%-- 
    Document   : registrazione
    Created on : 7-mag-2019, 16.37.50
    Author     : Alessandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="M1/style.css" media="screen">
        <title>FPW - Registrazione</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <div class="row">
            <main class="col-12 col-s-12 centrato" id="right">
                <h1>REGISTRAZIONE</h1>
                <form action="articoli.html" method="post" class="login">
                    <p><label for="user" class="bold">Username</label></p>

                    <p><input type="text" name="user" id="user" placeholder="Username"></p>

                    <p><label for="nome" class="bold">Nome</label></p>

                    <p><input type="text" name="nome" id="nome" placeholder="Nome"></p>

                    <p><label for="cognome" class="bold">Cognome</label></p>

                    <p><input type="text" name="cognome" id="cognome" placeholder="Cognome"></p>

                    <p><label for="email" class="bold">Email</label></p>

                    <p><input type="email" name="email" id="email" placeholder="Email"></p>

                    <p><label for="psw" class="bold">Password</label></p>

                    <p><input type="password" name="psw" id="psw" placeholder="Password"></p>

                    <p><label for="ente" class="bold">Ente</label></p>

                    <p><input type="url" name="ente" id="ente" placeholder="Ente"></p>

                    <p><input type="submit" value="REGISTRATI" class="bottone"></p>
                </form>
            </main>
        </div>
        
        <jsp:include page="footer.jsp"/>
    </body>
</html>
