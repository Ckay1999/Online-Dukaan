<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div id="location"></div>
<script>
	
    function getlocation() {
    	var x= document.getElementById("location");
    	if(navigator.geolocation){
    		navigator.geolocation.getCurrentPosition(showPosition, showError)
    	  }
    	else
    	{
             alert("Sorry! your browser is not supporting")
         } }
     
     function showPosition(position){
       var x = "Your current location is (" + "Latitude: " + position.coords.latitude + ", " + "Longitude: " +    position.coords.longitude + ")";
                document.getElementById("location").innerHTML = x;
     }

     function showError(error) {
        switch(error.code){
            case error.PERMISSION_DENIED:
            alert("User denied the request for Geolocation API.");
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
     getlocation();
</script>

</body>
</html>