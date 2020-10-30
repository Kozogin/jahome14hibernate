let studentR;
function ready() {
	
	var xhr = new XMLHttpRequest();
	xhr.responseType = 'json';
	xhr.open("GET", "downloadFileThis");
	xhr.onload = function() {
		
		studentR = xhr.response;
		
				
	
	
	var context = 
		'<div class="img">' + 
	'<img src="' + studentR.fileDownloadUri + '" alt="">'+ 
	'</div>' + 
	'<div class=student>' + 
	'<p>First name :  ' + studentR.firstName + '</p>'+ 
	'<p>Last name : '+ studentR.lastName + '</p>' + 
	'<p>Age : ' + studentR.age + '</p>';

	document.getElementById('paste').innerHTML = context;
	
	}	
	xhr.send();
	

}

document.addEventListener("DOMContentLoaded", ready);
