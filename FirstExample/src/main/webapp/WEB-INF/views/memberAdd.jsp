<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>会員登録</title>
</head>
<body>
	<div align="center">
		<form:form action="accept" method="post" commandName="memberVal">
			<table border="0">
			 <tr>
                    <td colspan="2" align="center"><h2>会員登録</h2></td>
                </tr>
				<tr>
					<td>名前：</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>性別：</td>
					<td><form:select path="sex" items="${sex}"></form:select></td>
				</tr>
				<tr>
					<td>生年月日(yyyy/mm/dd)：</td>
					<td><form:input path="birthday" /></td>
				</tr>
				<tr>
					<td>Eメール：</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>国籍：</td>
					<td><form:input path="country" /></td>
				</tr>
				<tr>
					<td>ユーザID：</td>
					<td><form:input path="username" /></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="登録" /></td>

				</tr>


			</table>
		</form:form>
	</div>

</body>
</html>
