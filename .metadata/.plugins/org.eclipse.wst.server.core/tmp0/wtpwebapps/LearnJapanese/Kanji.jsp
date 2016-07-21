<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/Kanji.css">
<script type="text/javascript" src="js/Kanji.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>漢字辞典</title>
</head>
<body onload="kanjiload()">
	<div id="screen">
		<form action="KanjiController" method="post" id="kanji" name="kanji">
			<abbr title="戻る"> <a id="modoru" href="Menu.jsp"><img
					id="modoru" src="css/picture/tan.png"
					onmouseover="src ='css/picture/tan2.png'"
					onmouseout="src ='css/picture/tan.png'"></a>
			</abbr>
			<h3>漢字辞典</h3>
			<br>
			<div id="searchField">
				<table id="searchTable">
					<tr>
						<th height="25px" style="text-align: left;">■ 漢字検索</th>
					</tr>

					<tr>
						<td><input type="text" id="kanjisearch" name="kanjisearch"><input
							type="button" id="search" name="search" value="検索"></td>
					</tr>

				</table>
				<hr>
				<p>■ 画数検索</p>
				<table border="1" id="gasuiTable">
					<tbody>
						<tr>
							<td><a href="#">1画</a></td>
							<td><a href="#">2画</a></td>
							<td><a href="#">3画</a></td>
						</tr>
						<tr>
							<td><a href="#">4画</a></td>
							<td><a href="#">5画</a></td>
							<td><a href="#">6画</a></td>
						</tr>
						<tr>
							<td><a href="#">7画</a></td>
							<td><a href="#">8画</a></td>
							<td><a href="#">9画</a></td>
						</tr>
						<tr>
							<td><a href="#">10画</a></td>
							<td><a href="#">11画</a></td>
							<td><a href="#">12画</a></td>
						</tr>
						<tr>
							<td><a href="#">13画</a></td>
							<td><a href="#">14画</a></td>
							<td><a href="#">15画</a></td>
						</tr>
						<tr>
							<td><a href="#">16画</a></td>
							<td><a href="#">17画</a></td>
							<td><a href="#">18画</a></td>
						</tr>
						<tr>
							<td><a href="#">19画</a></td>
							<td><a href="#">20画</a></td>
							<td><a href="#">21画</a></td>
						</tr>
						<tr>
							<td><a href="#">22画</a></td>
							<td><a href="#">23画</a></td>
							<td><a href="#">24画</a></td>
						</tr>
						<tr>
							<td><a href="#">25画</a></td>
							<td><a href="#">26画</a></td>
							<td><a href="#">27画</a></td>
						</tr>
						<tr>
							<td><a href="#">28画</a></td>
							<td><a href="#">29画</a></td>
							<td><a href="#">30画</a></td>
						</tr>
					</tbody>
				</table>
				<hr>
				<p>■ 漢検の級（学年）</p>
				<table border="1" id="kankenTable">
					<tbody>
						<tr>
							<td><a href="#">1級</a></td>
							<td><a href="#">準1</a></td>
							<td><a href="#">2級</a></td>
						</tr>
						<tr>
							<td><a href="#">準2</a></td>
							<td><a href="#">3級</a></td>
							<td><a href="#">4級</a></td>
						</tr>
						<tr>
							<td><a href="#">5級</a></td>
							<td><a href="#">6級</a></td>
							<td><a href="#">7級</a></td>
						</tr>
						<tr>
							<td><a href="#">8級</a></td>
							<td><a href="#">9級</a></td>
							<td><a href="#">10級</a></td>
						</tr>
					</tbody>
				</table>

			</div>
			<div id="showField">
				<table border="1" id="info">
					<tbody>
						<c:forEach var="row" items="${Valshow}">
							<tr>
								<td><a href="#"><c:out value="${row.local1}"></c:out></a></td>
								<td><a href="#"><c:out value="${row.local2}"></c:out></a></td>
								<td><a href="#"><c:out value="${row.local3}"></c:out></a></td>
								<td><a href="#"><c:out value="${row.local4}"></c:out></a></td>
								<td><a href="#"><c:out value="${row.local5}"></c:out></a></td>
								<td><a href="#"><c:out value="${row.local6}"></c:out></a></td>
								<td><a href="#"><c:out value="${row.local7}"></c:out></a></td>
								<td><a href="#"><c:out value="${row.local8}"></c:out></a></td>
								<td><a href="#"><c:out value="${row.local9}"></c:out></a></td>
								<td><a href="#"><c:out value="${row.local10}"></c:out></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<input type="hidden" id="actionVal" name="actionVal" value="${actionVal}">
			<input type="hidden" id="actionName" name="actionName">
			<input type="hidden" id="searchVal" name="searchVal">
		</form>
	</div>

</body>
</html>