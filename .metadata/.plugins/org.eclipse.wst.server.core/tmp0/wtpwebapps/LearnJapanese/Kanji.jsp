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
						<td><input type="text" id="kanjisearch" name="kanjisearch" placeholder="漢字、読み">
						<input type="button" id="search" name="search" value="検索" onclick="searchClick()"></td>
					</tr>

				</table>
				<hr>
				<p>■ 画数検索</p>
				<table border="1" id="gasuiTable">
					<tbody>
						<tr>
							<td><a href="#" onclick="gasuiClick(1)">1画</a></td>
							<td><a href="#" onclick="gasuiClick(2)">2画</a></td>
							<td><a href="#" onclick="gasuiClick(3)">3画</a></td>
						</tr>
						<tr>
							<td><a href="#" onclick="gasuiClick(4)">4画</a></td>
							<td><a href="#" onclick="gasuiClick(5)">5画</a></td>
							<td><a href="#" onclick="gasuiClick(6)">6画</a></td>
						</tr>
						<tr>
							<td><a href="#" onclick="gasuiClick(7)">7画</a></td>
							<td><a href="#" onclick="gasuiClick(8)">8画</a></td>
							<td><a href="#" onclick="gasuiClick(9)">9画</a></td>
						</tr>
						<tr>
							<td><a href="#" onclick="gasuiClick(10)">10画</a></td>
							<td><a href="#" onclick="gasuiClick(11)">11画</a></td>
							<td><a href="#" onclick="gasuiClick(12)">12画</a></td>
						</tr>
						<tr>
							<td><a href="#" onclick="gasuiClick(13)">13画</a></td>
							<td><a href="#" onclick="gasuiClick(14)">14画</a></td>
							<td><a href="#" onclick="gasuiClick(15)">15画</a></td>
						</tr>
						<tr>
							<td><a href="#" onclick="gasuiClick(16)">16画</a></td>
							<td><a href="#" onclick="gasuiClick(17)">17画</a></td>
							<td><a href="#" onclick="gasuiClick(18)">18画</a></td>
						</tr>
						<tr>
							<td><a href="#" onclick="gasuiClick(19)">19画</a></td>
							<td><a href="#" onclick="gasuiClick(20)">20画</a></td>
							<td><a href="#" onclick="gasuiClick(21)">21画</a></td>
						</tr>
						<tr>
							<td><a href="#" onclick="gasuiClick(22)">22画</a></td>
							<td><a href="#" onclick="gasuiClick(23)">23画</a></td>
							<td><a href="#" onclick="gasuiClick(24)">24画</a></td>
						</tr>
						<tr>
							<td><a href="#" onclick="gasuiClick(25)">25画</a></td>
							<td><a href="#" onclick="gasuiClick(26)">26画</a></td>
							<td><a href="#" onclick="gasuiClick(27)">27画</a></td>
						</tr>
						<tr>
							<td><a href="#" onclick="gasuiClick(28)">28画</a></td>
							<td><a href="#" onclick="gasuiClick(29)">29画</a></td>
							<td><a href="#" onclick="gasuiClick(30)">30画</a></td>
						</tr>
					</tbody>
				</table>
				<hr>
				<p>■ 漢検の級（学年）</p>
				<table border="1" id="kankenTable">
					<tbody>
						<tr>
							<td><a href="#" onclick="levelClick('1級')">1級</a></td>
							<td><a href="#" onclick="levelClick('準1')">準1</a></td>
							<td><a href="#" onclick="levelClick('2級')">2級</a></td>
						</tr>
						<tr>
							<td><a href="#" onclick="levelClick('準2')">準2</a></td>
							<td><a href="#" onclick="levelClick('3級')">3級</a></td>
							<td><a href="#" onclick="levelClick('4級')">4級</a></td>
						</tr>
						<tr>
							<td><a href="#" onclick="levelClick('5級')">5級</a></td>
							<td><a href="#" onclick="levelClick('6級')">6級</a></td>
							<td><a href="#" onclick="levelClick('7級')">7級</a></td>
						</tr>
						<tr>
							<td><a href="#" onclick="levelClick('8級')">8級</a></td>
							<td><a href="#" onclick="levelClick('9級')">9級</a></td>
							<td><a href="#" onclick="levelClick('10級')">10級</a></td>
						</tr>
					</tbody>
				</table>

			</div>
			<div id="showField">
			<div id="notvalue" style="display: none"><p>一致漢字を見つけませんでした。検索条件を再確認してください。</p></div>
				<table border="1" id="info">
					<tbody>
						<c:forEach var="row" items="${Valshow}">
							<tr>
								<td><a href="#" onmouseover="overEvent('${row.local1}')" onmouseout="outEvent()"><c:out value="${row.local1}"></c:out></a>
								</td>
								<td><a href="#" onmouseover="overEvent('${row.local2}')" onmouseout="outEvent()"><c:out value="${row.local2}"></c:out></a>
								</td>
								<td><a href="#" onmouseover="overEvent('${row.local3}')" onmouseout="outEvent()"><c:out value="${row.local3}"></c:out></a>
								</td>
								<td><a href="#" onmouseover="overEvent('${row.local4}')" onmouseout="outEvent()"><c:out value="${row.local4}"></c:out></a>
								</td>
								<td><a href="#" onmouseover="overEvent('${row.local5}')" onmouseout="outEvent()"><c:out value="${row.local5}"></c:out></a>
								</td>
								<td><a href="#" onmouseover="overEvent('${row.local6}')" onmouseout="outEvent()"><c:out value="${row.local6}"></c:out></a>
								</td>
								<td><a href="#" onmouseover="overEvent('${row.local7}')" onmouseout="outEvent()"><c:out value="${row.local7}"></c:out></a>
								</td>
								<td><a href="#" onmouseover="overEvent('${row.local8}')" onmouseout="outEvent()"><c:out value="${row.local8}"></c:out></a>
								</td>
								<td><a href="#" onmouseover="overEvent('${row.local9}')" onmouseout="outEvent()"><c:out value="${row.local9}"></c:out></a>
								</td>
								<td><a href="#" onmouseover="overEvent('${row.local10}')" onmouseout="outEvent()"><c:out value="${row.local10}"></c:out></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!--popup  -->
				<div id="popdivdetail" class="ontop" style="display: none;">
					<div id="detailform">
						<!-- <abbr title="閉じる"><a href="#" id="tojiru" name="tojiru" onclick="hide('popdivdetail')">X</a></abbr><br>  -->
						<div id="popupkanji"><p id="kanjishow"></p></div>
						<div>
						<p id="popuphanviet"></p>
						<table id="poptable">
						<tr>
						<th>訓読み：</th>
						</tr>
						<tr>
						<td><p id="popupkunyomi"></p></td>
						</tr>
						
						<tr>
						<th>音読み：</th>
						</tr>
						<tr>
						<td><p id="popuponyomi"></p></td>
						</tr>
						
						<tr>
						<th>画数：</th>
						</tr>
						<tr>
						<td><p id="popupgasui"></p></td>
						</tr>
						
						<tr>
						<th>レベル：</th>
						</tr>
						<tr>
						<td><p id="popuplevel"></p></td>
						</tr>
						</table>
						</div>
						
					</div>
				</div>
				<!-- popup -->
			</div>
			<table id="hiddenTable" style="display: none;">
			<tbody>
			<c:forEach var="hiddenrows" items="${kanjidetail}">
			<tr>
				<td><c:out value="${hiddenrows.kanji}"></c:out></td>
				<td><c:out value="${hiddenrows.kunyomi}"></c:out></td>
				<td><c:out value="${hiddenrows.onyomi}"></c:out></td>
				<td><c:out value="${hiddenrows.gasui}"></c:out></td>
				<td><c:out value="${hiddenrows.level}"></c:out></td>
				<td><c:out value="${hiddenrows.imi}"></c:out></td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
			<input type="hidden" id="actionVal" name="actionVal" value="${actionVal}">
			<input type="hidden" id="actionName" name="actionName">
			<input type="hidden" id="searchVal" name="searchVal">
			<input type="hidden" id="searchOther" name="searchOther">
		</form>
	</div>

</body>
</html>