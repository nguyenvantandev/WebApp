<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Menu.css">
<script type="text/javascript" src="js/Menu.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>メニュー</title>
</head>
<body onload="menuload()">
<form action="MenuController" method="post" id="menu" name="menu">
<div id="screen">
<table>
<tr>
<td id="kotobabtn"><a href="Home.jsp" id="kotoba">言葉</a></td>
<td rowspan="4" id="info">
<p id="title">${title}<p>
<p id="news">${news}</p>
<p id="honyakupan" style="display: none;">${honyakupan}</p>
<a href="#" id="honyaku" onclick="honyaku()">翻訳...</a><br>

<a href="#" id="honnpan" onclick="honpan()" style="display: none;">本版...</a>
</td>
</tr>
<tr>
<td id="kanjibtn"><a href="Kanji.jsp" id="kanji">漢字</a></td>
</tr>
<tr>
<td id="bunpobtn"><a href="Bunpo.jsp" id="bunpo">文法</a></td>
</tr>
<tr>
<td id="choukaibtn"><a href="Choukai.jsp" id="choukai">聴解</a></td>
</tr>
</table>
</div>
<input type="hidden" id="actionVal" name="actionVal" value="${actionVal}">
</form>
</body>
</html>