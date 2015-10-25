
package com.dreyer.ssm.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dreyer.ssm.controller.common.BaseController;
import com.dreyer.ssm.dao.user.User;

/** 
 * @Description 用户是否登陆拦截器
 * @author Dreyer 
 * @date 2015年8月31日 下午11:18:47 
 * @version 1.0 
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
	

	/**
	 * 请求进来后，执行Action业务逻辑之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//如果是登陆的访问路径，则通过
		String requestUrl = request.getRequestURI();
		if (requestUrl.contains("login.do")) {
			return true;
		}
		//判断会话中是否有登陆用户信息
		User user = BaseController.getUserInfoFromSession(request);
		if (user != null) {
			return true;
		}
		return false;
	}

	/**
	 * 执行Action业务逻辑之后，返回视图之前
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * 返回视图之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		super.afterConcurrentHandlingStarted(request, response, handler);
	}

}
