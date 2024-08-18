package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
public class FileUploadController {

	@RequestMapping(path = "/viewUploadForm")
	public String viewUploadForm() {
		String str=null;
		System.out.println(str.length());
		return "FileUploadForm";
	}

	@RequestMapping(path = "/uploadForm", method = RequestMethod.POST)
	public String processUploadForm(@RequestParam("file") MultipartFile file, HttpSession session, Model model)
			throws IOException {
		

		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getResource());
		System.out.println(file.getInputStream());

		byte[] data = file.getBytes();
		String path = session.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources"
				+ File.separator + "img" + File.separator + file.getOriginalFilename();
		System.out.println(path);

		FileOutputStream fileOutputStream = new FileOutputStream(path);
		fileOutputStream.write(data);
		fileOutputStream.close();

		model.addAttribute("fileName", file.getOriginalFilename());
		return "fileSuccess";
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public String exceptionHandler() {
		return "error_page";
	}

}
