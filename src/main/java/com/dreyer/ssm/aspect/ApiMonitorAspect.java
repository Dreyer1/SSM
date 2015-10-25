package com.dreyer.ssm.aspect;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Description 对api调用的监控
 * @author Dreyer
 * @date 2015年10月25日 下午9:04:45
 * @version 1.0
 */
@Aspect
@Component
public class ApiMonitorAspect {
	private Logger logger = Logger.getLogger(ApiMonitorAspect.class);

	@Around(value = "execution(public * com.dreyer.ssm.controller..*.*(..))")
	public Object monitor(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		// 请求的服务器
		String serverName = request.getServerName();
		// 请求的端口
		int serverPort = request.getServerPort();
		// Context路径
		String contextPath = request.getContextPath();
		// Servlet的路径
		String servletPath = request.getServletPath();

		logger.info("请求路径：" + request.getScheme() + ":" + serverName + ":" + serverPort + contextPath + servletPath);

		Enumeration<String> parameters = request.getParameterNames();
		String element = "";
		while (parameters.hasMoreElements()) {
			element = parameters.nextElement();
			logger.info("param key：" + element + " == " + request.getParameter(element));
		}
		long start = System.currentTimeMillis();
		try {
			return proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
		} catch (Throwable e) {
			throw e;
		} finally {
			logger.info("此次请求耗时：" + (System.currentTimeMillis() - start) +" ms");
		}
	}
}
