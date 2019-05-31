<%-- 
    Document   : header
    Created on : 4-mag-2019, 17.09.08
    Author     : Alessandro
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <header class="row">
            <div class="col-2 col-s-2 centrato">
                <a href="login.html"><img class="logo" title="Logo" src="./images/logo.png " alt="logo FPW"></a>
            </div>
            <c:if test="${utente.getIdUtente() != null}">
            <div id="logout">
                <a  href="logout.html?logout=${utente.getIdUtente()}">LOGOUT</a>
            </div>
            </c:if>

            <div class="col-10 col-s-10">
                <ul class="topnav">

                    <c:if test="${utente.getIdUtente() != null}">
                        <c:choose>
                            <c:when test="${utente.isOrganizzatore() == false}">
                                <c:choose>
                                    <c:when test="${(pageContext.request.servletPath == '/articoli.jsp') or (pageContext.request.servletPath == '/scriviArticolo.jsp')}">
                                        <li><a href="articoli.html" class="current_page_item">ARTICOLI</a></li>
                                        <li><a href="valutazione.jsp" >VALUTAZIONE</a></li>
                                        <li><a href="registrazione.html">PROFILO</a></li>
                                        </c:when>

                                    <c:when test="${(pageContext.request.servletPath == '/valutazione.jsp')}">
                                        <li><a href="articoli.html">ARTICOLI</a></li>
                                        <li><a href="valutazione.jsp" class="current_page_item" >VALUTAZIONE</a></li>
                                        <li><a href="registrazione.html">PROFILO</a></li>
                                        </c:when>

                                    <c:when test="${(pageContext.request.servletPath == '/profilo.jsp')}">
                                        <li><a href="articoli.html">ARTICOLI</a></li>
                                        <li><a href="valutazione.jsp">VALUTAZIONE</a></li>
                                        <li><a href="registrazione.html" class="current_page_item">PROFILO</a></li>
                                        </c:when>
                                    </c:choose>
                                </c:when>
                                <c:when test="${utente.isOrganizzatore() == true}">
                                <li><a href="gestione.html" class="current_page_item">GESTIONE</a></li>
                                </c:when>
                            </c:choose>
                        </c:if>
                </ul>
            </div>
        </header>
    </body>
</html>
