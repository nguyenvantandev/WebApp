<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/SkillList.css">
<script type="text/javascript" src="js/.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>技術資格マスタ一覧画面</title>
</head>
<body>
<form action="">
<div>
<input type="button" id="modoru" name="modoru" value="戻る" onclick="location.href='Menu.jsp'"><br>
<h3><b>技術資格マスタ</b></h3>
<fieldset>
<legend>検索条件</legend>
<label id="label_shikakuid">資格ID</label><input type="text" id="shikakuId" name="shikakuId">
<label id="label_shikakumei">資格名</label><input type="text" id="shikakumei" name="shikakumei">
<input type="button" id="kuria" name="kuria" value="クリア"><br>
<input type="checkbox" id="seisekinashi" name="seisekinashi"><label id="label_seisekinashi">成績なしのみ</label>
<input type="checkbox" id="seisekiari" name="seisekiari"><label id="label_seisekiari">成績ありのみ</label>
<input type="checkbox" id="sakujosumi" name="sakujosumi"><label id="label_sakujosumi">削除済資格名も含める</label>
</fieldset>
<input type="button" id="shinkitsuika" name="shinkitsuika" value="新規追加">
<input type="button" id="kensaku" name="kensaku" value="検索">
			<div id="list">
				<table id="table" border="1">
					<thead>
						<tr>
							<th style="width: 73px" align="center">No</th>
							<th style="width: 164px" align="center">資格ID</th>
							<th  style="width: 261px" align="center">資格名</th>
							<th style="width: 87px" align="center">成績</th>
							<th style="width: 87px" align="center">削除済</th>
							<th style="width: 263px" align="center">技術資格マスタ編集</th>
							
						</tr>
					</thead>
					<tbody>
					<c:forEach var="row" items="${memberList}">
							<tr>
								<td style="width: 73px" align="center"><c:out value="${row.num}"/></td>
								<td style="width: 164px" align="center"><c:out value="${row.shikakuid}"></c:out></td>
								<td style="width: 261px" align="center"><c:out value="${row.shikakumei}"></c:out></td>
								<td style="width: 87px" align="center"><c:out value="${row.seiseki}"></c:out></td>
								<td style="width: 87px" align="center"><c:out value="${row.sakujosumi}"></c:out></td>
								<td style="width: 263px" align="center">
								<input type="button" id="henshu" name="henshu" value="編集">
								<input type="button" id="sakujo" name="sakujo" value="削除">
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