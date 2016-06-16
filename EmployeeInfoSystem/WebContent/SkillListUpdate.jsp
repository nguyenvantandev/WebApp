<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/SkillListUpdate.css">
<script type="text/javascript" src="js/SkillListUpdate.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<title>技術資格マスタ更新画面</title>
</head>
<body onload="SkillListUpdate_load()">
	<form action="GijutsuShikakuMasterUpdate" method="post"
		id="SkillListUpdate" name="SkillListUpdate">
		<div>
			<input type="button" id="modoru" name="modoru" value="戻る"
				onclick="modoru_click()">
			<h3>
				<b>技術資格マスタ更新</b>
			</h3>
			<label id="label_shikakuID">資格ID</label> <input type="text"
				id="shikakuId" name="shikakuId"
				value="<%=request.getAttribute("shikakuId")%>"
				style="ime-mode: disabled;" maxlength="6"><br> <label
				id="label_shikakumei">資格名</label> <input type="text" id="shikakumei"
				name="shikakumei" value="<%=request.getAttribute("shikakumei")%>"
				maxlength="80"><br> <label id="label_seiseki">成績</label>
			<select id="seiseki" name="seiseki">
				<option></option>
				<option>無し</option>
				<option>あり</option>
			</select><br> <input type="hidden" id="sex" name="sex"
				value="<%=request.getAttribute("sex")%>"> <input
				type="button" id="AddUpdate" name="AddUpdate" value=""
				onclick="AddUpdate_click()"> <input type="hidden"
				id="buttonChange" name="buttonChange"
				value="<%=request.getAttribute("buttonChange")%>">
		</div>
		<input type="hidden" id="skillListFrom_shikakuId"
			name="skillListFrom_shikakuId"
			value="<%=request.getAttribute("skillListFrom_shikakuId")%>">
		<input type="hidden" id="hidden_shikakuId" name="hidden_shikakuId"
			value="<%=request.getAttribute("hidden_shikakuId")%>"> <input
			type="hidden" id="hidden_shikakumei" name="hidden_shikakumei"
			value="<%=request.getAttribute("hidden_shikakumei")%>"> <input
			type="hidden" id="hidden_seisekinashi" name="hidden_seisekinashi"
			value="<%=request.getAttribute("hidden_seisekinashi")%>"> <input
			type="hidden" id="hidden_seisekiari" name="hidden_seisekiari"
			value="<%=request.getAttribute("hidden_seisekiari")%>"> <input
			type="hidden" id="hidden_sakujosumi" name="hidden_sakujosumi"
			value="<%=request.getAttribute("hidden_sakujosumi")%>"> <input
			type="hidden" id="actionName" name="actionName"> <input
			type="hidden" id="errorMessage" name="errorMessage"
			value="<%=request.getAttribute("errorMessage")%>"> <input
			type="hidden" id="completeMessage" name="completeMessage"
			value="<%=request.getAttribute("completeMessage")%>"> <input
			type="hidden" id="serverErrorMessage" name="serverErrorMessage"
			value="<%=request.getAttribute("serverErrorMessage")%>"> <input
			type="hidden" id="actionValue" name="actionValue">
	</form>
</body>
</html>