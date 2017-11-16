package com.dmxiaoshen;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class DubboServlet extends HttpServlet{

	/** */
	private static final long serialVersionUID = -2491087366749830856L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String appName = config.getInitParameter("appName");
		String zkAddress = config.getInitParameter("zkAddress");
		new DubboContext(appName,zkAddress).start();
	}

}
