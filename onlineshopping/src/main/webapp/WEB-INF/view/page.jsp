<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!-- load static resources -->
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="fonts" value="/resources/fonts" />
<spring:url var="images" value="/resources/images" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping -${title}</title>

<script>
	window.menu = '${title}'; /* get title value */
	
	window.contextRoot='${contextRoot}'
	
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap readable theame -->
<link href="${css}/boostrapreadabletheame.css" rel="stylesheet">

<!-- Bootstrap DataTable-->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- boostrap-select.min.css-->
<link href="${css}/bootstrap-select.min.css" rel="stylesheet">



</head>

<body>


	<!-- 		<div class ="wrapper"> -->


	<!-- Navigation bar comes here -->
	<%@include file="./shared/navibar.jsp"%>

	<!-- Page Content -->
	<!--    <div class="content"> -->

	<!-- loading the home content -->
	<c:if test="${userClickHome==true }">
		<%@include file="./home.jsp"%>
		<!-- content shuold only load user click home -->
	</c:if>

	<!-- content shuold only load user click about -->
	<c:if test="${userClickAbout==true }">
		<%@include file="./about.jsp"%>

	</c:if>

	<!-- content shuold only load user click contact -->

	<c:if test="${userClickContact==true }">
		<%@include file="./contact.jsp"%>

	</c:if>

	<!-- load only user click allproducts -->
	<c:if
		test="${userClickAllProducts==true or userClickCategoryProducts==true  }">
		<%@include file="./listProducts.jsp"%>

	</c:if>
	
	<!-- load only user click userClickShowProduct -->
	<c:if
		test="${userClickShowProduct==true}">
		<%@include file="./sigleProduct.jsp"%>

	</c:if>
	
	<!-- load only user click manageProduct -->
	<c:if
		test="${userClickManageProduct==true}">
		<%@include file="./ManageProduct.jsp"%>

	</c:if>
	
	<!-- load only user click manageVarients -->
	<c:if
		test="${userClickManageVarients==true}">
		<%@include file="./ManageVarient.jsp"%>

	</c:if>

	<!-- 	 </div> -->

	<!-- Footer comes here -->
	<%@include file="./shared/footer.jsp"%>

	<!-- jquery -->
	<script src="${js}/jquery.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script src="${js}/bootstrap.bundle.min.js"></script>
	
	<!-- DataTablePluging -->
	<script src="${js}/jquery.dataTables.js"></script>
	
	<!-- DataTableBoostrap -->
	<script src="${js}/dataTables.bootstrap4.js"></script>
	
	<!-- BootBox.min.js -->
	<script src="${js}/bootbox.min.js"></script>
	
	<!-- jquery validate -->
	<script src="${js}/jquery.validate.js"></script>
	
	<!-- jqueryvalidate.min.js -->
	<script src="${js}/jquery.validate.min.js"></script>
	
	<!-- boostrap-select.min.js -->
	<script src="${js}/bootstrap-select.min.js"></script>
	

	<!--  self coded java script -->

	<script src="${js}/myapp.js"></script>

	<!--       </div> -->
</body>

</html>
