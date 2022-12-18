<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
   <link href="<c:url value="/resources/css/email.css" />" rel="stylesheet">
      <link href="<c:url value="/resources/css/rate.css" />" rel="stylesheet">
</head>
<body>
<div class="outer" >
      <div class="outer1">
<div class="container">
      <div class="post">
        <div class="text">Thanks for rating us!</div>
        <div class="edit">EDIT</div>
      </div>

<div class="star-widget">

<input type="radio" name="rate" id="rate-5" value=5 />
<label for="rate-5" class="fas fa-star"></label>


<input type="radio" name="rate" id="rate-4" value=4 />
<label for="rate-4" class="fas fa-star"></label>


<input type="radio" name="rate" id="rate-3" value=3 />
<label for="rate-3" class="fas fa-star"></label>


<input type="radio" name="rate" id="rate-2" value=2 />
<label for="rate-2" class="fas fa-star"></label>


<input type="radio" name="rate" id="rate-1" value=1 />
<label for="rate-1" class="fas fa-star"></label>

<form action="stars_processing" method="post">
<header></header>
<input type="number"  id="name"  name="stars" value=2 hidden>
 <div class="textarea">
<textarea cols="30" placeholder="Describe your experience.." name="experience"></textarea>
  </div>
  <input type="email" class="textinp"  name="email" value=${email } hidden>
  <input type="number" class="textinp"  name="id" value=${id } hidden>
<div class="btn">
<button type="submit">Post</button>
</div>
 </form>


</div>
</div>

</div>
          
</div>

<script>
document.onclick = function(){
    var value = document.querySelector('input[name = rate]:checked').value;
    var test = value;
    document.getElementById("name").value = test;
    
}
</script>    

</body>
</html>