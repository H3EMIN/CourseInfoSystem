<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td>전기</td>
			<td>전지</td>
			<td>전선</td>
			<td>교필</td>
			<td>핵교</td>
			<td>일교</td>
			<td>총학점</td>
		</tr>
		<tr>
			<c:forEach var="i" items="${cl}">
				<td>${i}</td>
			</c:forEach>
		</tr>

	</table>




</body>
</html>