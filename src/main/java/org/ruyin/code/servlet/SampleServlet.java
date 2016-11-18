package org.ruyin.code.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		asyncSupported=false,
		name="myServlet",
		urlPatterns={"*.do"},
		initParams={
			@WebInitParam(name="hello",value="world")	
		})
public class SampleServlet extends HttpServlet{

	private static final long serialVersionUID = 2126481230654303302L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer = resp.getWriter();
		writer.println("Start..."+new Date()+"<br/>");
		writer.flush();
		
		String value = getInitParameter("hello");
		writer.println("Process..."+value+"<br/>");
		writer.flush();
		
		writer.println("End..."+new Date()+"<br/>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
