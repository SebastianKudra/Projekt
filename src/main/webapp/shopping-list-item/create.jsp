<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nowy element listy zakupów</title>
</head>
<body>
<h1>Nowy element listy zakupów</h1>
<form action="/listitem/add" method="post">
    <label for="product">Produkt:</label>
    <select id="product" name="product.id">
        <c:forEach items="${products}" var="product">
            <option value="${product.id}">${product.nameProduct}</option>
        </c:forEach>
    </select>
    <br/>
    <label for="shoppingList">Lista zakupów:</label>
    <select id="shoppingList" name="shoppingList.id">
        <c:forEach items="${shoppingLists}" var="shoppingList">
            <option value="${shoppingList.id}">${shoppingList.name}</option>
        </c:forEach>
    </select>
    <br/>
    <label for="quantity">Ilość:</label>
    <input type="number" id="quantity" name="quantity" required/>
    <br/>
    <input type="submit" value="Dodaj" />
    <a href="/listitem/list/">Powrót do listy zakupów</a>
</form>
</body>
</html>
