function resumeSearch_load() {
	var id = document.getElementById("shainId").value;
	var name = document.getElementById("namae").value;
	var deleted = document.getElementById("hidden_sakujocheck").value;
	var gyumumei = document.getElementById("gyumumei").value;
	var gyoushu = document.getElementById("gyoushu").value;
	var shokumunaiyou = document.getElementById("shokumunaiyou").value;
	var shiyougengo = document.getElementById("shiyougengo").value;
	var db = document.getElementById("db").value;
	var sonohoka = document.getElementById("sonohoka").value;
	if (id == "null") {
		document.getElementById("shainId").value = "";
	} else {
		document.getElementById("shainId").value = id;
	}
	if (name == "null") {
		document.getElementById("namae").value = "";
	} else {
		document.getElementById("namae").value = name;
	}
	if (deleted == "null") {
		document.getElementById("sakujocheck").checked = false;
	} else {
		document.getElementById("sakujocheck").checked = true;
	}
	if (gyumumei == "null") {
		document.getElementById("gyumumei").value = "";
	} else {
		document.getElementById("gyumumei").value = gyumumei;
	}
	if (gyoushu == "null") {
		document.getElementById("gyoushu").value = "";
	} else {
		document.getElementById("gyoushu").value = gyoushu;
	}
	if (shokumunaiyou == "null") {
		document.getElementById("shokumunaiyou").value = "";
	} else {
		document.getElementById("shokumunaiyou").value = shokumunaiyou;
	}
	if (shiyougengo == "null") {
		document.getElementById("shiyougengo").value = "";
	} else {
		document.getElementById("shiyougengo").value = shiyougengo;
	}
	if (db == "null") {
		document.getElementById("db").value = "";
	} else {
		document.getElementById("db").value = db;
	}
	if (sonohoka == "null") {
		document.getElementById("sonohoka").value = "";
	} else {
		document.getElementById("sonohoka").value = sonohoka;
	}

	var tbl = document.getElementById("table").rows.length;
	for (var i = 1; i < tbl; i++) {
		var n = document.getElementById("table").rows[i].cells[7].innerHTML;
		if (n == "○") {
			document.getElementById("shosai" + i).disabled = true;
		}
	}

	var count = document.getElementById("kennsu").value;
	if (count == "0") {
		alert("検索条件に一致する社員が見つかりません。");
	}
	var search = document.getElementById("actionName").value
	if (search == "再検索") {
		document.getElementById("actionName").value = "検索"
		document.getElementById("ResumeSearch").submit();
	}

}

function kuria_click() {
	document.getElementById("shainId").value = "";
	document.getElementById("namae").value = "";
	document.getElementById("sakujocheck").checked = false;
	document.getElementById("gyumumei").value = "";
	document.getElementById("gyoushu").value = "";
	document.getElementById("shokumunaiyou").value = "";
	document.getElementById("shiyougengo").value = "";
	document.getElementById("db").value = "";
	document.getElementById("sonohoka").value = "";
}

function kensaku_click() {
	var shainId = document.getElementById("shainId").value;
	if (shainId != "") {
		var regex = /^[A-Za-z0-9]+$/;
		if (!shainId.match(regex)) {
			alert("社員IDは半角英数字で入力してください。");
			return false;
		}
	}
	document.getElementById("actionName").value = "検索"
	document.getElementById("ResumeSearch").submit();

}

function shosai_click(Val) {
	var report = Val.parentNode.parentNode.cells[1].innerHTML;
	document.getElementById("actionName").value = "詳細";
	document.getElementById("actionValue").value = report;
	document.getElementById("ResumeSearch").submit();

}