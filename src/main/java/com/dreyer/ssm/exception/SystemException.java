
package com.dreyer.ssm.exception;

import com.dreyer.ssm.common.result.ApiResultCodeMsg;

/** 
 * @Description 系统自定义异常
 * @author Dreyer 
 * @date 2015年9月1日 下午11:28:33 
 * @version 1.0 
 */
public class SystemException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -481168448979750617L;
	
	private ApiResultCodeMsg resultCodeMsg;
	
	public SystemException(ApiResultCodeMsg resultCodeMsg) {
		this.resultCodeMsg = resultCodeMsg;
	}

	public ApiResultCodeMsg getResultCodeMsg() {
		return resultCodeMsg;
	}

	public void setResultCodeMsg(ApiResultCodeMsg resultCodeMsg) {
		this.resultCodeMsg = resultCodeMsg;
	}

}
