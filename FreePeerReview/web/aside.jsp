<%-- 
    Document   : aside
    Created on : 7-mag-2019, 11.24.30
    Author     : Alessandro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <aside class="col-2 col-s-2">
            <c:choose>
                <c:when test="${utente.getIdUtente() != null}">
                    <div id="saluto">
                        <c:choose>
                            <c:when test="${(utente.isOrganizzatore() == false)}">
                                <p>Ciao <a href="profilo.jsp" >${utente.getName()}</a></p>
                                </c:when>
                                <c:otherwise>
                                <p>Ciao Organizzatore</p>
                            </c:otherwise>
                        </c:choose>
                        <a href="logout.html?logout=${utente.getIdUtente()}" class="bottone" name="logout">LOGOUT</a>
                    </div>
                    <c:choose>
                        <c:when test="${(utente.isOrganizzatore()  == false)}">
                            <div id="iMieiArticoli">
                                <h4>I miei articoli</h4>
                                <ul>
                                    <c:forEach end="${mieiArticoli.size()}" var="a" items="${mieiArticoli}">
                                        <li><a href="">${a.getTitolo()}</a></li>
                                        </c:forEach>
                                </ul>
                            </div>

                            <div id="miniMieiArticoli">
                                <a href="articoli.html">I miei articoli</a>
                            </div>

                            <div id="daValutare">
                                <h4>Da Valutare</h4>
                                <ul>
                                    <c:forEach begin="0" end="2" var="a" items="${articoliDaValutare}">
                                        <li><a href="">${a.getTitolo()}</a></li>
                                        </c:forEach>
                                </ul>
                            </div>

                            <div id="miniDaValutare">
                                <a href="valutazione.html">Da Valutare</a>
                            </div>

                        </c:when>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <div class="centrato" style="padding-top: 10px">
                        <a href="login.html" class="bottone" name="login">LOGIN</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </aside>
    </body>
</html>
