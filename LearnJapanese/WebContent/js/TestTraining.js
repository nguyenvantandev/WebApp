function chooseLv(val) {
	document.getElementById("levelList").style.display = 'none';
	document.getElementById("backdiv").style.display = 'block';
	document.getElementById("testItem").style.display = 'block';
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

		lable.textContent = (hours ? (hours > 9 ? hours : "0" + hours) : "00")
				+ ":"
				+ (minutes ? (minutes > 9 ? minutes : "0" + minutes) : "00")
				+ ":" + (seconds > 9 ? seconds : "0" + seconds);

		if (minutes == "30") {
			clearTimeout(t);
		} else {
			timer();
		}
	}
	function timer() {
		t = setTimeout(add, 1000);
	}
	timer();
}

function backitemEvent() {
	document.getElementById("testItem").style.display = 'block';
	document.getElementById("backdiv").style.display = 'block';
	document.getElementById("testExam").style.display = 'none';
	document.getElementById("backitemdiv").style.display = 'none';
}
