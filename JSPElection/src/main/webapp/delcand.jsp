<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Candidate</title>
</head>
<body>

	<h1>${initParam.appTitle} </h1>
	
	<jsp:useBean id="dcb" class="com.sunbeam.beans.DeleteCandidateBean" />
	
	<jsp:setProperty property="id" name="dcb" param="id"/> 
	
	${dcb.deleteCandidate() }
	
	<c:choose>
		<c:when test="${dcb.count == 1 } ">
			Deleted
			<c:redirect url="result.jsp"/>			
		</c:when>
		
		<c:otherwise>
			Deleted Failed..
		</c:otherwise>
	
	</c:choose>
	

</body>
</html>