package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ServletConfigDemoServlet
 */
@WebServlet(name="ServletConfigDemoServlet", 
			urlPatterns={"/servletConfigDemo"},
			initParams = {
			@WebInitParam(name="admin", value="Harry Taciak"),
			@WebInitParam(name="email", value="admin@example.com")
})
public class ServletConfigDemoServlet implements Servlet {

	private transient ServletConfig servletConfig;
    /**
     * Default constructor. 
     */
    public ServletConfigDemoServlet() {
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
		return "ServletConfig Demo"; 
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		ServletConfig servletConfig = getServletConfig();
		String admin = servletConfig.getInitParameter("admin");
		String email = servletConfig.getInitParameter("email");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html><head></head><body>" +
				"Admin:" + admin +
				"<br/>Email:" + email +
				"</body></html>");
	}

}
