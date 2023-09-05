<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add Quantity</title>
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
<h1>DODAJ NOWĄ ILOŚĆ</h1>
<form:form modelAttribute="quantity" method="post">
<label for="quantity">Ilość: <form:input path="quantity"/>
    <form:errors path="quantity" cssClass="error"/>
</label>
<label for="baseOfMeasures">Jednostka miary: <form:input path="baseOfMeasures"/>
    <form:errors path="baseOfMeasures" cssClass="error"/>
</label>



<input type="submit">
</form:form>
