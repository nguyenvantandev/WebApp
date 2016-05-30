<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/EmployeeSearch.css">
<script type="text/javascript" src="js/EmployeeSearch.js"></script>
<!-- <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css"> -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<title>社員マスタ検索画面</title>
</head>
<body>
	<form action="ShainMasterKensaku" method="post" id="EmployeeSearch" name="EmployeeSearch">
		<div>
			<h3>
				<b>社員マスタ検索</b>
			</h3>
			<fieldset>
				<legend>検索条件</legend>
				<label id="shain_title"><b>社員ID：</b></label><input type="text" id="shain_ID" name="shain_id" maxlength="4" style="ime-mode: disabled;"> 
					<label id="namae_title"><b>名前：</b></label><input type="text" id="namae" name="namae" maxlength="40"> 
					<label id="sebetsu_title"><b>性別：</b></label>
					<select id="sebetsu" name="sebetsu">
					<option></option>
					<option>男</option>
					<option>女</option>
					</select> 
					<input type="checkbox" id="sakujosumi" name="sakujosumi"><label>削除済社員も含める</label>
				<input type="button" id="kuria" name="kuria" value="クリア" onclick="kuria_click()">
			</fieldset>
			<input type="button" id="shikitsuika" name="shinkitsuika" value="新規追加" onclick="shinkitsuika_click()"> 
			<input type="button" id="kensaku" name="kensaku" value="検索" onclick="kensaku_click()">
			<input type="hidden" id="click_action" name="click_action">
 			<div id="num">
				<%-- <c:if test="${empty count}">
             		対象件数：0件<br>
				</c:if>
				<c:if test="${not empty count}">
					対象件数：<%=((Integer) request.getAttribute("count"))%>件<br>
				</c:if> --%>
				対象件数：0件<br>
			</div> 
			
			<div id="list">
				<table id="table" border="1">
					<thead>
						<tr>
							<th>No.</th>
							<th>社員ID</th>
							<th>名前</th>
							<th>性別</th>
							<th>年齢</th>
							<th>経験年数</th>
							<th>最寄駅</th>
							<th>削除済</th>
							<th>社員マスタ</th>
							<th>技術資格マスタ</th>
							<th>技術者経歴書</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="row" items="${memberList}">

							<tr>

								<td><c:out value="${row.No}"></c:out></td>
								<td><c:out value="${row.ShainID}"></c:out></td>
								<td><c:out value="${row.Namae}"></c:out></td>
								<td><c:out value="${row.Sebetsu}"></c:out></td>
								<td><c:out value="${row.Nenrei}"></c:out></td>
								<td><c:out value="${row.Keikennensuu}"></c:out></td>
								<td><c:out value="${row.Saiyorieki}"></c:out></td>
								<td><c:out value="${row.Sakujosumi}"></c:out></td>
								<td>
								<input type="button" id="ShainMaster" name="ShainMaster" value="参照／編集">
								<input type="button" id="Sakujo" name="Sakujo" value="削除">
								</td>
								<td>
								<input type="button" id="GijutsushikakuMaster" name="GijutsushikakuMaster" value="参照／編集">
								</td>
								<td>
								<input type="button" id="GijitsushaKerekisho" name="GijitsushaKerekisho" value="参照">
								</td>

							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>

		</div>
	</form>

</body>
</html>