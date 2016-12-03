<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" action="signup.do" modelAttribute="course">
		년도 : <form:input type="text" path="year" value="" />
		<br />
		<form:errors path="year"></form:errors>
		<br />    
		학기 : <form:input type="text" path="semester" value="" />
		<br />
		<form:errors path="semester"></form:errors>
		<br />  
		교과목명 : <form:input type="text" path="name" />
		<br />
		<form:errors path="name"></form:errors>
		<br />  
		과목코드 : <form:input type="text" path="code" />
		<br />
		<form:errors path="code"></form:errors>
		<br />   
		 분류 : <form:input type="text" path="classify" />
		<br />
		<form:errors path="classify"></form:errors>
		<br />  
		학점 : <form:input type="text" path="credit" value="" />
		<br />
		<form:errors path="credit"></form:errors>
		<br />

		<input type="submit" value="수강 신청" />
	</form:form>





</body>
</html>