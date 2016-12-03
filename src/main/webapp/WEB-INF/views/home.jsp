<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<style>
  table {
  }
  th, td {
    border: 1px solid #bcbcbc;
  }
</style>
<head>

	<title>Home</title>
</head>
<body>

<table>
		<tr>
			<td><a href = "${pageContext.request.contextPath}/semester"> 학기별 이수 학점 조회</a></td>
		</tr>
		<tr>
			<td><a href = "${pageContext.request.contextPath}/classify"> 이수 구분별 학점 조회</a></td>
		</tr>
		<tr>
			<td><a href = "${pageContext.request.contextPath}/signup"> 수강 신청하기</a></td>
		</tr>
		<tr>
			<td><a href = "${pageContext.request.contextPath}/signupinfo"> 수강 신청 조회</a></td>
		</tr>
			

	</table>


</body>
</html>
