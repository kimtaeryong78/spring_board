package jmp.spring.controller;

import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jmp.spring.service.AttachService;
import jmp.spring.vo.AttachFileVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnails;

@RestController
@Log4j
public class AjaxFileUploadController {
	
	private static final String ROOT_DIR = "C:\\upload\\";
	
	@Setter(onMethod_ = @Autowired)
	AttachService service;
	
	/**
	 * get list
	 * @param attachNo
	 * @return
	 */
	@GetMapping("/getList/{attachNo}")
	public List<AttachFileVO> getList(@PathVariable("attachNo") int attachNo){
		return service.getList(attachNo);
	}//get list
	
	/**
	 * upload
	 * @param uploadFile
	 * @param attachNo
	 * @return
	 */
	@PostMapping("/ajaxFileUpload")
	public List<AttachFileVO> upload(MultipartFile[] uploadFile, int attachNo) {
		//new page -> attachNo;seq.nextval
		if(attachNo == 0) attachNo = service.sequence();
				
		for (MultipartFile file : uploadFile) {
			
			String uploadPath = getFolder();
			
			UUID uuid = UUID.randomUUID();//create uuid(unique)
			String uploadFileName = uuid.toString() + "_" + file.getOriginalFilename();
			
			File saveFile = new File(ROOT_DIR+uploadPath,uploadFileName);
			
			//save file
			try {
				file.transferTo(saveFile);
				//search file type
				String contentType = Files.probeContentType(saveFile.toPath());
				
				if(contentType.startsWith("image")) {
					// create thumbnail
					String thumbnailPath = ROOT_DIR+uploadPath + "s_"+ uploadFileName;
					Thumbnails.of(saveFile).size(100,100).toFile(thumbnailPath);
				}
				
				AttachFileVO vo = new AttachFileVO();
				
				vo.setUuid(uuid.toString());
				vo.setAttachNo(attachNo);
				vo.setFileName(file.getOriginalFilename());
				vo.setFileType(contentType.startsWith("image")?"Y":"N");
				vo.setUploadPath(uploadPath);
				
				service.insert(vo);
			} catch (Exception e) {log.error(e.getMessage());}
		}//for
		
		List<AttachFileVO> list = service.getList(attachNo);
		return list;
	}//upload process
	
	/**
	 * download
	 * @param fileName
	 * @return
	 */
	@GetMapping("/download")
	public ResponseEntity<byte[]> download(String fileName) {
		File file = new File(ROOT_DIR+fileName);
		try {
			if(file.exists()) {
				try {
					HttpHeaders headers = new HttpHeaders();
					headers.add("Content-Type", MediaType.APPLICATION_OCTET_STREAM_VALUE);
					headers.add("Content-Disposition", "attachment;fileName=\""+ new String(fileName.getBytes("UTF-8"),"ISO-8859-1") + "\"");
					
					return new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),headers,HttpStatus.OK);
				} catch (Exception e) {
					e.printStackTrace();
					return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}else {
				return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//download
	
	/**
	 * 이미지 로딩
	 * @param fileName
	 * @return
	 */
	@GetMapping("/display")
	public ResponseEntity<byte[]> display(String fileName){
		File file = new File(ROOT_DIR + fileName);
		HttpHeaders headers = new HttpHeaders();
		
		try {
			if(file.exists()) {
				headers.add("Content-Type", Files.probeContentType(file.toPath()));
				
				return new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (IOException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//image loading
	
	@GetMapping("attachDelete/{attachNo}")
	public ResponseEntity<String> allDelete(@PathVariable int attachNo){
		List<AttachFileVO> list = service.getList(attachNo);
		for (AttachFileVO vo : list) {
			String pathname = ROOT_DIR+vo.getSavePath();
			String s_pathname = ROOT_DIR+vo.getS_savePath();
			File file = new File(pathname);
			if(file.exists()) {
				file.delete();
				
				if(vo.getFileType().equals("Y")) {
					file = new File(s_pathname);
					file.delete();
				}
			}
		}
		int result = service.allDelete(attachNo);
		
		if(result>0) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail",HttpStatus.OK);
		}
	}
	
	
	
	
	@GetMapping("/attachDelete/{uuid}/{attachNo}")
	public ResponseEntity<String> delete(@PathVariable("uuid") String uuid, @PathVariable("attachNo") int attachNo) {
		AttachFileVO vo = service.get(uuid, attachNo);
		String pathname = ROOT_DIR+vo.getSavePath();
		String s_pathname = ROOT_DIR+vo.getS_savePath();
		File file = new File(pathname);
		if(file.exists()) {
			file.delete();
			
			if(vo.getFileType().equals("Y")) {
				file = new File(s_pathname);
				file.delete();
			}
		}
		int result = service.delete(uuid,attachNo);
		
		if(result>0) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail",HttpStatus.OK);
		}
	}
	
	/**
	 * 중복 방지용
	 * 업로드 날짜를 업로드 경로로 지정
	 * 경로에 폴더가 없다면 해당 폴더 생성
	 * @return uploadPath
	 */
	private String getFolder() {
		//today(yyyy-MM-dd)
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String str = format.format(new Date());
		
		log.debug(str);
		String uploadPath = str.replace("-", File.separator) + File.separator;// yyyy\\MM\\dd\\(뒤에 추가하기 위해 하나 더 추가, 빼먹더라도 method에서 처리하면 되는데 파일마다 처리하는건 비효율적); 
		File saveFile = new File(ROOT_DIR , uploadPath);
		//경로가 존재하지 않으면 해당 경로 생성
		if(!saveFile.exists()) saveFile.mkdirs();
		
		return uploadPath;
	}//make path
}
