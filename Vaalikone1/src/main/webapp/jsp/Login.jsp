<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<style><%@include file="/jsp/style.css"%></style>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="/LoginCheck">
		<table>
			<tr>
				<td>K�ytt�j�tunnus</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Salasana</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Kirjaudu sis��n" /></td>
			</tr>
			
		</table>
	</form>
</body>
</html>


