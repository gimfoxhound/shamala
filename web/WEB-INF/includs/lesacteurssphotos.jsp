<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="MyErrors.jsp" %>
<!DOCTYPE html>
<c:if test="${usr==null}">
    <c:redirect url="FrontControleur?section=login"/>
</c:if>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des acteurs avec photos</title>
    </head>
    <body>
        <c:if test="${usr!=null}">
            <p>${usr} vous visionnez les acteurs</p>
        
            <p>
                <a href="FrontControleur?section=logout">Se deloguer ?</a>
            </p>
            <hr>
            <table border="1">
                <thead>
                <th>Prenom</th>   
                <th>Nom</th>
                <th>sex</th>
                <th>Date de naissance</th>
                <th>Photo</th>
                </thead>                
                <tbody>
                    <c:forEach items="${lstactorssphotos}" var="lesactors">
                        <tr>
                            <td>${lesactors.first_name}</td>
                            <td>${lesactors.last_name}</td>
                            <td>${lesactors.sex}</td>
                            <td>${lesactors.birthdate}</td>
                            <td><a href="${lesactors.img}" target="_blank" ><img width="102" height="102" src="${lesactors.img}"/></a></td>
                               
                                
                   </tr>
                        
                        
                    </c:forEach>  
                    
                </tbody>
                
                
            </table>
            
        </c:if>
    </body>
</html>
