<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Lista Produktów</title>
</head>
<body>
<h1>Lista Produktów</h1>
<table>
    <thead>
    <tr>
        <th>Nazwa Produktu</th>
        <th>Cena</th>
        <th>Wybierz</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allProducts}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.nameProduct}</td>
            <td>${product.priceProduct}</td>
            <td>
                <form method="post" action="/shoppingList/selectAll">
                    <input type="hidden" name="productId" value="${product.id}">
                    <input type="submit" value="Wybierz">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h2>Wybrane Produkty</h2>
<table>
    <thead>
    <tr>
        <th>Nazwa Produktu</th>
        <th>Cena</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${shoppingList.products}" var="selectedProduct">
        <tr>
            <td>${selectedProduct.product.id}</td>
            <td>${selectedProduct.product.nameProduct}</td>
            <td>${selectedProduct.product.priceProduct}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form method="post" action="/shoppingList/selectAll">
    <input type="submit" value="Zapisz Wybrane Produkty">
</form>
<%--<c:if test="${not empty shoppingList.products}">--%>
<%--    <h3>Suma wybranych produktów: ${shoppingList.getTotalPrice()}</h3>--%>
<%--</c:if>--%>
</body>
</html>