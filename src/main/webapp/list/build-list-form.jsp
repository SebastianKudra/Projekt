<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Lista zakupów</title>
</head>
<body>

<h1>Lista zakupów</h1>
<form:form modelAttribute="productList" method="post">

<c:forEach items="${productList}" var="product">
    <p>${product.name}- ${product.priceProduct} ${product.currencyProduct}
        <label for="amount"> Ilość:
                <form:select items="${amount}" path="amount" itemLabel="quantity" itemValue="id"/>
    </p>

</c:forEach>
</form:form>
</body>
</html>
