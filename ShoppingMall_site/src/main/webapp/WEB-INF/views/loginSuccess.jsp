<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
</head>
<body>
<h1>로그인 성공</h1>
<h2>개인정보조회</h2>
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
	<input type="submit" value="회원정보 수정">
	</form>
	<form action="/deleteMember">
	<input type="hidden" name="userId" value="${currentUserId}">
	<input type="submit" value="회원탈퇴">
	</form>
</body>
</html>