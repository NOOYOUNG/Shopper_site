<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Admin Page</title>
	</head>
	<body>
		<h1>로그인 성공</h1>
		<h2>관리자 정보 조회</h2>
		아이디: ${currentUserId}<br>
		이름: ${currentName}<br>
		나이: ${currentAge}<br>
		주소: ${currentAddress}<br>
		전화번호: ${currentPhone}<br>
		<form action="/logout">
			<input type="submit" value="로그아웃">
		</form>
		<form action="/updatePage">
			<input type="hidden" name="userId" value="${currentUserId}">
			<input type="submit" value="관리자 정보 수정">
		</form>
		<form action="/deleteMember">
			<input type="hidden" name="userId" value="${currentUserId}">
			<input type="submit" value="관리자 탈퇴">
		</form>
		<form action="/addItem">
			<input type="submit" value="상품 추가">
		</form>
		<form action="/readItemList">
			<input type="submit" value="상품 목록 조회">
		</form>
		<table>
		<tr>
			<td>상품 검색</td>
			<td>
				<form action="/searchItem">
					<input type="text" name="searchText">
					<input type="submit" value="검색">
				</form>
			</td>
		</tr>
		</table>
	</body>
</html>