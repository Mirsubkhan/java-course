<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>888</title>
</head>
<body>
	<h2>Update a user</h2>
    <form action="updateUser" method="post">
        <label for="login">Login: </label>
        <input type="text" id="login" name="login" required><br><br>
        
        <label for="newLogin">New login:</label>
        <input type="text" id="newLogin" name="newLogin"><br><br>
        
        <label for="newEmail">New email:</label>
        <input type="email" id="newEmail" name="newEmail"><br><br>

        <button type="submit">Update</button>
    </form>
    
    <span>${message}</span>
</body>
</html>