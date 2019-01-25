package com.shiyanlou.lesson4.filter;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.shiyanlou.lesson4.domain.ResultObject;

public class LoginFilter implements Filter {

	private static String exclusions;
	private static String[] ALLOWEDURLS;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		exclusions = filterConfig.getInitParameter("exclusions");
		if (!exclusions.isEmpty()) {
			ALLOWEDURLS = exclusions.split(",");
		}
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		
		String url = request.getRequestURI();
				
		HttpSession session = request.getSession(false);
		if (isAllowed(url) || session != null && session.getAttribute("user") != null) {
			chain.doFilter(request, response);
		} else {
			render(response, "not login");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	
	public boolean isAllowed(String url) {
		for (String ALLOWEDURL: ALLOWEDURLS) {
			if (ALLOWEDURL.equals(url)) {
				return true;
			}
		}
		return false;
	}
	
	public void render(HttpServletResponse response, String msg) throws IOException {
		ResultObject resultObject = new ResultObject(-1, "fail", msg);
		
		JSONObject object = new JSONObject(resultObject);

		response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        out.write(object.toString().getBytes("UTF-8"));
        out.flush();
        out.close();
	}

}
