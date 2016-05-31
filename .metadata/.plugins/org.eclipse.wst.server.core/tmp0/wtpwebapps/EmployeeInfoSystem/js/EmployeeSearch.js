function employeeSearch_load(){
	var id = document.getElementById("id").value;
	var name = document.getElementById("name").value;
	var sex = document.getElementById("sex").value;
	var del = document.getElementById("del").value;
//	var man = document.getElementById("sebetsu")[1].innerHTML;
//	var woman = document.getElementById("sebetsu")[2].innerHTML;
//	var other = document.getElementById("sebetsu")[0].innerHTML;
	
	if(id != "null"){
		document.getElementById("shain_ID").value = id;
	}
	if(name != "null"){
		document.getElementById("namae").value = name;
	}
	if(sex != "null"){
		document.getElementById("sebetsu")[0].innerHTML = sex;
	}
	
	if(del == "1"){
		document.getElementById("sakujosumi").checked = true;
	}
}

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