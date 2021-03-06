<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/ResumeUpdate.css">
<script type="text/javascript" src="js/ResumeUpdate.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>経歴書更新画面</title>
</head>
<body onload="ResumeUpdate_load()">

	<form action="KeirekishoUpdate" method="post" id="ResumeUpdate"
		name="ResumeUpdate">
		<input type="button" id="modoru" name="modoru" value="戻る"
			onclick="modoru_click()"><br>
		<h3>
			<b>経歴書更新</b>
		</h3>
		<br> <label id="label_shainId">社員ID</label><input type="text"
			id="shainId" name="shainId"
			value="<%=request.getAttribute("shainId")%>"><br> <label
			id="label_jinengapi">自年月日</label> <select id="year" name="year">
			<option></option>
		</select> <label id="label_year">年</label> <select id="month" name="month">
			<option></option>
		</select> <label id="label_month">月</label> <select id="day" name="day">
			<option></option>
		</select> <label id="label_day">日</label><br>
		<!--自年月日の表示されないデータ  -->
		<input type="hidden" id="start_year" name="start_year"
			value="<%=request.getAttribute("start_year")%>"> <input
			type="hidden" id="start_month" name="start_month"
			value="<%=request.getAttribute("start_month")%>"> <input
			type="hidden" id="start_day" name="start_day"
			value="<%=request.getAttribute("start_day")%>">
		<!--  -->
		<label id="label_itarunengapi">至年月日</label> <select id="itaru_year"
			name="itaru_year">
			<option></option>
		</select> <label id="label_year">年</label> <select id="itaru_month"
			name="itaru_month">
			<option></option>
		</select> <label id="label_month">月</label> <select id="itaru_day"
			name="itaru_day">
			<option></option>
		</select> <label id="label_day">日</label><br>
		<!--至年月日の表示されないデータ  -->
		<input type="hidden" id="end_year" name="end_year"
			value="<%=request.getAttribute("end_year")%>"> <input
			type="hidden" id="end_month" name="end_month"
			value="<%=request.getAttribute("end_month")%>"> <input
			type="hidden" id="end_day" name="end_day"
			value="<%=request.getAttribute("end_day")%>">
		<!--  -->


		<label id="label_gyoushu">業種</label><input type="text" id="gyoushu"
			name="gyoushu" value="<%=request.getAttribute("gyoushu")%>"><br>
		<label id="label_gyumumei">業務名</label>
		<textarea id="gyumumei" name="gyumumei"><%=request.getAttribute("gyumumei")%></textarea>
		<br> <label id="label_shokumunaiyo">職務内容</label>
		<textarea id="shokumunaiyo" name="shokumunaiyo"><%=request.getAttribute("shokumunaiyo")%></textarea>
		<br>
		<br>
		<br> <label id="label_kaihatsukankyou">開発環境</label><br>
		<br> <label id="label_os">OS</label>
		<textarea id="os" name="os"><%=request.getAttribute("os")%></textarea>
		<label id="label_shiyogengo">使用言語</label>
		<textarea id="shiyogengo" name="shiyogengo"><%=request.getAttribute("shiyogengo")%></textarea>
		<br> <label id="label_db">DB</label>
		<textarea id="db" name="db"><%=request.getAttribute("db")%></textarea>
		<label id="label_sonohoka">その他</label>
		<textarea id="sonohoka" name="sonohoka"><%=request.getAttribute("sonohoka")%></textarea>
		<br> <input type="button" id="addUpd" name="addUpd" value="更新"
			onclick="addUpd_click()">
		<!--処理使用データ  -->
		<input type="hidden" id="actionId" name="actionId"
			value="<%=request.getAttribute("actionId")%>"> <input
			type="hidden" id="actionName" name="actionName"
			value="<%=request.getAttribute("actionName")%>"> <input
			type="hidden" id="actionValue" name="actionValue"
			value="<%=request.getAttribute("actionValue")%>"> <input
			type="hidden" id="serverErrorMs" name="serverErrorMs"
			value="<%=request.getAttribute("serverErrorMs")%>"> <input
			type="hidden" id="notFindMes" name="notFindMes"
			value="<%=request.getAttribute("notFindMes")%>"> <input
			type="hidden" id="completeMs" name="completeMs"
			value="<%=request.getAttribute("completeMs")%>"> <input
			type="hidden" id="whatpage" name="whatpage"
			value="<%=request.getAttribute("whatpage")%>">
		<!--社員マスタ検索画面  -->
		<input type="hidden" id="shain_shainId" name="shain_shainId"
			value="<%=request.getAttribute("shain_shainId")%>"> <input
			type="hidden" id="shain_namae" name="shain_namae"
			value="<%=request.getAttribute("shain_namae")%>"> <input
			type="hidden" id="shain_sebetsu" name="shain_sebetsu"
			value="<%=request.getAttribute("shain_sebetsu")%>"> <input
			type="hidden" id="shain_sakujo" name="shain_sakujo"
			value="<%=request.getAttribute("shain_sakujo")%>"><br>

		<!--経歴書検索画面  -->
		<input type="hidden" id="keireki_shainId" name="keireki_shainId"
			value="<%=request.getAttribute("keireki_shainId")%>"> <input
			type="hidden" id="keireki_namae" name="keireki_namae"
			value="<%=request.getAttribute("keireki_namae")%>"> <input
			type="hidden" id="keireki_sakujocheck" name="keireki_sakujocheck"
			value="<%=request.getAttribute("keireki_sakujocheck")%>"> <input
			type="hidden" id="keireki_gyumumei" name="keireki_gyumumei"
			value="<%=request.getAttribute("keireki_gyumumei")%>"> <input
			type="hidden" id="keireki_gyoushu" name="keireki_gyoushu"
			value="<%=request.getAttribute("keireki_gyoushu")%>"> <input
			type="hidden" id="keireki_shokumunaiyou" name="keireki_shokumunaiyou"
			value="<%=request.getAttribute("keireki_shokumunaiyou")%>"> <input
			type="hidden" id="keireki_shiyougengo" name="keireki_shiyougengo"
			value="<%=request.getAttribute("keireki_shiyougengo")%>"> <input
			type="hidden" id="keireki_db" name="keireki_db"
			value="<%=request.getAttribute("keireki_db")%>"> <input
			type="hidden" id="keireki_sonohoka" name="keireki_sonohoka"
			value="<%=request.getAttribute("keireki_sonohoka")%>">

	</form>
</body>
</html>