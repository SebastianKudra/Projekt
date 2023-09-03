<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Shop</title>
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
<h1>DODAJ NOWY SKLEP</h1>
<form:form modelAttribute="shops" method="post">
<label for="shopName">Nazwa sklepu: <form:input path="shopName"/>
    <form:errors path="shopName" cssClass="error"/>
</label>
<label for="shopStreet">Ulica: <form:input path="shopStreet"/>
    <form:errors path="shopStreet" cssClass="error"/>
</label>
<label for="postCode">Kod pocztowy: <form:input path="postCode"/>
    <form:errors path="postCode" cssClass="error"/>
</label>
<label for="shopCity">Miasto: <form:input path="shopCity"/>
    <form:errors path="shopCity" cssClass="error"/>
</label>
<label for="signatureShop">Kod sklepu: <form:input path="signatureShop"/>
    <form:errors path="signatureShop" cssClass="error"/>
</label>


<input type="submit">
</form:form>
