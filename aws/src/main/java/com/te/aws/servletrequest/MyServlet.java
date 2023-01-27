package com.te.aws.servletrequest;

import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@SuppressWarnings("serial")
public class MyServlet extends HttpServlet {
	
	@GetMapping("/")
	public String showHomePage() {
		System.err.println("homePage");
		return "6";
	}

	@PostMapping("/sum")
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		System.err.println(i);
		System.err.println(j);
		int k = i + j;
		System.err.println(k);

		PrintWriter out = resp.getWriter();
		out.println("result is :" + k);

	}

}
