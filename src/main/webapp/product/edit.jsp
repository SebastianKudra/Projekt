<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Edycja Produktu</title>
</head>
<body>
<h1>Edycja Produktu</h1>
<h2>
  <a href="/product/list">Powrót do Listy Produktów</a>
</h2>
<form:form modelAttribute="updateProduct" method="post">
  <form:hidden path="id"/>
  <label for="nameProduct">Nazwa produktu: <form:input path="nameProduct"/>
  </label><br>
  <label for="priceProduct">Cena: <form:input path="priceProduct"/>
  </label><br>
  <label for="currencyProduct">Waluta: <form:input path="currencyProduct"/>
  </label><br>
  <label for="zoneProductBiedronka">Biedronka: <form:input path="zoneProductBiedronka"/>
  </label><br>
  <label for="zoneProductLidl">Lidl: <form:input path="zoneProductLidl"/>
  </label><br>
  <input type="submit" value="Zapisz zmiany">

<%--<a href="/product/view/${product.id}">Powrót do Szczegółów Produktu</a> |--%>

</form:form>
</body>
</html>
