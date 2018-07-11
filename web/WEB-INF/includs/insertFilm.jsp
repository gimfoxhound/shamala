<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="MyErrors.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insertion Film</title>
    
    
 
</head>

<body  style="background-color:powderblue;">
<center><h2>Java Registration Film application using MVC and MySQL </h2></center>
                                                 
<form name="form" action="FrontControleur?section=InsertionFilm" method="post" onsubmit="return validate()" enctype="multipart/form-data">
<table align="center">
 <tr>
 <td>Titre</td>
 <td><input type="text" name="txttitle" /></td>
 </tr>
 <tr>
 <td>Description</td>
 <td><input type="text" name="txtdescription" /></td>
 </tr>
 <tr>     
 <td>Release Year</td>
 <td><input type="text" name="txtrelease_year" /></td>
 </tr>
 <tr>
 <td>Length</td>
 <td><input type="text" name="txtlength" /></td>
 </tr>
 <tr>
 <td>Price</td>
 <td><input type="text" name="txtprice" /></td>
 </tr>
 <tr>
 <td>Quantities</td>
 <td><input type="text" name="txtquantite" /></td>
 </tr>
 
 <tr>
 <td>Box Cover</td>
 <td><input type="file" name="boxcover" /></td>
 </tr>
 
 
 <tr>     
 <td><%=(request.getAttribute("errMessage") == null) ? ""
 : request.getAttribute("errMessage")%></td>
 </tr>
 <tr>
 <td></td>
 <td><input type="submit" value="Inserer"></input><input
 type="reset" value="Reset"></input></td>
 </tr>
</table>
</form>
</html>
