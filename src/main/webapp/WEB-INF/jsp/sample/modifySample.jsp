<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(()=>{
	    $('#modifyBtn').click(()=>{
	    	$('#modifyForm').submit();
	    });
	});
</script>
</head>
<body>
	<h2>Sample 수정화면</h2>
	<form id="modifyForm" action="${pageContext.request.contextPath}/sample/modifySample" method="post">
		<table class="table">
			<tr>
				<td>NO</td>
				<td><input type="text" name="sampleNo" value="${sample.sampleNo}" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>ID</td>
				<td><input type="text" name="sampleId" value="${sample.sampleId}"/></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="text" name="samplePw" value="${sample.samplePw}"/></td>
			</tr>
			<tr>
				<td callspan="2"><button id="modifyBtn" class="btn btn-primary">수정</button></td>
			</tr>
		</table>
	</form>
</body>
</html>