<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page isELIgnored="false" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Help PAgee</title>
</head>
<body>


<%
/* String name = (String)request.getAttribute("name");
Integer eid=(Integer)request.getAttribute("eid");

LocalDateTime time = (LocalDateTime)request.getAttribute("time"); */

%>

<%-- <h1>Hello <%=name %></h1> --%>
<%-- <h1>Your Emp Id <%=eid %></h1>
<h1>Current Date and Time <%=time %></h1> --%>


<h1>Hello ${name} </h1> 
<h1>Your Emp Id ${eid}</h1>

<h1>Current Date and Time ${time} </h1> 

<hr>

<c:forEach var="item" items="${marks }">

<h1>${item }</h1>

</c:forEach>

<h1> This is Help Page</h1>




</body>
</html>