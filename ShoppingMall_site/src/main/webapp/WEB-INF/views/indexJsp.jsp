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
		<h1>�μ���� ���� ���� ȯ���մϴ�!</h1>
		<h2>�α����� �������ּ���.</h2>
		<form name="log" method="POST" action="/logIn">
			<p>
				���̵� <input type="text" name="userId">
			</p>
			<p>
				��й�ȣ <input type="password" name="password">
			</p>
			<input type="submit" value="�α���"><br>
		</form>
		<input type="button" value="ȸ������"
			onclick="javascript:location.replace('/signUpPage')">
		<input type="button" value="��й�ȣ ã��"
			onclick="javascript:location.replace('/findPage')">
	</div>
</body>
</html>