package ua.lviv.lgs.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.domain.FileMultipart;
import ua.lviv.lgs.domain.Student;
import ua.lviv.lgs.repository.FileMultipartRepository;

@Service
public class FileMultipartService {	

	@Autowired
	private FileMultipartRepository fileMultipartRepository;

	public FileMultipart storeFile(Student student, MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileMultipart multipart = null;

		if (!fileName.contains("..")) {
			multipart = new FileMultipart(fileName, file.getContentType(), file.getBytes());
		}
		if(student != null) {
			multipart.setStudent(student);
			return fileMultipartRepository.save(multipart);
		}
		return null;
	}

	public FileMultipart getFile(String fileId) throws FileNotFoundException {
		
//		System.out.println(fileMultipartRepository.findById(fileId).get());
//		System.out.println(fileMultipartRepository.findById(fileId).get().getStudent());
		
		return fileMultipartRepository.findById(fileId)
				.orElseThrow(() -> new FileNotFoundException("File not found with Id =" + fileId));
	}
}
