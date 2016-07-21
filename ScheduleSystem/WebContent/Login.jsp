<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Login.css">
<script type="text/javascript" language="JavaScript" src="js/Login.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<title>ScheduleSystem</title>
</head>
<body onload="loginload()">
<form action="Login" method="post" id="login" name="login">
<div class="logo"></div>
<div class="login-block">
    <h1>スケジュール管理システム</h1>
    <%
    if(session != null){
		  session.removeAttribute("UserInfo");
	}
    %>
    ユーザID：　<input type="text" value="<%= request.getAttribute("userid") %>" id="userid" name="userid" onkeydown="return numberonly()"  style="ime-mode:disabled;"/>
    パスワード：　<input type="password" value="<%= request.getAttribute("password") %>" id="password" name="password" onKeydown="return keychk()"/>
     <p id="error" ><input type="text" name="ErrMsg" id="ErrMsg" value="<%= request.getAttribute("ErrMsg")%>"></p>
    <input type="button" id="login" name="clickbutton" value="ログイン" onclick="logincalendar()"> 
    <input type="button" id="close" name="clickbutton" value="閉じる" onclick="closeWindow()"> 

   
</div>
</form>

</body>
</html>