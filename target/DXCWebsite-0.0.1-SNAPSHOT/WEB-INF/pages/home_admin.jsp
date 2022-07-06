<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
	 <link rel="stylesheet" href="${pageContext.request.contextPath}/decorator_admin/assets/css/bootstrap.min.css"/> 
     <link rel="stylesheet" href="${pageContext.request.contextPath}/decorator_admin/font-awesome/4.5.0/css/font-awesome.min.css"/>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/decorator_admin/assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />
<script
	src="<c:url value='/decorator_admin/assets/js/ace-extra.min.js' />"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type='text/javascript'
	src='<c:url value="/decorator_admin/js/jquery-2.2.3.min.js" />'></script>
<script
	src="<c:url value='/decorator_admin/assets/js/jquery.2.1.1.min.js' />"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>
</head>
<body>
	<!-- Header-->
	<jsp:include page="header_admin.jsp" />
	<!-- End Header-->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a>
					</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12"></div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- /.main-content -->
		<!-- Menu-->
	<jsp:include page="menu_admin.jsp" />
	<!-- End Menu-->
	
	
	<!--  Footer -->
	<jsp:include page="footer_admin.jsp" />
	<!-- End Footer -->
	
	    	  <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
		  <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		  </a>
	<script
		src="<c:url value='/decorator_admin/assets/js/bootstrap.min.js' />"></script>
	<script
		src="<c:url value='/decorator_admin/assets/js/jquery-ui.custom.min.js' />"></script>
	<script
		src="<c:url value='/decorator_admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
	<script
		src="<c:url value='/decorator_admin/assets/js/jquery.easypiechart.min.js' />"></script>
	<script
		src="<c:url value='/decorator_admin/assets/js/jquery.sparkline.min.js' />"></script>
	<script
		src="<c:url value='/decorator_admin/assets/js/jquery.flot.min.js' />"></script>
	<script
		src="<c:url value='/decorator_admin/assets/js/jquery.flot.pie.min.js' />"></script>
	<script
		src="<c:url value='/decorator_admin/assets/js/jquery.flot.resize.min.js' />"></script>
	<script
		src="<c:url value='/decorator_admin/assets/js/ace-elements.min.js' />"></script>
	<script src="<c:url value='/decorator_admin/assets/js/ace.min.js' />"></script>
	<script
		src="<c:url value='/decorator_admin/assets/js/bootstrap.min.js'/>"></script>

	<!-- page specific plugin scripts -->
	<script
		src="<c:url value='/decorator_admin/assets/js/jquery-ui.min.js'/>"></script>
</body>
</html>