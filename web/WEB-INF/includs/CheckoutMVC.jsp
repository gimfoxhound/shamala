<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page errorPage="MyErrors.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check-Out paiement</title>
    </head>
    <body>
        <h2>Facturation</h2>
        <table border="3">
            <thead>
            <th>Prenom</th>   
            <th>Nom</th>
            <th>email</th>
            <th>Adresse</th>
            <th>Ville</th>
            
            </thead>
            <tr>
                <td><c:out value="${usr.prenom}"> </c:out></td>    
                <td><c:out value="${usr.nom}"> </c:out></td>
                <td><c:out value="${usr.email}"> </c:out></td>
                <td><c:out value="${usr.adresse}"> </c:out></td>
                <td><c:out value="${usr.ville}"> </c:out></td>
            </tr>
            
            
        </table>
        
        
        
        <table border="1">
            <thead>
            <th>Titre</th>    
            <th>Description</th>
            <th>Quantité</th>
            <th>Prix</th>
            <th>Box Cover</th>
            <th></th>
            </thead>
            
               
            <c:forEach items="${filmschoisis}" var="lesfilms">
                <c:if test="${lesfilms.quantite>0}" >
                <tr>
                    <td>${lesfilms.title}<input type="hidden" name="modelNo" value="${lesfilms.title}"></td>
                    <td>${lesfilms.description}<input type="hidden" name="description" value="${lesfilms.description}"></td>
                    <td>${lesfilms.quantite}</td>
                    <td>${lesfilms.price}<input type="hidden" name="price" value="${lesfilms.price}"></td>
                    <td><a href="${lesfilms.boxcover}" target="_blank" ><img alt="fiche" width="102" height="102" src="${lesfilms.boxcover}"/></a></td>
                
                </tr>
                 </c:if>
            </c:forEach>
              
                <tr><td><font size="4"  face="Verdana, Arial, Helvetica, sans-serif" ><b>Le Montant de la facture ------------>  ${prixdelacommande} euros</b></font> </td></tr>
        </table>
        
        <form action="FrontControleur?section=htmlverspdf" method="POST">        
            <input type="submit" value="Vers PDF">
        </form>
        
    </body>
    
</html>