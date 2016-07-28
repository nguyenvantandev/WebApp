<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Bunpo.css">
<script type="text/javascript" src="js/Bunpo.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>文法練習</title>
</head>
<body onload="BunpoLoad()">
	<div id="screen">
		<form action="BunpoController" method="post" id="Bunpo" name="Bunpo">
			<abbr title="戻る"> <a id="modoru" href="Menu.jsp"><img
					id="modoru" src="css/picture/tan.png"
					onmouseover="src ='css/picture/tan2.png'"
					onmouseout="src ='css/picture/tan.png'"></a>
			</abbr>
			<h3>文法練習</h3>
			<br>
			<div id="searchField">
				<table id="searchTable">
					<tr>
						<th height="25px" style="text-align: left;">■ 文法検索</th>
					</tr>

					<tr>
						<td><input type="text" id="bunposearch" name="bunposearch">
							<input type="button" id="search" name="search" value="検索"
							onclick="searchClick()"></td>
					</tr>

				</table>
				<hr>
				<p>■ 文法試験の級</p>
				<table border="1" id="levelTable">
					<tbody>
						<tr>
							<td><a href="#" onclick="levelSearch(1)">1級</a></td>
							<td><a href="#" onclick="levelSearch(2)">2級</a></td>
							<td><a href="#" onclick="levelSearch(3)">3級</a></td>
						</tr>
						<tr>
							<td><a href="#" onclick="levelSearch(4)">4級</a></td>
							<td><a href="#" onclick="levelSearch(5)">5級</a></td>
							<td style="display: none;"></td>
						</tr>
					</tbody>
				</table>
				<hr>
				<p>■ その他</p>
				<table id="otherTable">
					<tbody>
						<tr>
							<td><a href="#" style="margin-left: 5px;" onclick="otherSearch(1)">◆ 助詞</a></td>
						</tr>
						<tr>
							<td><a href="#" style="margin-left: 5px;" onclick="otherSearch(2)">◆ 接続詞</a></td>
						</tr>
					</tbody>
				</table>

			</div>
			<div id="showField">
				<div id="notvalue" style="display: none;">
					<p>一致文法を見つけませんでした。検索条件を再確認してください。</p>
				</div>
				<table border="1" id="info">
					<tbody>
						<c:forEach var="row" items="${Valshow}">
							<tr>
								<td><a href="#" onclick="bunpoShow(this)"><c:out
											value="${row.grammar}"></c:out></a><br> <label><c:out
											value="${row.meaning}"></c:out></label></td>
								<td style="display: none;"><c:out value="${row.grammar}"></c:out></td>
								<td style="display: none;"><c:out value="${row.syntax}"></c:out></td>
								<td style="display: none;"><c:out value="${row.meaning}"></c:out></td>
								<td style="display: none;"><c:out value="${row.example}"></c:out></td>
								<td style="display: none;"><c:out value="${row.comment}"></c:out></td>
								<td style="display: none;"><c:out value="${row.note}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div id="overwindows" style="display: none;">
				<!--詳細説明  popup ON -->
				<div id="popdivdetail" class="ontop" style="display: none;">
					<div id="detailform">
						<abbr title="閉じる"><a href="#" id="tojiru" name="tojiru"
							onclick="hide('popdivdetail')">X</a></abbr><br>
						<h3 id="grammar"></h3>
						<label>意味：</label><br>
						<p id="meaning"></p>
						<label>例：</label><br>
						<p id="example"></p>
						<br> <label>説明：</label><br>
						<p id="comment"></p>
						<br> <label>注意：</label><br>
						<p id="note"></p>
						<br>
					</div>
				</div>
				<!--詳細説明  popup OFF  -->
				</div>
			</div>
			<input type="hidden" id="loadAction" name="loadAction" value="${loadAction}"> 
			<input type="hidden" id="actionId" name="actionId">
			<input type="hidden" id="level" name="level">
			<input type="hidden" id="other" name="other">
		</form>
	</div>

</body>
</html>