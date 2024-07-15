<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enter Personal Information</title>
</head>
<body>
<h2>회원정보 조회</h2>
<form name="find" method="POST" action="/findPassword">
이름을 입력하세요: <input type="text" name="name" value="${currentName}"><br>
전화번호를 입력하세요: <input type="text" name="phone" value="${currentPhone}"><br>
<input type="hidden" name="listNumber" value="${currentListNumber}">
<input type="submit" value="비밀번호 찾기">
</form>
</body>
</html>