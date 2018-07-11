<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
              
<c:url value="FrontControleur?section=header" var="urlHeader" />
<c:import url="${urlHeader}" />
<title>Page Login</title>
<section>
    
    <c:if test="${LogoutMessage}!null">
        <b><${LogoutMessage}></b>           
    </c:if>
    
    <h3>
        Page Login
    </h3>
    <hr>
    <p>
    <a href="FrontControleur?section=login">Se logger ?</a>
    </p>
    <p>
    <a href="FrontControleur?section=listfilms">Voir les films ?</a>
    </p>
    <p>
        <a href="FrontControleur?section=listeactoravecphotos">Liste des acteurs ?</a>   
    </p>
</section>

<c:url value="FrontControleur?section=footer" var="urlFooter" />
<c:import url="${urlFooter}"/>