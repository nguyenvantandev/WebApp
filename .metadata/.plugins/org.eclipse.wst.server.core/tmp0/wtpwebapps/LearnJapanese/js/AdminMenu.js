function addRow(dataTable) {

	/*
	 * VocabularyInsertTable
	 */
	if(dataTable == "0001"){
		var table = document.getElementById("VocabularyInsertTable");

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var cell1 = row.insertCell(0);
		var element1 = document.createElement("input");
		element1.type = "checkbox";
		element1.name = "chkbox[]";
		cell1.appendChild(element1);

		var cell2 = row.insertCell(1);
		cell2.innerHTML = rowCount;

		var cell3 = row.insertCell(2);
		var element2 = document.createElement("input");
		element2.type = "text";
		element2.name = "txtbox[]";
		cell3.appendChild(element2);

		var cell4 = row.insertCell(3);
		var element3 = document.createElement("input");
		element3.type = "text";
		element3.name = "txtbox[]";
		cell4.appendChild(element3);

		var cell5 = row.insertCell(4);
		var element4 = document.createElement("input");
		element4.type = "text";
		element4.name = "txtbox[]";
		cell5.appendChild(element4);

		var cell6 = row.insertCell(5);
		var element5 = document.createElement("input");
		element5.type = "text";
		element5.name = "txtbox[]";
		cell6.appendChild(element5);

		var cell7 = row.insertCell(6);
		var element6 = document.createElement("input");
		element6.type = "text";
		element6.name = "txtbox[]";
		cell7.appendChild(element6);

		var cell8 = row.insertCell(7);
		var element7 = document.createElement("input");
		element7.type = "text";
		element7.name = "txtbox[]";
		cell8.appendChild(element7);
	}
	/*
	 * KanjiInsertTable
	 */
	if(dataTable == "0002"){
		var table = document.getElementById("KanjiInsertTable");

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var cell1 = row.insertCell(0);
		var element1 = document.createElement("input");
		element1.type = "checkbox";
		element1.name = "chkbox[]";
		cell1.appendChild(element1);

		var cell2 = row.insertCell(1);
		cell2.innerHTML = rowCount;

		var cell3 = row.insertCell(2);
		var element2 = document.createElement("input");
		element2.type = "text";
		element2.name = "txtbox[]";
		cell3.appendChild(element2);

		var cell4 = row.insertCell(3);
		var element3 = document.createElement("input");
		element3.type = "text";
		element3.name = "txtbox[]";
		cell4.appendChild(element3);

		var cell5 = row.insertCell(4);
		var element4 = document.createElement("input");
		element4.type = "text";
		element4.name = "txtbox[]";
		cell5.appendChild(element4);

		var cell6 = row.insertCell(5);
		var element5 = document.createElement("input");
		element5.type = "text";
		element5.name = "txtbox[]";
		cell6.appendChild(element5);

		var cell7 = row.insertCell(6);
		var element6 = document.createElement("input");
		element6.type = "text";
		element6.name = "txtbox[]";
		cell7.appendChild(element6);

		var cell8 = row.insertCell(7);
		var element7 = document.createElement("input");
		element7.type = "text";
		element7.name = "txtbox[]";
		cell8.appendChild(element7);
	}
	/*
	 * GrammarInsertTable
	 */
	if(dataTable == "0003"){
		var table = document.getElementById("GrammarInsertTable");

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var cell1 = row.insertCell(0);
		var element1 = document.createElement("input");
		element1.type = "checkbox";
		element1.name = "chkbox[]";
		cell1.appendChild(element1);

		var cell2 = row.insertCell(1);
		cell2.innerHTML = rowCount;

		var cell3 = row.insertCell(2);
		var element2 = document.createElement("input");
		element2.type = "text";
		element2.name = "txtbox[]";
		cell3.appendChild(element2);

		var cell4 = row.insertCell(3);
		var element3 = document.createElement("input");
		element3.type = "text";
		element3.name = "txtbox[]";
		cell4.appendChild(element3);

		var cell5 = row.insertCell(4);
		var element4 = document.createElement("input");
		element4.type = "text";
		element4.name = "txtbox[]";
		cell5.appendChild(element4);

		var cell6 = row.insertCell(5);
		var element5 = document.createElement("input");
		element5.type = "text";
		element5.name = "txtbox[]";
		cell6.appendChild(element5);

		var cell7 = row.insertCell(6);
		var element6 = document.createElement("input");
		element6.type = "text";
		element6.name = "txtbox[]";
		cell7.appendChild(element6);

		var cell8 = row.insertCell(7);
		var element7 = document.createElement("input");
		element7.type = "text";
		element7.name = "txtbox[]";
		cell8.appendChild(element7);
		
		var cell9 = row.insertCell(8);
		var element8 = document.createElement("input");
		element8.type = "text";
		element8.name = "txtbox[]";
		cell9.appendChild(element8);
		
		var cell10 = row.insertCell(9);
		var element9 = document.createElement("input");
		element9.type = "text";
		element9.name = "txtbox[]";
		cell10.appendChild(element9);
	}
	/*
	 * GrammarInsertTable
	 */
	if(dataTable == "0004"){
		var table = document.getElementById("TestInsertTable");

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var cell1 = row.insertCell(0);
		var element1 = document.createElement("input");
		element1.type = "checkbox";
		element1.name = "chkbox[]";
		cell1.appendChild(element1);

		var cell2 = row.insertCell(1);
		cell2.innerHTML = rowCount;

		var cell3 = row.insertCell(2);
		var element2 = document.createElement("input");
		element2.type = "text";
		element2.name = "txtbox[]";
		cell3.appendChild(element2);

		var cell4 = row.insertCell(3);
		var element3 = document.createElement("input");
		element3.type = "text";
		element3.name = "txtbox[]";
		cell4.appendChild(element3);

		var cell5 = row.insertCell(4);
		var element4 = document.createElement("input");
		element4.type = "text";
		element4.name = "txtbox[]";
		cell5.appendChild(element4);

		var cell6 = row.insertCell(5);
		var element5 = document.createElement("input");
		element5.type = "text";
		element5.name = "txtbox[]";
		cell6.appendChild(element5);

		var cell7 = row.insertCell(6);
		var element6 = document.createElement("input");
		element6.type = "text";
		element6.name = "txtbox[]";
		cell7.appendChild(element6);

		var cell8 = row.insertCell(7);
		var element7 = document.createElement("input");
		element7.type = "text";
		element7.name = "txtbox[]";
		cell8.appendChild(element7);
		
		var cell9 = row.insertCell(8);
		var element8 = document.createElement("input");
		element8.type = "text";
		element8.name = "txtbox[]";
		cell9.appendChild(element8);
		
		var cell10 = row.insertCell(9);
		var element9 = document.createElement("input");
		element9.type = "text";
		element9.name = "txtbox[]";
		cell10.appendChild(element9);
		
		var cell11 = row.insertCell(10);
		var element10 = document.createElement("input");
		element10.type = "text";
		element10.name = "txtbox[]";
		cell11.appendChild(element10);
		
		var cell12 = row.insertCell(11);
		var element11 = document.createElement("input");
		element11.type = "text";
		element11.name = "txtbox[]";
		cell12.appendChild(element11);
	}


}

function deleteRow(dataTable) {
	try {
		var table = document.getElementById(dataTable);
		var rowCount = table.rows.length;

		for (var i = 0; i < rowCount; i++) {
			var row = table.rows[i];
			var chkbox = row.cells[0].childNodes[0];
			if (null != chkbox && true == chkbox.checked) {
				table.deleteRow(i);
				rowCount--;
				i--;
			}

		}
	} catch (e) {
		alert(e);
	}
}


function VocabularyInsertClick(){
	document.getElementById("VocabularyInsert").style.display = 'block';
	document.getElementById("VocabularyUpdate").style.display = 'none';
	
	document.getElementById("KanjiInsert").style.display = 'none';
	document.getElementById("KanjiUpdate").style.display = 'none';
	
	document.getElementById("GrammarInsert").style.display = 'none';
	document.getElementById("GrammarUpdate").style.display = 'none';
	
	document.getElementById("TestInsert").style.display = 'none';
	document.getElementById("TestUpdate").style.display = 'none';
	
}
function VocabularyUpdateClick(){
	document.getElementById("VocabularyInsert").style.display = 'none';
	document.getElementById("VocabularyUpdate").style.display = 'block';
	
	document.getElementById("KanjiInsert").style.display = 'none';
	document.getElementById("KanjiUpdate").style.display = 'none';
	
	document.getElementById("GrammarInsert").style.display = 'none';
	document.getElementById("GrammarUpdate").style.display = 'none';
	
	document.getElementById("TestInsert").style.display = 'none';
	document.getElementById("TestUpdate").style.display = 'none';
	
}
function KanjiInsertClick(){
	document.getElementById("VocabularyInsert").style.display = 'none';
	document.getElementById("VocabularyUpdate").style.display = 'none';
	
	document.getElementById("KanjiInsert").style.display = 'block';
	document.getElementById("KanjiUpdate").style.display = 'none';
	
	document.getElementById("GrammarInsert").style.display = 'none';
	document.getElementById("GrammarUpdate").style.display = 'none';
	
	document.getElementById("TestInsert").style.display = 'none';
	document.getElementById("TestUpdate").style.display = 'none';
}

function KanjiUpdateClick(){
	document.getElementById("VocabularyInsert").style.display = 'none';
	document.getElementById("VocabularyUpdate").style.display = 'none';
	
	document.getElementById("KanjiInsert").style.display = 'none';
	document.getElementById("KanjiUpdate").style.display = 'block';
	
	document.getElementById("GrammarInsert").style.display = 'none';
	document.getElementById("GrammarUpdate").style.display = 'none';
	
	document.getElementById("TestInsert").style.display = 'none';
	document.getElementById("TestUpdate").style.display = 'none';
}

function GrammarInsertClick(){
	document.getElementById("VocabularyInsert").style.display = 'none';
	document.getElementById("VocabularyUpdate").style.display = 'none';
	
	document.getElementById("KanjiInsert").style.display = 'none';
	document.getElementById("KanjiUpdate").style.display = 'none';
	
	document.getElementById("GrammarInsert").style.display = 'block';
	document.getElementById("GrammarUpdate").style.display = 'none';
	
	document.getElementById("TestInsert").style.display = 'none';
	document.getElementById("TestUpdate").style.display = 'none';
}

function GrammarUpdateClick(){
	document.getElementById("VocabularyInsert").style.display = 'none';
	document.getElementById("VocabularyUpdate").style.display = 'none';
	
	document.getElementById("KanjiInsert").style.display = 'none';
	document.getElementById("KanjiUpdate").style.display = 'none';
	
	document.getElementById("GrammarInsert").style.display = 'none';
	document.getElementById("GrammarUpdate").style.display = 'block';
	
	document.getElementById("TestInsert").style.display = 'none';
	document.getElementById("TestUpdate").style.display = 'none';
}

function TestInsertClick(){
	document.getElementById("VocabularyInsert").style.display = 'none';
	document.getElementById("VocabularyUpdate").style.display = 'none';
	
	document.getElementById("KanjiInsert").style.display = 'none';
	document.getElementById("KanjiUpdate").style.display = 'none';
	
	document.getElementById("GrammarInsert").style.display = 'none';
	document.getElementById("GrammarUpdate").style.display = 'none';
	
	document.getElementById("TestInsert").style.display = 'block';
	document.getElementById("TestUpdate").style.display = 'none';
}

function TestUpdateClick(){
	document.getElementById("VocabularyInsert").style.display = 'none';
	document.getElementById("VocabularyUpdate").style.display = 'none';
	
	document.getElementById("KanjiInsert").style.display = 'none';
	document.getElementById("KanjiUpdate").style.display = 'none';
	
	document.getElementById("GrammarInsert").style.display = 'none';
	document.getElementById("GrammarUpdate").style.display = 'none';
	
	document.getElementById("TestInsert").style.display = 'none';
	document.getElementById("TestUpdate").style.display = 'block';
}
// Val.parentNode.parentNode.cells[1].innerHTML;
