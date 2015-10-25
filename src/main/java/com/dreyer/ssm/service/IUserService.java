
package com.dreyer.ssm.service;

import com.dreyer.ssm.dao.user.User;

/** 
 * @Description 用户服务接口
 * @author Dreyer 
 * @date 2015年8月31日 下午11:12:26 
 * @version 1.0 
 */
public interface IUserService {
	
	/**
	 * 对用户信息进行库表保存
	 * @param user
	 */
	void save (User user);
	
	/**
	 * 根据手机号和密码查询用户
	 * @param userName
	 * @param password
	 * @return
	 */
	User query(String phone,String password);
	
	void test();

}
