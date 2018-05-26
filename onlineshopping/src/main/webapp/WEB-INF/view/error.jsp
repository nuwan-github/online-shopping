<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!-- load static resources -->
<spring:url var="css" value="/resources/css" />


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



</head>

<body>


	
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${contextRoot }/home">Home</a>

	</div>
</nav>

<div class="content">

	<div class="container">
		<div class="row">
			<div class="col-xs-12">
			
			<div class="jumbotron">
				<h1>${errorTitle}</h1>
				<hr/>
				
				<blockquote style="word-wrap:break-word">
					${errorDescription}
					
				</blockquote>
			</div>
				
			</div>
		</div>
	</div>

</div>

<!-- Footer comes here -->
	<%@include file="./shared/footer.jsp"%>


</body>

</html>
