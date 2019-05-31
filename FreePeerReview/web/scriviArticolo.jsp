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
        <title>FPW - Nuovo Articolo</title>
        <link rel="stylesheet" type="text/css" href="M1/style.css" media="screen">
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <div class="row">
            <jsp:include page="aside.jsp"/>

            <main class="col-10 col-s-10 centrato">
                <c:choose>
                    <c:when test="${utente.isOrganizzatore() == false}">
                        <h1>Scrivi Articolo</h1>
                        <div id="scriviArticolo">
                            <form action="scriviArticolo.html?pid=${mieiArticoli.get(i).getIdArticolo()}" method="post">
                                <p>
                                    <label for="titolo" class="lab bold">Titolo</label>
                                    <input type="text" value="${articolo.getTitolo()}" name="titolo" id="titolo" placeholder="Titolo">
                                </p>

                                <p>
                                    <label for="autori" class="lab bold">Autori</label>
                                    <!--<input type="text" value="<c:forEach begin="0" end="${articolo.getAutore().size()-1}" var="i">${articolo.getAutore().get(i).getName()}</c:forEach>" name="autori" id="autori" placeholder="Autori">-->
                                    <select size="”${allUtenti.size()-1}" multiple>
                                        <c:forEach begin="0" end="${allUtenti.size()-1}" var="i">
                                            <option value="${allUtenti.get(i).getIdUtente()}">${allUtenti.get(i).getName()}</option>
                                        </c:forEach>
                                    </select>
                                </p>

                                <p class="bold">Categorie</p>
                                <div>
                                    <p class="inline">
                                        <label class="lab" for="html"><input type="checkbox" name="html" value="1" <c:if test="${articolo.isCategoria(1)==true}">checked</c:if>>HTML</label>
                                        </p>
                                        <p class="inline">
                                            <label class="lab" for="jsp"><input type="checkbox" name="jsp" value="2" <c:if test="${articolo.isCategoria(2)==true}">checked</c:if>>JSP</label>
                                        </p>
                                    </div>

                                    <div>
                                        <p class="inline">
                                            <label class="lab" for="css"><input type="checkbox" name="css" value="3" <c:if test="${articolo.isCategoria(3)==true}">checked</c:if>>CSS</label>
                                        </p>

                                        <p class="inline">
                                            <label class="lab" for="javascript"><input type="checkbox" name="javascript" value="4" <c:if test="${articolo.isCategoria(4)==true}">checked</c:if>>JavaScript</label>
                                        </p>
                                    </div>

                                    <div>
                                        <p class="inline">
                                            <label class="lab" for="servlet"><input type="checkbox" name="servlet" value="5" <c:if test="${articolo.isCategoria(5)==true}">checked</c:if>>Servlet</label>
                                        </p>

                                        <p class="inline">
                                            <label  class="lab" for="ajax"><input type="checkbox" name="ajax" value="6" <c:if test="${articolo.isCategoria(6)==true}">checked</c:if>>AJAX</label>
                                        </p>
                                    </div>

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
            </main>

        </div>




        <jsp:include page="footer.jsp"/>
    </body>
</html>
+