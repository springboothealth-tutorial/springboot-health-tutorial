package com.shiyanlou.lesson9.interceptor;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.shiyanlou.lesson9.domain.ResultObject;
import com.shiyanlou.lesson9.domain.User;
import com.shiyanlou.lesson9.util.RedisUtil;

@Component
public class LoginInterceptor  implements HandlerInterceptor{

	private static final Log logger = LogFactory.getLog(LoginInterceptor.class);

	@Autowired
	private RedisUtil redisUtil;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		try {
			// 校验用户是否已经登录, 如果登录过, 将之前用户踢掉, 同时更新缓存中用户信息
			// 获取用户id
			// step 1 检查请求是否携带token
			
			String token = request.getParameter("token");
			if (token == null) {
				render(response, "lack token");
				return false;
			}
			
			// step 2  检查token是否合法
			User user = (User)redisUtil.get(token);
			if (user != null) {
				Object preToken = redisUtil.get(Integer.toString(user.getId()));
				// step 3  检查同一账号是否被其他用户登录
				if (!token.equals(preToken)) {
					render(response, "another user login");
					return false;
				// step 4  至此登录成功，查看token过期时间是否小于1分钟, 返回值单位毫秒，故 * 1000比较
				} else {
					Long expire = redisUtil.getExpire(token);
					if (expire < 60 * 1000) {
						redisUtil.expire(token, 60 * 30);
					}
				}
			} else {
				render(response, "token error");
				return false;
			}
		} catch (Exception e) {
			logger.info("preHandle=" + e);
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
