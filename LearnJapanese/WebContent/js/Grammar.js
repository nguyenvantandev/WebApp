function BunpoLoad() {
	var loadAction = document.getElementById("loadAction").value;
	if (loadAction == "") {
		document.getElementById("actionId").value = "0001";
		document.getElementById("grammar").submit();
	}
	var row = document.getElementById("info").getElementsByTagName("tbody")[0].getElementsByTagName("tr").length;
	if(row == 0 && loadAction != ""){
		document.getElementById("info").style.display = 'none';
		document.getElementById("notvalue").style.display = 'block';	
	}
}

function bunpoShow(Val) {
	var report = Val.parentNode.parentNode.cells[1].innerHTML;
	var cells = document.getElementById("info").getElementsByTagName("tbody")[0]
			.getElementsByTagName("tr")[0].cells.length;
	var list = new Array;
	for (var i = 1; i < cells; i++) {
		list.push(Val.parentNode.parentNode.cells[i].innerHTML);
	}

	document.getElementById("grammar").innerHTML = list[1] + "+"
			+ list[0].split(". ")[1];
	document.getElementById("meaning").innerHTML = list[2];
	var example = list[3].split("\n");
	document.getElementById("example").innerHTML = example.join("<br>");
	var comment = list[4].split("\n");
	document.getElementById("comment").innerHTML = comment.join("<br>");
	var note = list[5].split("\n");
	document.getElementById("note").innerHTML = note.join("<br>");

	document.getElementById("popdivdetail").style.display = 'block';
	document.getElementById("overwindows").style.display = 'block';
}
function hide(div) {
	document.getElementById("popdivdetail").style.display = 'none';
	document.getElementById("overwindows").style.display = 'none';

}

function searchClick(){
	document.getElementById("actionId").value = "0001";
	document.getElementById("grammar").submit();
}

function levelSearch(Val){
	document.getElementById("level").value = Val;
	document.getElementById("actionId").value = "0001";
	document.getElementById("grammar").submit();
	
}
function otherSearch(val){
	document.getElementById("other").value = val;
	document.getElementById("actionId").value = "0001";
	document.getElementById("grammar").submit();
}