function kanjiload(){
	var actionVal = document.getElementById("actionVal").value;
	if(actionVal == ""){
		document.getElementById("actionName").value = "初期表示";
		document.getElementById("kanji").submit();
	}
	
}