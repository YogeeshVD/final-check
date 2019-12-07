// Include form validation functions here
function validate() {
		var titl = document.forms["form1"]["txtTitle"].value;
		var bxoffice = document.forms["form1"]["txtPrice"].value;
		var dol= document.forms["form1"]["txtDol"].value;
		
		if(titl.trim()=="") {
			alert(" Title is required.");
			return false;
			
		} else if( bxoffice.trim()=="") {
			alert(" Box is required.");
			return false;
			
		}else if(dol.trim()=="") {
			alert(" Date of Launch is required");
			return false;
		}else {
		 true;
		}
		
		if(/[^0-9/]/.test(dol)) {
			alert("Date is to be a number");
			return false;
		} else {
			true;
		}
		
		if(/[^0-9]/.test(bxoffice)) {
			alert("Box is to be a number");
			return false;
		} else {
			true;
		}
		
		

		if(titl.length <2 || nam.length >100) {
			alert("Title should have 2-100 characters");
			return false; 
		} else {
			true;
		}
	}

	