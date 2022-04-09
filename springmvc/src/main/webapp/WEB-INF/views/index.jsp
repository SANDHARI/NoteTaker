<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

<h1>This is home page</h1>
<h1>Called by Home Controller</h1>
<h1>url /home</h1>

<%

String name = (String)request.getAttribute("name");
Integer id= (Integer)request.getAttribute("id");
%>

<h1>
Name : <%=name%>
Id : <%=id %>
</h1>


</body>
</html>