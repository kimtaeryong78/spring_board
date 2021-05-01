package jmp.spring.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class FileUploadController {
	@PostMapping("/uploadFormAction")
	public void uploadProcess(MultipartFile[] uploadFile) {
		for(MultipartFile multipartFile : uploadFile) {
			File saveFile = new File(multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(saveFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			log.info("===========================Upload File Name : " + multipartFile.getOriginalFilename());
			log.info("===========================Upload File Size : " + multipartFile.getSize());
		}
	}
	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("upload form=============================");
	}
}
