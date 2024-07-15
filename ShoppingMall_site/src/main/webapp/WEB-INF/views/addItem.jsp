<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add Merchandise Item</title>
	</head>
	<body>
		<form action="/insertItem">
			<h2>상품 정보 입력</h2>
			상품명: <input type="text" name="itemName"><br>
			상품종류: <input type="text" name="productType"><br>
			판매처: <input type="text" name="shop"><br>
			상품가격: <input type="text" name="price"><br>
			판매시작일: <input type="date" name="saleDate"><br>
			<input type="submit" value="상품 등록하기">
		</form>
	</body>
</html>