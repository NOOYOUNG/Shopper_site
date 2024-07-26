<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InShow Mall</title>
</head>
<body>
	<div id="loginbox">
		<h1>인쇼몰에 오신 것을 환영합니다!</h1>
		<h2>로그인을 진행해주세요.</h2>
		<form name="log" method="POST" action="/logIn">
			<p>
				아이디 <input type="text" name="userId">
			</p>
			<p>
				비밀번호 <input type="password" name="password">
			</p>
			<input type="submit" value="로그인"><br>
		</form>
		<input type="button" value="회원가입"
			onclick="javascript:location.replace('/signUpPage')">
		<input type="button" value="비밀번호 찾기"
			onclick="javascript:location.replace('/findPage')">
	</div>
</body>
</html>