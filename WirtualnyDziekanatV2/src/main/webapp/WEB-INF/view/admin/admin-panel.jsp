<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panel Administratora</title>
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

<div>
	<center><h1>Panel Administratora</h1></center>
	<h3>Funkcje</h3>
	
	<ul>
		<li><a href="/WirtualnyDziekanat/admin/manageUsers">Zarzadzaj uzytkownikami</a></li>
		<li><a href="/WirtualnyDziekanat/admin/manageStudentGroups">Zarzadzaj grupami studenckimi</a></li>		
		<li><a href="/WirtualnyDziekanat/admin/logs">Sprawdz logi serwera</a>
	</ul>
	


</div>

</body>
</html>