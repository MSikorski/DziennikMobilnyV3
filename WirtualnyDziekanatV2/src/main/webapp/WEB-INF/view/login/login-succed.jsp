<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta http-equiv="refresh" content="3;url=/WirtualnyDziekanat/" />

<title>Zalogowano pomylsnie</title>

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
		<h3>${msg}</h3>
		
		<br>
		
		Przekierowanie do strony glownej po 3 sekundach
		
		<br>
		
		<a href="/WirtualnyDziekanat">Powrot do strony glownej</a>
	</div>
	

	
	

</body>
</html>