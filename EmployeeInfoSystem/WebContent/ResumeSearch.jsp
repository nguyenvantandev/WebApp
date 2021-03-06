<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/ResumeSearch.css">
<script type="text/javascript" src="js/ResumeSearch.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>経歴書検索画面</title>
</head>
<body onload="resumeSearch_load()">
	<form action="KeirekishoKensaku" method="post" id="ResumeSearch"
		name="ResumeSearch">
		<input type="button" name="modoru" id="modoru" value="戻る"
			onclick="location.href='Menu.jsp'">
		<h3>
			<b>経歴書検索 </b>
		</h3>
		<fieldset>
			<legend>検索条件</legend>
			<label id="label_shainId">社員ID</label><input type="text" id="shainId"
				name="shainId" value="<%=request.getAttribute("shainId")%>"
				style="ime-mode: disabled;" maxlength="4"> <label
				id="label_namae">名前</label><input type="text" id="namae"
				name="namae" value="<%=request.getAttribute("namae")%>"
				maxlength="40"> <input type="checkbox" id="sakujocheck"
				name="sakujocheck">削除済社員も含める<br> <input type="hidden"
				id="hidden_sakujocheck" name="hidden_sakujocheck"
				value="<%=request.getAttribute("hidden_sakujocheck")%>"> <label
				id="label_gyumumei">業務名</label><input type="text" id="gyumumei"
				name="gyumumei" value="<%=request.getAttribute("gyumumei")%>">
			<label id="label_gyoushu">業種</label><input type="text" id="gyoushu"
				name="gyoushu" value="<%=request.getAttribute("gyoushu")%>"
				maxlength="10"> <label id="label_shokumunaiyou">職務内容</label><input
				type="text" id="shokumunaiyou" name="shokumunaiyou"
				value="<%=request.getAttribute("shokumunaiyou")%>"><br>

			<label id="label_shiyougengo">使用言語</label><input type="text"
				id="shiyougengo" name="shiyougengo"
				value="<%=request.getAttribute("shiyougengo")%>"> <label
				id="label_db">DB</label><input type="text" id="db" name="db"
				value="<%=request.getAttribute("db")%>"> <label
				id="label_sonohoka">その他</label><input type="text" id="sonohoka"
				name="sonohoka" value="<%=request.getAttribute("sonohoka")%>"><br>
			<input type="button" id="kuria" name="kuria" value="クリア"
				onclick="kuria_click()">
		</fieldset>
		<input type="button" id="kensaku" name="kensaku" value="検索"
			onclick="kensaku_click()"><br>
		<div id="kensu">
			<c:if test="${empty count}">
				対象件数：0件<br>
			</c:if>
			<c:if test="${not empty count}">
				対象件数：<%=((Integer) request.getAttribute("count"))%>件<br>
			</c:if>
			<input type="hidden" id="kennsu" name="kennsu"
				value="<%=((Integer) request.getAttribute("count"))%>">
		</div>
		<!--社員一覧  -->
		<div id="list">
			<table id="table" border="1">
				<thead>
					<tr>
						<th style="width: 50px" align="center">No</th>
						<th style="width: 100px;" align="center">社員ID</th>
						<th style="width: 185px;" align="center">名前</th>
						<th style="width: 70px;" align="center">性別</th>
						<th style="width: 70px;" align="center">年齢</th>
						<th style="width: 97px;" align="center">経験年数</th>
						<th style="width: 229px;" align="center">最寄駅</th>
						<th style="width: 83px;" align="center">削除済</th>
						<th style="width: 188px;" align="center">参照</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="row" items="${memberList}">
						<tr>
							<td style="width: 50px" align="center"><c:out
									value="${row.num}" /></td>
							<td style="width: 100px" align="center"><c:out
									value="${row.shainid}"></c:out></td>
							<td style="width: 185px" align="center"><c:out
									value="${row.namae}"></c:out></td>
							<td style="width: 70px" align="center"><c:out
									value="${row.sebetsu}"></c:out></td>
							<td style="width: 70px" align="center"><c:out
									value="${row.nenrei}"></c:out></td>
							<td style="width: 97px" align="center"><c:out
									value="${row.keikennensuu}"></c:out></td>
							<td style="width: 229px" align="center"><c:out
									value="${row.saiyorieki}"></c:out></td>
							<td style="width: 83px" align="center"><c:out
									value="${row.sakujosumi}"></c:out></td>
							<td style="width: 188px" align="center"><input type="button"
								id="shosai${row.num}" class="shosai" name="shosai${row.num}"
								value="詳細" onclick="shosai_click(this)"></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
		<input type="hidden" id="actionName" name="actionName"
			value="<%=request.getAttribute("actionName")%>"> <input
			type="hidden" id="actionValue" name="actionValue">
	</form>

</body>
</html>