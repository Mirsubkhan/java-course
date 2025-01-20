<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Math" method="post">
		<input type="text" name="num"/>
		<input type="text" name="num2"/>
		<input type="text" name="num3"/>
		<br>
		<input type="radio" name="command" value="0"/> Average
		<input type="radio" name="command" value="1"/> Maximum
		<input type="radio" name="command" value="2"/> Minimum
		<br>
		<button>Start</button>
		<br>
		<span>${ res }</span>
	</form>
</body>
</html>