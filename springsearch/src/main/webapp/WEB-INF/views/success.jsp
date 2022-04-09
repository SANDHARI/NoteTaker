<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Please Verify your Details</h3>

<h1>Your Name: ${student.name }</h1>
<h1>Your Id: ${student.id }</h1>
<h1>Your DOB: ${student.dob }</h1>
<h1>Selected Courses: ${student.courses }</h1>
<h1>Your Gender: ${student.gender }</h1>
<h1>Your Type: ${student.type }</h1>
<hr>
<h1>Your Address:</h1>
<h3>Your Address: ${student.address.street }</h3>
<h3>Your Address: ${student.address.city }</h3>




</body>
</html>