<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>

	<h3>${initParam.appTitle}</h3>
	<jsp:useBean id="rb" class="com.sunbeam.beans.RegistrationBean" scope="page" />
	
	<jsp:setProperty name="rb" property="firstName" param="firstName"/>
	<jsp:setProperty name="rb" property="lastName" param="lastName"/>
	<jsp:setProperty name="rb" property="email" param="email"/>
	<jsp:setProperty name="rb" property="passwd" param="passwd"/>
	<jsp:setProperty name="rb" property="birth" param="birth"/>
	<jsp:setProperty property="status" name="rb" value="0" />
	<jsp:setProperty property="role" name="rb" value="voter"/>
	
	
	
	${rb.registerUser() }
	<c:choose>
		<c:when test="${rb.count == 1}">
			Registration successful.
			<a href="index.jsp">Sign In</a>
		</c:when>
		<c:otherwise>
			Registration failed.
			<a href="newuser.jsp">Sign Up</a>
		</c:otherwise>
	</c:choose>
</body>
</html>