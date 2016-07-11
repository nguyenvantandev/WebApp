<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Learning.css">
<script type="text/javascript" src="js/Learning.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>言葉練習</title>
</head>
<body>
	<form action="LearningController" method="post" id="learning" name="learning">
		<div id="learn">
			<table>
				<tr>
					<td><input type="button" id="back" name="back" value="《">
					</td>
					<td><a onclick="detailShow()"><input type="text" id="context" name="context" value="${context}" disabled="disabled"></a>
					</td>
					<td><input type="button" id="next" name="next" value="》">
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>