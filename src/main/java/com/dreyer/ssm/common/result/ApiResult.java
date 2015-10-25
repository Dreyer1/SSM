package com.dreyer.ssm.common.result;

/**
 * @Description Controller层返回的统一结果对象
 * @author Dreyer
 * @date 2015年8月31日 下午11:57:43
 * @version 1.0
 */
public class ApiResult {
	
	/** 状态码**/
	private String code;
	
	/** 状态码对于的提示信息**/
	private String msg;
	
	/** 返回的具体数据**/
	private Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ApiResult(String code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

}
