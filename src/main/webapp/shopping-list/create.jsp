<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<<html>
<head>
    <title>Dodaj nową listę zakupów</title>
</head>
<body>
<h1>Dodaj nową listę zakupów</h1>
<form action="/shoppinglists/add" method="post">
    <label for="name">Nazwa:</label>
    <input type="text" id="name" name="name" required/>
    <br/>
    <input type="submit" value="Utwórz listę"/>
</form>
<br/>
<a href="/shoppinglists/list">Wróć do listy zakupów</a>
</body>
</html>

