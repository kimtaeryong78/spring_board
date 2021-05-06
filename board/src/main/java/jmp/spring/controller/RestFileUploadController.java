package jmp.spring.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class RestFileUploadController {
	
	@PostMapping("/fileUploadAjax")
	public void fileUpload(MultipartFile[] uploadFile) {
		for(MultipartFile file : uploadFile) {
			String originName = file.getOriginalFilename();
			String name = file.getName();
			long size = file.getSize();
			log.info("===============================================================");
			log.info(originName);
			log.info(name);
			log.info(size);
			File saveFile = new File(file.getOriginalFilename());
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
