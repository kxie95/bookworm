package kxie.uoa.bookshop.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookShopServlet extends HttpServlet {
	private static Logger _logger = LoggerFactory.getLogger(BookShopServlet.class);

	// Servlet lifecycle method, called by the servlet container when
	// it instantiates HelloWorldServlet.
	@Override
	public void init() {
		_logger.debug("Initialising servlet");
	}

	// Servlet lifecycle method, called by the servlet container just before a
	// HelloWorldServlet instance is detroyed. A servlet may be destroyed at
	// any time by its hosting servlet container to free resources.
	@Override
	public void destroy() {
		_logger.debug("Destroying servlet");
	}

	// Template Method hook method. When invoking a servlet, the servlet
	// container calls the servlet's service() method, which then calls doGet()
	// for HTTP GET requests.
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		_logger.debug("Processing HTTP GET request");

		// Set the content-type header.
		response.addHeader("Content-Type", "text/html");

		PrintWriter out = response.getWriter();

	}
}
