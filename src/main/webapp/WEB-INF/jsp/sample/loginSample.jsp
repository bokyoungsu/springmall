<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(()=>{
	    $('#loginBtn').click(()=>{
	    	$('#loginForm').submit();
	    });
	});
</script>
</head>
<body>
	<h2>SAMPLE LOGIN</h2>
	<form id="loginForm" action="/sample/loginSample" method="post">
		<table class="table">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="sampleId" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="samplePw" /></td>
			</tr>
			<tr>
				<td colspan="2"><button id="loginBtn" class="btn btn-primary">로그인</button></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>