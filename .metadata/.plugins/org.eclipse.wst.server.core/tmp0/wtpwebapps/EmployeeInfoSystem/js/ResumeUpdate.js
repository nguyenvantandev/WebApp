function ResumeUpdate_load() {
	/*
	 * 生年月日 日付設定 ↓
	 */
	var nowyear = new Date().getFullYear();
	var startyear = 2020;
	var endyear = 1950;
	var optionsyear = "";
	for (var year = startyear; year >= endyear; year--) {
		optionsyear += "<option>" + year + "</option>";
	}
	document.getElementsByName("year")[0].innerHTML = optionsyear;
	document.getElementsByName("itaru_year")[0].innerHTML = optionsyear;
	$('#year').val("");
	$('#itaru_year').val("");
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
	document.getElementsByName("itaru_month")[0].innerHTML = optionsmonth;
	$('#month').val("");
	$('#itaru_month').val("");
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
	document.getElementsByName("itaru_day")[0].innerHTML = optionsday;
	$('#day').val("");
	$('#itaru_day').val("");
	/*
	 * 生年月日 日付設定 ↑
	 */

	/*
	 * 社員マスタ検索
	 */
	var shain_shainId = document.getElementById("shain_shainId").value;
	document.getElementById("shain_shainId").value = shain_shainId;
	var shain_namae = document.getElementById("shain_namae").value;
	document.getElementById("shain_namae").value =shain_namae;
	var shain_sebetsu = document.getElementById("shain_sebetsu").value;
	document.getElementById("shain_sebetsu").value= shain_sebetsu;
	var shain_sakujo = document.getElementById("shain_sakujo").value;
	document.getElementById("shain_sakujo").value = shain_sakujo;
	/*
	 * 経歴書検索
	 */
	var keireki_shainId = document.getElementById("keireki_shainId").value;
	document.getElementById("keireki_shainId").value = keireki_shainId
	var keireki_namae = document.getElementById("keireki_namae").value;
	document.getElementById("keireki_namae").value = keireki_namae;
	var keireki_sakujocheck = document.getElementById("keireki_sakujocheck").value;
	document.getElementById("keireki_sakujocheck").value = keireki_sakujocheck;
	var keireki_gyumumei = document.getElementById("keireki_gyumumei").value;
	document.getElementById("keireki_gyumumei").value = keireki_gyumumei;
	var keireki_gyoushu = document.getElementById("keireki_gyoushu").value;
	document.getElementById("keireki_gyoushu").value = keireki_gyoushu;
	var keireki_shokumunaiyou = document.getElementById("keireki_shokumunaiyou").value;
	document.getElementById("keireki_shokumunaiyou").value = keireki_shokumunaiyou;
	var keireki_shiyougengo = document.getElementById("keireki_shiyougengo").value;
	document.getElementById("keireki_shiyougengo").value = keireki_shiyougengo;
	var keireki_db = document.getElementById("keireki_db").value;
	document.getElementById("keireki_db").value = keireki_db;
	var keireki_sonohoka = document.getElementById("keireki_sonohoka").value;
	document.getElementById("keireki_sonohoka").value = keireki_sonohoka;
	var whatpage = document.getElementById("whatpage").value;
	document.getElementById("whatpage").value = whatpage;
	

	var actionValue = document.getElementById("actionValue").value;
	document.getElementById("actionValue").value = actionValue;

	
	var shainId = document.getElementById("shainId").value;
	if (shainId == "null") {
		document.getElementById("shainId").value = "";
	} else {
		document.getElementById("shainId").value = shainId;
		document.getElementById("shainId").disabled = true;
	}

	var gyoushu = document.getElementById("gyoushu").value;
	if (gyoushu == "null") {
		document.getElementById("gyoushu").value = ""
	} else {
		document.getElementById("gyoushu").value = gyoushu;
	}

	var gyumumei = document.getElementById("gyumumei").value;
	if (gyumumei == "null") {
		document.getElementById("gyumumei").value = "";
	} else {
		document.getElementById("gyumumei").value = gyumumei;
	}

	var shokumunaiyo = document.getElementById("shokumunaiyo").value;
	if (shokumunaiyo == "null") {
		document.getElementById("shokumunaiyo").value = "";
	} else {
		document.getElementById("shokumunaiyo").value = shokumunaiyo;
	}

	var os = document.getElementById("os").value;
	if (os == "null") {
		document.getElementById("os").value = "";
	} else {
		document.getElementById("os").value = os;
	}

	var shiyogengo = document.getElementById("shiyogengo").value;
	if (shiyogengo == "null") {
		document.getElementById("shiyogengo").value = "";
	} else {
		document.getElementById("shiyogengo").value = shiyogengo;
	}

	var db = document.getElementById("db").value;
	if (db == "null") {
		document.getElementById("db").value = "";
	} else {
		document.getElementById("db").value = db;
	}

	var sonohoka = document.getElementById("sonohoka").value;
	if (sonohoka == "null") {
		document.getElementById("sonohoka").value = "";
	} else {
		document.getElementById("sonohoka").value = sonohoka;
	}

	var start_year = document.getElementById("start_year").value;
	if (start_year != "null") {
		$('#year').val(start_year);
	}

	var start_month = document.getElementById("start_month").value;
	if (start_month != "null") {
		$('#month').val(start_month);
	}

	var start_day = document.getElementById("start_day").value;
	if (start_day != "null") {
		$('#day').val(start_day);
	}

	var end_year = document.getElementById("end_year").value;
	if (end_year != "null") {
		$('#itaru_year').val(end_year);
	}

	var end_month = document.getElementById("end_month").value;
	if (end_month != "null") {
		$('#itaru_month').val(end_month);
	}

	var end_day = document.getElementById("end_day").value;
	if (end_day != "null") {
		$('#itaru_day').val(end_day);
	}

	var actionId = document.getElementById("actionId").value;
	document.getElementById("actionId").value = actionId;
	
	var actionName = document.getElementById("actionName").value;
	
	if (actionName == "新規追加") {
		document.getElementById("addUpd").value = "登録";
		document.getElementById("shainId").value = actionId;
		document.getElementById("shainId").disabled = true;
		
		return false;
	}
	if (actionName == "更新") {
		document.getElementById("actionName").value = "初期検索";
		document.getElementById("ResumeUpdate").submit();
	}

}

function modoru_click(){
	document.getElementById("actionName").value = "戻る";
	document.getElementById("actionId").value = document.getElementById("shainId").value
	document.getElementById("ResumeUpdate").submit();
}

function addUpd_click() {
	var action = document.getElementById("addUpd").value;
	document.getElementById("actionName").value = action;
	document.getElementById("actionId").value = document.getElementById("shainId").value
	document.getElementById("ResumeUpdate").submit();
		
}
