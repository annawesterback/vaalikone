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
				<td>Käyttäjätunnus</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Salasana</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Kirjaudu sisään" /></td>
			</tr>
			
		</table>
	</form>
</body>
</html>


<!-- Käyttäjätunnus:<input type="text" name="username"/><br/><br/>   -->
<!-- Salasana:<input type="password" name="password"/><br/><br/>   -->
<!-- <input type="submit" value="Kirjaudu sisään"/>  </form> -->
<!-- </body> -->
<!-- </html> -->