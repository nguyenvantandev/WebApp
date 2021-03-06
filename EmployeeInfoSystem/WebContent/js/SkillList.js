function skillList_load() {
	var id = document.getElementById("hidden_shikakuId").value;
	var name = document.getElementById("hidden_shikakumei").value;
	var seisekinashi = document.getElementById("hidden_seisekinashi").value;
	var seisekiari = document.getElementById("hidden_seisekiari").value;
	var sakujosumi = document.getElementById("hidden_sakujosumi").value;
	var errorMessage = document.getElementById("errorMessage").value;
	var saikensaku = document.getElementById("saikensaku").value;
	if (id != "null") {
		document.getElementById("shikakuId").value = id;
	}
	if (name != "null") {
		document.getElementById("shikakumei").value = name;
	}
	if (seisekinashi == "on") {
		document.getElementById("seisekinashi").checked = true;
	}
	if (seisekiari == "on") {
		document.getElementById("seisekiari").checked = true;
	}
	if (sakujosumi == "on") {
		document.getElementById("sakujosumi").checked = true;
	}
	if (errorMessage != "null") {
		alert(errorMessage);
	}
	if (saikensaku == "再検索") {
		document.getElementById("actionName").value = "検索";
		document.getElementById("SkillList").submit();
	}
	var tbl = document.getElementById("table").rows.length;
	for (var i = 1; i < tbl; i++) {
		var n = document.getElementById("table").rows[i].cells[4].innerHTML;
		if (n == "○") {
			document.getElementById("henshu" + i).disabled = true;
			document.getElementById("sakujo" + i).disabled = true;
		}
	}
}

function kuria_click() {
	document.getElementById("shikakuId").value = "";
	document.getElementById("shikakumei").value = "";
	document.getElementById("seisekinashi").checked = false;
	document.getElementById("seisekiari").checked = false;
	document.getElementById("sakujosumi").checked = false;
}

function kensaku_click() {
	var id = document.getElementById("shikakuId").value;
	if (id != "") {
		var regex = /^[A-Za-z0-9]+$/;
		if (!id.match(regex)) {
			alert("資格IDは半角英数字で入力してください。");
			return false;
		}
	}
	document.getElementById("actionName").value = "検索";
	document.getElementById("SkillList").submit();
}

function hennshu_click(Val) {
	document.getElementById("actionName").value = "編集";
	var report = Val.parentNode.parentNode.cells[1].innerHTML;
	document.getElementById("actionValue").value = report;
	document.getElementById("SkillList").submit();
}

function sakujo_click(Val) {
	var kakunin = confirm("資格を削除してよろしいですか？");
	if (kakunin == true) {
		document.getElementById("actionName").value = "削除"
		var report = Val.parentNode.parentNode.cells[1].innerHTML;
		document.getElementById("actionValue").value = report;
		document.getElementById("SkillList").submit();
	} else {
		return false;
	}
}

function shinkitsuika_click() {
	document.getElementById("actionName").value = "新規追加";
	document.getElementById("SkillList").submit();
}
