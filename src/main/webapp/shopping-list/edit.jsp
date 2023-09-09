<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Edytuj nazwę listę zakupów</title>
</head>
<body>
<h1>Edytuj nazwę listy zakupów</h1>
<h2>
  <a href="/shoppinglists/list">Wróć do listy zakupów</a>
</h2>
<form:form modelAttribute="editShoppingList" method="post">
<form:hidden path="id"/>
<label for="name">Nazwa listy zakupów: <form:input path="name"/>
</label>
  <input type="submit" value="Zapisz zmiany">
</form:form>
</body>
</html>