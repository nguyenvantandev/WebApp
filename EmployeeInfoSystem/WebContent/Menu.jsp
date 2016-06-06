<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Menu.css">
<title>メニュー画面</title>
</head>
<body>
<div>
<h1>メニュー</h1>
<input type="button" id="employeeSearch" name="employeeSearch"  class="button" value="社員マスタ検索" onClick="location.href='EmployeeSearch.jsp'">
<input type="button" id="resumeSearch" name="resumeSearch" class="button" value="経歴書検索" onClick="location.href='ResumeSearch.jsp'">
<input type="button" id="skillList" name="skillList" class="button" value="技術資格マスタ一覧" onClick="location.href='SkillList.jsp'">
</div>

</body>
</html>