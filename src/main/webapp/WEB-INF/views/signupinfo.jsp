<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<table border="1">
		<tr>
			<td>년도</td>
			<td>학기</td>
			<td>과목코드</td>
			<td>교과목명</td>
			<td>구분</td>
			<td>학점</td>
		</tr>
			
	<c:forEach var="course" items="${signupCourse}">
		<tr>
			<td><c:out value="${course.year}">
			</c:out></td>
			<td><c:out value="${course.semester}">
			</c:out></td>
			<td><c:out value="${course.code}">
			</c:out></td>
			<td><c:out value="${course.name}">
			</c:out></td>
			<td><c:out value="${course.classify}">
			</c:out></td>
			<td><c:out value="${course.credit}">
			</c:out></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>