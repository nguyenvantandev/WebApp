<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/EmployeeUpdate.css">
<script type="text/javascript" src="js/EmployeeUpdate.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>社員マスタ更新画面</title>
</head>
<body onload="employeeUpdate_load()">


	<form action="ShainMasterUpdate" method="post" id="employeeUpdate"
		name="employeeUpdate">
		<input type="hidden" name="shainNum" id="shainNum"
			value="<%=request.getAttribute("shaiNum")%>"> <input
			type="hidden" id="shainId_search" name="shainId_search"
			value="<%=request.getAttribute("shainId_search")%>"> <input
			type="hidden" id="namae_search" name="namae_search"
			value="<%=request.getAttribute("namae_search")%>"> <input
			type="hidden" id="sebetsu_search" name="sebetsu_search"
			value="<%=request.getAttribute("sebetsu_search")%>"> <input
			type="hidden" id="sakujo_search" name="sakujo_search"
			value="<%=request.getAttribute("sakujo_search")%>"> <input
			type="button" id="modoru" name="modoru" value="戻る"
			onclick="modoru_click()"><br>
		<h2>
			<b>社員マスタ更新</b>
		</h2>
		<span id="id">社員ID</span><input type="text" id="shainId"
			name="shainId" value="<%=request.getAttribute("shainId")%>"
			maxlength="4"><br> <span id="name">名前</span><input
			type="text" id="namae" name="namae"
			value="<%=request.getAttribute("namae")%>" maxlength="40"> <span
			id="furiname">フリガナ</span><input type="text" id="furigana"
			name="furigana" value="<%=request.getAttribute("furigana")%>"
			maxlength="40"> <span id="shortname">イニシャル</span><input
			type="text" id="inisharu" name="inisharu"
			value="<%=request.getAttribute("inisharu")%>" maxlength="10"><br>
		<span id="sex">性別</span> <select id="sebetsu" name="sebetsu">
			<option></option>
			<option>男</option>
			<option>女</option>
		</select><br> <input type="hidden" id="selcect_sex" name="selcect_sex"
			value="<%=request.getAttribute("selcect_sex")%>"> <span
			id="birthday">生年月日</span> <select id="year" name="year">
			<option></option>
		</select> <span>年</span> <select id="month" name="month">
			<option></option>
		</select> <span>月</span> <select id="day" name="day">
			<option></option>
		</select> <span>日</span><br> <input type="hidden" id="birth_year"
			name="birth_year" value="<%=request.getAttribute("birth_year")%>">
		<input type="hidden" id="birth_month" name="birth_month"
			value="<%=request.getAttribute("birth_month")%>"> <input
			type="hidden" id="birth_day" name="birth_day"
			value="<%=request.getAttribute("birth_day")%>"> <span
			id="station">最寄駅</span><input type="text" id="saiyorieki"
			name="saiyorieki" value="<%=request.getAttribute("saiyorieki")%>"
			maxlength="40"><br> <span id="address">住所</span><input
			type="text" id="jusho" name="jusho"
			value="<%=request.getAttribute("jusho")%>" maxlength="100"><br>
		<span id="pr">自己PR</span>
		<textarea id="jikopr" name="jikopr"><%=request.getAttribute("jikopr")%></textarea>
		<br> <input type="button" id="addUpdate" name="addUpdate"
			value="登録/更新" onclick="addUpdate_click()"> <input
			type="hidden" id="serverErrorMs" name="serverErrorMs"
			value="<%=request.getAttribute("serverErrorMs")%>"> <input
			type="hidden" id="notFindMes" name="notFindMes"
			value="<%=request.getAttribute("notFindMes")%>"> <input
			type="hidden" id="conditionVal" name="conditionVal" value="">
		<input type="hidden" id="completeMs" name="completeMs"
			value="<%=request.getAttribute("completeMs")%>">
	</form>
</body>
</html>