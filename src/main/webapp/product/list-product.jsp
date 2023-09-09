<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista produktów</title>
</head>
<body>
<a href="add">Dodaj nowy produkt</a>
<h1>Lista produktów</h1>

<c:forEach items="${products}" var="product">
    <p>${product.id}. ${product.nameProduct} ${product.priceProduct} ${product.currencyProduct}
        <a href="updateProduct/${product.id}">Edytuj produkt</a>
        <a href="remove/${product.id}">Usuń produkt</a>
    </p>

</c:forEach>

</body>
</html>