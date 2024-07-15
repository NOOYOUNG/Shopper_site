<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset Password</title>
</head>
<body>
<form name="resetPwd" method="POST" action="/resetPassword">
	아이디: <input type="text" name="userId" value="${currentUserId}">
	비밀번호를 재설정하세요<br>
	<input type="password" name="repassword">
	<input type="submit" value="비밀번호 재설정">
</form>
</body>
</html>