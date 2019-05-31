<%-- 
    Document   : index
    Created on : 7-mag-2019, 10.47.02
    Author     : Alessandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <title>FPW - Home</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        
        <div class="row">
            <main class="col-12 col-s-12 centrato">
                <h1>BENVENUTO SU FPW</h1>
                <a href="login.html" class="bottone centrato">LOGIN</a>
            </main>
        </div>
        
        <jsp:include page="footer.jsp"/>
    </body>
</html>
