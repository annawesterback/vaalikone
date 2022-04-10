<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <style><%@include file="/jsp/style.css"%></style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaalikone</title>
</head>
<body>

<<<<<<< HEAD


<h3>Lisää uusi KYSYMYS</h3>
<br>


<a href='/ShowQuestions'>Takaisin kysymyksiin</a> <br><br>
<a href='/mainpage'>Takaisin pääsivulle</a>
=======
<h1>Lisää uusi kysymys</h1>
<br>
<h2>
<a href='/mainpage'>Takaisin pääsivulle</a>
</h2>
>>>>>>> branch 'main' of https://github.com/annawesterback/vaalikone.git
<form action='/addquestions' method='post'>
Kysymyksen ID: <input type='text' name='kysymys_id' value='${requestScope.kysymykset.id}'><br> 
Kysymys: <input type='text' name='kysymys' value='${requestScope.kysymykset.kysymys}'><br>
<input type='submit' name='ok' value='Send help'> 
</form>

<br>
<br>
<<<<<<< HEAD


=======
>>>>>>> branch 'main' of https://github.com/annawesterback/vaalikone.git

</body>
</html>