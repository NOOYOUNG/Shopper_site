<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>All Item List</title>
	</head>
	<body>
		<h2>전체 상품 조회</h2>
		<table>
			<c:forEach items="${itemList}" var="item">
				<tr>
					<td>상품명</td>
					<td>${item.itemName}</td>
				</tr>
				<tr>
					<td>상품종류</td>
					<td>${item.productType}</td>
				</tr>
				<tr>
					<td>판매처</td>
					<td>${item.shop}</td>
				</tr>
				<tr>
					<td>가격</td>
					<td>${item.price}</td>
				</tr>
				<tr>
					<td>판매시작일</td>
					<td>${item.saleDate}</td>
				</tr>
				<tr>
					<td>상품 삭제하기</td>
					<td>
						<form action="deleteItem">
							<input type="hidden" name="id" value="${item.id}">
							<input type="submit" value="삭제">
						</form>
					</td>
				</tr>
				<tr>
					<td bgcolor="black" height="2px" colspan=2></td>
				</tr>
			</c:forEach>
		</table>
		<form action="/adminPage">
			<input type="submit" value="관리자 페이지로 이동">
		</form>
	</body>
</html>