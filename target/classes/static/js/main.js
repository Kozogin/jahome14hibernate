var singleUploadForm = document.querySelector('#singleUploadForm');
var singleFileUploadInput = document.querySelector('#singleFileUploadInput');
var singleFileUploadError = document.querySelector('#singleFileUploadError');
var singleFileUploadSuccess = document
		.querySelector('#singleFileUploadSuccess');
var uploadBool = false;

var fileDownUri;


function resetForm(){
	for (var i = 0; i < singleUploadForm.elements.length; i++) {		
		var elemUser = singleUploadForm.elements[i];		
		if(elemUser.type == "text"){
			elemUser.value = "";
		} 
		if(elemUser.type == "file"){
			elemUser.value = "";
		}
	}
}


function uploadSingleFile(file) {
	
	var formData = new FormData();
	formData.append("file", file);	
	

	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/uploadFile");

	xhr.onload = function() {
		console.log(xhr.responseText);
		var response = JSON.parse(xhr.responseText);
		if (xhr.status == 200) {

			fileDownUri = response.fileDownloadUri;
			
			
			document.getElementsByClassName('submit_b')[0].innerHTML = "Success";
			
		} else {
			
			document.getElementsByClassName('submit_b')[0].innerHTML = "Try again";
		}
	}

	xhr.send(formData);	
}


function readFormRegistration(){
	
	var firstName = document.querySelector('#firstName').value;
	var lastName = document.querySelector('#lastName').value;
	var age = document.querySelector('#age').value;
	
	if (age == '' || firstName == '' || lastName == "") {
		alert("Please fill all fields...!!!!!!");
		uploadBool = false;
	} else {
		
		uploadBool = true;
	
	var userData = {
			firstName: firstName,
			lastName: lastName,
			age: age
			
	};
	
		var xhr = new XMLHttpRequest();
		xhr.open("POST", "/registration");
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.send(JSON.stringify(userData));
	}
}

review.onclick = function(event) {
	resetForm();
	document.getElementsByClassName('submit_b')[0].innerHTML = "Submit";
		
	var fileId = "";
	var urlContent = fileDownUri.split('/');
	
	fileId = urlContent[urlContent.length-1];
	
	var formData = new FormData();
	formData.append("fileId", fileId);	
	var xhr = new XMLHttpRequest();
	xhr.open("GET", fileDownUri);
		
	xhr.send(formData);
}


singleUploadForm.addEventListener('submit', function(event) {
	uploadBool = true;
	var files = singleFileUploadInput.files;
	if (files.length === 0) {
		singleFileUploadError.innerHTML = "Please select a file";
		singleFileUploadError.style.display = "block";
	}
	
	setTimeout(function() {
		readFormRegistration();
	}, 0);
	
	setTimeout(function() {
		(uploadBool && uploadSingleFile(files[0]));
		uploadBool = true;
	}, 0);	
	
	event.preventDefault();
}, true);
