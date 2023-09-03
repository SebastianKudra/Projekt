<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edition product</title>
    <style>
        label {
            display: inherit;
            margin: 10px;
        }

        .error {
            color: red;
            font-weight: bolder;
        }

    </style>
</head>
<body>
<h1>Edycja produktu</h1>
<form:form modelAttribute="updateProduct" method="post">
<form:hidden path="id"/>
<label for="nameProduct">Nazwa produktu: <form:input path="nameProduct"/>
    <form:errors path="nameProduct" cssClass="error"/>
</label>
<label for="quantityProduct">Ilość: <form:input path="quantityProduct"/>
    <form:errors path="quantityProduct" cssClass="error"/>
</label>
<label for="baseOfMeasure">Jednostka miary: <form:input path="baseOfMeasure"/>
    <form:errors path="baseOfMeasure" cssClass="error"/>
</label>
<label for="priceProduct">Cena : <form:input path="priceProduct"/>
    <form:errors path="priceProduct" cssClass="error"/>
</label>
<label for="currencyProduct">Waluta : <form:input path="currencyProduct"/>
    <form:errors path="currencyProduct" cssClass="error"/>
</label>
<label for="zoneProductBiedronka">Cecha Biedronka: <form:input path="zoneProductBiedronka"/>
    <form:errors path="zoneProductBiedronka" cssClass="error"/>
</label>
<label for="zoneProductLidl">Cecha Lidl: <form:input path="zoneProductLidl"/>
    <form:errors path="zoneProductLidl" cssClass="error"/>
</label>
<label for="zoneProductDino">Cecha Dino: <form:input path="zoneProductDino"/>
    <form:errors path="zoneProductDino" cssClass="error"/>
</label>


<input type="submit">

</form:form>
