<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"  %>
<%@ page import="data.Answers"  %>
<%@ page import="javax.ws.rs.client.*"  %>
<%@ page import="javax.ws.rs.client.Invocation.Builder"  %>
<%@ page import="javax.ws.rs.core.*"  %>
 <style><%@include file="/jsp/style.css"%></style>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>From request</h3>
<ol>
<c:forEach var="vastaukset" items="${requestScope.answerslist }">
	<li>
	
				${vastaukset.ehdokas_id}:
		 		${vastaukset.kysymys_id} 
				${vastaukset.vastaus}	
				${vastaukset.kommentti}
</c:forEach>
</ol>

<h3>From method</h3>

<ol>
<c:forEach var="vastaukset" items="<%=readAll() %>">
	<li>
	
				${vastaukset.ehdokas_id}:
		 		${vastaukset.kysymys_id} 
				${vastaukset.vastaus}	
				${vastaukset.kommentti}
</c:forEach>
</ol>
</body>
</html>

<%!
List<Answers> readAll() {
	String uri = "http://127.0.0.1:8080/rest/vaalikoneservice/readanswer";
	Client c=ClientBuilder.newClient();
	WebTarget wt=c.target(uri);
	Builder b=wt.request();
	GenericType<List<Answers>> genericList = new GenericType<List<Answers>>() {};
	
	List<Answers> list=b.get(genericList);
	return list;
/* 	String bookjsonlist=b.get(String.class);
	//Print the contents of the list
	System.out.println("All the books");
	for (Book x:list){
		System.out.println(x);
	}
	System.out.println(bookjsonlist);
 */
 }
%>