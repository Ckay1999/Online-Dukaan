<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
      <link href="<c:url value="/resources/css/catalog.css" />" rel="stylesheet">
</head>
<body>
 <div>
<!-------------------------------------------HEADER----------------------------------------------------------> 
        <div class="header">
            <div class="header222">
            <div class="heading">Catalogue</div>
            
           <div class="search-bar">  <div class="search">
            <input type="text" class="searchTerm" placeholder="Search">
            <button type="submit" class="searchButton">
              <i class="fa fa-search"></i>
           </button>
         </div> </div>

         </div>
        </div>
<!--------------------------------------------HEADER-END----------------------------------------------------------> 

<div class="item-section">
    <div class="item-category">
        <div class="Category-name">Items</div>
        <div class="item-section-main">
        
    
    <div class="item-section-right">
    <c:forEach items="${catalog }" var="item">
        <div class="item-box">
            <div class="cat-image"><img src="<c:url value="/resources/images/${item.image }" /> "/></div>
            <div class="cat-content">
                <div class="N">${item.sub_cat }</div>
                <br></br>
                <div class="D">Cost: ${item.price }</div>
                
                <br></br>
                <div class="D">Details:</div>
                <div class="Dd">Item name: ${item.name }</div>
                
            </div>

        </div>
        </c:forEach>
        </div>

    </div>
    

        </div>

    </div>

</div>

</div>

    <script src="https://kit.fontawesome.com/b43947f0dd.js" crossorigin="anonymous"></script>
  

</body>
</html>