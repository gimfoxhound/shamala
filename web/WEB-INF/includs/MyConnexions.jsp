<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="MyErrors.jsp" %>
<!DOCTYPE html>


<c:url value="FrontControleur?section=header" var="urlHeader" />
<c:import url="${urlHeader}" />

<section id="sectionConnection">
    
    <h2>
       Connection 
        
    </h2>
    
        <form method="post" action="FrontControleur?section=connectionControleur">
            <label>Usernamee : </label><input type="text" name="txtusername" value="">
            <label>Password : </label><input type="password" name="txtmotdepasse" value="">
            <input type="hidden" name="section" value="ConnectionControleur">
            <input id="submit" type="submit" value="Se Connecter !">            
        </form>
        
        
    
        
        <c:if test="${usr!=null}">
            <p>${message}</p>
        </c:if>
        
        
        
        
    
    
    
    
</section>

<c:url value="FrontControleur?section=footer" var="urlFooter" />
<c:import url="${urlFooter}"/>
