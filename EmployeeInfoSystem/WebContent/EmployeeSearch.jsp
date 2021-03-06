<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/EmployeeSearch.css">
<script type="text/javascript" src="js/EmployeeSearch.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<title>社員マスタ検索画面</title>
</head>
<body onload="employeeSearch_load()">
	<form action="ShainMasterKensaku" method="post" id="EmployeeSearch"
		name="EmployeeSearch">
		<div>
			<input type="button" id="modoru" name="modoru" value="戻る"
				onclick="location.href='Menu.jsp'"><br>
			<h3>
				<b>社員マスタ検索</b>
			</h3>

			<fieldset>
				<legend>検索条件</legend>
				<label id="shain_title"><b>社員ID：</b></label><input type="text"
					id="shain_ID" name="shain_id" maxlength="4"
					style="ime-mode: disabled;"> <label id="namae_title"><b>名前：</b></label><input
					type="text" id="namae" name="namae" maxlength="40"> <label
					id="sebetsu_title"><b>性別：</b></label> <select id="sebetsu"
					name="sebetsu">
					<option></option>
					<option>男</option>
					<option>女</option>
				</select> <input type="checkbox" id="sakujosumi" name="sakujosumi"><label>削除済社員も含める</label>
				<input type="hidden" id="id" name="id"
					value="<%=request.getAttribute("id")%>"> <input
					type="hidden" id="name" name="name"
					value="<%=request.getAttribute("name")%>"> <input
					type="hidden" id="sex" name="sex"
					value="<%=request.getAttribute("sex")%>"> <input
					type="hidden" id="del" name="del"
					value="<%=request.getAttribute("del")%>"> <input
					type="button" id="kuria" name="kuria" value="クリア"
					onclick="kuria_click()">
			</fieldset>
			<input type="button" id="shikitsuika" name="shinkitsuika"
				value="新規追加" onclick="shinkitsuika_click()"> <input
				type="button" id="kensaku" name="kensaku" value="検索"
				onclick="kensaku_click()"> <input type="hidden"
				id="click_action" name="click_action">
			<div id="num">
				<c:if test="${empty count}">
				対象件数：0件<br>
				</c:if>
				<c:if test="${not empty count}">
				対象件数：<%=((Integer) request.getAttribute("count"))%>件<br>
				</c:if>
			</div>
			<input type="hidden" id="kennsu" name="kennsu"
				value="<%=((Integer) request.getAttribute("count"))%>">
			<div id="list">
				<table id="table" border="1">
					<thead>
						<tr>
							<th style="width: 50px" align="center">No</th>
							<th style="width: 60px" align="center">社員ID</th>
							<th style="width: 160px" align="center">名前</th>
							<th style="width: 45px" align="center">性別</th>
							<th style="width: 60px" align="center">年齢</th>
							<th style="width: 76px" align="center">経験年数</th>
							<th style="width: 250px" align="center">最寄駅</th>
							<th style="width: 53px" align="center">削除済</th>
							<th style="width: 176px" align="center">社員マスタ</th>
							<th style="width: 117px" align="center">技術資格マスタ</th>
							<th style="width: 110px" align="center">技術者経歴書</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="row" items="${memberList}">
							<tr>
								<td style="width: 50px" align="center"><c:out
										value="${row.num}" /></td>
								<td style="width: 60px" align="center"><c:out
										value="${row.shainid}"></c:out></td>
								<td style="width: 160px" align="center"><c:out
										value="${row.namae}"></c:out></td>
								<td style="width: 45px" align="center"><c:out
										value="${row.sebetsu}"></c:out></td>
								<td style="width: 60px" align="center"><c:out
										value="${row.nenrei}"></c:out></td>
								<td style="width: 76px" align="center"><c:out
										value="${row.keikennensuu}"></c:out></td>
								<td style="width: 250px" align="center"><c:out
										value="${row.saiyorieki}"></c:out></td>
								<td style="width: 53px" align="center"><c:out
										value="${row.sakujosumi}"></c:out></td>
								<td style="width: 176px" align="center"><input
									type="button" id="ShainMaster${row.num}" name="ShainMaster"
									value="参照／編集" onclick="shainmaster_click(this)"
									style="height: 30px; width: 90px;"> <input
									type="button" id="Sakujo${row.num}" name="Sakujo" value="削除"
									onclick="sakujo_click(this)" style="height: 30px; width: 70px;">
								</td>
								<td style="width: 117px" align="center"><input
									type="button" id="GijutsushikakuMaster${row.num}"
									name="GijutsushikakuMaster" value="参照／編集"
									onclick="GijutsushikakuMaster_click(this)"
									style="height: 31px; width: 109px;"></td>
								<td style="width: 110px" align="center"><input
									type="button" id="GijitsushaKerekisho${row.num}"
									name="GijitsushaKerekisho" value="参照"
									onclick="GijitsushaKerekisho_click(this)"
									style="height: 31px; width: 104px;"></td>

							</tr>
						</c:forEach>

					</tbody>
				</table>
				<input type="hidden" id="serverErrorMs" name="serverErrorMs"
					value="<%=request.getAttribute("serverErrorMs")%>"> <input
					type="hidden" id="shainmasterButton" name="shainmasterButton"
					value="<%=request.getAttribute("shainmasterButton")%>"> <input
					type="hidden" id="sakujoButton" name="sakujoButton"
					value="<%=request.getAttribute("sakujoButton")%>"> <input
					type="hidden" id="sakujoMes" name="sakujoMes"
					value="<%=request.getAttribute("sakujoMes")%>"> <input
					type="hidden" id="GijutsushikakuMasterButton"
					name="GijutsushikakuMasterButton"
					value="<%=request.getAttribute("GijutsushikakuMasterButton")%>">
				<input type="hidden" id="GijitsushaKerekishoButton"
					name="GijitsushaKerekishoButton"
					value="<%=request.getAttribute("GijitsushaKerekishoButton")%>">
			</div>

		</div>
	</form>

</body>
</html>