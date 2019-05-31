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
                <a href="index.jsp"><img class="logo" title="Logo" src="./images/logo.png " alt="logo FPW"></a>
            </div>

            <div id="logout">
                <a  href="../index.html">LOGOUT</a>
            </div>

            <div class="col-10 col-s-10">
                <ul class="topnav">
                    <c:choose>
                        <c:when test="${utente.isOrganizzatore() == false}">
                            <c:choose>
                                <c:when test="${(pageContext.request.servletPath == '/articoli.jsp') or (pageContext.request.servletPath == '/scriviArticolo.jsp')}">
                                    <li><a href="articoli.jsp" class="current_page_item">ARTICOLI</a></li>
                                    <li><a href="valutazione.jsp" >VALUTAZIONE</a></li>
                                    <li><a href="profilo.jsp">PROFILO</a></li>
                                    </c:when>

                                <c:when test="${(pageContext.request.servletPath == '/valutazione.jsp')}">
                                    <li><a href="articoli.jsp">ARTICOLI</a></li>
                                    <li><a href="valutazione.jsp" class="current_page_item" >VALUTAZIONE</a></li>
                                    <li><a href="profilo.jsp">PROFILO</a></li>
                                    </c:when>

                                <c:when test="${(pageContext.request.servletPath == '/profilo.jsp')}">
                                    <li><a href="articoli.jsp">ARTICOLI</a></li>
                                    <li><a href="valutazione.jsp">VALUTAZIONE</a></li>
                                    <li><a href="profilo.jsp" class="current_page_item">PROFILO</a></li>
                                    </c:when>
                                </c:choose>
                            </c:when>
                            <c:when test="${utente.isOrganizzatore() == true}">
                            <li><a href="gestione.jsp" class="current_page_item">GESTIONE</a></li>
                        </c:when>
                    </c:choose>

                </ul>
            </div>
        </header>
    </body>
</html>
