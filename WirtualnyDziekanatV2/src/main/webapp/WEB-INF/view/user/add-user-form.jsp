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
		<a href="/WirtualnyDziekanat/">Strona glowna </a> 
		<a href="detail">Profil uzytkownika [${user.userName}] </a>
	</div>

	<div align="center">

		<h2>Rejestracja nowego uzytkownika</h2>

		<form action="save" method="POST">

			<!-- need to pass id -->
			<form:hidden path="user.id" />

			<table>
				<tbody>

					<tr>
						<td><label>Nazwa uzytknownika:</label></td>
						<td><form:input path="user.userName" /></td>
						<td><div class="isa_error">
								<i class="fa fa-times-circle"></i><center>
								 <form:errors path="user.userName" /></center>
							</div></td>
					</tr>

					<tr>
						<td><label>Haslo:</label></td>
						<td><form:password path="user.password" /></td>
						<td><div class="isa_error">
								<i class="fa fa-times-circle"></i><center>
						<form:errors path="user.password" /></center>
						</div></td>
					</tr>


					<tr>
						<td></td>
						<td><input type="submit" value="Wyslij" /></td>
					</tr>

				</tbody>
			</table>


		</form>
	</div>


</body>
</html>