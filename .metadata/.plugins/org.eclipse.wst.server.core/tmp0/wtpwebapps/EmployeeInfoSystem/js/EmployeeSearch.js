function employeeSearch_load(){
	var id = document.getElementById("id").value;
	var name = document.getElementById("name").value;
	var sex = document.getElementById("sex").value;
	var del = document.getElementById("del").value;
	var count = document.getElementById("kennsu").value;
	var serverErrorMs = document.getElementById("serverErrorMs").value;
	var searchAgain = document.getElementById("sakujoButton").value;
	var sakujoMes = document.getElementById("sakujoMes").value;
	
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
	if(serverErrorMs != "null"){
		alert(serverErrorMs);
		return false;
	}
	if (sakujoMes != "null") {
		alert (sakujoMes);
	}

	if(searchAgain != "null"){
		document.getElementById("click_action").value = "検索";
		document.getElementById("EmployeeSearch").submit();
	}
	if(count == "0"){
		alert("検索条件に一致する社員が見つかりません。");
	}
	var tbl = document.getElementById("table").rows.length;
	for(var i = 1; i < tbl; i++){
		var n = document.getElementById("table").rows[i].cells[7].innerHTML;
		if(n == "○"){
			document.getElementById("ShainMaster"+i).disabled = true;
			document.getElementById("Sakujo"+i).disabled = true;
			document.getElementById("GijutsushikakuMaster"+i).disabled = true;
			document.getElementById("GijitsushaKerekisho"+i).disabled = true;
			
		}
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

function shainmaster_click(Val){
    var report = Val.parentNode.parentNode.cells[1].innerHTML;
    document.getElementById("shainmasterButton").value = report;
    document.getElementById("EmployeeSearch").submit();
    //alert(report);
}

function sakujo_click(Val){
	var confim = confirm("社員を削除してよろしいですか？");
	if(confim == true){
		var report = Val.parentNode.parentNode.cells[1].innerHTML;
		document.getElementById("sakujoButton").value = report;
		document.getElementById("EmployeeSearch").submit();
	}else{
		return false;
	}
}

function GijutsushikakuMaster_click(Val){
	var report = Val.parentNode.parentNode.cells[1].innerHTML;
	document.getElementById("GijutsushikakuMasterButton").value = report;
	 document.getElementById("EmployeeSearch").submit();
}


function GijitsushaKerekisho_click(Val){
	var report = Val.parentNode.parentNode.cells[1].innerHTML;
	document.getElementById("GijitsushaKerekishoButton").value = report;
	 document.getElementById("EmployeeSearch").submit();
}
