<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/ichirangamen.css">
<script type="text/javascript" language="JavaScript" src="resources/js/bookmaster.js"></script>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<form:form action="list" method="post" commandName="searchInfo" id="ichirangamen" name="ichirangamen">
		<div>
			<h2>本マスタ一覧</h2>

			<fieldset>
				<legend>
					<b>検索条件</b>
				</legend>
				
				本ID:<form:input path="bookid" id="book_id"/>
				<!-- <input type="hidden" id="updateid" name="updateid" value=""> -->
				
				本タイトル：<form:input path="title" id="title"/> 
				著者名：<form:input path="author" id="author"/> 
				出版社：<form:input path="pulisher" id="pulisher"/> <br>
				出版年月日：<form:input path="inday" id="pulication_dayin"/> ～ <form:input path="outday" id="pulication_dayout"/>
				<form:checkbox path="del" id="checkbox" label="label"/> 削除済本も含める <br> 
				<!-- <input type="hidden" id="check" name="check" value=""> -->
				
			<input type="button" value="クリア" id="clear" onclick="clearsearch()"/>
			</fieldset>
			<a><input type="button" value="新規追加" id="insert" onclick="addpage()" />
			</a> 
			<a><input type="button" value="更新" id="update" onclick="updatepage()" /> 
			
			</a><input type="button" value="検索" id="search" onclick="searchpage()"/>
			
	
	<!-- 		<input type="hidden" name="action" id="action" value=""> -->
			<div id="num">

				<c:if test="${empty count}">
				対象件数：0件<br>
				</c:if>
				<c:if test="${not empty count}">
				対象件数：<%=((Integer) request.getAttribute("count"))%>件<br>
				</c:if>
				<input type="hidden" id="servererrormessage" name="servererrormessage" value="">
				
			</div>
			<div id="list">
				<table id="table" border="1">
					<thead>
						<tr>
							<th>選択</th>
							<th>本ID</th>
							<th>本タイトル</th>
							<th>著者名</th>
							<th>出版社</th>
							<th>出版年月日</th>
							<th>在庫数</th>
							<th>削除済</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="row" items="${memberList}">

							<tr>

								<td><input name="listradio" type="radio" id="listradio"
									value="${row.bookid}"></td>
								<td><c:out value="${row.bookid}" /></td>
								<td><c:out value="${row.booktitle}"></c:out></td>
								<td><c:out value="${row.authorname}"></c:out></td>
								<td><c:out value="${row.publisher}"></c:out></td>
								<td><c:out value="${row.publicationday}"></c:out></td>
								<td><c:out value="${row.stock}"></c:out></td>
								<td><c:out value="${row.deleleflg}"></c:out>
									 <input type="hidden"  name="deleteflg" value="${row.deleleflg}">
								</td>

							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
			<c:if test="${count == 0}">
				<script>alert("検索条件に一致する本が見つかりません。");</script>
			</c:if>
		</div>
</form:form>


</body>
</html>