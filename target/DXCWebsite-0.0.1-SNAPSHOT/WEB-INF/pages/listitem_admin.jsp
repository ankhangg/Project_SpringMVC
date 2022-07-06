<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file= "taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Item</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/decorator_admin/item/assets/favicon.ico"/> 
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/decorator_admin/item/css/styles.css"/> 
           <!-- Core theme JS-->
        <script src="<c:url value='/decorator_admin/item/js/scripts.js' />"></script>
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
        <div class="page-content">
            <div class="row" >
                <div class="col-xs-12">
                
                  <div class="row">
                        <div class="col-xs-12">
                       <div class="table-responsive">
                        <table class="table">
    <thead>
      <tr>
        <th>Id Item</th>
        <th>Name Item</th>
        <th>Price Item</th>
        <th>Amount</th>
        <th>Function</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${itemlist }" var="i">
      <tr>
        <td scope="row">${i.id }</td>
        <td>${i.nameItem }</td>
          <td>${i.price } đ</td>
          <td>${i.amountItem } đơn vị</td>
         <td>
         <a href="${pageContext.request.contextPath}/update_item?id=${i.id}">Edit</a>
                  <a href="${pageContext.request.contextPath}/delete_item?id=${i.id}">Delete</a>
         </td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
<!--   <ul class="pagination" id="pagination"></ul> -->
					    </div>
					  </div>		
                  </div>
                </div>
            </div>
        </div>
    </div>
</div><!-- /.main-content -->
<!-- <script type="text/javascript">
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: 20,
            visiblePages: 5,
            onPageClick: function (event, page) {
                console.info(page + ' (from options)');
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
    
</script> -->
</body>
</html>