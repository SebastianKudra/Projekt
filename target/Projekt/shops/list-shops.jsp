<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista sklepów</title>
</head>
<body>
<a href="add">Dodaj nowy sklep</a>
<h1>Lista sklepów</h1>

<c:forEach items="${shopList}" var="shop">
<p>${shop.id}. ${shop.shopName} ${shop.shopStreet} ${shop.postCode} ${shop.shopCity} ${shop.signatureShop}
    <a href="updateShop/${shop.id}">Edytuj Sklep</a>
    <a href="removeShop/${shop.id}">Usuń sklep</a>
</p>

</c:forEach>

</body>
</html>