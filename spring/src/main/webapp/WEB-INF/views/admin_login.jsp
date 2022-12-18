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

<h2>Admin Login</h2>
<form method="post" id="register" action="delete_bus">
  <div class="form-group">
    <label for="e">User Id</label>
    <input type="text" class="textinp"  placeholder="Enter UserId" name="userid" required>
  </div>
  
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="textinp" placeholder="Password" name="password" required>
  </div>

  <button type="submit" class="btn btn-primary">Login</button>
</form> 
</div> <!-- End Register here-->
</div> <!-- End Main here-->
</body>
</html>