<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista dostępnych ilości</title>
</head>
<body>
<a href="add">Dodaj nowe dane</a>
<h1>Lista ilości</h1>

<c:forEach items="${quantityList}" var="quantity">
<p>${quantity.id}. ${quantity.quantity} ${quantity.baseOfMeasures}
    <a href="updateQuantity/${quantity.id}">Edytuj ilosc</a>
    <a href="removeQuantity/${quantity.id}">Usuń pozycję z ilością</a>
</p>

</c:forEach>

</body>
</html>