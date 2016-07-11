<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Seminar 2014</title>
</head>
<body>
<h2>Hello Form</h2>
<form:form action="hello.htm" method="post" modelAttribute="user">
<div>ID:</div>
<form:input path="id"/>
<div>Name:</div>
<form:input path="name"/>
<hr>
<input type="submit" value="Say Hello">
</form:form>
</body>
</html>