package com.project.UploadFile.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.util.StringUtils;
import java.io.IOException;


import com.project.UploadFile.model.Files;
import com.project.UploadFile.repository.FilesRepository;

import net.bytebuddy.utility.RandomString;

@RestController
public class FilesController {
@Autowired
private FilesRepository frepo;

@GetMapping("/files/{fname}")
public ResponseEntity<Resource> getFileByFileName(@PathVariable String fname) {
	Files file=frepo.getFilesByFileName(fname);
	 return ResponseEntity.ok()
             .contentType(MediaType.parseMediaType(file.getFileType()))
             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
             .body(new ByteArrayResource(file.getData()));

}
@GetMapping("/files")
public List<String> getFiles() {
	List<Files> files=frepo.findAll();
	List<String> Urls = new ArrayList<>();
	for(Files f:files) {
		Urls.add(f.getFileName());
	}
	return Urls;
}
@PostMapping("/files")
public ModelAndView addFiles(@RequestParam("data") MultipartFile file) throws IOException {
	//System.out.println("Files are - "+file);
	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	String fileSubName=fileName.substring(0,fileName.length()-4);
	String generatedString = RandomString.make(7);
	//System.out.println(generatedString);
	fileName = fileSubName+generatedString+".pdf";

        Files dbFile = new Files(fileName, file.getContentType(), file.getBytes());
	 frepo.save(dbFile);
	 return new ModelAndView("redirect:/");
}
}
