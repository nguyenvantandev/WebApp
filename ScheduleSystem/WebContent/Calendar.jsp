<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" id="UserInfo" name="UserInfo" value="<%= session.getAttribute("UserInfo")%>">
<table>

<tbody><tr><td class="week">日</td><td class="week">月</td><td class="week">火</td><td class="week">水</td><td class="week">木</td><td class="week">金</td><td class="week">土</td></tr>

<tr><td class="otherday">29</td><td class="otherday">30</td><td class="otherday">31</td><td class="day">1</td><td class="day">2</td><td class="day">3</td><td class="day">4</td></tr>
<tr><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td></tr>

<tr><td class="day">5</td><td class="day">6</td><td class="day">7</td><td class="day">8</td><td class="day">9</td><td class="day">10</td><td class="day">11</td></tr>
<tr><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td></tr>

<tr><td class="day">12</td><td class="day">13</td><td class="day">14</td><td class="day">15</td><td class="day">16</td><td class="day">17</td><td class="day">18</td></tr>
<tr><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td></tr>

<tr><td class="day">19</td><td class="day">20</td><td class="day">21</td><td class="day">22</td><td class="day">23</td><td class="day">24</td><td class="day">25</td></tr>
<tr><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td></tr>

<tr><td class="day">26</td><td class="day">27</td><td class="day">28</td><td class="day">29</td><td class="day">30</td><td class="otherday">1</td><td class="otherday">2</td></tr>
<tr><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td><td class="sche"><img src="./img/memo.png" width="14" height="16"></td></tr>

</tbody></table>
</body>
</html>