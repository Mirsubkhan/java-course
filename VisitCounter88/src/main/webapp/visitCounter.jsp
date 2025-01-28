<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>Visit count: ${visitCount}</h1>
    
    <form action="visitCounter" method="post">
        <button type="submit">Reset the counter</button>
    </form>
</body>
</html>