package com.shiyanlou.lesson4.interceptor;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.shiyanlou.lesson4.domain.ResultObject;


@Component
public class WordInterceptor  implements HandlerInterceptor{

	private static final String[] forbitWords = {"apple", "pear", "peach", "Lemon "};
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		 String word = request.getParameter("word");
		 for (String forbitWord: forbitWords) {
			 if (word.equals(forbitWord)) {
					render(response, "search word " + "'" + word + "'" + " is not allowed.");
				 return false;
			 }
		 }
		 
		 return true;
	}

	 @Override  
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,  
            ModelAndView modelAndView) throws Exception {
    }  
  
    @Override  
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)  
            throws Exception {  
    }
    
    public void render(HttpServletResponse response, String msg) throws IOException {
		ResultObject resultObject = new ResultObject(-1, msg, null);
		
		JSONObject object = new JSONObject(resultObject);

		response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        out.write(object.toString().getBytes("UTF-8"));
        out.flush();
        out.close();
	}
}
