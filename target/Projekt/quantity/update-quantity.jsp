<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Edition quantity</title>
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
<h1>Edycja ilości</h1>
<form:form modelAttribute="updateQuantity" method="post">
<form:hidden path="id"/>
<label for="quantity">Ilość: <form:input path="quantity"/>
    <form:errors path="quantity" cssClass="error"/>
</label>
<label for="baseOfMeasures">Jednostka miary: <form:input path="baseOfMeasures"/>
    <form:errors path="baseOfMeasures" cssClass="error"/>

<input type="submit">

</form:form>
