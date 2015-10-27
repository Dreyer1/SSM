package com.dreyer.ssm.controller.user;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreyer.ssm.common.result.ApiResult;
import com.dreyer.ssm.common.result.ApiResultCodeMsg;
import com.dreyer.ssm.common.result.ApiResultGenerator;
import com.dreyer.ssm.controller.common.BaseController;
import com.dreyer.ssm.dao.user.User;
import com.dreyer.ssm.exception.SystemException;
import com.dreyer.ssm.service.user.IUserService;
import com.dreyer.ssm.utils.StringUtil;

/**
 * @Description 用户控制器
 * @author Dreyer
 * @date 2015年8月31日 下午11:10:37
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Autowired
	private IUserService userService;
	
	/**
	 * 获取用户信息
	 * @param phone
	 * @param password
	 * @return
	 */
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public ApiResult getUserInfo(@RequestParam("phone") String phone,@RequestParam("password") String password) {
		if (StringUtil.hasEmpty(phone,password)) {
			return ApiResultGenerator.badParameter();
		}
		User user = userService.query(phone, password);
		if (user == null) {
			throw new SystemException(ApiResultCodeMsg.USER_NOT_EXIST);
		}
		return ApiResultGenerator.success(user);
	}

	/**
	 * 用户登录
	 * @param phone
	 * @param password
	 * @param request
	 * @return
	 * @throws SystemException
	 */
	@RequestMapping("/login")
	public String login(@RequestParam("phone") String phone,
			@RequestParam("password") String password,
			HttpServletRequest request) throws SystemException{
		User user = userService.query(phone, password);
		if (user == null) {
			throw new SystemException(ApiResultCodeMsg.USER_NOT_EXIST);
		}
		//将登陆用户信息放入session
		setUserInfoToSession(request, user);
		return "index";
	}

	@RequestMapping("/save")
	public String save(@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			@RequestParam("phone") String phone)
			throws IllegalArgumentException, UnsupportedEncodingException {
		
		if (StringUtil.hasEmpty(userName, password, phone)) {
			throw new IllegalArgumentException();
		}
		String name = new String(userName.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("用户名："+name);
		User user = new User();
		user.setPassword(password);
		user.setPhone(phone);
		user.setUser_name(name);
		user.setCreate_time(new Date());

		userService.save(user);
		return "index";
	}
}
