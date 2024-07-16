<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.shop.site.Model.Member" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ASK Q&A</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>게시글번호</td>
				<td>사용자 아이디</td>
				<td>내용</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardList}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.userId}</td>
					<td>${item.content}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<td bgcolor="black" height="2px" colspan=10></td>
		</tr>
	</table>
	<h3>1:1 문의 작성하기</h3>
	<form name="personalqna" action="/writeqna" method="post">
		<table>
			<tr>
				<td><input type="text" name="content" placeholder="내용을 입력하세요"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
				<td><input type="submit" value="문의하기"></td>
			</tr>
		</table>
	</form>
<%-- 	<script>
	function checkPwd(){
		var enterpwd=document.getElementById().value;
		var realpwd = "<%= ((Member) request.getAttribute("loggedmember")).getPassword() %>";
		 
		if(enterpwd==realpwd){
			document.getElementById("personalqna").submit();
		}
		else{
			alert("비밀번호가 일치하지 않습니다.");
		}
	}
	</script> --%>
</body>
</html>