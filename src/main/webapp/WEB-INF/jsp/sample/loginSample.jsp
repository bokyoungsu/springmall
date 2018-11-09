<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<h2>SAMPLE LOGIN</h2>
	<form action="/sample/loginSample" method="post">
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
				<td colspan="2"><input type="submit" value="로그인" /></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>