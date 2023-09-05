<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Lista zakupów</title>
</head>
<body>

<h1>Lista zakupów</h1>
<c:forEach items="${productList}" var="product">
    <p>${product.id} ${product.nameProduct}
        <label for="uniqueBaseOfMeasures">Ilość:
                <form:select items="${quantity}" path="uniqueBaseOfMeasures" itemLabel="quantity" itemValue="id"/>
    </p>
<%--    <ul>--%>
<%--        <c:forEach items="${product.quantity}" var="quantityList">--%>
<%--            <li>--%>
<%--                    ${quantity.quantity} ${quantity.baseOfMeasures}--%>
<%--            </li>--%>
<%--        </c:forEach>--%>
<%--    </ul>--%>
</c:forEach>
</body>
</html>