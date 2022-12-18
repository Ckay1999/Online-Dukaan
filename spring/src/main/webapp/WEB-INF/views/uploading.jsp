<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
</head>
<body>
<div class="main" ></div>
<div class="register">

<form action="handle_img" method="post" id="register" enctype="multipart/form-data" >

<div class="form-group">
    <input type="text" class="textinp"  placeholder="id" name="id" value=${id } hidden>
  </div>

  <div class="form-group">
	    <label for="exampleFormControlFile1">Example file input</label>
	    <br>
	    <input type="file" class="textinp" name="image" id="exampleFormControlFile1" single>
	  </div>

  <button type="submit" class="btn btn-primary">Upload</button>
</form> 
</div> <!-- End Register here-->
</div> <!-- End Main here-->

</body>
</html>