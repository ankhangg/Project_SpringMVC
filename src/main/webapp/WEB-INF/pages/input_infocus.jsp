<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Infor</title>
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
                    <a href="${pageContext.request.contextPath}/home">Back</a>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>
         </div>
<h1>Information Customer Form</h1>
 <%--  <!-- /create_account?error=true -->
       <!-- /login?error=true -->
      <c:if test="${not empty alertmessage}"> 
<div class="alert alert-${typealert }">
${alertmessage }
</div>
        </c:if>  --%>
  <form:form modelAttribute="customerForm"  enctype="multipart/form-data" method="POST" action="inputinfo"> 
  <div class="form-group">
    <label for="formGroupExampleInput">Name: </label>
        <form:input path="nameCustomer" placeholder="Type Name here"/>  
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">Address:</label>
  <form:input path="addressCustomer" placeholder="Type Address here" /> 
  </div>
    <div class="form-group">
    <label for="formGroupExampleInput2">Phone:</label>
  <form:input path="phoneCustomer" placeholder="Type Phonenumber here" /> 
  </div>
    <div class="form-group">
    <!-- <label for="formGroupExampleInput2">Roll User:</label> -->
    <form:input type="hidden"  path="userNameCustomer" value="${pageContext.request.userPrincipal.name}" />  
    <form:input type="hidden" path="idCustomer"/>  
  </div>
         <div class="form-group">
    <input type="submit" value="Submit" />
     <input type="reset" value="Clear" />
  </div>
</form:form>
</body>
</html>