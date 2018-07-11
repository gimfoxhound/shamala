
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  isErrorPage="true" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Error</title>
    </head>
    <body>
        <h3>Probleme rencontré : ${msgError}</h3>
        <h4>Probleme rencontré : <c:out value="${msgError}"></c:out> </h4>
        <c:out value="${msgException}"/>
        <a href="FrontControleur?section=IndexControl">Retour</a>
    </body>
</html>
