<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Nowy Produkt</title>
</head>
<body>
<h1>Nowy Produkt</h1>    <form method="post" action="<c:url value='/product/add'/>">
  <label for="nameProduct">Nazwa:</label>
  <input type="text" id="nameProduct" name="nameProduct" required/>
  <br/>
  <label for="priceProduct">Cena:</label>
  <input type="number" id="priceProduct" name="priceProduct" required/>
  <br/>
  <label for="currencyProduct">Waluta:</label>
  <input type="text" id="currencyProduct" name="currencyProduct" required/>
  <br/>
  <label for="zoneProductBiedronka">Strefa Biedronka:</label>
  <input type="text" id="zoneProductBiedronka" name="zoneProductBiedronka" required/>
  <br/>
  <label for="zoneProductLidl">Strefa Lidl:</label>
  <input type="text" id="zoneProductLidl" name="zoneProductLidl" required/>
  <br/>
  <input type="submit" value="Utwórz"/>
</form>    <a href="<c:url value='/product/list'/>">Powrót do Listy Produktów</a>
</body>
</html>