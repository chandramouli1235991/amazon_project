package com.amazon.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazon.entity.AmazonUser;
import com.amazon.service.AmazonService;
import com.amazon.service.AmazonServiceInterface;


public class GlobalServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		
	String option =	request.getParameter("ac");
	if(option.equals("register")) {
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		AmazonUser au= new AmazonUser();
		au.setName(name);
		au.setPass(pass);
		au.setEmail(email);
		au.setAddress(address);
		AmazonServiceInterface as =AmazonService.createServiceObject();
		int i=as.createProfile(au);
		if(i>0) {
			out.println("profile created");
		}
		else
		{
			out.println("could not create profile");
		}
	}
	if(option.equals("login")){
	}
	if(option.equals("timeline")) {
	}
out.println("</body></html>");
}
}
