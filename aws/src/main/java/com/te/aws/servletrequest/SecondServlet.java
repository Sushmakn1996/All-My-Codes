package com.te.aws.servletrequest;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("serial")
public class SecondServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.err.println("generic servlet");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("second servlet extends generic servlet");
	}

}
