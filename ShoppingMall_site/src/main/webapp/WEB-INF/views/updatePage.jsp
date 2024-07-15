<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Personal Information</title>
</head>
<body>
<form name="update" method="GET" action="/updateMember">
	<h2>개인정보 수정</h2>
	아이디: ${currentUserId}<br>
	이름: <input type="text" name="modname" value="${currentName}"><br>
	나이: <input type="text" name="modage" value="${currentAge}"><br>
	주소: <input type="text" name="modaddress" value="${currentAddress}"><br>
	전화번호: <input type="text" name="modphone" value="${currentPhone}"><br>
	<input type="hidden" name="userId" value="${currentUserId}">
	<input type="submit" value="회원정보 변경하기">
</form>
</body>
</html>