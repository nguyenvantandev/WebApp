<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Choukai.css">
<script type="text/javascript" src="js/Choukai.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>聴解練習</title>
</head>
<body>
<div id="screen">
<form action="ChoukaiController" method="post" id="Choukai" name="Choukai">
<abbr title="戻る"> <a id="modoru" href="Menu.jsp"><img
					id="modoru" src="css/picture/tan.png"
					onmouseover="src ='css/picture/tan2.png'"
					onmouseout="src ='css/picture/tan.png'"></a>
			</abbr>
			<h3>聴解練習</h3><br>
			
	<div id="levelList">
	<input type="button" id="level1" name="level1" value="聴解検定試験1級" onclick="chooseLv(this)"><br>
	<input type="button" id="level2" name="level2" value="聴解検定試験2級" onclick="chooseLv(this)"><br>
	<input type="button" id="level3" name="level3" value="聴解検定試験3級" onclick="chooseLv(this)"><br>
	<input type="button" id="level4" name="level4" value="聴解検定試験4級" onclick="chooseLv(this)"><br>
	<input type="button" id="level5" name="level5" value="聴解検定試験5級" onclick="chooseLv(this)">
	</div>
	<div id="backdiv" style="display: none;">
	<input type="button" id="backbtn" name="backbtn" value="⇐" onclick="backEvent()"><br>
	</div>
	
	<div id="testYear" style="display: none;">
	<input type="hidden" id="showTest" name="showTest" value="0">
	<input type="button" id="year1" name="year1" value="2016" onclick="chooseYear(this.value)"><br>
	<input type="button" id="year2" name="year2" value="2015" onclick="chooseYear(this.value)"><br>
	<input type="button" id="year3" name="year3" value="2014" onclick="chooseYear(this.value)"><br>
	<input type="button" id="year4" name="year4" value="2013" onclick="chooseYear(this.value)"><br>
	<input type="button" id="year5" name="year5" value="2012" onclick="chooseYear(this.value)"><br>
	<input type="button" id="year6" name="year6" value="2011" onclick="chooseYear(this.value)"><br>
	<input type="button" id="year7" name="year7" value="2010" onclick="chooseYear(this.value)"><br>
	</div>
	<div id="backyeardiv" style="display: none;">
	<input type="button" id="backyearbtn" name="backyearbtn" value="⇐" onclick="backyearEvent()"><br>
	</div>
	<div id="testExam" style="display: none;">
	<%-- <input type="image" id="testimg" name="testimg" src="${testimg}"> --%>
	
	<div id="testInfo">
	<textarea disabled="disabled">質問：男の人と女の人が話しています。どの男の人について話していますか？
	男：その男はどんな感じでした？
	女：背広を着ていました。
	男：めがねは？
	女：めがねはかけていませんでした。
	</textarea>
	</div>
	<div id="questionInfo">
	<p>質問：どの男の人について話していますか？</p>
	<table id="questionTable">
	<tr>
	<td>1．セーターを着てまがねをかけてない。</td>
	<td>3．制服を着てめがねをかけてない。</td>
	</tr>
	<tr>
	<td>2．スーツを着てめがねをかけてない。</td>
	<td>4．裸でめがねをかけていない。</td>
	</tr>
	</table>
	</div>
	
	<div id="btnDiv">
	<a href="#" id="resultlink" name="resultlink">回答</a>
	<a href="#" id="detaillink" name="detaillink">詳細</a>
	</div>
	
	<div id="audioDiv">
	<audio controls>
	<source src="css/picture/audio.mp3" type="audio/mpeg">
	</audio>
	<a href="#" id="backlink" name="backlink">前へ</a>
	<a href="#" id="nextlink" name="nextlink">次へ</a>
	</div>
	
	</div>
</form>
</div>
</body>
</html>