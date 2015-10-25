package com.dreyer.ssm.exception.handler;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreyer.ssm.common.result.ApiResult;
import com.dreyer.ssm.common.result.ApiResultGenerator;
import com.dreyer.ssm.exception.SystemException;

/**
 * @Description 系统全局异常的处理器（可以捕获Controller、Service、Dao层的异常）
 * @author Dreyer
 * @date 2015年9月1日 下午10:53:54
 * @version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

	/**
	 * 处理系统运行时异常
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler
	@ResponseBody
	public ApiResult runTimeExceptionHandelr(RuntimeException exception) {
		logger.error("系统发生错误，错误信息：" + exception.getMessage());
		exception.printStackTrace();
		return ApiResultGenerator.error(exception);
	}

	/**
	 * 处理系统自定义的SystemException异常
	 * 
	 * @param systemException
	 * @return
	 */
	@ExceptionHandler
	@ResponseBody
	public ApiResult systemExceptionHandelr(SystemException systemException) {
		logger.error("系统发生错误，错误代码："
				+ systemException.getResultCodeMsg().getCode() + "，错误信息："
				+ systemException.getResultCodeMsg().getMsg());
		return ApiResultGenerator.error(systemException);
	}

}
