<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<spring:url value="/resources/css/infoboxes.css" var="infoBoxes" />
<link href="${infoBoxes}" rel="stylesheet" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Akcja nieudana</title>
</head>
<body>

	<div align="right">
		<a href="/WirtualnyDziekanat/">Strona glowna </a> 
		<a href="/WirtualnyDziekanat/user/detail">Profil uzytkownika [${user.userName}] </a>
		<a href="/WirtualnyDziekanat/user/logout">Wyloguj</a>
	</div>
	
	
	<div class="isa_error"><i class="fa fa-times-circle">
	<center><h2>Zapytanie nie moglo zostac wykonane</h2></center></i></div>
	
	<br>
	<div class="isa_info"><i class="fa fa-times-circle">
	<center>Powod: ${msg}</center></i></div>
	<center><a href="/WirtualnyDziekanat/">Powrot do strony glownej</a></center>

</body>
</html>