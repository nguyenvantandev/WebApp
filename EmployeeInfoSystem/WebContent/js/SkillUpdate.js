//function pop(div) {
//	document.getElementById(div).style.display = 'block';
//}
function hide(div) {
	document.getElementById(div).style.display = 'none';
}

function SkillUpdate_load(){
	
	/*
	 * 生年月日 日付設定 ↓
	 */
	var nowyear = new Date().getFullYear();
	var startyear = 2020;
	var endyear = 1950;
	var optionsyear = "";
	for (var year = startyear; year >= endyear; year--) {
		optionsyear += "<option>" + year + "</option>";
	}
	document.getElementsByName("year")[0].innerHTML = optionsyear;
	$('#year').val("");
	// month
	var startmonth = 1;
	var endmonth = 12;
	var optionsmonth = "";
	for (var month = startmonth; month <= endmonth; month++) {
		if (month <= 9) {
			month = "0" + month.toString();
		}
		optionsmonth += "<option>" + month + "</option>";
	}
	document.getElementsByName("month")[0].innerHTML = optionsmonth;
	$('#month').val("");
	// day
	var startday = 1;
	var endday = 31;
	var optionsday = "";
	for (var day = startday; day <= endday; day++) {
		if (day <= 9) {
			day = "0" + day.toString();
		}
		optionsday += "<option>" + day + "</option>";
	}
	document.getElementsByName("day")[0].innerHTML = optionsday;
	$('#day').val("");
	/*
	 * 生年月日 日付設定 ↑
	 */

	
	
	/*
	 * 生年月日 日付設定 ↓
	 */
	var nowyear = new Date().getFullYear();
	var startyear = 2020;
	var endyear = 1950;
	var optionsyear = "";
	for (var year = startyear; year >= endyear; year--) {
		optionsyear += "<option>" + year + "</option>";
	}
	document.getElementsByName("upd_year")[0].innerHTML = optionsyear;
	$('#upd_year').val("");
	// month
	var startmonth = 1;
	var endmonth = 12;
	var optionsmonth = "";
	for (var month = startmonth; month <= endmonth; month++) {
		if (month <= 9) {
			month = "0" + month.toString();
		}
		optionsmonth += "<option>" + month + "</option>";
	}
	document.getElementsByName("upd_month")[0].innerHTML = optionsmonth;
	$('#upd_month').val("");
	// day
	var startday = 1;
	var endday = 31;
	var optionsday = "";
	for (var day = startday; day <= endday; day++) {
		if (day <= 9) {
			day = "0" + day.toString();
		}
		optionsday += "<option>" + day + "</option>";
	}
	document.getElementsByName("upd_day")[0].innerHTML = optionsday;
	$('#upd_day').val("");
	/*
	 * 生年月日 日付設定 ↑
	 */
	
	
	
	
	
	
	var shikakuId = document.getElementById("shainId").value;
	var namae = document.getElementById("namae").value;
	if(shikakuId != "null"){
		document.getElementById("shainId").disabled = true;
		document.getElementById("shainId").value = shikakuId;
	}else{
		document.getElementById("shainId").value = "";
	}
	if(namae != "null"){
		document.getElementById("namae").disabled = true;
		document.getElementById("namae").value= namae;
	}else{
		document.getElementById("namae").value = "";
	}
	var id = document.getElementById("zengamen_shainId").value;
	if(id != "null"){
		document.getElementById("actionName").value = "初期表示";
		document.getElementById("actionValue").value = id;
		document.getElementById("SkillUpdate").submit();
	}
}

function popupKoshin_click(Val){
	
	var shikakuname = Val.parentNode.parentNode.cells[2].innerHTML;
	var shutokudate = Val.parentNode.parentNode.cells[3].innerHTML;
	var seiseki = Val.parentNode.parentNode.cells[4].innerHTML;
	var junban = Val.parentNode.parentNode.cells[0].innerHTML;
	document.getElementById("upd_shikakumei").value = shikakuname;
	document.getElementById("upd_shikakumei").disabled = true;
	document.getElementById("upd_seiseki").value = seiseki;
	document.getElementById("upd_houjijun")[0].innerHTML = junban;
	var res = shutokudate.split("-");
	$('#upd_year').val(res[0]);
	$('#upd_month').val(res[1]);
	$('#upd_day').val(res[2]);
	document.getElementById("popDivUpdate").style.display = 'block';
}

function popupTsuika_click(){
	document.getElementById("popDivAdd").style.display = 'block';
}



