function SkillListUpdate_load(){
	var shikakuId = document.getElementById("shikakuId").value;
	var shikakumei = document.getElementById("shikakumei").value;
	var firstSearch = document.getElementById("skillListFrom_shikakuId").value;
	
	if(shikakuId != "null"){
		document.getElementById("shikakuId").value = shikakuId;
		document.getElementById("SkillListUpdate").submit();
	}else{
		document.getElementById("shikakuId").value = "";
	}
	if(shikakumei != "null"){
		document.getElementById("shikakumei").value = shikakumei;
	}else{
		document.getElementById("shikakumei").value = "";
	}
	if(firstSearch != "null"){
		document.getElementById("shikakuId").value = firstSearch;
		document.getElementById("SkillListUpdate").submit();
	}
	
}