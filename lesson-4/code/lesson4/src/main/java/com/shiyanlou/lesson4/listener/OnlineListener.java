package com.shiyanlou.lesson4.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineListener implements HttpSessionListener{

	private int onlineNumber = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		onlineNumber++;
		se.getSession().getServletContext().setAttribute("onlineNumber", onlineNumber);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		onlineNumber--;
		se.getSession().getServletContext().setAttribute("onlineNumber", onlineNumber);
	}

}
