<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Vocabulary.css">
<script type="text/javascript" src="js/Vocabulary.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>語彙</title>
</head>
<body onload="homeload()">
<div id="screen">
<form action="VocabularyController" method="post" id="vocabulary" name="vocabulary">
<abbr title="戻る">
<a id="modoru" href="Menu.jsp"><img id="modoru" src="css/picture/tan.png" onmouseover="src ='css/picture/tan2.png'" onmouseout="src ='css/picture/tan.png'"></a>
</abbr> 
<h3>語彙練習</h3>

		
		<br>
		<fieldset>
			<legend>検索条件</legend>
			<label id="lbkanji">漢字</label><abbr title="検索したい漢字を入力してください。"><input type="text" name="kanji" id="kanji" value="${kanji}"></abbr> 
			<label id="lbhiragana">ひらがな</label><abbr title="検索したい言葉をひらがなで入力してください。"><input type="text" name="hiragana" id="hiragana" value="${hiragana}"></abbr><br>  
			<label id="lblevel">レベル</label><abbr title="適当な日本語能力を入力してください。（１～５）"><input type="text" name="level" id="level" value="${level}"></abbr> 
			<label id="lbimi">意味</label><abbr title="検索したい言葉をベトナム語で入力してください。（全小文字）"><input type="text" name="imi" id="imi" value="${imi}"></abbr>
			<a href="#" id="kuria" name="kuria" onclick="clearclick()">
			<abbr title="クリア"><img src="css/picture/clear.png" style="width: 40px; height: 40px;"></abbr>
			</a>
		</fieldset>
		<a href="#" id="kotobarenshu" name="kotobarenshu" onclick="learning()">
		<abbr title="言葉練習"><img src="css/picture/learning1.png" style="width: 40px; height: 40px;"></abbr>
		</a>
		<a href="#" id="kadairenshu" name="kadairenshu">
		<abbr title="課題練習"><img src="css/picture/training.png" style="width: 40px; height: 40px;"></abbr>
		</a>
		
		<a href="#" id="tsuika" name="tsuika" onclick="insert()">
		<abbr title="追加"><img src="css/picture/create.png" style="width: 40px; height: 40px;"></abbr>
		</a>
		
		<a href="#" id="kensaku" name="kensaku" onclick="searchVal()">
		<abbr title="検索"><img src="css/picture/search1.png" style="width: 40px; height: 40px;"></abbr>
		</a>
		<br> 
		<div style="margin-top: 1%">
		<label id="lbkensu">件数<c:out value="${count}"></c:out>件</label><br>
		</div>
		
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
							<a href="#"  id="shosai" name="shosai" onclick="detailShow(this)">
							<abbr title="詳細"><img src="css/picture/details.png" style="width: 30px; height: 30px;"></abbr>
							</a>
							<a href="#"  id="update" name="update" onclick="update(this)">
							<abbr title="更新"><img src="css/picture/update.png" style="width: 30px; height: 30px;"></abbr>
							</a>
							<a href="#" id="sakujo" name="sakujo" onclick="del(this)">
							<abbr title="削除"><img src="css/picture/delete.png" style="width: 30px; height: 30px;"></abbr>
							</a>
							</td>
						</tr>
					
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		
		<!--詳細ポップアップ  -->
		<div id="popdivdetail" class="ontop" style="display: none;">
		<div id="detailform">
		<abbr title="閉じる"><a href="#" id="tojiru" name="tojiru" onclick="hide('popdivdetail')">X</a></abbr><br>
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
				<abbr title="閉じる"><a href="#" id="tojiru" name="tojiru" onclick="hide('poplearn')">X</a></abbr><br>
				
				<abbr title="前へ"><input type="button" id="back" name="back" value="《" onclick="backclick()"></abbr>
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
				<abbr title="次へ"><input type="button" id="next" name="next" value="》" onclick="nextclick()"></abbr>
				<input type="hidden" id="countrows" name="countrows">
			

				
				</div>
		</div>
		
			<input type="hidden" id="actionStatus" name="actionStatus" value="${actionStatus}">
			<input type="hidden" id="kotobaid" name="kotobaid" value="">
	</form>
</div>

</body>
</html>