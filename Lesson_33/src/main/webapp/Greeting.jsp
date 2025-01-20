<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Greeting" method="post">
		<input type="text" name="name" placeholder="input your name to see time"/>
		<button>Hello!</button>
		<br>
		<span>Hello, ${ name != null ? name : 'guest' }!</span>
		<br>
		<span>${ time }</span>
	</form>
</body>
</html>