<%-- 
    Document   : gestione
    Created on : 12-mag-2019, 10.54.06
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

        <title>FPW - Gestione</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <div class="row">
            <jsp:include page="aside.jsp"/>

            <main class="col-10 col-s-10 centrato">
                <c:if test="${utente.getIdUtente() != null}">
                    <c:choose>
                        <c:when test="${utente.isOrganizzatore() == true}">
                            <div>
                                <table id="tabellaArticoli">
                                    <tr>
                                        <th>Data</th>
                                        <th>Titolo</th>
                                        <th>Valutazioni</th>
                                        <th>Decisione</th>
                                    </tr>

                                    <c:forEach begin="0" end="${articoli.size()-1}" var="i">
                                        <c:choose>
                                            <c:when test="${i % 2 == 0}">
                                                <tr class="pari">
                                                </c:when>
                                                <c:otherwise>
                                                <tr class="dispari">
                                                </c:otherwise>
                                            </c:choose>

                                            <td> ${articoli.get(i).getDataFormatoClassico()}</td>
                                            <td>${articoli.get(i).getTitolo()}</td>

                                            <td>
                                                <c:choose>
                                                <c:when test="${articoli.get(i).getStato().getNomeStato() != 'APERTO'}">
                                                    ${articoli.get(i).getValutazioni().size()}/3
                                                </c:when>
                                                <c:otherwise>
                                                    <a href="">Decidi Valutatori</a>
                                                </c:otherwise>
                                                </c:choose>    
                                                </td>

                                            <c:choose>
                                                <c:when test="${articoli.get(i).getStato().getNomeStato() == 'APERTO'}">
                                                    <td class="aperto">Aperto</td>
                                                </c:when>
                                                <c:when test="${(articoli.get(i).getStato().getNomeStato() == 'VALUTAZIONE')}">
                                                    <c:if test="${(articoli.get(i).getValutazioni().size()-1 == 3)}">
                                                        <td class="inValutazione"><a href="">Decidi<a></td>
                                                                </c:if>
                                                    <c:if test="${(articoli.get(i).getValutazioni().size()-1 != 3)}">
                                                        <td class="inValutazione">In attesa valutazioni</td>
                                                                </c:if>                
                                                </c:when>
                                                <c:when test="${articoli.get(i).getStato().getNomeStato() == 'ACCETTATO'}">
                                                    <td class="accettato">Accettato</td>
                                                </c:when>
                                                <c:when test="${articoli.get(i).getStato().getNomeStato() == 'RIFIUTATO'}">
                                                    <td class="rifiutato">Respinto</td>
                                                </c:when>
                                            </c:choose>
                                        </tr>
                                    </c:forEach>
                                </table>
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
