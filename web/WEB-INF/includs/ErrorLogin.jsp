<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Login</title>
    </head>
    <body>
        
        <h3>Hello ${usr}  </h3>
        <h3>  ${unmessage}</h3>
        <c:if test="${errorfilm!=null}">
            <h3>${errorfilm}</h3>
        </c:if>
        
        <br>
        <a href="FrontControleur?section=login">Retour pour se logguer ?</a>
    </body>
</html>
