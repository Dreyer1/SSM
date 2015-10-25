
package com.dreyer.ssm.common.result;
/** 
 * @Description Controller层返回的统一结果对象信息码
 * @author Dreyer 
 * @date 2015年8月31日 下午11:58:29 
 * @version 1.0 
 */
public enum ApiResultCodeMsg {
	SUCCESSFUL("1000", "成功"), 
	BAD_PARAMETER("1001", "请求参数错误"),
	USER_NOT_EXIST("1002", "用户不存在"),
	SYSTEM_ERROR("9999", "系统内部错误");

	private String code;
	private String msg;

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

	private ApiResultCodeMsg(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 根据状态码获取到对应的提示信息
	 * @param code
	 * @return
	 */
	public static String getMsg(String code) {
		for (ApiResultCodeMsg resultCodeMsg : values()) {
			if (resultCodeMsg.getCode().equals(code)) {
				return resultCodeMsg.getMsg();
			}
		}
		return null;
	}

}
