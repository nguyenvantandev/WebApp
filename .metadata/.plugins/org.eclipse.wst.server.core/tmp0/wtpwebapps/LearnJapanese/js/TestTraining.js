function chooseLv(val) {
	document.getElementById("levelList").style.display = 'none';
	document.getElementById("backdiv").style.display = 'block';
	document.getElementById("testItem").style.display = 'block';
	document.getElementById("levelchoosed").value = val;
}

function backEvent() {
	document.getElementById("levelList").style.display = 'block';
	document.getElementById("backdiv").style.display = 'none';
	document.getElementById("testItem").style.display = 'none';
}

function chooseItem(val) {
	document.getElementById("testItem").style.display = 'none';
	document.getElementById("backdiv").style.display = 'none';
	document.getElementById("testExam").style.display = 'block';
	document.getElementById("backitemdiv").style.display = 'block';
	document.getElementById("itemchoosed").value = val;
	document.getElementById("testTraining").submit();
}

function backitemEvent() {
	document.getElementById("testItem").style.display = 'block';
	document.getElementById("backdiv").style.display = 'block';
	document.getElementById("testExam").style.display = 'none';
	document.getElementById("backitemdiv").style.display = 'none';
}

function loadpage() {
	
	var val = document.getElementById("showpage").value;
	if (val == "") {
		document.getElementById("levelList").style.display = 'block';
	} else {
		document.getElementById("testExam").style.display = 'block';
		document.getElementById("backitemdiv").style.display = 'block';
		
		var lens = $('div.testInfo').length;
		var timelimit = "0";
		if(lens <= 9){
			timelimit = "0"+ lens;
		}else{
			timelimit = lens;
		}
		document.getElementById("time").innerHTML = timelimit;
		var lable = document.getElementsByTagName('label')[0], seconds = 0, minutes = 0, hours = 0, t;
		function add() {
			seconds++;
			if (seconds >= 60) {
				seconds = 0;
				minutes++;
				if (minutes >= 60) {
					minutes = 0;
					hours++;
				}
			}

			lable.textContent = (hours ? (hours > 9 ? hours : "0" + hours)
					: "00")
					+ ":"
					+ (minutes ? (minutes > 9 ? minutes : "0" + minutes) : "00")
					+ ":" + (seconds > 9 ? seconds : "0" + seconds);

			if (minutes == timelimit) {
				clearTimeout(t);
				$("input[type=radio]").attr('disabled', true);
				document.getElementById("resultlink").style.visibility = "hidden";
				var len = $('div.resultDiv').length;
				for (var i = 0; i < len; i++) {
					document.all("resultDiv", i).style.display = 'block';
				}
			} else {
				timer();
			}
		}
		function timer() {
			t = setTimeout(add, 1000);
		}
		timer();

	}
}

function resultshow() {
	var len = $('div.resultDiv').length;
	for (var i = 0; i < len; i++) {
		document.all("resultDiv", i).style.display = 'block';
	}

}

function detailshow() {
	var len = $('div.testInfo').length;
	for (var i = 0; i < len; i++) {
		document.all("resultquestion", i).style.display = 'block';
		document.all("question", i).style.display = 'none';
	}

}

function checkresult(val) {
	var len = document.getElementsByName(val);
	var getVal;
	for (var i = 0; i < len.length; i++) {
		if (len[i].checked) {
			var id = 1 + i;
			getVal = document.getElementById("choosed" + id).value;
		}
		document.getElementById(val).value = getVal;
	}
	var corectResult = document.getElementById("corectresult" + val).value;
	if (getVal == corectResult) {
		document.getElementById("resultval" + val).innerHTML = "回答： "
				+ corectResult + " 正解";
		document.getElementById("resultval" + val).style.color = "blue";
	} else {
		document.getElementById("resultval" + val).innerHTML = "回答： "
				+ corectResult + " 間違い";
		document.getElementById("resultval" + val).style.color = "red";
	}
}
