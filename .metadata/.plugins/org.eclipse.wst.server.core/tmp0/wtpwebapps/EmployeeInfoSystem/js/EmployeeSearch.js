function kuria_click(){
	document.getElementById("shain_ID").value = "";
	document.getElementById("namae").value = "";
	document.getElementById("sebetsu").value = "";
	document.getElementById("sakujosumi").checked = false;
}
function shinkitsuika_click(){
	document.getElementById("click_action").value = "新規追加";
	document.getElementById("EmployeeSearch").submit();
}
function kensaku_click(){
	var shainID = document.getElementById("shain_ID").value;
	if (shainID != "") {
		var regex = /^[A-Za-z0-9]+$/;
		if (!shainID.match(regex)) {
			alert("社員IDは半角英数字で入力してください。");
			return false;
		}
		var regex2 = /^[0-9]+$/;
		if(!shainID.match(regex2)){
			alert("検索条件に一致する社員が見つかりません。");
			return false;
		}
	}
	document.getElementById("click_action").value = "検索";
	document.getElementById("EmployeeSearch").submit();

}