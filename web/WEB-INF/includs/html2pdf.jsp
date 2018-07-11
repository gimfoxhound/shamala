<%@page errorPage="MyErrors.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HTML vers PDF</title>
    </head>
    <body>
        <h2>HTML ----> PDF</h2>
        <form action="FrontControleur?section=pdfgeneration" method="POST">
            <div>My Invoice</div>
            <textarea name="html" rows="50" cols="60" >Facturation :::: <jsp:include page='CheckoutMVC.jsp'/> </textarea>
            
                    
            <input type="hidden" name="action" value="genPDF"><input type="submit" value=">>> Generation PDF">
        
        </form>
        
        
    </body>
</html>
