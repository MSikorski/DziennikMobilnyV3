<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<spring:url value="/resources/css/infoboxes.css" var="infoBoxes" />
<link href="${infoBoxes}" rel="stylesheet" />

<spring:url value="http://code.jquery.com/jquery-2.2.4.min.js" var="jQueryScript" />
<script type="text/javascript" src="${jQueryScript}"></script>

<spring:url value="/resources/js/userNamePanel.js" var="userNameScript" />
<script type="text/javascript" src="${userNameScript}"></script>

<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Rejestracja nowego uzytkownika</title>
</head>
<body>

<div id="userPanel" align="right">
	<table>
		<tr>
			<td><a href="/WirtualnyDziekanat/">Strona glowna</a></td>
			<td><a href="/WirtualnyDziekanat/user/detail" id="userName">Profil uzytkownika ${user.userName}</a></td>
			<td><a href="/WirtualnyDziekanat/user/logout" id="logout">Wyloguj</a></td>
		</tr>
	</table>
</div>

	<div align="center">

		<h2>Rejestracja nowego uzytkownika</h2>

		<form action="save" method="POST">

		${msg}

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
						<td><form:password path="user.tempPass" /></td>
						<td><div class="isa_error">
								<i class="fa fa-times-circle"></i><center>
						<form:errors path="user.tempPass" /></center>
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