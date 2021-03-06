<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Resume.css">
<script type="text/javascript" src="js/Resume.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>技術者経歴書画面</title>
</head>
<body onload="Resume_load()">
	<form action="Keirekisho" method="post" id="Resume" name="Resume">
		<input type="button" id="modoru" name="modoru" value="戻る"
			onclick="modoru_click()">
		<h3>
			<b>経歴書</b>
		</h3>
		<label id="label_shainId">社員ID</label><input type="text" id="shainId"
			name="shainId" value="<%=request.getAttribute("shainId")%>"><br>
		<label id="label_namae">名前</label><input type="text" id="namae"
			name="namae" value="<%=request.getAttribute("namae")%>"><br>
		<input type="button" id="shinkitsuka" name="shinkitsuka" value="新規追加"
			onclick="shinkitsuika_click()"><br>

		<div id="list">
			<table id="table" border="1">
				<thead>
					<tr>
						<th rowspan="2" style="width: 50px" align="center">No.</th>
						<th rowspan="2" style="width: 100px" align="center">自月日</th>
						<th rowspan="2" style="width: 100px" align="center">至月日</th>
						<th rowspan="2" style="width: 250px" align="center">業務名</th>
						<th rowspan="2" style="width: 90px" align="center">業種</th>
						<th rowspan="2" style="width: 137px" align="center">職務内容</th>
						<th colspan="4" align="center">開発環境</th>
						<th rowspan="2" style="width: 100px" align="center">編集</th>
					</tr>
					<tr>
						<th style="width: 90px" align="center">OS</th>
						<th style="width: 90px" align="center">使用言語</th>
						<th style="width: 90px" align="center">DB</th>
						<th style="width: 90px" align="center">その他</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="row" items="${memberList}">
						<tr>
							<td style="width: 50px" align="center"><c:out
									value="${row.num}" /></td>
							<td style="width: 100px" align="center"><c:out
									value="${row.startdate}"></c:out></td>
							<td style="width: 100px" align="center"><c:out
									value="${row.enddate}"></c:out></td>
							<td style="width: 250px" align="center"><c:out
									value="${row.systemname}"></c:out></td>
							<td style="width: 90px" align="center"><c:out
									value="${row.industryname}"></c:out></td>
							<td style="width: 137px" align="center"><c:out
									value="${row.progressname}"></c:out></td>
							<td style="width: 90px" align="center"><c:out
									value="${row.osname}"></c:out></td>
							<td style="width: 90px" align="center"><c:out
									value="${row.language}"></c:out></td>
							<td style="width: 90px" align="center"><c:out
									value="${row.dbname}"></c:out></td>
							<td style="width: 90px" align="center"><c:out
									value="${row.other}"></c:out></td>
							<td style="width: 100px" align="center"><input type="button"
								id="henshu" name="henshu" value="更新"
								onclick="henshu_click(this)"> <input type="button"
								id="sakujo" name="sakujo" value="削除"
								onclick="sakujo_click(this)"></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>




		<!--社員マスタ検索画面と 経歴書検索画面の該当行の社員ID -->
		<input type="hidden" id="actionId" name="actionId"
			value="<%=request.getAttribute("actionId")%>"> <input
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

		<!-- 処理 -->
		<input type="hidden" id="actionName" name="actionName"> <input
			type="hidden" id="actionValue" name="actionValue"> <input
			type="hidden" id="serverErrorMs" name="serverErrorMs"
			value="<%=request.getAttribute("serverErrorMs")%>"> <input
			type="hidden" id="notFindMes" name="notFindMes"
			value="<%=request.getAttribute("notFindMes")%>"> <input
			type="hidden" id="completeMs" name="completeMs"
			value="<%=request.getAttribute("completeMs")%>">
	</form>
</body>
</html>