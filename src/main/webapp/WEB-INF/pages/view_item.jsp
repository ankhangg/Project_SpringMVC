<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file= "taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Page</title>
           <!-- Favicon-->
       <link rel="icon" type="timage/x-icon" href="${pageContext.request.contextPath}/decorator_userpage/item/assets/favicon.ico"/>
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/decorator_userpage/item/css/styles.css"/>
           <!-- Core theme JS-->
          <script src="<c:url value='/decorator_userpage/item/js/scripts.js' />"></script>
</head>
<body>
<!-- Header -->
  <jsp:include page="header_user.jsp" />
  <!--End Header -->
                <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">

                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="${pageContext.request.contextPath}/itemImage?id=${itemview.id}" alt="..." /></div>
                    <div class="col-md-6">
                        <h1 class="display-5 fw-bolder">${itemview.nameItem }</h1>
                        <div class="fs-5 mb-5">
                            <span>${itemview.price } đ</span>
                         </div>
                                 <div class="fs-5 mb-5">
                            <span>Còn lại: ${itemview.amountItem } </span>
                         </div>
                        <p class="lead">${itemview.shortdescription }</p>
                        <div class="d-flex"> 
                        </div>
                                                    <input class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem" />
                            <button class="btn btn-outline-dark flex-shrink-0" type="button">
                                <i class="bi-cart-fill me-1"></i>
                                Add to cart
                            </button>
                    </div>
                </div>
            </div>
            
        </section>
                    <!--  Footer -->
     <jsp:include page="footer_user.jsp" />
     <!-- End Footer -->
</body>
</html>