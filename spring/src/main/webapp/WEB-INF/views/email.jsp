<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="<c:url value="/resources/css/email.css" />">
    <body>
    
        <div class="outer" >
        <div class="outer1">
        <div class="inner">
        <div class="header">
            <div class="header-text">
                Verify Your email !
            </div>
		<form action="${pageContext.request.contextPath }/otp" method="post">

            <div class="lower1">
            <div class="body1">
                <div class="email">
                    Email:
                </div>

                <div class="email-enter"> 
                    <input type="email" class="searchTerm" placeholder="Email" name="email" required >
                </div>
                <input type="number" class="searchTerm" name="id" value=${id } hidden >
               
            </div>
    

        </div>
        <div class="but">
                <button class="button-37" role="button">Get OTP</button>

            </div>

        </div>
		</form>
        </div>
    </div>
    </div>
    </body>
</html>