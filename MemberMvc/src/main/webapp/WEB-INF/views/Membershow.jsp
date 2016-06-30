<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>会員登録</h2></td>
				</tr>
				<tr>
					<td>ID：</td>
					<td>${memberid}</td>
				</tr>
				<tr>
					<td>名前:</td>
					<td>${membername}</td>
				</tr>
				<tr>
					<td>性別：</td>
					<td>${sex}</td>
				</tr>
				<tr>
					<td>生年月日：</td>
					<td>${birthdate}</td>
				</tr>
				<tr>
					<td>出身地：</td>
					<td>${birthplace}</td>
				</tr>
				<tr>
					<td>結婚状況：</td>
					<td>${marStatus}</td>
				</tr>
				<tr>
					<td>職務：</td>
					<td>${employee}</td>
				</tr>
				<tr>
					<td>現在住所：</td>
					<td>${persentaddress}</td>
				</tr>
			</table>

</div>

</body>
</html>