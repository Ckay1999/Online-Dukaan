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

<h2>Update Business Information</h2>
<form action="${pageContext.request.contextPath }/handle_updating" method="post" id="register">

  <div class="form-group">
    <input type="text" class="textinp"  placeholder="id" name="id" value=${s1.id } hidden>
  </div>
  
  <div class="form-group">
    <label for="name">Enter your business name</label>
    <input type="text" class="textinp" id="name" placeholder="Name" name="bus_name" value=${s1.bus_name } required>
  </div>


    <input type="email" class="textinp" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" value=${s1.email } name="email" hidden >

    <input type="password" class="textinp" id="exampleInputPassword1" placeholder="Password" name="password" value=${s1.password } hidden>
<input type="text" class="textinp" id="exampleInputPassword1"  name="lng" value=${s1.lng } hidden>
<input type="text" class="textinp" id="exampleInputPassword1" name="lat" value=${s1.lat } hidden>
<input type="text" class="textinp" id="exampleInputPassword1" name="dist" value=${s1.dist } hidden>
<input type="text" class="textinp"  placeholder="id" name="image" value=${s1.image } hidden>

  <div class="form-group">
    <label for="phone">Phone number</label>
    <input type="text" class="textinp" placeholder="Phone number" name="phone" value=${s1.phone } required>
  </div>
  
    <input type="text" class="textinp"  placeholder="Address" aria-describedby="address" name="address" value=${s1.address } hidden>

     <div class="form-group">
    <label for="open">Opening hours(Please specify AM/PM)</label>
    <input type="text" class="textinp"  placeholder="Opening hours" aria-describedby="open" name="open" value=${s1.open } >
</div>
 <div class="form-group">
    <label for="close">Closing hours(Please specify AM/PM)</label>
    <input type="text" class="textinp"  placeholder="Closing hours" aria-describedby="close" name="close" value=${s1.close }>
</div>
  
  <div class="form-group">
    <label for="Category">Category</label>
    <input type="text" class="textinp"  placeholder="Category" name="type"  value=${s1.type } required>
  </div>
  

  <button type="submit" class="btn btn-primary">Update</button>
</form> 
</div> <!-- End Register here-->
</div> <!-- End Main here-->

</body>
</html>