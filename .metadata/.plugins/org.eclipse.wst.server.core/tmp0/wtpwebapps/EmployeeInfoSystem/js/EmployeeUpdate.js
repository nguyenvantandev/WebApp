function employeeUpdate_load(){
	//Set Day => Start
	var nowyear = new Date().getFullYear();
	var startyear = 2020;
	var endyear = 1950;
	var optionsyear = "";
	for (var year = startyear; year >= endyear; year--) {
		optionsyear += "<option>" + year + "</option>";
	}
	document.getElementsByName("year")[0].innerHTML = optionsyear;
	//var year = $("#year")[0].value;
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
//	var month = $("#month_id")[0].value;
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
//	var day = $("#day_id")[0].value;
	$('#day').val("");
	//Set Day => End
	
	
	var shainId = document.getElementById("shaiNum").value;
	if(shainId != "null"){
		document.getElementById("shaiNum").value = shainId;
		document.getElementById("shainId").disabled = true;
		document.getElementById("addUpdate").value = "更新";
		document.getElementById("employeeUpdate").submit();
	}
}