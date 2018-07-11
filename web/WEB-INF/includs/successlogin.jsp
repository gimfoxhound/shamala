<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="MyErrors.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success Login!</title>
    </head>
    <body>
        
        
        <h3>Hello ${usr}  </h3>
        <h3>  ${unmessage}</h3>
        <p>
        <a href="FrontControleur?section=listfilms">Liste of films</a>
        </p>
        <p>
        <a href="FrontControleur?section=insertacteurpage2">Enregistrer Acteur ?</a>
        </p>
        <p>
            <a href="FrontControleur?section=InsertionFilmPage">Enregistrer un film ?</a>   
        </p>
        
        
        <p>
        <a href="FrontControleur?section=listeactoravecphotos">Liste of acteurs ?</a>
        </p>
        <a href="FrontControleur?section=logout">SE delogguer ?</a>
    </body>
</html>
