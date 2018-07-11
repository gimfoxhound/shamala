<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="MyErrors.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Acteur</title>
    </head>
    <title>Register</title>
 
</head>

<body  style="background-color:powderblue;">
<center><h2>Java Registration Actor application using MVC and MySQL </h2></center>
<form name="form" action="FrontControleur?section=InsertionActeuract2" method="post" onsubmit="return validate()" enctype="multipart/form-data">
<table align="center">
 <tr>
 <td>Firstname</td>
 <td><input type="text" name="txtfirstname" /></td>
 </tr>
 <tr>
 <td>Lastname</td>
 <td><input type="text" name="txtlastname" /></td>
 </tr>
 <tr>     
 <td>Sex</td>
 <td><input type="text" name="txtsex" /></td>
 </tr>
 <tr>
 <td>Birthdate</td>
 <td><input type="text" name="txtbirthdate" /></td>
 </tr>
 <tr>
 <td>Size</td>
 <td><input type="text" name="txttaille" /></td>
 </tr>
 <tr>
 <td>Last Update</td>
 <td><input type="text" name="txtlast_update" /></td>
 </tr>
 <tr>
 <td>Image</td>
 <td><input type="text" name="txtimg" /></td>
 </tr>
 <tr>
 <td>Image Upload</td>
 <td><input type="file" name="txfile" /></td>
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
