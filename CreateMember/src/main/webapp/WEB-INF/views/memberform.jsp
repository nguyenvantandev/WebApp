<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>メンバー登録</title>
</head>
<body>
	<form:form action="member" method="POST">
		<div align="center">
		<P>The time on the server is ${serverTime}.</P>
			<table border="0">
				<tr>
					<td colspan="2" align="center">メンバー登録</td>
				</tr>

				<tr>
					<td>ID:</td>
					<td><form:input path="memeber_id" /></td>
				</tr>

				<tr>
					<td>名前:</td>
					<td><form:input path="member_name" /></td>
				</tr>

				<tr>
					<td>性別:</td>
					<td><form:select path="sex" items="${sexlist}"></form:select></td>
				</tr>
				<tr>
					<td>生年月日:</td>
					<td><form:select path="year" items="${yearlist}"></form:select><label>年</label>
						<label>年</label>
					<form:select path="month" items="${monthlist}"></form:select> <label>年</label>
					<form:select path="day" items="${daylist}"></form:select></td>
				</tr>
				<tr>
					<td>出身地:</td>
					<td><form:input path="birthplace"/></td>
				</tr>
				<tr>
					<td>結婚状況:</td>
					<td><form:select path="mari" items="${maristatus}"></form:select></td>
				</tr>
				<tr>
					<td>職務:</td>
					<td><form:input path="employee"/></td>
				</tr>
				<tr>
					<td>現在住所:</td>
					<td><form:input path="persent_address"/></td>
				</tr>
				<tr>

					<td colspan="2" align="right"><input type="submit" id="add"
						name="add" value="登録"></td>
				</tr>

			</table>
		</div>
	</form:form>
	
</body>
</html>
