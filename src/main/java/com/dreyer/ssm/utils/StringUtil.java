package com.dreyer.ssm.utils;

/**
 * @Description 字符串操作相关的工具类
 * @author Dreyer
 * @date 2015年8月31日 下午11:13:17
 * @version 1.0
 */
public class StringUtil extends org.springframework.util.StringUtils {
	/**
	 * 判断字符是否为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return (str == null || "".equals(str));
	}

	/**
	 * 判断字符数组中是否存在空值
	 * 
	 * @param strs
	 * @return
	 */
	public static boolean hasEmpty(String... strs) {
		if (strs == null || strs.length == 0) {
			return true;
		}
		for (String str : strs) {
			if (isEmpty(str)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断字符串数组中的值是否全部为空
	 * 
	 * @param strs
	 * @return
	 */
	public static boolean isAllEmpty(String... strs) {
		if (strs == null || strs.length == 0) {
			return true;
		}
		for (String str : strs) {
			if (!isEmpty(str)) {
				return false;
			}
		}
		return true;
	}

}
