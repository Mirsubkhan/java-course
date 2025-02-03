<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="NameServlet" method="post">
		<lablel>Input your name here: </lablel>
		<input type="text" name="name" value="Guest">
		<button>Hello</button>
	</form>
	
	<h1>Hello, ${name}</h1>
</body>
</html>