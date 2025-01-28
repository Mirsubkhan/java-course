<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>888</title>
</head>
<body>
	<h2>Find a user</h2>
    <form action="findUser" method="post">
        <label for="login">Login:</label>
        <input type="text" id="login" name="login" required><br><br>

        <button type="submit">Find</button>
    </form>
    
    <span>${message}</span>
</body>
</html>