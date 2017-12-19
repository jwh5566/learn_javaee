package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet(name="MyServlet", urlPatterns={"/my"})
public class MyServlet implements Servlet {

	private transient ServletConfig servletConfig;
    /**
     * Default constructor. 
     */
    public MyServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.servletConfig = config;
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		return servletConfig;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		return "My Servlet";
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String servletName = servletConfig.getServletName();
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html><head></head>"
				+ "<body>Hello from " + servletName
				+ "</body></html>");
	}

}
