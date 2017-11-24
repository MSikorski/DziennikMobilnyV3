<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Szczegoly profilu studenta</title>
</head>
<body>

	<div align="right">
		<table>
			<tbody>
				<tr>
					<td><a href="/WirtualnyDziekanat/">Strona glowna </a></td>
					<td><a href="/WirtualnyDziekanat/user/detail">Profil
							uzytkownika [${user.userName}] </a></td>
					<td><a href="/WirtualnyDziekanat/user/logout">Wyloguj</a></td>
				</tr>
			</tbody>
		</table>
	</div>


	<div align="center">
		<table>
			<tbody>
				<tr>
					<td>Numer indeksu:</td>
					<td>${user.userDetail.studentDetail.indexNumber}</td>
				</tr>

				<tr>
					<td>Kierunek i specjalizacja:</td>
					<td>${user.userDetail.studentDetail.specialization}</td>
				</tr>

				<tr>
					<td><a href="/WirtualnyDziekanat/student/subjects">Przedmioty</a></td>
				</tr>

				<tr>
					<td><a href="/WirtualnyDziekanat/student/timetable">
					Plan zajec</a></td>
				</tr>

			</tbody>
		</table>
	</div>









	</tbody>
	</table>
</body>
</html>