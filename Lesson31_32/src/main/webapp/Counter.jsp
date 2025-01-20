<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Count" method="post">
		<input type="text" name="text"/>
		<button>Start</button>
		<br>
		<span>Vowels -> ${ vowelsList }</span>
		<br>
		<span>Vowels amount -> ${ vowels }</span>
		<br>
		<span>Marks -> ${ marksList }</span>
		<br>
		<span>Marks amount -> ${ marks }</span>
		<br>
		<span>Consonants -> ${ consonantsList }</span>
		<br>
		<span>Consonants amount -> ${ consonants }</span>
	</form>
</body>
</html>