<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="MyErrors.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertion Actor success</title>
    </head>
    <body>
        <h3>L'acteur en question a été inséré dans la base!</h3>
        <p>
        <p>Le fichier ${fichierCharge} a bien été entre dans la DB </p>
        
        <hr>    
        
        <a href="FrontControleur?section=listeactoravecphotos">Visionnez les acteurs ?</a>
        </p>
        <p>
        <a href="FrontControleur?section=listfilms">Retour aux films ?</a>
        </p>
        <p>
            <a href="FrontControleur?section=InsertionFilmPage">Enregistrer un film</a>    
        </p>
        
    </body>
</html>
