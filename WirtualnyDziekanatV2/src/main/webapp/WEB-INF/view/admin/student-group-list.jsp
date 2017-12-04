<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grupy studenckie</title>
</head>
<body>

<div align="right">
	<table>
		<tr>
			<td><a href="/WirtualnyDziekanat/">Strona glowna </a></td>
			<td><a href="/WirtualnyDziekanat/user/detail">Profil
						uzytkownika [${user.userName}] </a></td>
			<td><a href="/WirtualnyDziekanat/user/logout">Wyloguj</a></td>
		</tr>
	</table>
</div>


<center><h1>Grupy Studenckie</h1>
<h3>${msg}</h3>
</center>

<h3>Lista grup</h3>

<input type="button" value="Stworz grupe" onclick="window.location.href='createStudentGroup';">

<br><br>


<table>
	<tr>
		<th>Nazwa grupy</th>
		<th>Id grupy</th>
		<th>Ilosc czlonkow</th>
		<th>Zarzadzaj</th>
		<th>Plan zajec</th>
	</tr>
	
	<c:forEach var="tempStudentGroup" items="${studentGroupList}">
					
		<c:url var="updateLink" value="/admin/updateStudentGroup">
		<c:param name="studentGroupId" value="${tempStudentGroup.id}" />
		</c:url>
		
		<c:url var="timeTableLink" value="/admin/showTimeTable">
		<c:param name="timeTableId" value="${tempStudentGroup.timeTable.id}" />
		</c:url>
				
		<tr>
			<td>${tempStudentGroup.name}</td>
			<td>${tempStudentGroup.id}</td>
			<td>${tempStudentGroup.members}</td>
			<td><a href="${updateLink}">Link</a></td>
			<td><a href="${timeTableLink}">Link</a></td>
		</tr>
	</c:forEach>

</table>



</body>
</html>