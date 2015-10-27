package com.dreyer.ssm.controller.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dreyer.ssm.dao.user.User;

/**
 * @Description Controller类的顶层基类
 * @author Dreyer
 * @date 2015年8月31日 下午11:56:52
 * @version 1.0
 */
@Controller
public class BaseController {
	/**
	 * Session中存放登陆用户的key值
	 */
	private final String LOGIN_USER_INFO = "userInfo";
	

	/**
	 * 获取HttpServletRequest，每个http请求独立一份的数据
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获取HttpSession
	 * 
	 * @return
	 */
	public HttpSession getSession() {

		return getRequest().getSession();
	}

	/**
	 * 获取application
	 * 
	 * @return
	 */
	protected ServletContext getApplication() {
		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession()
				.getServletContext();
	}

	/**
	 * 根据指定的key，从HttpSession中获取对应的value
	 * 
	 * @param session
	 * @param key
	 * @return
	 */
	public Object getValueFromSession(String key) {
		
		return getSession().getAttribute(key);
	}

	/**
	 * 将服务器响应的内容写到客户端
	 * 
	 * @param response
	 * @param data
	 * @throws IOException
	 */
	public static void write(HttpServletResponse response, Object data) throws IOException {
		PrintWriter writer = response.getWriter();
		writer.println(data);
		writer.flush();
	}

	/**
	 * 从Session中获取登陆用户信息
	 * 
	 * @param request
	 * @return
	 */
	public User getUserInfoFromSession() {
		return (User) getValueFromSession(LOGIN_USER_INFO);
	}

	/**
	 * 将登陆用户的值存入Session中
	 * 
	 * @param request
	 * @param user
	 */
	public void setUserInfoToSession(HttpServletRequest request,User user) {
		getSession().removeAttribute(LOGIN_USER_INFO);
		getSession().setAttribute(LOGIN_USER_INFO, user);
	}
	
	/**
	 * 得到IP地址
	 * 
	 * @param request
	 * @return
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
