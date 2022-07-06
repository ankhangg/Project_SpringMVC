<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="${pageContext.request.contextPath}/login">Back</a>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>
         </div>
<h1>Welcome To Create Account Form</h1>
  <!-- /create_account?error=true -->
       <!-- /login?error=true -->
      <c:if test="${not empty alertmessage}"> 
<div class="alert alert-${typealert }">
${alertmessage }
</div>
        </c:if> 
  <form:form modelAttribute="accountForm" enctype="multipart/form-data" method="POST" action="create_account" >
  <div class="form-group">
    <label for="formGroupExampleInput">Input UserName: </label>
    <form:input path="userName" placeholder="Type username here"/>
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">Input Password:</label>
     <form:input type="password" path="password" placeholder="Type password here"/>
  </div>
    <div class="form-group">
    <label for="formGroupExampleInput2">Confirm Password:</label>
         <form:input type="password" path="password2" placeholder="Type confirmPassword "/>
  </div>
    <div class="form-group">
     <form:hidden path="userRole" value="USER"/> 
  </div>
      <div class="form-group">
    <form:hidden path="active" value="1"/> 
  </div>
         <div class="form-group">
    <input type="submit" value="Submit" />
     <input type="reset" value="Clear" />
  </div>
</form:form>
</body>
</html>