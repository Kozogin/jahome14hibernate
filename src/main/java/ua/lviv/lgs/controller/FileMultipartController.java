package ua.lviv.lgs.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ua.lviv.lgs.domain.FileMultipart;
import ua.lviv.lgs.domain.Student;
import ua.lviv.lgs.dto.MultipartUploadResponse;
import ua.lviv.lgs.service.FileMultipartService;


@RestController
public class FileMultipartController {

	@Autowired
	private FileMultipartService fileMultipartService;
	private FileMultipart fileMultipartThis;
	private Student student;
	private String fileDownloadUriThis;
	
	@RequestMapping(value="/registration" , method = RequestMethod.POST)
	public @ResponseBody MultipartUploadResponse registration(@RequestBody Student students) {		
		student = students;				
		return null;		
	}
		

	@PostMapping("/uploadFile")
	public MultipartUploadResponse uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
				
		FileMultipart fileMultipart = fileMultipartService.storeFile(student, file);
		

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileMultipart.getId()).toUriString();
		
		fileDownloadUriThis = fileDownloadUri;

		return new MultipartUploadResponse(student.getFirstName() ,student.getLastName() ,student.getAge() 
				,fileMultipart.getFileName(), fileDownloadUri, file.getContentType(),
				file.getSize());
	}

	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<Resource> downlaodFile(@PathVariable String fileId) throws FileNotFoundException {

		FileMultipart fileMultipart = fileMultipartService.getFile(fileId);		
		fileMultipartThis = fileMultipart;
		
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileMultipart.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileMultipart.getFileName() + "\"")
				.body(new ByteArrayResource(fileMultipart.getData()));
	}
	
	@GetMapping("/downloadFileThis")
	public MultipartUploadResponse downloadFileThis() {
		
		return new MultipartUploadResponse(fileMultipartThis.getStudent().getFirstName(), 
				fileMultipartThis.getStudent().getLastName(), fileMultipartThis.getStudent().getAge(), 
				fileMultipartThis.getFileName(), fileDownloadUriThis, 
				fileMultipartThis.getFileType(), 0);
		
	}
	
	
//	@GetMapping("/downloadFileString")
//	public String downlaodFileString() throws FileNotFoundException {
//
//		System.out.println("uuuuuuuuuuueeeeeeeeee");
//		return "success";
//	}

}


//@RequestMapping(value = "/registration", method = RequestMethod.POST)
//public ModelAndView registration(
//		//@RequestParam MultipartFile image, 
//		@RequestParam String firstName, 
//		@RequestParam String lastName, 
//		@RequestParam Integer age) throws IOException {		
//	
//	System.out.println(firstName + lastName + age);
//	
//	//periodicalsService.save(PeriodicalsDTOHelper.createEntity(image, name, description, price));
//	return  null;// new ModelAndView("redirect:/home");
//}




//@ModelAttribute("students")
//public Student getStudent(HttpServletRequest request) 
//{
//	Student s = (Student) request.getAttribute("students");
//	System.out.println("getStudent" + s);
//    return s;
//}


//@PostMapping("/registration")
//public @ResponseBody MultipartUploadResponse registrationStudent(@RequestParam("students") Student students) {
//	
//	System.out.println(students);
//	return null;		
//}

