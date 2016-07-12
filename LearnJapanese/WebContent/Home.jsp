<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Home.css">
<script type="text/javascript" src="js/Home.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>日本語勉強アプリケーション</title>
</head>
<body onload="homeload()">
<div id="screen">
<form action="HomeController" method="post" id="Home" name="Home">
		<h3>日本語勉強アプリケーション</h3>
		<br>
		<fieldset>
			<legend>検索条件</legend>
			<label id="lbkanji">漢字</label><input type="text" name="kanji" id="kanji" value="${kanji}"> 
			<label id="lbhiragana">ひらがな</label><input type="text" name="hiragana" id="hiragana" value="${hiragana}"><br>  
			<label id="lblevel">レベル</label><input type="text" name="level" id="level" value="${level}" placeholder = "1 から ~ 5 まで"> 
			<label id="lbimi">意味</label><input type="text" name="imi" id="imi" value="${imi}" placeholder = "ベトナム語で">
			<input type="button" id="kuria" name="kuria" value="クリア" onclick="clearclick()">
		</fieldset>
		<input type="button" name="kotobarenshu" id="kotobarenshu" value="言葉練習" onclick="learning()"> 
		<input type="button" name="kadairenshu" id="kadairenshu" value="課題練習" disabled="disabled"> 
		<input type="button" name="tsuika" id="tsuika" value="追加" onclick="insert()"> 
		<input type="button" name="kensaku" id="kensaku" value="検索" onclick="search()"><br> 
		<label id="lbkensu">件数<c:out value="${count}"></c:out>件</label><br>
		<div id="list">
			<table id="table" border="1">
				<thead>
					<tr>
						<th style="width: 45px" align="center">No.</th>
						<th style="width: 160px" align="center">漢字</th>
						<th style="width: 160px" align="center">ひらがな</th>
						<th style="width: 250px" align="center">意味</th>
						<th style="width: 46px" align="center">品詞</th>
						<th style="width: 175px" align="center">編集</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="row" items="${valList}">
						<tr>
							<td style="display:none;"><c:out value="${row.id}"></c:out></td>
							<td style="width: 45px" align="center"><c:out value="${row.count}"></c:out></td>
							<td style="width: 160px" align="center"><c:out value="${row.kanji}"></c:out></td>
							<td style="width: 160px" align="center"><c:out value="${row.hiragana}"></c:out></td>
							<td style="width:250px" align="center"><c:out value="${row.imi}"></c:out></td>
							<td style="width: 46px" align="center"><c:out value="${row.hinshi}"></c:out></td>
							<td style="display:none;"><c:out value="${row.reibun}"></c:out></td>
							<td style="width: 175px" align="center">
							<a href="#"  id="shosai" name="shosai" onclick="detailShow(this)">詳細</a>
							<a href="#"  id="update" name="update" onclick="update(this)">更新</a>
							<a href="#" id="sakujo" name="sakujo" onclick="del(this)">削除</a>
							</td>
						</tr>
					
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!--詳細ポップアップ  -->
		<div id="popdivdetail" class="ontop" style="display: none;">
		<div id="detailform">
		<input type="button" id="tojiru" name="tojiru" value="閉じる" onclick="hide('popdivdetail')"><br>
		<input type="text" id="popkanji" name="popkanji" disabled="disabled"><br>
		<input type="text" id="pophiragana" name="pophiragana" disabled="disabled"><br>
		<input type="text" id="popimi" name="popimi" disabled="disabled"><br>
		<input type="text" id="pophinshi" name="pophinshi" disabled="disabled"><br>
		<label id="poprei">例：</label><br>
		<textarea id="popbun" name="popbun" disabled="disabled"></textarea>

			
		</div>
		</div>
		
		<!-- 言葉練習 -->
				<div id="poplearn" class="ontop" style="display: none;">
				<div id="learnword">
				
				<input type="button" id="tojiru" name="tojiru" value="閉じる" onclick="hide('poplearn')"><br>
				<input type="button" id="back" name="back" value="《" onclick="backclick()">
				<a href="#" id="training" onclick="training()">
					<input type="text" id="context" name="context" value="" disabled="disabled">
				</a>
				<a href="#" id="showdetail" onclick="showdetail()" style="display: none;">
					<input type="text" id="showkanji" name="showkanji" disabled="disabled"><br>
					<input type="text" id="showhiragana" name="showhiragana" disabled="disabled"><br>
					<input type="text" id="showimi" name="showimi" disabled="disabled"><br>
					<input type="text" id="showhinshi" name="showhinshi" disabled="disabled"><br>
					<label id="poprei">例：</label><br>
					<textarea id="showbun" name="showbun" disabled="disabled"></textarea>
				</a>
				<input type="button" id="next" name="next" value="》" onclick="nextclick()">
				<input type="hidden" id="countrows" name="countrows">
			

				
				</div>
		</div>
			<input type="hidden" id="actionStatus" name="actionStatus" value="${actionStatus}">
			<input type="hidden" id="kotobaid" name="kotobaid" value="">
	</form>
</div>

</body>
</html>