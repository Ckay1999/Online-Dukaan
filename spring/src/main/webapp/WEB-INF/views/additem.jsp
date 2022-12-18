<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
</head>
<body>
<div class="main" ></div>
<div class="register">

<h2>Add an item</h2>
<form action="processitems" method="post" id="register"  enctype="multipart/form-data">
  <div class="form-group">
<input type="text" class="textinp"  placeholder="id" value=${id } name="bus_id" value=${id } hidden>
</div>
  <div class="form-group">
    <label for="name">Enter Sub-category</label>
    <input type="text" class="textinp"  placeholder="sub-category" name="sub_cat" required>
  </div>



  <div class="form-group">
    <label for="e">Item Name</label>
    <input type="text" class="textinp" placeholder="Name" name="name" required>
  </div>
  
  <div class="form-group">
    <label for="c">Cost</label>
    <input type="text" class="textinp" placeholder="Cost" name="price" required>
  </div>
<div class="form-group">
	    <label for="exampleFormControlFile1">Example file input</label>
	    <br>
	    <input type="file" class="textinp" name="image" id="exampleFormControlFile1">
	  </div>
  
    


  
  <button type="submit" class="btn btn-primary">Submit</button>
</form> 
</div> <!-- End Register here-->
</div> <!-- End Main here-->


</body>
</html>