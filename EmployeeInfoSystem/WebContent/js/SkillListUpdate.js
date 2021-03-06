function SkillListUpdate_load() {
	var shikakuId = document.getElementById("shikakuId").value;
	var shikakumei = document.getElementById("shikakumei").value;
	var firstSearch = document.getElementById("skillListFrom_shikakuId").value;
	var sex = document.getElementById("sex").value;
	if (sex == "1") {
		$('#seiseki').val("無し");
	} else if (sex == "0") {
		$('#seiseki').val("あり");
	} else {
		$('#seiseki').val("");
	}

	if (shikakuId != "null") {
		document.getElementById("shikakuId").disabled = true;
		document.getElementById("shikakuId").value = shikakuId;
		document.getElementById("actionValue").value = shikakuId;
	} else {
		document.getElementById("shikakuId").value = "";
	}
	if (shikakumei != "null") {
		document.getElementById("shikakumei").value = shikakumei;
	} else {
		document.getElementById("shikakumei").value = "";
	}

	var id = document.getElementById("hidden_shikakuId").value;
	if (id != "null") {
		document.getElementById("hidden_shikakuId").value = id;
	}

	var name = document.getElementById("hidden_shikakumei").value;
	if (name != "null") {
		document.getElementById("hidden_shikakumei").value = name;
	}

	var seisekinashi = document.getElementById("hidden_seisekinashi").value;
	if (seisekinashi != "null") {
		document.getElementById("hidden_seisekinashi").value = seisekinashi;
	}

	var seisekiari = document.getElementById("hidden_seisekiari").value;
	if (seisekiari != "null") {
		document.getElementById("hidden_seisekiari").value = seisekiari;
	}

	var sakujosumi = document.getElementById("hidden_sakujosumi").value;
	if (sakujosumi != "null") {
		document.getElementById("hidden_sakujosumi").value = sakujosumi;
	}

	var buttonChange = document.getElementById("buttonChange").value;
	if (buttonChange == "null") {
		document.getElementById("AddUpdate").value = "登録";
	} else {
		document.getElementById("AddUpdate").value = "更新";
	}
	var serverErrorMessage = document.getElementById("serverErrorMessage").value;
	if (serverErrorMessage != "null") {
		document.getElementById("AddUpdate").disabled = true;
		alert(serverErrorMessage);
		return false;
	}
	var errorMessage = document.getElementById("errorMessage").value;
	if (errorMessage != "null") {
		alert(errorMessage);
		document.getElementById("actionName").value = "エラー";
		document.getElementById("SkillListUpdate").submit();
		return false;
	}
	var completeMessage = document.getElementById("completeMessage").value;
	if (completeMessage != "null") {
		alert(completeMessage);
	}
	if (firstSearch != "null") {

		document.getElementById("actionName").value = "初期表示";
		document.getElementById("skillListFrom_shikakuId").value = firstSearch;
		document.getElementById("SkillListUpdate").submit();
	}

}

function modoru_click() {
	document.getElementById("actionName").value = "戻る";
	document.getElementById("SkillListUpdate").submit();
}

function AddUpdate_click() {
	var shikakuId = document.getElementById("shikakuId").value;
	var shikakumei = document.getElementById("shikakumei").value;
	var seiseki = document.getElementById("seiseki").value;
	if (shikakuId == "" || shikakuId == " " || shikakuId == "　") {
		alert("資格IDが未入力です。");
		return false;
	}
	if (shikakuId != "") {
		var regex = /^[A-Za-z0-9]+$/;
		if (!shikakuId.match(regex)) {
			alert("資格IDは半角英数字で入力してください。");
			return false;
		}
	}
	if (shikakumei == "" || shikakumei == " " || shikakumei == "　") {
		alert("資格名が未入力です。");
		return false;
	}
	if (seiseki == "") {
		alert("成績が未選択です。");
		return false;
	}

	var Val = document.getElementById("AddUpdate").value;
	var conf;
	if (Val == "登録") {
		conf = confirm("資格を登録してよろしいですか？");
	} else if (Val == "更新") {
		conf = confirm("資格を更新してよろしいですか？");
	}
	if (conf == true) {
		document.getElementById("actionName").value = Val;
		document.getElementById("SkillListUpdate").submit();
	} else {
		return false;
	}
}
