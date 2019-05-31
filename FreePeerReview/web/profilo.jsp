<%-- 
    Document   : profilo
    Created on : 7-mag-2019, 12.08.29
    Author     : Alessandro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="M1/style.css" media="screen">
        <title>FPW - Profilo</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="row">
            <jsp:include page="aside.jsp"/>            
            
            <main class="col-10 col-s-10">
                <div class="sezProfilo centrato">
                    <h1 >PROFILO</h1>
                    <form>
                        <c:choose>
                            <c:when test="${utente.getFoto() == null}">
                                <img src="images/profilo.jpg" alt="foto profilo" id="imgProf">
                            </c:when>
                            <c:otherwise>
                                <img src="${utente.getFoto()}" alt="foto profilo" id="imgProf">
                            </c:otherwise>
                        </c:choose>
                        <p>
                            <label for="nome" class="lab bold">Nome</label>
                            <input type="text" name="nome" value="${utente.getName()}" id="nome" placeholder="Nome">
                        </p>

                        <p>
                            <label for="cognome" class="lab bold">Cognome</label>
                            <input type="text" name="cognome" value="${utente.getSurname()}" id="cognome" placeholder="Cognome">
                        </p>

                        <p>
                            <label for="foto" class="lab bold">Foto</label>
                            <input type="url" name="foto" value="${utente.getFoto()}" id="foto" placeholder="Inserisci l'url">
                        </p>

                        <p>
                            <label for="email" class="lab bold">Email</label>
                            <input type="email" name="email" value="${utente.getEmail()}" id="email" placeholder="Email">
                        </p>

                        <p>
                            <label for="password" class="lab bold">Password</label>
                            <input type="password" name="password" value="${utente.getPassword()}" id="password" placeholder="Password">
                        </p>

                        <p>
                            <label for="ente" class="lab bold">Ente</label>
                            <input type="text" name="ente" value="${utente.getEnte()}" id="ente" placeholder="Ente">
                        </p>

                        <p>
                            <input type="submit" value="SALVA" class="bottone">
                        </p>
                    </form>

                    <p  id="cancellati"><a href=""> CANCELLATI</a></p>
                </div>
            </main>
            
        </div>
        
        
        <jsp:include page="footer.jsp"/>
    </body>
</html>