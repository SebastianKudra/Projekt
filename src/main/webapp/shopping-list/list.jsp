<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Lista zakupów</title>
</head>
<body>
<h1>Lista zakupów</h1>
<table>
  <tr>
    <th>Nazwa</th>
    <th>Akcje</th>
  </tr>
  <c:forEach items="${shoppingLists}" var="shoppingList">
    <tr>
      <td>${shoppingList.name}</td>
      <td>
        <a href="editlist/${shoppingList.id}">Edytuj</a>
        <a href="remove/${shoppingList.id}">Usuń</a>
      </td>
    </tr>
  </c:forEach>
</table>
<br/>
<a href="add">Dodaj nową listę zakupów</a>
</body>
</html>
