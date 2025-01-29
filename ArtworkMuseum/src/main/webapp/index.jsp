<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search</title>
</head>
<body>
    <h2>Search</h2>

    <form action="searchArtworks" method="post">
        <label for="title">Title:</label>
        <input type="text" name="title" id="title"><br><br>

        <label for="author">Author:</label>
        <input type="text" name="author" id="author"><br><br>

        <label for="year">Year of Creation:</label>
        <input type="text" name="year" id="year"><br><br>

        <label for="category">Category:</label>
        <input type="text" name="category" id="category"><br><br>

        <label for="place">Created in:</label>
        <input type="text" name="place" id="place"><br><br>

        <button type="submit">Search</button>
    </form>

    <span>${message}</span>

    <h3>Result:</h3>
    
    <c:forEach var="artwork" items="${artworks}">
        <p>${artwork.title} - ${artwork.author} - ${artwork.yearOfCreation} - ${artwork.category} - ${artwork.placeOfCreation}</p>
        <img src="${artwork.imageUrl}" alt="${artwork.title}" width="300">
    </c:forEach>
</body>
</html>
