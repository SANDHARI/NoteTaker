<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
</head>
<body>

<h1>${Header }</h1>
<p>${Desc }</p>

<h2 style="color:green" class="text-center">${msg }</h2>

<h1>Welcome ${user.userName }</h1>
<h1>Your Email :  ${user.email }</h1>
<h1>Your Password : ${user.password }</h1>
<h1>Please change your password after first login</h1>


</body>
</html>