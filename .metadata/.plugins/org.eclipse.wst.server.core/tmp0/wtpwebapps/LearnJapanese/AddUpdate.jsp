<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/AddUpdate.css">
<script type="text/javascript" src="js/AddUpdate.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>言葉追加</title>
</head>
<body onload="addupdateLoad()">
	<div id="screen">
		<form action="AddUpdateController" method="post" id="addupdate"
			name="addupdate">
			<input type="button" id="modoru" name="modoru" value="戻る"
				onclick="returnpage()">
			<h3>言葉画面</h3>
			<label id="lbkotoba">言葉</label><input type="text" id="kotoba"
				name="kotoba" value="${kotoba}"><br> <label
				id="lbhiragana">ひらがな</label><input type="text" id="hiragana"
				name="hiragana" value="${hiragana}"><br> <label
				id="lbimi">意味</label><input type="text" id="imi" name="imi"
				value="${imi}"><br> <label id="lbhinshi">品詞</label><select
				id="hinshi" name="hinshi">
				<option></option>
				<option>名詞</option>
				<option>動詞</option>
				<option>い形</option>
				<option>な形</option>
				<option>副詞</option>
			</select><br> <input type="hidden" id="gethinshi" name="gethinshi"
				value="${hinshi}"> <label id="lblevel">レベル</label><select
				id="level" name="level">
				<option></option>
				<option>N1</option>
				<option>N2</option>
				<option>N3</option>
				<option>N4</option>
				<option>N5</option>
			</select><br> <input type="hidden" id="getlevel" name="getlevel"
				value="${level}"> <label id="lbreibun">例文</label>
			<textarea id="reibun" name="reibun">${reibun}</textarea>
			<br> <input type="button" id="addupdatebtn" name="addupdatebtn"
				value="追加・更新" onclick="btnEvent()"> <input type="hidden"
				id="kotobaid" name="kotobaid" value="${kotobaid}"> <input
				type="hidden" id="actionStatus" name="actionStatus" value="">
		</form>
	</div>


</body>
</html>