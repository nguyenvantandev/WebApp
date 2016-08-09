function loginClick(){
	var user = document.getElementById("user").value;
	var pass = document.getElementById("pass").value;
	if(user == ""){
		alert("ユーザーを入力してください");
		return false;
	}
	if(pass == ""){
		alert("パスワードを入力してください");
		return false;
	}
	document.getElementById("login").submit();
}

function loadpage(){
	var message = document.getElementById("message").value;
	if(message != ""){
		alert(message);
		return false;
	}
}