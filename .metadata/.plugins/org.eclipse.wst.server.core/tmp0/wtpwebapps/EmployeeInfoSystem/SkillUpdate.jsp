<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/SkillUpdate.css">
<script type="text/javascript" src="js/SkillUpdate.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>技術資格マスタ更新画面</title>
</head>
<body onload="SkillUpdate_load()">
	<form action="GijutsuShikakuUpdate" method="post" id="SkillUpdate" name="SkillUpdate">
	
		<div id="Interface">

			<input type="button" id="modoru" name="modoru" value="戻る">
			<h3>
				<b>技術資格マスタ更新画面</b>
			</h3>

			<label id="label_id">社員ID</label><input type="text" id="shainId" name="shainId" value="<%=request.getAttribute("shainId")%>"><br>
			<label id="label_name">名前</label><input type="text" id="namae" name="namae" value="<%=request.getAttribute("namae")%>"><br>
			<div id="list">
				<table id="table" border="1">
					<thead>
						<tr>
							<th style="width: 50px" align="center">No</th>
							<th style="width: 120px" align="center">社員ID</th>
							<th style="width: 200px" align="center">名前</th>
							<th style="width: 113px" align="center">取得年月日</th>
							<th style="width: 141px" align="center">成績</th>
							<th style="width: 204px" align="center">更新/削除</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="row" items="${memberList}">
							<tr>
								<td style="width: 50px" align="center"><c:out value="${row.num}" /></td>
								<td style="width: 120px" align="center"><c:out value="${row.shikakuid}"></c:out></td>
								<td style="width: 200px" align="center"><c:out value="${row.namae}"></c:out></td>
								<td style="width: 113px" align="center"><c:out value="${row.shutokuday}"></c:out></td>
								<td style="width: 141px" align="center"><c:out value="${row.seiseki}"></c:out></td>
								<td style="width: 204px" align="center">
								<input type="button" id="koushin" name="koushin" value="更新" onclick="popupKoshin_click(this)"> 
									<input  type="button" id="sakujo" name="sakujo" value="削除">
								</td>

							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>

			 
			<input type="button" id="tsuika" name="tsuika" value="追加" onclick="popupTsuika_click()">
			<!--追加  -->
			<div id="popDivAdd" class="ontop">
				<div id="addform">
					<input type="button" id="tojiru" name="tojiru" value="閉じる" onclick="hide('popDivAdd')">
					<h3><b>資格追加</b></h3>
					<label id="label_shiakumei">資格名</label>
					<select id="shikakuMei" name="shikakuMei">
					<c:forEach var="item" items="${ColectionList }">
					<option><c:out value="${item.Info }"></c:out></option>
					</c:forEach>
					<option></option>
					</select><br>
					
					<label id="label_shutokuDate" >取得年月日</label>
					<select id="year" name="year">
					<option></option>
					</select>
					<label id="label_year">年</label>
					<select id="month" name="month">
					<option></option>
					</select>
					<label id="label_month">月</label>
					<select id="day" name="day">
					<option></option>
					</select>
					<label id="label_day">日</label><br>
					<label id="label_seiseki">成績</label><input type="text" id="seiseki" name="seiseki"><br>
					<label id="label_houjijun">表示順</label>
					<select id="houjijun" name="houjijun">
					<option></option>
					</select><br>
					<input type="button" id="popup_tsuika" name="popup_tsuika" value="追加">
				</div>
			</div>

			<!--更新  -->			
			<div id="popDivUpdate" class="ontop">
				<div id="addform">
					<input type="button" id="tojiru" name="tojiru" value="閉じる" onclick="hide('popDivUpdate')">
					<h3><b>資格追加</b></h3>
					<label id="label_shiakumei">資格名</label><input type="text" id="upd_shikakumei" name="upd_shikakumei"><br>
					<label id="label_shutokuDate" >取得年月日</label>
					<select id="upd_year" name="upd_year">
					<option></option>
					</select>
					<label id="label_year">年</label>
					<select id="upd_month" name="upd_month">
					<option></option>
					</select>
					<label id="label_month">月</label>
					<select id="upd_day" name="upd_day">
					<option></option>
					</select>
					<label id="label_day">日</label><br>
					<label id="label_seiseki">成績</label><input type="text" id="upd_seiseki" name="upd_seiseki"><br>
					<label id="label_houjijun">表示順</label>
					<select id="upd_houjijun" name="upd_houjijun">
					<option></option>
					</select><br>
					<input type="button" id="popup_koushin" name="popup_koushin" value="更新">
				</div>
			</div>
		</div>
		<input type="hidden" id="zengamen_shainId" name="zengamen_shainId" value="<%=request.getAttribute("zengamen_shainId")%>">
		<input type="hidden" id="actionName" name="actionName">
		<input type="hidden" id="actionValue" name="actionValue">

	</form>

</body>
</html>