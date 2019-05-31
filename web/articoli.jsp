<%-- 
    Document   : articoli
    Created on : 7-mag-2019, 11.21.21
    Author     : Alessandro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <title>FPW - Articoli</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="row">
            <jsp:include page="aside.jsp"/>

            <main class="col-10 col-s-10 centrato">

                <c:if test="${utente.getIdUtente() != null}">
                    <c:choose>
                        <c:when test="${utente.isOrganizzatore() == false}">
                            <div>
                                <h1>I MIEI ARTICOLI</h1>
                                <table id="tabellaArticoli">
                                    <tr>
                                        <th>Data</th>
                                        <th>Titolo</th>
                                        <th>Stato</th>
                                        <th>Azione</th>
                                    </tr>
                                    <c:if test="${mieiArticoli.size() != 0}">
                                        <c:forEach begin="0" end="${mieiArticoli.size()-1}" var="i">
                                            <c:choose>
                                                <c:when test="${i % 2 == 0}">
                                                    <tr class="pari">
                                                    </c:when>
                                                    <c:otherwise>
                                                    <tr class="dispari">
                                                    </c:otherwise>
                                                </c:choose>

                                                <td> ${mieiArticoli.get(i).getDataFormatoClassico()}</td>
                                                <td>${mieiArticoli.get(i).getTitolo()}</td>
                                                <c:choose>
                                                    <c:when test="${mieiArticoli.get(i).getStato().getNomeStato() == 'APERTO'}">
                                                        <td class="aperto">Aperto</td>
                                                    </c:when>
                                                    <c:when test="${mieiArticoli.get(i).getStato().getNomeStato() == 'VALUTAZIONE'}">
                                                        <td class="inValutazione">In Valutazione</td>
                                                    </c:when>
                                                    <c:when test="${mieiArticoli.get(i).getStato().getNomeStato() == 'ACCETTATO'}">
                                                        <td class="accettato">Accettato</td>
                                                    </c:when>
                                                    <c:when test="${mieiArticoli.get(i).getStato().getNomeStato() == 'RIFIUTATO'}">
                                                        <td class="rifiutato">Rifiutato</td>
                                                    </c:when>
                                                </c:choose>
                                                <td>
                                                    <c:if test="${mieiArticoli.get(i).getStato().getNomeStato() == 'APERTO' or mieiArticoli.get(i).getStato().getNomeStato() == 'VALUTAZIONE'}">
                                                        <a href=""><img src="images/cestino.png" class="azione" alt="Cancella"></a>
                                                        </c:if>
                                                        <c:if test="${mieiArticoli.get(i).getStato().getNomeStato() == 'APERTO'}">
                                                        <a href="scriviArticolo.html?pid=${mieiArticoli.get(i).getIdArticolo()}">
                                                            <img src="images/penna.png" class="azione" alt="Modifica">
                                                        </a>
                                                    </c:if>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>
                                </table>
                                <p><a href="scriviArticolo.html" class="bottone">NUOVO ARTICOLO</a></p>
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
