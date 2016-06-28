<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/koushingamen.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript" language="JavaScript" src="js/bookmaster.js"></script>
<title>Insert title here</title>
</head>
<body onload="addload()">
	<form action="Koushingamen" method="post" id="addupdate" name="addupdate">
		<div>
			<b id="title">本マスタ更新</b><input type="button" value="戻る" id="return" name="return"  onclick="gobackpage()"><br> <br> 
			<b>本ID：</b><br>
			<input type="text" id="text_input_id" disabled="disabled" readonly="readonly" value="<%=(request.getAttribute("bookid"))%>" /><br>
			<input type="hidden" name="id" id="id" value="<%=(request.getAttribute("bookid"))%>" /> 
			<b>本タイトル：</b><br>
			<input type="text" id="text_input_title" name="title" value="<%=(request.getAttribute("booktitle"))%>" maxlength="40" /><br> 
			<b>著者名：</b><br>
			<input type="text" id="text_input_author" name="author" value="<%=(request.getAttribute("authorname"))%>" maxlength="40"/><br> 
			<b>出版社：</b><br>
			<input type="text" id="text_input_publisher" name="publisher" value="<%=(request.getAttribute("publisher"))%>" maxlength="40"/><br> 
			<b>出版年月日:</b><br>
			<select id="year_input" name="year">
				<option></option>
			</select>年 
			<select id="month_input" name="month">
				<option></option>
			</select>月
			 <select id="date_input" name="day">
				<option></option>
			</select>日<br>
			 <input type="hidden" id="day_id" value="<%=request.getAttribute("day")%>"></input> 
			 <input type="hidden" id="year_id" value="<%=request.getAttribute("year")%>"></input>
			<input type="hidden" id="month_id" value="<%=request.getAttribute("month")%>"></input> 
			<b>在庫数:</b><br>
			<input type="text" id="text_input_zaiko" name="zaiko" value="<%=(request.getAttribute("stock"))%>" /><br>


				<input type="button" value="追加"  id="add" onclick="addvalue()"> 
				<input type="button" value="更新"  id="update" onclick="updatevalue()" /> 
				<input type="button" value="削除"  id="delete" onclick="deletevalue()"/>
				<input type="hidden" id="action" name="action" value="<%=request.getAttribute("action")%>">

		</div>
		<input type="hidden" id="searchid" name="searchid" value="<%=(request.getAttribute("searchid"))%>">
		<input type="hidden" id="searchtitle" name="searchtitle" value="<%=(request.getAttribute("searchtitle"))%>">
		<input type="hidden" id="searchauthor" name="searchauthor" value="<%=(request.getAttribute("searchauthor"))%>">
		<input type="hidden" id="searchpulisher" name="searchpulisher" value="<%=(request.getAttribute("searchpulisher"))%>">
		<input type="hidden" id="searchpulication_dayin" name="searchpulication_dayin" value="<%=(request.getAttribute("searchpulication_dayin"))%>">
		<input type="hidden" id="searchpulication_dayout" name="searchpulication_dayout" value="<%=(request.getAttribute("searchpulication_dayout"))%>">
		<input type="hidden" id="searchcheckbox" name="searchcheckbox" value="<%=(request.getAttribute("searchcheckbox"))%>">
		<input type="hidden" id="completemessage" name="completemessage" value="<%=request.getAttribute("completemessage") %>">
		<input type="hidden" id="bookupdatecount" name="bookupdatecount" value="<%=request.getAttribute("bookupdatecount")%>">
		<input type="hidden" id="stockupdatecount" name="stockupdatecount" value="<%=request.getAttribute("stockupdatecount")%>">
		<input type="hidden" id="existvalue" name="existvalue" value="<%=request.getAttribute("existvalue")%>">
		<input type="hidden" id="servererrormessage" name="servererrormessage" value="<%=request.getAttribute("servererrormessage")%>">
		
		
		
	</form>
</body>
</html>