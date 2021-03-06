function hide(div) {
	document.getElementById("tsuika").disabled = false;
	document.getElementById(div).style.display = 'none';
}

function SkillUpdate_load() {

	/*
	 * 社員マスタ検索画面から取得した値 ↓
	 */
	var shainId_search = document.getElementById("shainId_search").value;
	document.getElementById("shainId_search").value = shainId_search;
	var namae_search = document.getElementById("namae_search").value;
	document.getElementById("namae_search").value = namae_search;
	var sebetsu_search = document.getElementById("sebetsu_search").value;
	document.getElementById("sebetsu_search").value = sebetsu_search;
	var sakujo_search = document.getElementById("sakujo_search").value;
	document.getElementById("sakujo_search").value = sakujo_search;
	/*
	 * 社員マスタ検索画面から取得した値 ↑
	 */

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
	$('#year').val("");
	document.getElementsByName("upd_year")[0].innerHTML = optionsyear;
	$('#upd_year').val("");
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
	$('#month').val("");
	document.getElementsByName("upd_month")[0].innerHTML = optionsmonth;
	$('#upd_month').val("");
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
	$('#day').val("");
	document.getElementsByName("upd_day")[0].innerHTML = optionsday;
	$('#upd_day').val("");
	/*
	 * 生年月日 日付設定 ↑
	 */

	var shikakuId = document.getElementById("shainId").value;
	var namae = document.getElementById("namae").value;
	if (shikakuId != "null") {
		document.getElementById("shainId").disabled = true;
		document.getElementById("shainId").value = shikakuId;
	} else {
		document.getElementById("shainId").value = "";
	}
	if (namae != "null") {
		document.getElementById("namae").disabled = true;
		document.getElementById("namae").value = namae;
	} else {
		document.getElementById("namae").value = "";
	}

	var compeleteMes = document.getElementById("compeleteMes").value;
	var errorMes = document.getElementById("errorMes").value;
	var serverErrorMes = document.getElementById("serverErrorMes").value;
	if (compeleteMes != "null") {
		alert(compeleteMes);
	}
	if (errorMes != "null") {
		alert(errorMes);
		document.getElementById("actionName").value = "エラー";
		document.getElementById("SkillUpdate").submit();
		return false;
	}
	if (serverErrorMes != "null") {
		alert(serverErrorMes);
		document.getElementById("koushin").disabled = true;
		document.getElementById("sakujo").disabled = true;
		document.getElementById("tsuika").disabled = true;
		return false;
	}

	/*
	 * 表示順セット ↓
	 */
	var hyoujijun = document.getElementById("hyoujijun_count").value;
	var show = "";
	var showupd = "";
	if (hyoujijun != "null") {

		for (var i = 1; i <= hyoujijun; i++) {
			show += "<option>" + i + "</option>";
		}
		document.getElementsByName("houjijun")[0].innerHTML = show;
		$('#houjijun').val("");
		for (var i = 1; i < hyoujijun; i++) {
			showupd += "<option>" + i + "</option>";
		}
		document.getElementsByName("upd_houjijun")[0].innerHTML = showupd;
	} else {
		show += "<option>" + 1 + "</option>";
		document.getElementsByName("houjijun")[0].innerHTML = show;
	}

	/*
	 * 初期表示処理 ↓
	 */
	var id = document.getElementById("zengamen_shainId").value;
	if (id != "null") {
		document.getElementById("actionName").value = "初期表示";
		document.getElementById("actionValue").value = id;
		document.getElementById("SkillUpdate").submit();
	}
}

function popupKoshin_click(Val) {
	document.getElementById("tsuika").disabled = true;
	var shikakuname = Val.parentNode.parentNode.cells[2].innerHTML;
	var shutokudate = Val.parentNode.parentNode.cells[3].innerHTML;
	var seiseki = Val.parentNode.parentNode.cells[4].innerHTML;
	var junban = Val.parentNode.parentNode.cells[0].innerHTML;
	var licenseId = Val.parentNode.parentNode.cells[1].innerHTML;
	document.getElementById("upd_shikakumei").value = shikakuname;
	document.getElementById("licenseID").value = licenseId;
	document.getElementById("junbanUpd").value = junban;
	document.getElementById("upd_shikakumei").disabled = true;
	if (seiseki == "○") {
		document.getElementById("upd_seiseki").value = "";
		document.getElementById("upd_seiseki").disabled = true;
	} else {
		document.getElementById("upd_seiseki").disabled = false;
		document.getElementById("upd_seiseki").value = seiseki;
	}
	$('#upd_houjijun').val(junban);
	var res = shutokudate.split("-");
	$('#upd_year').val(res[0]);
	$('#upd_month').val(res[1]);
	$('#upd_day').val(res[2]);

	var shainId = document.getElementById("shainId").value;
	document.getElementById("actionValue").value = shainId;
	document.getElementById("popDivUpdate").style.display = 'block';
}

function modoru_click() {
	document.getElementById("actionName").value = "戻る";
	document.getElementById("SkillUpdate").submit();
}

function popupTsuika_click() {
	var shainId = document.getElementById("shainId").value;
	document.getElementById("actionValue").value = shainId;
	document.getElementById("popDivAdd").style.display = 'block';
}

function tsuika_click() {
	var licenseid = document.getElementById("licenseID").value;
	if (licenseid == "") {
		var LcsId = document.getElementsByName("LcsId")[0].value;
		document.getElementById("licenseID").value = LcsId;
	}
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var day = document.getElementById("day").value;
	if (year == "") {
		alert("生年月日が未選択です。");
		return false;
	}
	if (month == "") {
		alert("生年月日が未選択です。");
		return false;
	}
	if (day == "") {
		alert("生年月日が未選択です。");
		return false;
	}
	dt = new Date(year, month - 1, day);
	if (dt.getFullYear() != year || dt.getMonth() != month - 1
			|| dt.getDate() != day) {
		alert("選択日付は不正です。");
		return false;
	}
	var seiseki = document.getElementById("seiseki").value;
	if (!document.getElementById("seiseki").disabled) {
		if (seiseki == "") {
			alert("成績が未入力です。");
			return false;
		} else if (seiseki != "") {
			var regex = /^[A-Za-z0-9]+$/;
			if (!seiseki.match(regex)) {
				alert("成績は半角英数字のみ入力してください。");
				return false;
			}
		}
	}

	var hyoujijun = document.getElementById("houjijun").value;
	if (hyoujijun == "") {
		alert("表示順が未選択です。");
		return false;
	}
	var conf = confirm("新技術資格を追加してよろしいですか。");
	if (conf == true) {
		document.getElementById("actionName").value = "追加";
		document.getElementById("SkillUpdate").submit();
	} else {
		return false;
	}
}

function koushin_click() {
	var year = document.getElementById("upd_year").value;
	var month = document.getElementById("upd_month").value;
	var day = document.getElementById("upd_day").value;
	dt = new Date(year, month - 1, day);
	if (dt.getFullYear() != year || dt.getMonth() != month - 1
			|| dt.getDate() != day) {
		alert("選択日付は不正です。");
		return false;
	}
	var seiseki = document.getElementById("upd_seiseki").value;
	if (!document.getElementById("upd_seiseki").disabled) {
		if (seiseki == "") {
			alert("成績が未入力です。");
			return false;
		} else if (seiseki != "") {
			var regex = /^[A-Za-z0-9]+$/;
			if (!seiseki.match(regex)) {
				alert("成績は半角英数字のみ入力してください。");
				return false;
			}
		}
	}

	var conf = confirm("資格名の情報を更新してよろしいですか。");
	if (conf == true) {
		document.getElementById("actionName").value = "更新";
		document.getElementById("SkillUpdate").submit();
	} else {
		return false;
	}

}

function shikakuMei_change() {
	var slectedOn = document.getElementById("shikakuMei").selectedIndex;
	var recordStype = document.getElementsByName("recordTest")[slectedOn].value;
	var LcsId = document.getElementsByName("LcsId")[slectedOn].value;
	document.getElementById("licenseID").value = LcsId;
	if (recordStype == "1") {
		document.getElementById("seiseki").disabled = true;
	} else {
		document.getElementById("seiseki").disabled = false;
	}

}

function sakujo_click(Val) {
	var shainId = document.getElementById("shainId").value;
	var licenseid = Val.parentNode.parentNode.cells[1].innerHTML;
	document.getElementById("actionValue").value = shainId;
	document.getElementById("licenseID").value = licenseid;
	var junban = Val.parentNode.parentNode.cells[0].innerHTML;
	document.getElementById("junbanUpd").value = junban;
	var conf = confirm("資格情報を削除してよろしいですか。");
	if (conf == true) {
		document.getElementById("actionName").value = "削除";
		document.getElementById("SkillUpdate").submit();
	} else {
		return false;
	}

}