
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="MyErrors.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des films</title>
    </head>
    <c:if test="${usr==null}">
                  <c:redirect url="FrontControleur?section=login"/>
             </c:if>      
    <body>
         <c:if test="${usr!=null}">
            <p>Hello ${usr} </p> 
        <hr>
        <p>
         Hello    
        </p>
        
        <p>
        <a href="FrontControleur?section=logout">SE delogguer ?</a>     
        </p>
        <p>
            <a href="FrontControleur?section=IndexControl">Retour à l'index</a>    
        </p>
        
        <c:if test="${msgError!=null}">
            <h4>Probleme rencontré : <c:out value="${msgError}"></c:out> </h4>
        </c:if>
        
        <p>
         Quantite actuelle dans panier ${nbelementdanspanier} articles. et le montant actuel est de : ${prixdelacommande} euros.  
        </p> 
        
        <p>
            <a href="FrontControleur?section=ShoppingCartMVC">Voir le contenu du panier</a>    
        </p>
        
        
        <h3>Catalogue</h3>      
      <table border="1">
      <thead>
      <th>Title</th>    
      <th>Description</th>
      <th>Quantitee</th>
      <th>Prix</th>
      <th>QQCH</th>       
      </thead>
      <tbody>
          <c:forEach items="${lisfilms}"  var="lesfilms">
              <tr>
                  <td>${lesfilms.title}</td>   
                  <td>${lesfilms.description}</td>
                  <td>${lesfilms.quantite}</td>
                  <td>${lesfilms.price}</td>
                  
                  
 <td><form name="modelDetail1" method="POST" action="FrontControleur?section=shopcontroller1">
 <font size="2" face="Verdana, Arial, Helvetica, sans-serif">
        
       <strong>Title:</strong>
        ${lesfilms.title}</font>
        <input type="hidden" name="modelNo" value="${lesfilms.title}">
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
          
      <strong>Description:</strong>
        ${lesfilms.description} </font><input type="hidden" name="description" value="${lesfilms.description}"></p>
      
      
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">       
       <strong>Quantity:</strong>
       <input type="text" size="2" value="1" name="quantity"></font></p>  
      
      
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
       <strong>Price:</strong> ${lesfilms.price}</font><input type="hidden" name="price" value="${lesfilms.price}"></p>      
      <p><font size="2" face="Verdana, Arial, Helvetica, sans-serif">
          
        <strong>Box Cover:</strong> </font><input type="hidden" name="boxcover" value="${lesfilms.boxcover}">
        <a href="${lesfilms.boxcover}" target="_blank" ><img alt="fiche" width="102" height="102" src="${lesfilms.boxcover}"/></a>
      
      </p>            
      <input type="hidden" name="action" value="add">
      <input type="submit" name="addToCart" value="Add To Cart">
      </form></td>
              </tr>    
          </c:forEach>
        </c:if>
              
    </body>
</html>
