<%-- 
    Document   : login
    Created on : 7-mag-2019, 11.00.05
    Author     : Alessandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <title>FPW - Login</title>
    </head>
    
    <body>
        <jsp:include page="header.jsp"/>
        
        <div class="row">
            <main class="centrato">
                <h1>LOGIN</h1>
                <form action="login.html" method="post" class="login">

                    <p>
                        <label for="username" class="bold"> Username: </label>
                    </p>

                    <p>
                        <input type="email" name="username" id="username" placeholder="Username">
                    </p>

                    <p>
                        <label for="password" class="bold"> Password: </label>
                    </p>
                    <p>
                        <input type="password" name="password" id="password" placeholder="Password">

                    </p>

                    <p>
                        <input type="submit" value="LOGIN" name="login" class="bottone">
                    </p>
                    <p>Non sei ancora registrato? <a href="registrazione.html" class="bold">REGISTRATI</a></p>
                </form>
            </main>
        </div>
        
        <jsp:include page="footer.jsp"/>
    </body>
</html>
