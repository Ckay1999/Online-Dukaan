<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/resources/css/email.css" />">
</head>
<body>
<div class="outer" >
        <div class="outer1">
        <div class="inner">
        <div class="header">
            <div class="header-text">
                Verify Your email !
            </div>

            <div class="lower">
            <form method="post" action="verify">
         
              
            <div class="body">
                <div class="email">
                    Enter Otp:
                </div>
                <div class="email-enter"> 
                    <input type="number" class="searchTerm" placeholder="OTP" name="otp" required>
                </div>
                
               
                    <input type="number" class="searchTerm" placeholder="OTP" name="otp1" value=${otp } hidden>
 
                    <input type="email" class="searchTerm"  name="email" value=${email } hidden>

 
                    <input type="number" class="searchTerm"  name="id" value=${id } hidden>


            </div>

            <div class="but">
                <button class="button-37" role="button">Enter OTP</button>

            </div>
            </form>
        </div>

        </div>

        </div>
        
    </div>
</body>
</html>