<%-- 
    Document   : scriviArticolo
    Created on : 7-mag-2019, 12.44.07
    Author     : Alessandro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FPW - Scrivi Articolo</title>
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <div class="row">
            <jsp:include page="aside.jsp"/>

            <main class="col-10 col-s-10 centrato">
                <c:if test="${utente.getIdUtente() != null}">
                    <c:choose>
                        <c:when test="${utente.isOrganizzatore() == false}">
                            <h1>Scrivi Articolo</h1>
                            <div id="scriviArticolo">
                                <form action="scriviArticolo.html?pid=${articolo.getIdArticolo()}" method="post">
                                    <p>
                                        <label for="titolo" class="lab bold">Titolo</label>
                                        <input type="text" value="${articolo.getTitolo()}" name="titolo" id="titolo" placeholder="Titolo">
                                    </p>

                                    <p>
                                        <label for="textAutori" class="lab bold">Autori</label>
                                        <textarea class="autori" name="authorsText" id="textAutori">${articolo.stampaAutori()}</textarea>
                                        <br>
                                        <select name="listaAutori" id="listaAutori">
                                            <option value= null ></option>
                                            <c:forEach begin="0" end="${allAutori.size()}" var="autore" items="${allAutori}">
                                                <option value="${autore.getIdUtente()}">${autore.getName()} ${autore.getSurname()}</option>
                                            </c:forEach>
                                        </select>
                                    </p>

                                    <p class="bold">Categorie</p>
                                    <c:forEach begin="1" end="${allCategorie.size()}" var="i" step="2">
                                        <div>
                                            <p class="inline">
                                                <label class="lab" for="servlet"><input type="checkbox" name="categoria" value="${i}" <c:if test="${articolo.isCategoria(i)==true}">checked</c:if>>${allCategorie.get(i-1).getNomeCategoria()}</label>
                                                </p>

                                                <p class="inline">
                                                    <label  class="lab" for="ajax"><input type="checkbox" name="categoria" value="${i+1}" <c:if test="${articolo.isCategoria(i+1)==true}">checked</c:if>>${allCategorie.get(i).getNomeCategoria()}</label>
                                                </p>
                                            </div>
                                    </c:forEach>

                                    <p>
                                        <label for="immagine" class="lab bold">Immagine</label>
                                        <input type="text" name="immagine" value="${articolo.getImmagine()}" id="immagine" placeholder="Inserisci l'url">
                                    </p>

                                    <p>
                                        <label for="data" class="lab bold">Data</label>
                                        <input type="date" name="data"  value="${articolo.getData()}" id="data">
                                    </p>

                                    <p><br><label for="testo" class="bold">Testo</label></p>
                                    <p><textarea class="testo" name="testo">${articolo.getTesto()}</textarea></p>

                                    <p><input type="submit" value="SALVA" name="salva" class="bottone"></p>

                                </form>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div><h1>ACCESSO NEGATO</h1></div>
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </main>

        </div>




        <jsp:include page="footer.jsp"/>
    </body>
</html>