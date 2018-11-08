<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
		$(document).ready(()=>{
	        $('#addBtn').click(()=>{
	            $('#addSampleForm').submit();
	        });
	    });
	</script>
</head>
<body>
	<h2>회원 가입</h2>
	<form id="addSampleForm" action="${pageContext.request.contextPath}/sample/addSample" method="post">
		<table class="table">
			<tr>
				<td>ID</td>
				<td><input type="text" name="sampleId"/></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="text" name="samplePw"/></td>
			</tr>
			<tr>
				<td callspan="2"><button id="addBtn" class="btn btn-primary">회원등록</button></td>
			</tr>
		</table>
	</form>
</body>
</html>