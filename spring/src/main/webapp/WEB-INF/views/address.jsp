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

<h2>Address Info</h2>
<form action="bus_address" method="post" id="register">
<div class="form-group">
    <input type="number" class="textinp"  placeholder="id" name="id" value=${id }>
  </div>
  <div>
    <input type="text" class="textinp" name="lat" id="lat" hidden>
  </div>
  <div>
    <input type="text" class="textinp"  name="lng" id="lng" hidden>
  </div>
  
  <div class="form-group">
    <label for="address">Address</label>
    <input type="text" class="textinp"  placeholder="Address" name="address" id="address" onchange="getCoordinates()" required>
  </div>
  
  
    <div class="form-group">
    <label for="Pincode">Pincode</label>
    <input type="text" class="textinp" id="pin" placeholder="Pincode" name="pincode" required>
  </div>
  
  
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


async function getCoordinates(){
	const apiKey = "AAPK4b417db3bb8a44c4a7e5e55d0ac936b03Ac82kY8BfDNvLI-cfZExe3JFRJdk_KkZ9cWYrF_6MQ5Nb8dEFC_A-GeA5KuKfF2";

    const authentication = arcgisRest.ApiKeyManager.fromKey(apiKey);
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