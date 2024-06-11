<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
	<h3>${initParam.appTitle}</h3>
	
		<jsp:useBean id="res" class="com.sunbeam.beans.CandidateListBean" />
		${res.fetchCandidates()}
		
		<table border="1">
			<thead>
				<th> Id </th>
				<th> Name </th>
				<th> Party </th>
				<th> Votes </th>
				<th> Action </th>
			</thead>
			
			<tbody>
			 	<c:forEach var="c" items="${res.candidateList}"> 
					<tr>
						<td>${c.id} </td>
						<td>${c.name} </td>
						<td>${c.party} </td>
						<td>${c.votes} </td>
			 			<td>
			 				<a href="editcand.jsp?id=${c.id}">
			 					<img alt="edit" src="images/edit.png" width="24" height="24" />
			 				</a>
			 				
			 				<a href="delcand.jsp?id=${c.id}">
			 					<img alt="delete" src="images/delete.png" width="24" height="24" />
			 				</a>
			 				
			 				
			 			</td>
			 	</c:forEach>
			
			</tbody>
		
		
		</table>
		<br/>
		<br/>
		<a href="logout.jsp">Sign Out</a>

</body>
</html>