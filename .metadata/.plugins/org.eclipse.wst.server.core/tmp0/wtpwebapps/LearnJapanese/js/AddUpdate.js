function addupdateLoad() {
	document.getElementById("kotoba").value = document.getElementById("kotoba").value
	document.getElementById("hiragana").value = document
			.getElementById("hiragana").value
	document.getElementById("imi").value = document.getElementById("imi").value
	$('#hinshi').val(document.getElementById("gethinshi").value);
	$('#level').val(document.getElementById("getlevel").value);
	document.getElementById("kotobaid").value = document
			.getElementById("kotobaid").value;

}

function btnEvent() {
	var conf = confirm("追加・更新をしてよろしいですか。");
	if (conf == true) {
		var id = document.getElementById("kotobaid").value;
		if (id == "") {
			document.getElementById("actionStatus").value = "追加";
			document.getElementById("addupdate").submit();
		} else {
			document.getElementById("actionStatus").value = "更新";
			document.getElementById("addupdate").submit();
		}
	} else {
		return false;
	}

}

function returnpage() {
	document.getElementById("actionStatus").value = "戻る";
	document.getElementById("addupdate").submit();
}
