package com.te.aws.servletrequest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Servlet3 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contentType = resp.getContentType();
		System.err.println("doGetMethod");
		System.err.println("contentType :" + contentType);
		PrintWriter out = resp.getWriter();
		try {
			String user = req.getParameter("user");
			out.println("<h2> Welcome " + user + " </h2>");
		} finally {
			out.close();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String contentType = resp.getContentType();
		System.err.println("doPostMethod");
		System.err.println("contentType :" + contentType);
		PrintWriter out = resp.getWriter();
		try {
			String user = req.getParameter("user");
			out.println("<h2> Welcome " + user + " </h2>");
		} finally {
			out.close();
		}
	}

}
