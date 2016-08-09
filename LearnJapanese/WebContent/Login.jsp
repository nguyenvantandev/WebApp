<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

    <link rel="stylesheet" href="css/Login.css" media="screen" type="text/css" />
    <script type="text/javascript" src="js/Login.js"></script>
<title>ログイン</title>
</head>
<body onload="loadpage()">
  <div class="login-card">
    <h1>ログイン</h1><br>
  <form action="LoginController" method="post" id="login" name="login">
    <input type="text" id="user" name="user" placeholder="ユーザー">
    <input type="password" id="pass" name="pass" placeholder="パスワード">
    <input type="button" name="login" class="login login-submit" value="ログイン" onclick="loginClick()"><br>
    <div class="login-help">
    <a href="#">会員登録</a>
  </div>
  <input type="hidden" name="message" id="message" value="${message}">
  </form>

  
</div>

<!-- <div id="error"><img src="https://dl.dropboxusercontent.com/u/23299152/Delete-icon.png" /> Your caps-lock is on.</div> -->

  <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
</body>
</html>