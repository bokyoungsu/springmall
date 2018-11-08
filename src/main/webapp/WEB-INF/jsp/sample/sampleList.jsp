<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sample list</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<h2>sample list</h2>
	<table class="table">
		<thead>
			<tr>
				<td colspan="4"></td>
				<td align="center"><a href="/sample/addSample"><button class="btn btn-primary">회 원 가 입</button></a></td>
			</tr>
			<tr class="info" align="center">
				<td>no</td>
				<td>id</td>
				<td>pw</td>
				<td>DELETE</td>
				<td>UPDATE</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sample" items="${sampleList}">
				<tr align="center">	
					<td>${sample.sampleNo}</td>
					<td>${sample.sampleId}</td>
					<td>${sample.samplePw}</td>
					<td><a href="/sample/removeSample?sampleNo=${sample.sampleNo}">DELETE</a></td>
					<td><a href="/sample/modifySample?sampleNo=${sample.sampleNo}">UPDATE</a></td>
				</tr>
			</c:forEach>
				<tr>
					<c:if test="${startRow >9}">
						<td align="center"><a href="/sample/sampleList?startRow=${startRow -10}"><button class="btn btn-primary btn-sm">이전</button></a></td>
					</c:if>
					<c:if test="${startRow < totalCount-10}">
						<td align="center"><a href="/sample/sampleList?startRow=${startRow +10}"><button class="btn btn-primary btn-sm">다음</button></a></td>
					</c:if>
				</tr>
				
		</tbody>
	</table>
</body>
</html>