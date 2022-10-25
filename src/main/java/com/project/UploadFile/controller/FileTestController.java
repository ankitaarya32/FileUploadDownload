package com.project.UploadFile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileTestController {
@GetMapping("/")
public String getIndexPage() {
	return "index.html";
}
}
