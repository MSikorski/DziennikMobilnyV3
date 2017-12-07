<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<spring:url value="/resources/css/infoboxes.css" var="infoBoxes" />
<link href="${infoBoxes}" rel="stylesheet" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profil uzytkownika</title>
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
	
	<h2>Profil uzytkownika ${user.userName}</h2>
	
	<h3>${msg}</h3>

	<form action="saveDetail" method="POST">

		<table>
			<tbody>

				<tr>
					<td><label>Email:</label></td>
					<td><form:input path="user.userDetail.email" /></td>
					<td><div class="isa_error">
								<i class="fa fa-times-circle"></i><center>
								 <form:errors path="user.userDetail.email" /></center>
							</div></td>
				</tr>

				<tr>
					<td><label>Imie:</label></td>
					<td><form:input path="user.userDetail.firstName" /></td>
					<td><div class="isa_error">
								<i class="fa fa-times-circle"></i><center>
								 <form:errors path="user.userDetail.firstName" /></center>
							</div></td>
				</tr>

				<tr>
					<td><label>Nazwisko:</label></td>
					<td><form:input path="user.userDetail.lastName" /></td>
					<td><div class="isa_error">
								<i class="fa fa-times-circle"></i><center>
								 <form:errors path="user.userDetail.lastName" /></center>
							</div></td>
				</tr>

				<tr>
					<td><label>Numer telefonu:</label></td>
					<td><form:input path="user.userDetail.telephoneNumber" /></td>
					<td><div class="isa_error">
								<i class="fa fa-times-circle"></i><center>
								 <form:errors path="user.userDetail.telephoneNumber" /></center>
							</div></td>
				</tr>
				
				
				<tr>
					<td><label>Uprawnienia studenta </label>
					<form:checkbox path="privagles.studentPrivagles"/></td>
					
					<td><label>Uprawnienia nauczyciela </label>
					<form:checkbox path="privagles.teacherPrivagles"/></td>
					
					<td><label>Uprawnienia administratora </label>
					<form:checkbox path="privagles.adminPrivagles"/></td>
					
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Save" class="save" /></td>
				</tr>

			</tbody>
		</table>
	</form>
</div>


</body>
</html>