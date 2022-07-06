<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/home">DXC Website</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/home">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/login">Login Account</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Categories</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#!">Apple</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="#!">SamSung</a></li>
                            </ul>
                        </li>
                       <!--  Phân Quyền -->
                       <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item"><a class="nav-link active" aria-current="page">Welcome: ${pageContext.request.userPrincipal.name}</a></li>
                           <security:authorize  access="hasRole('ROLE_ADMIN')">
                               <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/admin">Admin Manage</a></li>
                            </security:authorize>
                            
                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/updateinfo?username=${pageContext.request.userPrincipal.name}">User Information</a></li>
                       <li class="nav-item"><a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/logout">Logout</a></li>
                      
                      </c:if>
                      <!-- END Phân Quyền -->
                    </ul>
                    <form class="d-flex">
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                        </button>
                    </form>
                </div>
            </div>
        </nav>