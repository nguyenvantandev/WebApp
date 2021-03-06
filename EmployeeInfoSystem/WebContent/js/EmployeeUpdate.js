function employeeUpdate_load() {
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
	/*
	 * 生年月日 日付設定 ↑
	 */

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
	var shainNum = document.getElementById("shainNum").value;
	document.getElementById("shainNum").value = shainNum;
	/*
	 * 社員マスタ検索画面から取得した値 ↑
	 */

	/*
	 * 社員マスタ検索画面で「新規追加」ボタンを押下場合 ↓
	 */
	var shainId = document.getElementById("shainId").value;
	if (shainId == "null") {
		document.getElementById("shainId").value = "";
	} else {
		document.getElementById("shainNum").value = shainId
		document.getElementById("shainId").disabled = true;
		document.getElementById("shainId").value = shainId;
	}

	var namae = document.getElementById("namae").value;
	if (namae == "null") {
		document.getElementById("namae").value = "";
	} else {
		document.getElementById("namae").value = namae;
	}

	var furigana = document.getElementById("furigana").value;
	if (furigana == "null") {
		document.getElementById("furigana").value = "";
	} else {
		document.getElementById("furigana").value = furigana;
	}

	var inisharu = document.getElementById("inisharu").value;
	if (inisharu == "null") {
		document.getElementById("inisharu").value = "";
	} else {
		document.getElementById("inisharu").value = inisharu;
	}

	var saiyorieki = document.getElementById("saiyorieki").value;
	if (saiyorieki == "null") {
		document.getElementById("saiyorieki").value = "";
	} else {
		document.getElementById("saiyorieki").value = saiyorieki;
	}

	var jusho = document.getElementById("jusho").value;
	if (jusho == "null") {
		document.getElementById("jusho").value = "";
	} else {
		document.getElementById("jusho").value = jusho;
	}

	var jikopr = document.getElementById("jikopr").value;
	if (jikopr == "null") {
		document.getElementById("jikopr").value = "";
	} else {
		document.getElementById("jikopr").value = jikopr;
	}

	var sex = document.getElementById("selcect_sex").value;
	if (sex == "null") {
		document.getElementById("sebetsu")[0].innerHTML = "";
	} else {
		document.getElementById("sebetsu")[0].innerHTML = sex;
	}

	var birth_year = document.getElementById("birth_year").value;
	if (birth_year == "null") {
		$('#year').val("");
	} else {
		$('#year').val(birth_year);
	}

	var birth_month = document.getElementById("birth_month").value;
	if (birth_month == "null") {
		$('#month').val("");
	} else {
		$('#month').val(birth_month);
	}

	var birth_day = document.getElementById("birth_day").value;
	if (birth_day == "null") {
		$('#day').val("");
	} else {
		$('#day').val(birth_day);
	}

	/*
	 * 社員マスタ検索画面で「新規追加」ボタンを押下場合 ↑
	 */
	var serverErrorMs = document.getElementById("serverErrorMs").value;
	if (serverErrorMs != "null") {
		document.getElementById("addUpdate").disabled = true;
		alert(serverErrorMs);
		return false;
	}
	var notFind = document.getElementById("conditionVal").value;
	if (notFind != "") {
		alert(notFind);
		document.getElementById("conditionVal").value = "検索画面";
		document.getElementById("employeeUpdate").submit();
	}
	var completeMs = document.getElementById("completeMs").value;
	if (completeMs != "null") {
		alert(completeMs);
	}
	if (shainNum != "null") {
		document.getElementById("conditionVal").value = "初期表示";
		document.getElementById("employeeUpdate").submit();
	} else {
		return false;
	}

}

function modoru_click() {
	document.getElementById("conditionVal").value = "戻る";
	document.getElementById("employeeUpdate").submit();
}

function addUpdate_click() {
	var shainId = document.getElementById("shainId").value;
	if (shainId == "") {
		alert("社員IDが未入力です。");
		return false;
	}
	if (shainId != "") {
		var regex = /^[A-Za-z0-9]+$/;
		if (!shainId.match(regex)) {
			alert("社員IDは半角英数字で入力してください。");
			return false;
		}
	}
	var namae = document.getElementById("namae").value;
	if (namae == "" || namae == " " || namae == "　") {
		alert("名前が未入力です。");
		return false;
	}

	var furigana = document.getElementById("furigana").value;
	if (furigana == "" || furigana == " " || furigana == "　") {
		alert("フリガナが未入力です。");
		return false;
	}
	var inisharu = document.getElementById("inisharu").value;
	if (inisharu == "" || inisharu == " " || inisharu == "　") {
		alert("イニシャルが未入力です。");
		return false;
	}
	var sebetsu = document.getElementById("sebetsu").value;
	if (sebetsu == "") {
		alert("性別が未選択です。");
		return false;
	}
	var year = document.getElementById("year").value;
	if (year == "") {
		alert("生年月日が未選択です。");
		return false;
	}
	var month = document.getElementById("month").value;
	if (month == "") {
		alert("生年月日が未選択です。");
		return false;
	}
	var day = document.getElementById("day").value;
	if (day == "") {
		alert("生年月日が未選択です。");
		return false;
	}
	dt = new Date(year, month - 1, day);
	if (dt.getFullYear() != year || dt.getMonth() != month - 1
			|| dt.getDate() != day) {
		alert("出版年月日が不正です。");
		return false;
	}

	var jusho = document.getElementById("jusho").value;
	if (jusho == "" || jusho == " " || jusho == "　") {
		alert("住所が未入力です。");
		return false;
	}
	var com = confirm("社員を登録/更新してよろしいですか？");
	if (com == true) {
		document.getElementById("conditionVal").value = "登録/更新";
		document.getElementById("shainNum").value = shainId;
		document.getElementById("employeeUpdate").submit();
	} else {
		return false;
	}
}
