<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div id="userPanel" align="right">
	<table>
		<tr>
			<td><a href="/WirtualnyDziekanat/">Strona glowna </a></td>
			<td><a href="/WirtualnyDziekanat/user/detail">Profil uzytkownika [${user.userName}] </a></td>
			<td><a href="/WirtualnyDziekanat/user/logout">Wyloguj</a></td>
		</tr>
	</table>
</div>

<center>
<h2>Stworz grupe studencka</h2>
<form action="saveStudentGroup" method="POST">

	${msg}

	<table>

		<tr>
			<td><label>Nazwa grupy:</label></td>
			<td><form:input path="studentGroup.name" /></td>
		</tr>

		<tr>
			<td><label>Dolacz studenta do grupy</label>
			<td> w krotce implementacja</td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Wyslij" /></td>
		</tr>
			
	</table>
</form>



</center>

</body>
</html>