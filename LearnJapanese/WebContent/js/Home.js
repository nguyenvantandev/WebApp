function homeload() {
	document.getElementById("kanji").value = document.getElementById("kanji").value;
	document.getElementById("hiragana").value = document
			.getElementById("hiragana").value;
	document.getElementById("level").value = document.getElementById("level").value;
	document.getElementById("imi").value = document.getElementById("imi").value;
	var action = document.getElementById("actionStatus").value;
	if (action == "検索") {
		document.getElementById("actionStatus").value = action;
		document.getElementById("Home").submit();
	}
}

function search() {

	document.getElementById("actionStatus").value = "検索"
	document.getElementById("Home").submit();
}

function clearclick() {
	document.getElementById("kanji").value = "";
	document.getElementById("hiragana").value = "";
	document.getElementById("imi").value = "";
	document.getElementById("level").value = "";
}

function insert() {
	document.getElementById("actionStatus").value = "追加"
	document.getElementById("Home").submit();
}

function update(Val) {
	var report = Val.parentNode.parentNode.cells[0].innerHTML;
	document.getElementById("kotobaid").value = report;
	document.getElementById("actionStatus").value = "更新"
	document.getElementById("Home").submit();
}

function del(Val) {
	var conf = confirm("この言葉を削除しますか。");
	if (conf == true) {
		var report = Val.parentNode.parentNode.cells[0].innerHTML;
		document.getElementById("kotobaid").value = report;
		document.getElementById("actionStatus").value = "削除"
		document.getElementById("Home").submit();
	} else {
		return false;
	}

}

function detailShow(Val) {
	var kanij = Val.parentNode.parentNode.cells[2].innerHTML;
	var hiragana = Val.parentNode.parentNode.cells[3].innerHTML;
	var imi = Val.parentNode.parentNode.cells[4].innerHTML;
	var hinshi = Val.parentNode.parentNode.cells[5].innerHTML;
	var reibun = Val.parentNode.parentNode.cells[6].innerHTML;
	document.getElementById("popkanji").value = kanij;
	document.getElementById("pophiragana").value = "[　" + hiragana + "　]";
	document.getElementById("popimi").value = "◆　" + imi;
	document.getElementById("pophinshi").value = "☆　" + hinshi;
	document.getElementById("popbun").value = reibun;
	document.getElementById("popdivdetail").style.display = 'block';
}
function hide(div) {
	document.getElementById("popdivdetail").style.display = 'none';
	document.getElementById("poplearn").style.display = 'none';
}

function learning() {
	var kanji = document.getElementById("table").rows[1].cells[2].innerHTML;
	var hiragana = document.getElementById("table").rows[1].cells[3].innerHTML;
	var imi = document.getElementById("table").rows[1].cells[4].innerHTML;
	var hinshi = document.getElementById("table").rows[1].cells[5].innerHTML;
	var reibun = document.getElementById("table").rows[1].cells[6].innerHTML;
	document.getElementById("context").value = kanji;
	document.getElementById("showkanji").value = kanji;
	document.getElementById("showhiragana").value = "[　" + hiragana + "　]";
	document.getElementById("showimi").value = "◆　" + imi;
	document.getElementById("showhinshi").value = "☆　" + hinshi;
	document.getElementById("showbun").value = reibun;

	document.getElementById("countrows").value = 1;
	document.getElementById("poplearn").style.display = 'block';
}

function backclick() {
	var lenrows = document.getElementById('table').rows.length;
	var countrows = document.getElementById("countrows").value;
	if (countrows == 1) {
		var i = lenrows - 1;
		var kanji = document.getElementById("table").rows[i].cells[2].innerHTML;
		var hiragana = document.getElementById("table").rows[i].cells[3].innerHTML;
		var imi = document.getElementById("table").rows[i].cells[4].innerHTML;
		var hinshi = document.getElementById("table").rows[i].cells[5].innerHTML;
		var reibun = document.getElementById("table").rows[i].cells[6].innerHTML;
		document.getElementById("context").value = kanji;
		document.getElementById("showkanji").value = kanji;
		document.getElementById("showhiragana").value = "[　" + hiragana + "　]";
		document.getElementById("showimi").value = "◆　" + imi;
		document.getElementById("showhinshi").value = "☆　" + hinshi;
		document.getElementById("showbun").value = reibun;

		document.getElementById("countrows").value = i;
	} else {
		var i = countrows - 1;
		var kanji = document.getElementById("table").rows[i].cells[2].innerHTML;
		var hiragana = document.getElementById("table").rows[i].cells[3].innerHTML;
		var imi = document.getElementById("table").rows[i].cells[4].innerHTML;
		var hinshi = document.getElementById("table").rows[i].cells[5].innerHTML;
		var reibun = document.getElementById("table").rows[i].cells[6].innerHTML;
		document.getElementById("context").value = kanji;
		document.getElementById("showkanji").value = kanji;
		document.getElementById("showhiragana").value = "[　" + hiragana + "　]";
		document.getElementById("showimi").value = "◆　" + imi;
		document.getElementById("showhinshi").value = "☆　" + hinshi;
		document.getElementById("showbun").value = reibun;

		document.getElementById("countrows").value = i;
	}
}
function nextclick() {
	var lenrows = document.getElementById('table').rows.length;
	var countrows = document.getElementById("countrows").value;
	var maxlens = lenrows - 1;
	if (countrows == maxlens) {
		var kanji = document.getElementById("table").rows[1].cells[2].innerHTML;
		var hiragana = document.getElementById("table").rows[1].cells[3].innerHTML;
		var imi = document.getElementById("table").rows[1].cells[4].innerHTML;
		var hinshi = document.getElementById("table").rows[1].cells[5].innerHTML;
		var reibun = document.getElementById("table").rows[1].cells[6].innerHTML;
		document.getElementById("context").value = kanji;
		document.getElementById("showkanji").value = kanji;
		document.getElementById("showhiragana").value = "[　" + hiragana + "　]";
		document.getElementById("showimi").value = "◆　" + imi;
		document.getElementById("showhinshi").value = "☆　" + hinshi;
		document.getElementById("showbun").value = reibun;

		document.getElementById("countrows").value = 1;
	} else {
		var i = parseInt(countrows) + 1;
		var kanji = document.getElementById("table").rows[i].cells[2].innerHTML;
		var hiragana = document.getElementById("table").rows[i].cells[3].innerHTML;
		var imi = document.getElementById("table").rows[i].cells[4].innerHTML;
		var hinshi = document.getElementById("table").rows[i].cells[5].innerHTML;
		var reibun = document.getElementById("table").rows[i].cells[6].innerHTML;
		document.getElementById("context").value = kanji;
		document.getElementById("showkanji").value = kanji;
		document.getElementById("showhiragana").value = "[　" + hiragana + "　]";
		document.getElementById("showimi").value = "◆　" + imi;
		document.getElementById("showhinshi").value = "☆　" + hinshi;
		document.getElementById("showbun").value = reibun;

		document.getElementById("countrows").value = i;
	}
}

function training() {
	document.getElementById("training").style.display = 'none';
	document.getElementById("back").style.display = 'none';
	document.getElementById("next").style.display = 'none';
	document.getElementById("showdetail").style.display = 'block';
}

function showdetail() {
	document.getElementById("training").style.display = 'inline';
	document.getElementById("back").style.display = 'inline';
	document.getElementById("next").style.display = 'inline';
	document.getElementById("showdetail").style.display = 'none';
}