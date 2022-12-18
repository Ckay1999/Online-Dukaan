<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="<c:url value="/resources/css/form.css" />" rel="stylesheet">
  </head>
  <body>

<div class="main" ></div>
<div class="register">

<h2>Register Here</h2>
 <h4>Already a user?  <a href="<c:url value="/login" />">Click here to login</a></h4>
<form action="processform" method="post" id="register">
  <div class="form-group">
    <label for="name">Enter your business name</label>
    <input type="text" class="textinp" id="name" placeholder="Name" name="bus_name" required>
  </div>

  <div class="form-group">
    <label for="e">Email address</label>
    <input type="email" class="textinp" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email" required>
  </div>
  
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="textinp" id="exampleInputPassword1" placeholder="Password" name="password" required>
  </div>

  
  <div class="form-group">
    <label for="phone">Phone number</label>
    <input type="text" class="textinp" placeholder="Phone number" name="phone" required>
  </div>
  
    
  <div class="form-group">
    <label for="Category">Opening hours</label>
    <input type="text" class="textinp"  placeholder="Opening hours" name="open" required>
  </div>
  
  
  <div class="form-group">
    <label for="Category">Closing hours</label>
    <input type="text" class="textinp"  placeholder="Closing hours" name="close" required>
  </div>
  
  <div class="form-group">
    <label for="Category">Category</label>
    <input type="text" class="textinp"  placeholder="Category" name="type" required>
  </div>
  
<div>
    <input type="text" class="textinp" name="lat" id="lat" value="22.6708" hidden>
  </div>
  <div>
    <input type="text" class="textinp"  name="lng" id="lng" value="71.5724" hidden>
  </div>
  
  <div class="form-group">
    <label for="address">Address</label>
    <input type="text" class="textinp"  placeholder="Address" name="address" id="address" onchange="getCoordinates()" required>
  </div>
  <input type="text" class="textinp"  name="image" id="address" hidden>
  
  <div>
    <input type="text" class="textinp"   name="dist" value=0 hidden>
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form> 
</div> <!-- End Register here-->
</div> <!-- End Main here-->

<script src="https://unpkg.com/@esri/arcgis-rest-request@4.0.0/dist/bundled/request.umd.js"></script>
    <script src="https://unpkg.com/@esri/arcgis-rest-geocoding@4.0.0/dist/bundled/geocoding.umd.js"></script>
     <script src="https://unpkg.com/@esri/arcgis-rest-routing@4.0.0/dist/bundled/routing.umd.js"></script>

<script>
const apiKey = "AAPK4b417db3bb8a44c4a7e5e55d0ac936b03Ac82kY8BfDNvLI-cfZExe3JFRJdk_KkZ9cWYrF_6MQ5Nb8dEFC_A-GeA5KuKfF2";

const authentication = arcgisRest.ApiKeyManager.fromKey(apiKey);

async function getCoordinates(){
	
    const start = [-104.9903, 39.7392];
	const place=document.getElementById("address").value;
	var places = await arcgisRest
     .geocode({
       params: {
         address: place, // Place name to search for
         location: start
       },
       
       authentication
     });
	
	const candidate = places.candidates[0];
      
      document.getElementById("lat").value = JSON.stringify(candidate.location.y);
      document.getElementById("lng").value = JSON.stringify(candidate.location.x);

}
</script>


     </body>
</html>