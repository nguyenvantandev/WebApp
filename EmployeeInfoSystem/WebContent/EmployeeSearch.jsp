<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css"> -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>社員マスタ検索画面</title>
</head>
<body>
<form action="">
<div>
<h3><b>社員マスタ検索</b></h3>
<fieldset>
<legend>検索条件</legend>
<label><b>社員ID：</b></label><input type="text" id="shain_ID" name="shain_id">
<label><b>名前：</b></label><input type="text" id="namae" name="namae">
<label><b>性別：</b></label><select id="sebetsu" name="sebetsu"></select>
<input type="checkbox" id="sakujosumi" name="sakujosumi"><label>削除済社員も含める</label>
<input type="button" id="kuria" name="kuria" value="クリア">
</fieldset>
<input type="button" id="shikitsuika" name="shinkitsuika" value="新規追加">
<input type="button" id="kensaku" name="kensaku" value="検索">
<div id="num">
<c:if test="${empty count}">
対象件数：0件<br>
</c:if>
<c:if test="${not empty count}">
対象件数：<%=((Integer) request.getAttribute("count"))%>件<br>
</c:if>
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
							<th>在庫数</th>
							<th>最寄駅</th>
							<th>削除済</th>
							<th>社員マスタ</th>
							<th>技術資格マスタ</th>
							<th>技術者経歴書</th>
						</tr>
					</thead>
					<tbody>
<%-- 						<c:forEach var="row" items="${memberList}">

							<tr>

								<td><input name="listradio" type="radio" id="listradio"
									value="${row.bookid}"></td>
								<td><c:out value="${row.bookid}" /></td>
								<td><c:out value="${row.booktitle}"></c:out></td>
								<td><c:out value="${row.authorname}"></c:out></td>
								<td><c:out value="${row.publisher}"></c:out></td>
								<td><c:out value="${row.publicationday}"></c:out></td>
								<td><c:out value="${row.stock}"></c:out></td>
								<td><c:out value="${row.deleleflg}"></c:out>
									 <input type="hidden"  name="deleteflg" value="${row.deleleflg}">
								</td>

							</tr>
						</c:forEach> --%>

					</tbody>
				</table>
			</div>

</div>
</form>

</body>
</html>