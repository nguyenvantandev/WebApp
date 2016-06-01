<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/EmployeeUpdate.css">
<script type="text/javascript" src="js/EmployeeUpdate.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>社員マスタ更新画面</title>
</head>
<body onload="employeeUpdate_load()">


<form action="ShainMasterUpdate" method="post" id="employeeUpdate" name="employeeUpdate">
<input type="hidden" name="shainNum" id="shaiNum" value="<%=request.getAttribute("shaiNum")%>">
	<input type="button" id="modoru" name="modoru" value="戻る"><br>
	<h2><b>社員マスタ更新</b></h2>
	<span id="id">社員ID</span><input type="text" id="shainId" name="shainId" value="<%=request.getAttribute("shainId")%>"><br>
	<span id="name">名前</span><input type="text" id="namae" name="namae" value="">
	<span id="furiname">フリガナ</span><input type="text" id="furigana" name="furigana" value="">
	<span id="shortname">イニシャル</span><input type="text" id="inisharu" name="inisharu"value=""><br>
	<span id="sex">性別</span>
	<select id="sebetsu" name="sebetsu">
	<option></option>
	<option>男</option>
	<option>女</option>
	</select><br>
	<span id="birthday">生年月日</span>
	<select id="year" name="year">
	<option></option>
	</select>
	<span>年</span>
	<select id="month" name="month">
	<option></option>
	</select>
	<span>月</span>
	<select id="day" name="day">
	<option></option>
	</select>
	<span>日</span><br>
	<span id="station">最寄駅</span><input type="text" id="saiyorieki" name="saiyorieki" value=""><br>
	<span id="address">住所</span><input type="text" id="jusho" name="jusho" value=""><br>
	<span id="pr">自己PR</span><textarea id="jikopr" name="jikopr"></textarea><br>
	<input type="button" id="addUpdate" name="addUpdate" value="登録">
	 
</form>
</body>
</html>