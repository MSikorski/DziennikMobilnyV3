<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<spring:url value="/resources/css/infoboxes.css" var="infoBoxes" />
<link href="${infoBoxes}" rel="stylesheet" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rejestracja noowego uzytkownika</title>
</head>
<body>

	<div align="right">
		<table>
			<tr>
				<td><a href="/WirtualnyDziekanat/">Strona glowna </a></td>
				<td><a href="/WirtualnyDziekanat/user/detail">Profil uzytkownika [${user.userName}] </a></td>
				<td><a href="/WirtualnyDziekanat/user/logout">Wyloguj</a></td>
			</tr>
		</table>
	</div>
	
	<div align="center">

		<h2>Logowanie</h2>

		<form:form action="loginproceed" method="POST" modelAttribute="loginDetail">

			<h3>${msg}</h3>

			<table>
				<tbody>

					<tr>
						<td><label>Nazwa uzytknownika:</label></td>
						<td><form:input path="user" /></td>
					</tr>

					<tr>
						<td><label>Haslo:</label></td>
						<td><form:password path="pass" /></td>
					</tr>


					<tr>
						<td></td>
						<td><input type="submit" value="Wyslij" /></td>
					</tr>

				</tbody>
			</table>
			
			<br>
			<a href="create">Rejestracja nowego uzytkownika</a>

		</form:form>
	</div>


</body>
</html>