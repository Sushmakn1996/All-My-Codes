package com.te.http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadsServlet" })
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, 
		  maxFileSize = 1024 * 1024 * 10,      
		  maxRequestSize = 1024 * 1024 * 10  
		)
@RestController
public class SingleFileUploadServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@PostMapping("/uploadOne")
	public void doPost(MultipartHttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.err.println(request);
	    Part filePart = request.getPart("file");
	    String fileName = filePart.getSubmittedFileName();
	    System.err.println("Upload One :"+fileName);
	    for (Part part : request.getParts()) {
	      part.write("C:\\Users\\SUZIE\\Desktop\\UploadOne\\" + fileName);
	    }
	    response.getWriter().print("The file uploaded sucessfully.");
	  }

}
