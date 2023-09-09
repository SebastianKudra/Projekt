<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Lista elementów listy zakupów</title>
</head>
<body>
<h1>Lista elementów listy zakupów</h1>
<a href="/listitem/add">Dodaj nowy element listy zakupów</a>
<table>
  <thead>
  <tr>

    <th>Produkt</th>
    <th>Lista zakupów</th>
    <th>Ilość</th>
    <th>Akcje</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${listLidl}" var="shoppingListItem">
    <tr>

      <td>${shoppingListItem.product.nameProduct}</td>
      <td>${shoppingListItem.shoppingList.name}</td>
      <td>${shoppingListItem.quantity}</td>
      <td>
        <a href="/listitem/update/${shoppingListItem.id}">Edytuj</a>
        <a href="/listitem/remove/${shoppingListItem.id}">Usuń</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>

