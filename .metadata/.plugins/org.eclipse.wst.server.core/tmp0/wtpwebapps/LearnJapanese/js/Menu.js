function menuload(){
	var action = document.getElementById("actionVal").value;
	if(action == ""){
		document.getElementById("menu").submit();
	}else {
		document.getElementById("actionVal").value = action;
	}
	
}

//.style.display = 'block';
function honyaku(){
	document.getElementById("news").style.display = 'none';
	document.getElementById("honyaku").style.display = 'none';
	document.getElementById("honyakupan").style.display = 'block';
	document.getElementById("honnpan").style.display = 'block';
}

function honpan(){
	document.getElementById("news").style.display = 'block';
	document.getElementById("honyaku").style.display = 'block';
	document.getElementById("honyakupan").style.display = 'none';
	document.getElementById("honnpan").style.display = 'none';
}