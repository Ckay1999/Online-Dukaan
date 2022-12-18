<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
</head>
<body>
<div class="main" ></div>
<div class="register">

<h2>Deleting a business</h2>
<form method="post" id="register" action="deleting">
  <div class="form-group">
    <label for="e">Enter Business Id</label>
    <input type="text" class="textinp"  placeholder="Enter Id" name="id" required>
  </div>

  <button type="submit" class="btn btn-primary">Delete</button>
</form> 
</div> <!-- End Register here-->
</div> <!-- End Main here-->

</body>
</html>