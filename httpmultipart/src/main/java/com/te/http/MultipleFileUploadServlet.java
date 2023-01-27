package com.te.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@WebServlet(name = "FileUploadServlet", urlPatterns = { "/fileuploadservlet" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 100, maxFileSize = 1024 * 1024 * 100, maxRequestSize = 1024 * 1024
		* 100)
@RestController
public class MultipleFileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	String fileName;

	@PostMapping("/uploadMany")
	public void doPost(MultipartHttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Collection<Part> parts = request.getParts();
		System.err.println(parts);

		parts.stream().forEach(part -> {
						try {
							request.getPart("file");
						} catch (IOException | ServletException e) {
							e.printStackTrace();
						}
					fileName = part.getSubmittedFileName();
					List<String> files=new ArrayList<>();
					files.add(fileName);
					System.err.println("Upload Many :" + files);
		});
		
			for (Part part1 : request.getParts()) {
				String name = part1.getSubmittedFileName();
				System.err.println("file names :"+name);
				part1.write("C:\\Users\\SUZIE\\Desktop\\UploadMany\\" + name);
			}

		response.getWriter().print("All files uploaded sucessfully.");
	}

}
