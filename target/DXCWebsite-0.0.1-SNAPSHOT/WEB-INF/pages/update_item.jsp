<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Item</title>
<style type="text/css">
  .error{
  color: red
  }
</style>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="${pageContext.request.contextPath}/admin">Back</a>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>
      <form:form modelAttribute="itemUpdateForm" method="POST" enctype="multipart/form-data" action="update_item">
     <div class="form-group">
    <input type="hidden" class="form-control" id="formGroupExampleInput2" placeholder="Input_Price" name="id" value="${itemUpdateForm.id }">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput">Name Item</label>
   <form:input path="nameItem" value="${itemUpdateForm.nameItem }"/>
   <form:errors path="nameItem" class="error" />
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">Short Description</label>
  <form:input path="shortdescription" value="${itemUpdateForm.shortdescription }"/>
  <form:errors path="shortdescription" class="error" />
  </div>
   <div class="form-group">
    <label for="formGroupExampleInput2">Price</label>
     <form:input path="price" value="${itemUpdateForm.price }"/>
     <form:errors path="price" class="error"/>
  </div>
     <div class="form-group">
    <label for="formGroupExampleInput2">Amount</label>
    <form:input path="amountItem" value="${itemUpdateForm.amountItem }"/>
    <form:errors path="amountItem" class="error"/>
  </div>
   <div class="form-group">
    <label for="formGroupExampleInput2">Image</label>
     <form:input type="file" path="fileData"/>
  </div>
    <td><img src="${pageContext.request.contextPath}/itemImage?id=${itemUpdateForm.id}" width="100"/></td>
     <div class="form-group">
      <form:hidden path="modifiedBy" value="${pageContext.request.userPrincipal.name}"/>
  </div>
     <div class="form-group">
    <input type="submit" value="Submit" />
     <input type="reset" value="Clear" />
  </div>
   </form:form>
  
    </div>
    
      </div>
</body>
</html>