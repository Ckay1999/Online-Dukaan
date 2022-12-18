<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
    <link rel="stylesheet" href="<c:url value="/resources/css/shops.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/carousal.css" />">
    <div>
<!-------------------------------------------HEADER----------------------------------------------------------> 
        <div class="header">
            <div class="header222">
            <div class="heading">Shops near you</div>
            <form method="post" action="filter_bus">
           <div class="search-bar">  <div class="search">
            <input type="text" class="searchTerm" id="search" name="search" placeholder="Search">
            <button type="submit" class="searchButton" >
              <i class="fa fa-search"></i>
           </button>
         </div> </div>
	</form>
         </div>
        </div>
<!--------------------------------------------HEADER-END----------------------------------------------------------> 




<!--------------------------------------MAIN CONTENT---------------------------------------------------------->
            <div class="bottom">


<!--------------------------------------FILTERBOX------------------------------------------------------------->
                

                <div class="filter">
                    
                    
                    <div class="sub-heading">FILTERS <i class="fa-solid fa-filter"></i></div>
                    <div class="filter-box">
                        <div class="type">
                            <div class="f-heading">Type</div>
                            <hr class="line">
						<c:forEach items="${categories }" var="cat">
                            <div class="o">
                             <div class="o1">${cat} </div>
                             <input type="radio" name="demo1" class="r" value=${cat } onclick="document.location.href='<c:url value="/filter/${cat }" />'">
								</div>
								</c:forEach>
                        </div>
                        <div class="location">
                           <div class="f-heading"> Distance</div>
                           <hr class="line">
                           <div class="o"><div class="o1"> 0-50km </div><div class="r"><input type="radio" name="demo" onclick="document.location.href='<c:url value="/filter_cat/1" />'" ></div></div>
                           <div class="o"><div class="o1"> 50-100km </div><div class="r"><input type="radio" name="demo" onclick="document.location.href='<c:url value="/filter_cat/2" />'"></div></div>
                          <div class="o"><div class="o1">100-200km</div> <div class="r"><input type="radio" name="demo" onclick="document.location.href='<c:url value="/filter_cat/3" />'"></div></div>
                          <div class="o"><div class="o1"> >200km </div><div class="r"> <input type="radio" name="demo" onclick="document.location.href='<c:url value="/filter_cat/4" />'"></div></div>

                            

                        </div>

                       <p id='message'></p>



                    </div>
                </div>
<!--------------------------------------FILTERBOX-END------------------------------------------------------------>



 <!-------------------------------------SHOPPING CARDS------------------------------------------------------->           
                <div class="shops">
                <c:forEach items="${business }" var="bus">
                    <div class="shop-card">
                        <div class="shop-info">
                            <div class="card-top">
                            <div class="card-top-left"> 
                            <div class="shop-name">
                                ${bus.bus_name }
                            </div>

                            <div class="stars"></div>
                            </div>
                            <div class="card-top-right">
                               
                               <a href="<c:url value="/review/${bus.id }" />"><button class="button-6" role="button" > <i class="gg-pen" ></i> <div class="review-text">Add a review </div></button></a>

                            </div>
                        </div>
                             <div class="detail-icons">
                            
                                <!-- <a href="https://www.google.com/maps/dir/28.3562493,75.5864235/akshay+market/@28.3560248,75.5861581,17z/data=!3m1!4b1!4m9!4m8!1m1!4e1!1m5!1m1!1s0x39131965c75c7d65:0x9c6eda0a412bb5aa!2m2!1d75.5902689!2d28.3571481" target="_blank"><button class="button-42" role="button" ><i class="fa-solid fa-map ic"></i> Direction</button></a> -->
                                <button class="button-42" role="button" ><i class="fa-solid fa-map ic"></i> Direction</button>
                                <button class="button-42" role="button"><i class="fa-solid fa-earth-europe ic" ></i> Website</button>
                                <button class="button-42" role="button"><i class="fa-solid fa-phone ic"></i> Call</button>
                            </div>

                            <div class="info">
                                 <div class="info2"><div class="txt">Hours:</div><div>${bus.open } to ${bus.close }</div></div>
                                <div class="info2"><div class="txt">Phone:</div><div>${bus.phone }</div></div>
                                <div class="info2"><div class="txt">Email:</div><div>${bus.email }</div></div>
                                <div class="info2"><div class="txt">Address:</div><div>${bus.address }</div></div>

                            </div>
                            <div class="distyp">
                            <div class="dt"> Type: ${bus.type }</div>
                               <div class="dt"> Distance: ${bus.dist } </div>
                               
                            </div>

                        <div >

                    </div>
                </div>
        

                <!------------------------------IMAGE-CAROUSAL----------------------------------------->
                
                
                <div class="shop-pic">
                    
                    <div class="container-shop">

                        <img src = "<c:url value="/resources/${bus.image }" /> " class="shop_img"  id="productimg">
                  </div>
                      
                     </div>
                </div> <!-------------------------------------------ImageCarousal-END------------------------------------------------>
				 </c:forEach> 
                
<!-------------------------------------------SHOPPINGCARD-END------------------------------------------------>
                
</div>
            
    </div>
    <script src="https://kit.fontawesome.com/b43947f0dd.js" crossorigin="anonymous"></script>
    <script src="<c:url value="/resources/javascript/carousal.js" />"></script>
    <script src="scripts/shop.js"></script>

</script>
  

</html>