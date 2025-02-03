<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>
</head>
<body>
    <h2>Sum Calculator</h2>
    
    <form action="CalculatorServlet" method="post">
        <label for="num1">Input first number:</label>
        <input type="number" name="num1" required>
        <br><br>
        
        <label for="num2">Input second number:</label>
        <input type="number" name="num2" required>
        <br><br>
        
        <button type="submit">Calculate</button>
        <span>${res}</span>
    </form>
</body>
</html>
