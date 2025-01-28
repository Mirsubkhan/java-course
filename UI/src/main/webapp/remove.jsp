<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>888</title>
</head>
<body>
	<h2>Remove a user</h2>
    <form action="removeUser" method="post">
        <label for="loginOrEmail">Input a login or an email of some user to delete the data:</label>
        <input type="text" id="loginOrEmail" name="loginOrEmail" required><br><br>

        <button type="submit">Remove</button>
    </form>
    
    <span>${message}</span>
</body>
</html>