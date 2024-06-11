<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean"/>
	<jsp:setProperty property="*" name="lb"/>
	
	
	${lb.authenticate() }
	
	
	<c:choose>
		<c:when test="${lb.user.role == 'voter'}">
			<c:redirect url="candlist.jsp"/>		
		</c:when>
		<c:when test="${lb.user.role == 'admin'}">
			<c:redirect url="result.jsp"/>		
		</c:when>
		<c:otherwise>
			<h3>${initParam.appTitle}</h3>
			Hello, ${lb.email} <br/>
			Invalid email or password. <br/><br/>
			<a href="index.jsp">Login Again</a>		
		</c:otherwise>
	</c:choose>
	
</body>
</html>