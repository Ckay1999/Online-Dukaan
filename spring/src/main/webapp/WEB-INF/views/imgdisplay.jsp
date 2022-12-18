<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<h1>Hey there</h1>
<c:forEach items="${pic }" var="p">
<img src="<c:url value="/resources/${p }"/>" /> 
</c:forEach>
</body>
</html>