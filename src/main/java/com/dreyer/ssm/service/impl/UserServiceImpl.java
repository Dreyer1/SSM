
package com.dreyer.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dreyer.ssm.dao.user.User;
import com.dreyer.ssm.dao.user.UserCriteria;
import com.dreyer.ssm.dao.user.mapper.UserMapper;
import com.dreyer.ssm.service.IUserService;

/** 
 * @Description 用户服务实现类
 * @author Dreyer 
 * @date 2015年8月31日 下午11:12:40 
 * @version 1.0 
 */
@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;

	public void save(User user) {
		userMapper.insert(user);
	}

	public User query(String phone, String password) {
		UserCriteria criteria = new UserCriteria();
		UserCriteria.Criteria userCriteria = criteria.createCriteria();
		userCriteria.andPhoneEqualTo(phone);
		userCriteria.andPasswordEqualTo(password);
		List<User> users = userMapper.selectByExample(criteria);
		if (!CollectionUtils.isEmpty(users)) {
			return users.get(0);
		}
		return null;
	}
	
	public void test() {
		System.out.println("这是个测试方法..");
	}

}
