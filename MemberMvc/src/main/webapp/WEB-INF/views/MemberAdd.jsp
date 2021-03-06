<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メンバー画面</title>
</head>
<body>
	<form action="member" method="post">
		<div align="center">
			<table border="0">
				<tr>
					<td colspan="2" align="center"><h2>会員登録</h2></td>
				</tr>
				<tr>
					<td>ID：</td>
					<td><input type="text" id="memberId" name="memberId"
						value="${memberId}"></td>
				</tr>
				<tr>
					<td>名前:</td>
					<td><input type="text" name="memberName" id="memberName"
						value="${memberName}"></td>
				</tr>
				<tr>
					<td>性別：</td>
					<td><select id="sex" name="sex">
							<option></option>
							<c:forEach var="sexlit" items="${sexlist}">
								<option><c:out value="${sexlit}"></c:out></option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>生年月日：</td>
					<td><select id="year" name="year">
							<option></option>
							<c:forEach var="yearlit" items="${yearlist}">
								<option><c:out value="${yearlit}"></c:out></option>
							</c:forEach>
					</select> 
					<label>年</label> 
					<select id="month" name="month">
					<option></option>
							<c:forEach var="monthlit" items="${monthlist}">
								<option><c:out value="${monthlit}"></c:out></option>
							</c:forEach>
					</select>
					 <label>月</label>
					  <select id="day" name="day">
					  <option></option>
							<c:forEach var="daylit" items="${daylist}">
								<option><c:out value="${daylit}"></c:out></option>
							</c:forEach>
					</select> 
					<label>日</label></td>
				</tr>
				<tr>
					<td>出身地：</td>
					<td><input type="text" id="birthplace" name="birthplace"
						value="${birthplace}"></td>
				</tr>
				<tr>
					<td>結婚状況：</td>
					<td><select id="mariStatus" name="marStatus">
					<option></option>
							<c:forEach var="mari" items="${marilist}">
								<option><c:out value="${mari}"></c:out></option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>職務：</td>
					<td><input type="text" id="employee" name="employee"
						value="${employee}"></td>
				</tr>
				<tr>
					<td>現在住所：</td>
					<td><input type="text" id="persentaddress"
						name="persentaddress" value="${persentaddress}"></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="登録" /></td>

				</tr>
			</table>
		</div>
	</form>

</body>
</html>