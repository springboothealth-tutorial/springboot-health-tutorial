package com.shiyanlou.lesson2.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shiyanlou.lesson2.domain.ResultObject;

@RestController
@RequestMapping("file")
public class FileController {
	
	private static String PATH = "/home/project/";
	
	@PostMapping("upload")
	public ResultObject add(MultipartFile file) {
		if(file.isEmpty()) {
			return new ResultObject(-1, "file is empty");
		}
		
		String fileName = file.getOriginalFilename();
		long size = file.getSize();
		System.out.println(size);
		
		File dest = new File(PATH + fileName); 
		
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return new ResultObject(-1, "state exception");
		} catch (IOException e) {
			e.printStackTrace();
			return new ResultObject(-1, "io exception");
		}
		
		return new ResultObject(null);
	}	
}