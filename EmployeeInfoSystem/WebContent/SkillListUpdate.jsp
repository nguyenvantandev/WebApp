<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/SkillListUpdate.css">
<script type="text/javascript" src="js/SkillListUpdate.js"></script>

<title>技術資格マスタ更新画面</title>
</head>
<body onload="SkillListUpdate_load()">
<form action="GijutsuShikakuMasterUpdate" method="post" id="SkillListUpdate" name="SkillListUpdate">
<div>
<input type="button" id="modoru" name="modoru" value="戻る">
<h3><b>技術資格マスタ更新</b></h3>
<label id="label_shikakuID">資格ID</label>
<input type="text" id="shikakuId" name="shikakuId" value="<%=request.getAttribute("shikakuId")%>"><br>
<label id="label_shikakumei">資格名</label>
<input type="text" id="shikakumei" name="shikakumei" value="<%=request.getAttribute("shikakumei")%>"><br>
<label id="label_seiseki">成績</label>
<select id="seiseki" name="seiseki">
<option></option>
<option>無し</option>
<option>あり</option>
</select><br>
<input type="button" id="AddUpdate" name="AddUpdate" value="登録">
</div>
<input type="hidden" id="skillListFrom_shikakuId" name="skillListFrom_shikakuId" value="<%=request.getAttribute("skillListFrom_shikakuId")%>">
</form>
</body>
</html>