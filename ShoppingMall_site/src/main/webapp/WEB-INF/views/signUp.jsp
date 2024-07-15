<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up Page</title>
</head>
<body>
	<form name="signUp" method="POST" action="/signUp">
		아이디 <input type="text" name="userId"><br>
		비밀번호 <input type="password" name="password"><br>
		이름 <input type="text" name="name"><br>
		나이 <input type="text" name="age"><br>
		주소 <input type="text" name="address"><br>
		전화번호 <input type="text" name="phone"><br>
		<input type="submit" value="가입">
	</form>
</body>
</html>