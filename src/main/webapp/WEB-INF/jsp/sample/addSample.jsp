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
        $('#sampleId').focus();
        $('#sampleId').blur(()=>{
            if($('#sampleId').val().length < 4 || $('#sampleId').val().length > 8) {
                $('#addSampleHelp').text('아이디는 4자이상 8자이하입니다.');
                $('#sampleId').focus();
            } else {
                $('#addSampleHelp').text('');
            }
        });
        $('#samplePw').blur(()=>{
            if($('#samplePw').val().length < 4 || $('#samplePw').val().length > 8) {
                $('#addSampleHelp1').text('비밀 번호는 4자이상 8자이하입니다.');
                $('#samplePw').focus();
            } else {
                $('#addSampleHelp1').text('');
            }
        });
        $('#addBtn').click(()=>{
             if($('#sampleId').val().length < 4 || $('#sampleId').val().length > 8) {
                 $('#sampleId').focus();
             } else if($('#samplePw').val().length < 4 || $('#samplePw').val().length > 8) {
                 $('#samplePw').focus();
             } else {
                 $('#addForm').submit(); 
             }
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
				<td><input type="text" name="sampleId" id="sampleId"/><label id="addSampleHelp"></label></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="text" name="samplePw" id="samplePw"/><label id="addSampleHelp1"></label></td>
			</tr>
			<tr>
				<td callspan="2"><button id="addBtn" class="btn btn-primary">회원등록</button></td>
			</tr>
		</table>
	</form>
</body>
</html>