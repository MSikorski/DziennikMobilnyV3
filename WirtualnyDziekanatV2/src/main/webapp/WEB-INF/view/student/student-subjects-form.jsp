<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Przedmioty studenta</title>
</head>
<body>

<div id="wrapper">
	<div id="header">
		<h2> Przedmioty studenta</h2>		
	</div>
</div>

<table>
				<tr>
					<th>Przedmiot</th>
					<th>Szczegoly przedmiotu</th>
				</tr>
				
				<!-- loop over and print out subjects -->
				<c:forEach var="tempSubject" items="${subjects}">
					
				<!-- construct and update link with subjectid -->
				<c:url var="subjectLink" value="/student/showSubject">
					<c:param name="subjectId" value="${tempSubject.id}" />
				</c:url>
				
				<tr>
					<td> ${tempSubject.name} </td>
					
					<!--  Display the subject detail link -->
					<td> <a href="${subjectLink}">Update</a></td>
				</tr>
				</c:forEach>
				
			</table>



</body>
</html>