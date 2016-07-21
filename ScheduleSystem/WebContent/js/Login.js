function numberonly(){
	var m = String.fromCharCode(event.keyCode);
	  if("0123456789\b\r".indexOf(m, 0) < 0) return false;
	  return true;
}
function keychk(){
	var m = String.fromCharCode(event.keyCode);
		var regex = /^[A-Za-z0-9]+$/;
	 if (!m.match(regex)) {
		 return false;
		 }
		 return true;
	}
function loginload(){
	var ErrMsg = document.getElementById("ErrMsg").value;
	var userid = document.getElementById("userid").value;
	document.getElementById("password").value = "";
	if(ErrMsg == "null"){
		document.getElementById("error").style.display = "none";
	}
	if(ErrMsg != "null"){
		document.getElementById("error").style.display = "visible";
	}
	if(userid == "null"){
		document.getElementById("userid").value = "";
	}
	else{
		document.getElementById("userid").value = username;
	}
	
}
function logincalendar(){
	document.getElementById("login").submit();
}
function closeWindow(){
	window.open('','_self', '').close();
}