function Resume_load(){
	
	var whatpage = document.getElementById("whatpage").value;
	document.getElementById("whatpage").value = whatpage;
	
	var shainId = document.getElementById("shainId").value;
	if(shainId != "null"){
		document.getElementById("shainId").value = shainId;
		document.getElementById("shainId").disabled = true;
	}
	
	var namae = document.getElementById("namae").value;
	if(namae != "null"){
		document.getElementById("namae").value = namae;
		document.getElementById("namae").disabled = true;
	}
	/*
	 * 社員マスタ検索
	 */
	var shain_shainId = document.getElementById("shain_shainId").value;
	document.getElementById("shain_shainId").value = shain_shainId;
	var shain_namae = document.getElementById("shain_namae").value;
	document.getElementById("shain_namae").value =shain_namae;
	var shain_sebetsu = document.getElementById("shain_sebetsu").value;
	document.getElementById("shain_sebetsu").value= shain_sebetsu;
	var shain_sakujo = document.getElementById("shain_sakujo").value;
	document.getElementById("shain_sakujo").value = shain_sakujo;
	/*
	 * 経歴書検索
	 */
	var keireki_shainId = document.getElementById("keireki_shainId").value;
	document.getElementById("keireki_shainId").value = keireki_shainId
	var keireki_namae = document.getElementById("keireki_namae").value;
	document.getElementById("keireki_namae").value = keireki_namae;
	var keireki_sakujocheck = document.getElementById("keireki_sakujocheck").value;
	document.getElementById("keireki_sakujocheck").value = keireki_sakujocheck;
	var keireki_gyumumei = document.getElementById("keireki_gyumumei").value;
	document.getElementById("keireki_gyumumei").value = keireki_gyumumei;
	var keireki_gyoushu = document.getElementById("keireki_gyoushu").value;
	document.getElementById("keireki_gyoushu").value = keireki_gyoushu;
	var keireki_shokumunaiyou = document.getElementById("keireki_shokumunaiyou").value;
	document.getElementById("keireki_shokumunaiyou").value = keireki_shokumunaiyou;
	var keireki_shiyougengo = document.getElementById("keireki_shiyougengo").value;
	document.getElementById("keireki_shiyougengo").value = keireki_shiyougengo;
	var keireki_db = document.getElementById("keireki_db").value;
	document.getElementById("keireki_db").value = keireki_db;
	var keireki_sonohoka = document.getElementById("keireki_sonohoka").value;
	document.getElementById("keireki_sonohoka").value = keireki_sonohoka;
	
	
	var actionId = document.getElementById("actionId").value;
	if(actionId != "null"){
		document.getElementById("actionId").value = actionId;
		document.getElementById("actionName").value = "初期検索";
		document.getElementById("Resume").submit();
	}
	
}

function modoru_click(){
	document.getElementById("actionName").value = "戻る";
	document.getElementById("Resume").submit();
}

function shinkitsuika_click(){
	var shainId = document.getElementById("shainId").value;
	document.getElementById("actionId").value = shainId;
	document.getElementById("actionName").value = "新規追加";
	document.getElementById("Resume").submit();
}

function henshu_click(Val){
	var shainId = document.getElementById("shainId").value;
	document.getElementById("actionId").value = shainId;
	var report = Val.parentNode.parentNode.cells[1].innerHTML;
	document.getElementById("actionValue").value = report;
	document.getElementById("actionName").value = "更新";
	document.getElementById("Resume").submit();
}
function sakujo_click(Val){
	var shainId = document.getElementById("shainId").value;
	document.getElementById("actionId").value = shainId;
	var report = Val.parentNode.parentNode.cells[1].innerHTML;
	document.getElementById("actionValue").value = report;
	document.getElementById("actionName").value = "削除";
	document.getElementById("Resume").submit();
}
