<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC with JSP Crud Example</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="icon"
	href="<c:url value="/resources/images/sudarshan-logo.png"/>" />
<link rel="shortcut icon"
	href="<c:url value="/resources/images/ico/favicon.ico"/>"
	type="image/x-icon">

<style type="text/css">
.page-title {
	font-family: 'Open Sans', sans-serif;
	font-style: normal;
	font-weight: 600;
	font-size: 24px;
	color: #4C4C4C;
}

.mt-1 {
	margin-top: 1rem !important;
}

.mb-2, .my-2 {
	margin-bottom: 0.5rem !important;
}
</style>

</head>

<body>
	<div id="fullpage">
		<div class="header">

			<%@include file="../views/common/welcome-header.jspf"%>

		</div>


		<div class="container">
			<div class="row" style="margin-top: 150px;">
				<div class="col-6 mt-4">
					<marquee scrollamount="5" style="color: blue">
						<b>Rest API with Client App using Spring MVC</b>
					</marquee>
				</div>

				<div class="col-1"></div>
			</div>
		</div>

	</div>

	<div>
		<div class="col-lg-12 col-sm-12 col-xs-12 copyrights"
			style="margin-top: 500px;">
			<%@include file="../views/login-footer.jsp"%>
		</div>
	</div>
</body>
</html>