<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList" %>

<!DOCTYPE html>
	<html>
	  <head>
		<meta charset="utf-8">
		  <title>Dukaan Home</title>
		  <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
	  </head>
	<body onload="javascript:getlocation()">
	
	<div class="main22">
        <div class="mainleft">


        </div>
        <div class="mainright">
            <div class="mainrightup">
            <div class="heading">Online Dukan</div>
            <div class="tagline">Place for Indian Local shop owner to be visible online</div>
        </div>
        <div class="mainrightdown">
        <form action="view_bus">   
        <button class="button-56" role="button">Shop Keeper</button>
        </form>
        <form action="search_bus">
        <input type="text" class="textinp"  name="lat" id="lat" hidden>
  		<input type="text" class="textinp"  name="lng" id="lng"  hidden>
        <button class="button-56" role="button" >Customer</button>
	</form>



        </div>

        </div>

    </div>
    
    <script>
	var x= document.getElementById("lat");
	var y= document.getElementById("lng");
    function getlocation() {
    	if(navigator.geolocation){
    		navigator.geolocation.getCurrentPosition(showPosition, showError)
    	  }
    	else
    	{
             alert("Sorry! your browser is not supporting")
         } }
     
     function showPosition(position){
       document.getElementById("lat").value =JSON.stringify(position.coords.latitude);
       document.getElementById("lng").value =JSON.stringify(position.coords.longitude);
     }

     function showError(error) {
        switch(error.code){
            case error.PERMISSION_DENIED:
            alert("Please allow the website to use your location");
            break;
        case error.POSITION_UNAVAILABLE:
            alert("USer location information is unavailable.");
            break;
        case error.TIMEOUT:
            alert("The request to get user location timed out.");
            break;
        case error.UNKNOWN_ERROR:
            alert("An unknown error occurred.");
            break;
    }
        }
</script>
    
	</body>
</html>



 