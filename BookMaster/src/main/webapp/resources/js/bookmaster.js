

//初期表示
function mainload() {
}
// クリアボタン処理
function clearsearch() {
	document.getElementById("book_id").value = "";
	document.getElementById("title").value = "";
	document.getElementById("author").value = "";
	document.getElementById("pulisher").value = "";
	document.getElementById("pulication_dayin").value = "";
	document.getElementById("pulication_dayout").value = "";
	document.getElementById("checkbox").checked = false;
}
// 一覧画面に新規追加ボタン処理
function addpage() {
	var deletecheck = document.getElementById("checkbox").checked;
	var check = document.getElementById("check").value = deletecheck;
	var action = document.getElementById("action").value = "新規追加";
	document.getElementById("ichirangamen").submit();
}
// 一覧画面に更新ボタン処理
function updatepage() {
	var checkradio = document.getElementsByName("listradio");
	var len = checkradio.length;
	var i;
	for (i = 0; i < len; i++) {
		if (checkradio[i].checked) {
			break;
		}
	}
	if (i < len) {
		var deleteflg = document.getElementsByName("deleteflg")[i].value;
		if (deleteflg == 0) {
			var deletecheck = document.getElementById("checkbox").checked;
			var check = document.getElementById("check").value = deletecheck;
			var a = $("input[type='radio'][name='listradio']:checked");
			var updateid = document.getElementById("updateid").value = a[0].value;
			var action = document.getElementById("action").value = "更新";
			document.getElementById("ichirangamen").submit();
		} else {
			alert("削除済の本は更新できません。");
		}
	} else {
		alert("本が選択されていません。");
	}
}
// 一覧画面に検索処理
function searchpage() {
	document.getElementById("ichirangamen").submit();
}
function CheckDateTime(val){
	var year = val.substring(0, 4);
	var month = val.substring(4, 6);
	var day = val.substring(6, 8);
	dt=new Date(year,month-1,day);
    if(dt.getFullYear()== year && dt.getMonth()== month-1 && dt.getDate()== day){
    	return true;
    }
    return false;
}

// 更新画面に初期表示
function addload() {
	var a = document.getElementById("text_input_id").value;
	var servererrormessage = document.getElementById("servererrormessage").value
	var existvalue = document.getElementById("existvalue").value;
	if (servererrormessage != "null") {
		document.getElementById('update').disabled = true;
		document.getElementById('delete').disabled = true;
		alert(servererrormessage);
		return false;
	} else {
		if (existvalue == "1") {
			alert("本情報が更新された可能性があります。再度、本マスタ一覧画面に戻り、やり直してください。");
			document.getElementById('update').disabled = true;
			document.getElementById('delete').disabled = true;
		} else {

			var completemessage = document.getElementById("completemessage").value;
			if (completemessage != "null" && completemessage != "") {
				alert(completemessage);
			}
		}
	}
	if (a == "") {
		document.getElementById('update').style.visibility = 'hidden';
		document.getElementById('delete').style.visibility = 'hidden';
	} else {

		document.getElementById('add').style.visibility = 'hidden';
	}
	var servererrormessage = document.getElementById("servererrormessage").value
	if (servererrormessage != "null") {
		alert(servererrormessage);
	}
	//Set Day => Start
	var nowyear = new Date().getFullYear();
	var startyear = 2030;
	var endyear = 1970;
	var optionsyear = "";
	for (var year = startyear; year >= endyear; year--) {
		optionsyear += "<option>" + year + "</option>";
	}
	document.getElementsByName("year")[0].innerHTML = optionsyear;
	var year = $("#year_id")[0].value;
	$('#year_input').val(year);
	// month

	var startmonth = 1;
	var endmonth = 12;
	var optionsmonth = "";
	for (var month = startmonth; month <= endmonth; month++) {
		if (month <= 9) {
			month = "0" + month.toString();
		}
		optionsmonth += "<option>" + month + "</option>";
	}
	document.getElementsByName("month")[0].innerHTML = optionsmonth;
	var month = $("#month_id")[0].value;
	$('#month_input').val(month);
	// day
	var startday = 1;
	var endday = 31;
	var optionsday = "";
	for (var day = startday; day <= endday; day++) {
		if (day <= 9) {
			day = "0" + day.toString();
		}
		optionsday += "<option>" + day + "</option>";
	}
	document.getElementsByName("day")[0].innerHTML = optionsday;
	var day = $("#day_id")[0].value;
	$('#date_input').val(day);
	//Set Day => End
}
// 更新画面に追加処理
function addvalue() {
	var title = document.getElementById("text_input_title").value;
	var author = document.getElementById("text_input_author").value;
	var pulisher = document.getElementById("text_input_publisher").value;
	var stock = document.getElementById("text_input_zaiko").value;
	var yearsel = document.getElementById("year_input");
	var year = yearsel.options[yearsel.selectedIndex].value;
	var monthsel = document.getElementById("month_input");
	var month = monthsel.options[monthsel.selectedIndex].value;
	var daysel = document.getElementById("date_input");
	var day = daysel.options[daysel.selectedIndex].value;
	var valuecheking = checkingAddUpdateValue(title, author, pulisher, stock, year, month, day);
	if(valuecheking == false){
		return false;
	}
	var r = confirm("登録します、よろしいですか？");
	if (r == true) {
		var action = document.getElementById("action").value = "追加";
		document.getElementById("addupdate").submit();
	} else {
		return false;
	}
}
// 更新画面に更新処理
function updatevalue() {
	var title = document.getElementById("text_input_title").value;
	var author = document.getElementById("text_input_author").value;
	var pulisher = document.getElementById("text_input_publisher").value;
	var stock = document.getElementById("text_input_zaiko").value;
	var update = document.getElementById("update").value;
	var yearsel = document.getElementById("year_input");
	var year = yearsel.options[yearsel.selectedIndex].value;
	var monthsel = document.getElementById("month_input");
	var month = monthsel.options[monthsel.selectedIndex].value;
	var daysel = document.getElementById("date_input");
	var day = daysel.options[daysel.selectedIndex].value;
	var valuecheking = checkingAddUpdateValue(title, author, pulisher, stock, year, month, day);
	if(valuecheking == false){
		return false;
	}
	var servererrormessage = document.getElementById("servererrormessage").value
	if (servererrormessage != "null") {
		alert(servererrormessage);
	}
	var r = confirm("更新します、よろしいですか？");
	if (r == true) {
		var action = document.getElementById("action").value = "更新";
		document.getElementById("addupdate").submit();
	} else {
		return false;
	}
}

function checkingAddUpdateValue(title, author, pulisher, stock, year, month, day){
	if (title == "") {
		alert("本タイトルが未入力です。");
		return false;
	}
	if (author == "") {
		alert("著者名が未入力です。");
		return false;
	}
	if (pulisher == "") {
		alert("出版社が未入力です。");
		return false;
	}
	if (stock != "") {
		var regex = /^[0-9]+$/;
		if (!stock.match(regex)) {
			alert("在庫数は0以上の整数で入力してください。");
			return false;
		}
	}
	dt=new Date(year,month-1,day);
    if(dt.getFullYear()!= year || dt.getMonth()!= month-1 || dt.getDate()!= day){
    	alert("出版年月日が不正です。");
    	return false;
    }
	return true;
}
// 更新画面に削除処理
function deletevalue() {
	var r = confirm("削除します、よろしいですか？");
	if (r == true) {
		var action = document.getElementById("action").value = "削除"
		document.getElementById("addupdate").submit();
	} else {
		return false;
	}
}
// 更新画面に戻る処理
function gobackpage() {
	var action = document.getElementById("action").value = "戻る"
	document.getElementById("addupdate").submit();
}
