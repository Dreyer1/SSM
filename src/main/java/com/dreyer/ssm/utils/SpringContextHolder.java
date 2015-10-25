
package com.dreyer.ssm.utils;

import java.lang.annotation.Annotation;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/** 
 * @Description Spring上下文持有者，用于获取spring创建对象的引用
 * @author Dreyer 
 * @date 2015年9月4日 下午2:44:16 
 * @version 1.0 
 */
public class SpringContextHolder implements ApplicationContextAware{
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
	}
	
	/**
	 * 根据bean名称获取bean的引用
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}
	
	/**
	 * 根据bean的名称和bean的类类型获取
	 * @param beanName
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(String beanName,Class<T> clazz) {
		return applicationContext.getBean(beanName, clazz);
	}
	
	/**
	 * 根据bean的类类型获取
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}
	
	/**
	 * 根据注解获取全部对象引用
	 * 
	 * @param clazz
	 * @return
	 */
	public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> c) {
		return applicationContext.getBeansWithAnnotation(c);
	}

}
