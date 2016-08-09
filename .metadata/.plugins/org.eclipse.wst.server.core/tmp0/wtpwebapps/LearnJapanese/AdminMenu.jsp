<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/AdminMenu.css">
<script type="text/javascript" src="js/AdminMenu.js"></script>

<title>データ処理画面</title>
</head>
<body>
	<h3>追加・更新の画面</h3>
	<form action="" method="post">
		<abbr title="ログアウト"> <a id="modoru" href="Login.jsp"><img
				id="modoru" src="css/picture/tan.png"
				onmouseover="src ='css/picture/tan2.png'"
				onmouseout="src ='css/picture/tan.png'"></a>
		</abbr>
		<div id="screen">
			<div id="ContentList">
				<table border="1" id="listTbl">
					<tr>
						<th>項目</th>
						<th colspan="2">処理</th>
					</tr>
					<tr>
						<td>言葉</td>
						<td><a href="#" onclick="VocabularyInsertClick()">追加</a></td>
						<td><a href="#" onclick="VocabularyUpdateClick()">更新</a></td>
					</tr>
					<tr>
						<td>漢字</td>
						<td><a href="#" onclick="KanjiInsertClick()">追加</a></td>
						<td><a href="#" onclick="KanjiUpdateClick()">更新</a></td>
					</tr>
					<tr>
						<td>文法</td>
						<td><a href="#" onclick="GrammarInsertClick()">追加</a></td>
						<td><a href="#" onclick="GrammarUpdateClick()">更新</a></td>
					</tr>
					<tr>
						<td>試験</td>
						<td><a href="#" onclick="TestInsertClick()">追加</a></td>
						<td><a href="#" onclick="TestUpdateClick()">更新</a></td>
					</tr>
				</table>
			</div>

			<!--  言葉追加-->
			<div id="VocabularyInsert" style="display: none;">
			<INPUT type="button" value="列追加" onclick="addRow('0001')" style="margin-bottom: 5px;"/>

			<INPUT type="button" value="削除" onclick="deleteRow('VocabularyInsertTable')" style="margin-bottom: 5px;"/>
			
			<INPUT type="button" value="完了" onclick="" style="margin-bottom: 5px;"/>

			<TABLE id="VocabularyInsertTable" border="1">
				<tr>
					<th>チェック</th>
					<th>ID</th>
					<th>言葉</th>
					<th>ひらがな</th>
					<th>意味</th>
					<th>品詞</th>
					<th>例文</th>
					<th>レベル</th>

				</tr>
				<tbody>
				<tr>
					<td><INPUT type="checkbox" name="chk" /></td>
					<td>1</td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
				</tr>
				</tbody>
			</TABLE>
			</div>
			<!--  言葉追加-->
			<div id="VocabularyUpdate" style="display: none;">
			<INPUT type="button" value="削除" onclick="deleteRow('VocabularyUpdateTable')" style="margin-bottom: 5px;"/>
			
			<INPUT type="button" value="完了" onclick="" style="margin-bottom: 5px;"/>

			<TABLE id="VocabularyUpdateTable" border="1">
				<tr>
					<th>チェック</th>
					<th>ID</th>
					<th>言葉</th>
					<th>ひらがな</th>
					<th>意味</th>
					<th>品詞</th>
					<th>例文</th>
					<th>レベル</th>
					<th>編集</th>

				</tr>
				<tbody>
				<c:forEach var="row" items="${VocabularyList}">
				<tr>
					<td><INPUT type="checkbox" name="chk" /></td>
					<td><c:out value="${row.id}"></c:out></td>
					<td><INPUT type="text" value='<c:out value="${row.vocabulary}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.hiragana}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.meaning}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.sort}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.example}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.level}"></c:out>'/></td>
					<td><input type="button" id="updatebtn" name="updatebtn" value="編集" onclick="UpdateClick(this.value)"></td>
				</tr>
				</c:forEach>
				
				</tbody>
			</TABLE>
			</div>
			<!--言葉更新  -->
			<div id="KanjiInsert"  style="display: none;">
			<INPUT type="button" value="列追加" onclick="addRow('0002')" style="margin-bottom: 5px;"/>

			<INPUT type="button" value="削除" onclick="deleteRow('KanjiInsertTable')" style="margin-bottom: 5px;"/>
			
			<INPUT type="button" value="完了" onclick="" style="margin-bottom: 5px;"/>

			<TABLE id="KanjiInsertTable" border="1">
				<tr>
					<th>チェック</th>
					<th>ID</th>
					<th>漢字</th>
					<th>訓読み</th>
					<th>音読み</th>
					<th>意味</th>
					<th>画数</th>
					<th>レベル</th>

				</tr>
				<tbody>
				<tr>
					<td><INPUT type="checkbox" name="chk" /></td>
					<td>1</td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
				</tr>
				</tbody>
			</TABLE>
			</div>
			<div id="KanjiUpdate" style="display: none;">
			<INPUT type="button" value="削除" onclick="deleteRow('KanjiUpdateTable')" style="margin-bottom: 5px;"/>
			<INPUT type="button" value="完了" onclick="" style="margin-bottom: 5px;"/>

			<TABLE id="KanjiUpdateTable" border="1">
				<tr>
					<th>チェック</th>
					<th>ID</th>
					<th>漢字</th>
					<th>訓読み</th>
					<th>音読み</th>
					<th>意味</th>
					<th>画数</th>
					<th>レベル</th>
					<th>編集</th>

				</tr>
				<tbody>
				<c:forEach var="row" items="${KanjiList}">
				<tr>
					<td><INPUT type="checkbox" name="chk" /></td>
					<td><c:out value="${row.id}"></c:out></td>
					<td><INPUT type="text" value='<c:out value="${row.kanji}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.kuyomi}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.onyomi}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.meaning}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.gasui}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.level}"></c:out>'/></td>
					<td><input type="button" id="updatebtn" name="updatebtn" value="編集"></td>
				</tr>
				</c:forEach>
				</tbody>
			</TABLE>
			</div>

			<div id="GrammarInsert" style="display: none;">
			<INPUT type="button" value="列追加" onclick="addRow('0003')" style="margin-bottom: 5px;"/>

			<INPUT type="button" value="削除" onclick="deleteRow('GrammarInsertTable')" style="margin-bottom: 5px;"/>
			
			<INPUT type="button" value="完了" onclick="" style="margin-bottom: 5px;"/>

			<TABLE id="GrammarInsertTable" border="1">
				<tr>
					<th>チェック</th>
					<th>ID</th>
					<th>文法</th>
					<th>構築</th>
					<th>意味</th>
					<th>例文</th>
					<th>注意</th>
					<th>メモ</th>
					<th>レベル</th>
					<th>グルーブ</th>
					

				</tr>
				<tbody>
				<tr>
					<td><INPUT type="checkbox" name="chk" /></td>
					<td>1</td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
				</tr>
				</tbody>
			</TABLE>
			</div>
			<div id="GrammarUpdate" style="display: none;">
			<INPUT type="button" value="削除" onclick="deleteRow('GrammarUpdateTable')" style="margin-bottom: 5px;"/>
			<INPUT type="button" value="完了" onclick="" style="margin-bottom: 5px;"/>

			<TABLE id="GrammarUpdateTable" border="1">
				<tr>
					<th>チェック</th>
					<th>ID</th>
					<th>文法</th>
					<th>構築</th>
					<th>意味</th>
					<th>例文</th>
					<th>注意</th>
					<th>メモ</th>
					<th>レベル</th>
					<th>グルーブ</th>
					<th>編集</th>

				</tr>
				<tbody>
				<c:forEach var="row" items="${GrammarList}">
				<tr>
					<td><INPUT type="checkbox" name="chk" /></td>
					<td><c:out value="${row.id}"></c:out></td>
					<td><INPUT type="text" value='<c:out value="${row.grammar}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.syntax}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.meaning}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.example}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.comment}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.note}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.level}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.group}"></c:out>'/></td>
					<td><input type="button" id="updatebtn" name="updatebtn" value="編集"></td>
				</tr>
				</c:forEach>
				</tbody>
			</TABLE>
			</div>


			<div id="TestInsert" style="display: none;">
			<INPUT type="button" value="列追加" onclick="addRow('0004')" style="margin-bottom: 5px;"/>

			<INPUT type="button" value="削除" onclick="deleteRow('TestInsertTable')" style="margin-bottom: 5px;"/>
			
			<INPUT type="button" value="完了" onclick="" style="margin-bottom: 5px;"/>

			<TABLE id="TestInsertTable" border="1">
				<tr>
					<th>チェック</th>
					<th>ID</th>
					<th>質問内容</th>
					<th>質問</th>
					<th>回答1</th>
					<th>回答2</th>
					<th>回答3</th>
					<th>回答4</th>
					<th>回答結果</th>
					<th>質問回答</th>
					<th>レベル</th>
					<th>分類</th>
					

				</tr>
				<tbody>
				<tr>
					<td><INPUT type="checkbox" name="chk" /></td>
					<td>1</td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
					<td><INPUT type="text" /></td>
				</tr>
				</tbody>
			</TABLE>
			</div>
			<div id="TestUpdate" style="display: none;">
			<INPUT type="button" value="削除" onclick="deleteRow('TestUpdateTable')" style="margin-bottom: 5px;"/>
			<INPUT type="button" value="完了" onclick="" style="margin-bottom: 5px;"/>

			<TABLE id="TestUpdateTable" border="1">
				<tr>
					<th>チェック</th>
					<th>ID</th>
					<th>質問内容</th>
					<th>質問</th>
					<th>回答1</th>
					<th>回答2</th>
					<th>回答3</th>
					<th>回答4</th>
					<th>回答結果</th>
					<th>質問回答</th>
					<th>レベル</th>
					<th>分類</th>
					<th>編集</th>

				</tr>
				<tbody>
				<c:forEach var="row" items="${GrammarList}">
				<tr>
					<td><INPUT type="checkbox" name="chk" /></td>
					<td><c:out value="${row.id}"></c:out></td>
					<td><INPUT type="text" value='<c:out value="${row.content}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.question}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.anwser1}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.anwser2}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.anwser3}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.anwser4}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.resultanwser}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.resultquestion}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.level}"></c:out>'/></td>
					<td><INPUT type="text" value='<c:out value="${row.item}"></c:out>'/></td>
					<td><input type="button" id="updatebtn" name="updatebtn" value="編集"></td>
				</tr>
				</c:forEach>
				</tbody>
			</TABLE>
			
			</div>


		</div>
	</form>
</body>
</html>