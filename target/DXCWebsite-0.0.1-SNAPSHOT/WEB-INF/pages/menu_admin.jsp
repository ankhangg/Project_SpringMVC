<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar"
	class="sidebar                  responsive                    ace-save-state">
	<script type="text/javascript">
		try {
			ace.settings.loadState('sidebar')
		} catch (e) {
		}
	</script>
	<ul class="nav nav-list">

		<!--  Item -->
		<li><a href=""
			class="dropdown-toggle"> <i class="fa fa-shopping-bag"
				aria-hidden="true"></i> <span class="menu-text"></span> Manage Item
				<!--  <b class="arrow fa fa-angle-down"></b> -->
		</a> <b class="arrow"></b>
			<ul class="submenu">
				<li><a href="${pageContext.request.contextPath}/item"> <i
						class="fa fa-area-chart" aria-hidden="true"></i> List Item
				</a> <b class="arrow"></b></li>
				  <li>
                    <a href="${pageContext.request.contextPath}/add_item">
                        <i class="fa fa-rocket" aria-hidden="true"></i>
                        Add New Item
                    </a>
                    <b class="arrow"></b>
                </li>
                <!--
                     <li>
                    <a href="#">
                        <i class="fa fa-ambulance" aria-hidden="true"></i>
                       Successfully orders
                    </a>
                    <b class="arrow"></b>
                </li> -->
			</ul></li>
		<!-- End Item -->
		
				<!--  Customer -->
		<li><a href=""
			class="dropdown-toggle"> <i class="fa fa-list"aria-hidden="true"></i> <span class="menu-text"></span>Customer
				<!--  <b class="arrow fa fa-angle-down"></b> -->
		</a> <b class="arrow"></b>
			<ul class="submenu">
				<li><a href="${pageContext.request.contextPath}/listcustomer"> <i
						class="fa fa-apple" aria-hidden="true"></i> List Customer
				</a> <b class="arrow"></b></li>
			</ul></li>
		<!-- End Customer -->
	</ul>
</div>