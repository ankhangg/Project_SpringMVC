<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Item</title>
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
   <form:form modelAttribute="itemForm" method="POST" enctype="multipart/form-data">
        <div class="form-group">
    <label for="formGroupExampleInput">Tên sản phẩm Item</label>
     <form:input path="nameItem" placeholder="Input Name_Item"/>
         <form:errors path="nameItem" class="error" />
  </div>
          <div class="form-group">
    <label for="formGroupExampleInput">Short Description</label>
     <form:input path="shortdescription"  placeholder="Input Short Description"/>
         <form:errors path="shortdescription" class="error" />
  </div>
            <div class="form-group">
    <label for="formGroupExampleInput">Price</label>
     <form:input path="price" placeholder="Input Price"/>
         <form:errors path="price" class="error"/>
  </div>
              <div class="form-group">
    <label for="formGroupExampleInput">Amount</label>
     <form:input path="amountItem" placeholder="Input Short Amount"/>
         <form:errors path="amountItem" class="error"/>
  </div>
    <div class="form-group">
    <label for="formGroupExampleInput2">Image</label>
    <form:input type="file" path="fileData"/>
    <form:errors path="fileData" class="error"/>
  </div>
       <div class="form-group">
       <form:input type="hidden" path="createdBy" value="${pageContext.request.userPrincipal.name}"/>
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