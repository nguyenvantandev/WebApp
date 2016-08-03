function kanjiload(){
	var actionVal = document.getElementById("actionVal").value;
	if(actionVal == ""){
		document.getElementById("actionName").value = "0001";
		document.getElementById("kanji").submit();
	}
	var row = document.getElementById("info").getElementsByTagName("tbody")[0].getElementsByTagName("tr").length;
	if(row == 0 && actionVal != ""){
		document.getElementById("info").style.display = 'none';
		document.getElementById("notvalue").style.display = 'block';	
	}
	//var cells = document.getElementById("hiddenTable").getElementsByTagName("tbody")[0].getElementsByTagName("tr")[0].cells[0].innerHTML;
}

function searchClick(){
	document.getElementById("actionName").value = "0002";
	document.getElementById("kanji").submit();
}
function gasuiClick(Val){
	document.getElementById("searchOther").value = Val;
	document.getElementById("actionName").value = "0003";
	document.getElementById("kanji").submit();
}

function levelClick(Val){
	document.getElementById("searchOther").value = Val;
	document.getElementById("actionName").value = "0004";
	document.getElementById("kanji").submit();
}
	function overEvent(val){
	
	
	var rows = document.getElementById("hiddenTable").getElementsByTagName("tbody")[0].getElementsByTagName("tr").length;
	var cells = document.getElementById("hiddenTable").getElementsByTagName("tbody")[0].getElementsByTagName("tr")[0].cells.length;
	var list = new Array();
	for (var i = 0; i < rows; i++){
	var hiddenkanji = document.getElementById("hiddenTable").getElementsByTagName("tbody")[0].getElementsByTagName("tr")[i].cells[0].innerHTML;
	
	if(hiddenkanji == val){
		for(var j = 0; j < cells; j++){
			list.push(document.getElementById("hiddenTable").getElementsByTagName("tbody")[0].getElementsByTagName("tr")[i].cells[j].innerHTML);
		}
		continue;
	}
	}
	document.getElementById("kanjishow").innerHTML = list[0];
	document.getElementById("popuphanviet").innerHTML = list[5].toUpperCase();
	document.getElementById("popupkunyomi").innerHTML = list[1];
	document.getElementById("popuponyomi").innerHTML = list[2];
	document.getElementById("popupgasui").innerHTML = list[3];
	document.getElementById("popuplevel").innerHTML = list[4];
	document.getElementById("popdivdetail").style.display = 'block';
	
}
function outEvent(){
	document.getElementById("popdivdetail").style.display = 'none';
}