<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="MyErrors.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Articles dans panier</title>
    </head>
    <body>
        <h3>Articles présents dans votre panier</h3>
         
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
                
                <form  method="POST" action="FrontControleur?section=shopcontroller1">
                    
                    <td>${lesfilms.title}<input type="hidden" name="modelNo" value="${lesfilms.title}"></td>
                    <td>${lesfilms.description}<input type="hidden" name="description" value="${lesfilms.description}"></td>
                    <td>${lesfilms.quantite}</td>
                    <td>${lesfilms.price}<input type="hidden" name="price" value="${lesfilms.price}"></td>
                    <td><a href="${lesfilms.boxcover}" target="_blank" ><img alt="fiche" width="102" height="102" src="${lesfilms.boxcover}"/></a></td>
                    
                      <td><input type="hidden" name="action" value="remove"><input type="submit" name="remove" value="Enlever"></td>
                </form>
                </tr>
                 </c:if>
            </c:forEach>
              
                <tr><td><font size="4"  face="Verdana, Arial, Helvetica, sans-serif" ><b>Le Montant de la facture ------------>  ${prixdelacommande} euros</b></font> </td></tr>
        </table>
        <form action="FrontControleur?section=checkout" method="POST">
        <table>
            <tr>
                <td><input type="submit" value="Valider"> </td>   
            </tr>   
        </table>  
        </form>
          
        <p>
            <a href="FrontControleur?section=listfilms">Ajoutez article ?</a>   
        </p>        
        
    </body>
</html>
