package jmp.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jmp.spring.service.AttachService;
import lombok.Setter;

@Controller
public class FileUploadController {

	//private static final String ROOT_DIR = "C:\\upload\\";

	@Setter(onMethod_ = @Autowired)
	AttachService service;

	@GetMapping("/uploadFormAction")
	public void uploadForm() {
	} // form

	/*
	 * @PostMapping("/uploadFormAction") public void uploadFormPost(MultipartFile[]
	 * uploadFile, int attachNo) {
	 * 
	 * //new page -> attachNo;seq.nextval if(attachNo == 0) { attachNo =
	 * service.sequence(); }
	 * 
	 * 
	 * for (MultipartFile multipartFile : uploadFile) {
	 * log.info("-------------------------------------");
	 * log.info("Upload File Name: " +multipartFile.getOriginalFilename());
	 * log.info("Upload File Size: " +multipartFile.getSize());
	 * log.info("Upload File Size: " +multipartFile.getName());
	 * log.info("-------------------------------------");
	 * 
	 * String uploadPath = getFolder();
	 * log.debug("============================="+uploadPath);
	 * 
	 * UUID uuid = UUID.randomUUID();//create uuid(unique) String uploadFileName =
	 * uuid.toString() + "_" + multipartFile.getOriginalFilename();
	 * log.debug("============================================"+uploadFileName);
	 * 
	 * //save file File saveFile = new File(ROOT_DIR+uploadPath,uploadFileName);
	 * 
	 * try { multipartFile.transferTo(saveFile); //search file type String
	 * contentType = Files.probeContentType(saveFile.toPath());
	 * 
	 * if(contentType.startsWith("image")) { // create thumbnail String
	 * thumbnailPath = ROOT_DIR+uploadPath + "s_"+ uploadFileName;
	 * Thumbnails.of(saveFile).size(100,100).toFile(thumbnailPath); }
	 * 
	 * } catch (Exception e) {log.error(e.getMessage());}
	 * 
	 * } }//upload process
	 */
	/**
	 * 중복 방지용 업로드 날짜를 업로드 경로로 지정 경로에 폴더가 없다면 해당 폴더 생성
	 * 
	 * @return uploadPath
	 */
	/*
	 * private String getFolder() { //today(yyyy-MM-dd) SimpleDateFormat format =
	 * new SimpleDateFormat("yyyy-MM-dd"); String str = format.format(new Date());
	 * 
	 * log.debug(str); String uploadPath = str.replace("-", File.separator) +
	 * File.separator;// yyyy\\MM\\dd\\(뒤에 추가하기 위해 하나 더 추가, 빼먹더라도 method에서 처리하면 되는데
	 * 파일마다 처리하는건 비효율적); File saveFile = new File(ROOT_DIR , uploadPath); //경로가 존재하지
	 * 않으면 해당 경로 생성 if(!saveFile.exists()) saveFile.mkdirs();
	 * 
	 * return uploadPath; }//make path
	 */}
