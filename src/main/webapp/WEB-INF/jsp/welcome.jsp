<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
	<title>Momenton</title>
	<meta http-equiv=Content-Type content="text/html; charset=iso-8859-1">
	<meta http-equiv=Content-Type content="text/html; charset=iso-8859-1">
	<script>
		function onSubmit(){
			document.getElementById("WelcomeForm").submit();
		}
	</script>
	</head>
	<body onload="onSubmit();">
		<form id="WelcomeForm" action="employee" method="post">
		</form>
	</body>
</html>
