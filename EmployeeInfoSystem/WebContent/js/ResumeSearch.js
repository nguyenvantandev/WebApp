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
	if(id == "null"){
		document.getElementById("shainId").value = "";
	}else{
		document.getElementById("shainId").value = id;
	}
	if(name == "null"){
		document.getElementById("namae").value = "";
	}else{
		document.getElementById("namae").value = name;
	}
	if(deleted == "null"){
		document.getElementById("sakujocheck").checked = false;
	}else{
		document.getElementById("sakujocheck").checked = true;
	}
	if(gyumumei == "null"){
		document.getElementById("gyumumei").value = "";
	}else{
		document.getElementById("gyumumei").value = gyumumei;
	}
	if(gyoushu == "null"){
		document.getElementById("gyoushu").value = "";
	}else{
		document.getElementById("gyoushu").value = gyoushu;
	}
	if(shokumunaiyou == "null"){
		document.getElementById("shokumunaiyou").value = "";
	}else{
		document.getElementById("shokumunaiyou").value = shokumunaiyou;
	}
	if(shiyougengo == "null"){
		document.getElementById("shiyougengo").value = "";
	}else{
		document.getElementById("shiyougengo").value = shiyougengo;
	}
	if(db == "null"){
		document.getElementById("db").value = "";
	}else{
		document.getElementById("db").value = db;
	}
	if(sonohoka == "null"){
		document.getElementById("sonohoka").value = "";
	}else{
		document.getElementById("sonohoka").value = sonohoka;
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
	document.getElementById("actionName").value = "検索"
	document.getElementById("ResumeSearch").submit();

	
}

function shosai_click(Val) {

}