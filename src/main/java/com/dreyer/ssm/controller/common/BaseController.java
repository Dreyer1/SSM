
package com.dreyer.ssm.controller.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.dreyer.ssm.dao.user.User;

/** 
 * @Description Controller层的顶层对象
 * @author Dreyer 
 * @date 2015年8月31日 下午11:56:52 
 * @version 1.0 
 */
@Controller
public class BaseController {
	/**
	 *Session中存放登陆用户的key值 
	 */
	private static final String LOGIN_USER_INFO = "userInfo";
	
	/**
	 * 获取HttpSession
	 * @param request
	 * @return
	 */
	public static HttpSession getSession(HttpServletRequest request) {
		if (request != null) {
			return request.getSession();
		}
		return null;
	}
	
	/**
	 * 根据指定的key，从HttpSession中获取对应的value
	 * @param session
	 * @param key
	 * @return
	 */
	public static Object getValueFromSession(HttpSession session, String key) {
		if (session != null) {
			return session.getAttribute(key);
		}
		return null;
	}

	/**
	 * 根据指定的key，从HttpSession中获取对应的value
	 * @param request
	 * @param key
	 * @return
	 */
	public static Object getValueFromSession(HttpServletRequest request,String key) {
		return getValueFromSession(getSession(request), key);
	}
	
	/**
	 * 将服务器响应的内容写到客户端
	 * @param response
	 * @param data
	 * @throws IOException
	 */
	public static void write(HttpServletResponse response,Object data) throws IOException {
		PrintWriter writer = response.getWriter();
		writer.println(data);
		writer.flush();
	}
	
	/**
	 * 从Session中获取登陆用户信息
	 * @param request
	 * @return
	 */
	public static User getUserInfoFromSession(HttpServletRequest request) {
		return (User)getValueFromSession(request, LOGIN_USER_INFO);
	}
	
	/**
	 * 将登陆用户的值存入Session中
	 * @param request
	 * @param user
	 */
	public static void setUserInfoToSession(HttpServletRequest request,User user) {
		getSession(request).removeAttribute(LOGIN_USER_INFO);
		getSession(request).setAttribute(LOGIN_USER_INFO, user);
	}
}
