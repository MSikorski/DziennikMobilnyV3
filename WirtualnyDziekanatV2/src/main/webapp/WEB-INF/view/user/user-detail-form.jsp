<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profil</title>
</head>
<body>

	<h2>Profil uzytkownika ${user.userName}</h2>
	
	<form:form action="saveDetail" modelAttribute="user.userDetail"
		method="POST">

		<!-- need to pass id -->
		<form:hidden path="id" />

		<table>
			<tbody>

				<tr>
					<td><label>Email:</label></td>
					<td><form:input path="email" /></td>
				</tr>

				<tr>
					<td><label>Imie:</label></td>
					<td><form:input path="firstName" /></td>
				</tr>
				
				<tr>
					<td><label>Nazwisko:</label></td>
					<td><form:input path="lastName" /></td>
				</tr>	
				
				<tr>
					<td><label>Numer telefonu:</label></td>
					<td><form:input path="telephoneNumber" /></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Save" class="save" /></td>
				</tr>

			</tbody>
		</table>


	</form:form>



</body>
</html>