<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>会員情報</title>
</head>
<body>
<div align="center">
        <table border="0">
            <tr>
                <td colspan="2" align="center"><h2>会員情報</h2></td>
            </tr>
          
            <tr>
                <td>名前：</td>
                <td>${memberVal.name}</td>
            </tr>
            <tr>
                <td>性別:</td>
                <td>${memberVal.sex}</td>
            </tr>
            <tr>
                <td>生年月日:</td>
                <td>${memberVal.birthday}</td>
            </tr>
            <tr>
                <td>Eメール:</td>
                <td>${memberVal.email}</td>
            </tr>
            <tr>
                <td>国籍:</td>
                <td>${memberVal.country}</td>
            </tr>
            <tr>
                <td>ユーザID:</td>
                <td>${memberVal.username}</td>
            </tr>
        </table>
    </div>
</body>
</html>
