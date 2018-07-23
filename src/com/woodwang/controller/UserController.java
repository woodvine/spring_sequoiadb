package com.woodwang.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woodwang.bean.ResultData;
import com.woodwang.bean.User;
import com.woodwang.service.UserService;

/**
 * Controller
 * @author admin
 *
 */
@RequestMapping("/user")
@Controller
public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * check if the target is exists
	 * @param user
	 * @return
	 */
	@RequestMapping("/isUserExist")
	@ResponseBody
	public ResultData isUserExist(HttpServletRequest request) {
		ResultData result = new ResultData();
		String userId = request.getParameter("userId");
		
		try{
			boolean flag = userService.isUserExist(userId);
			result.setResult(flag);
			result.setSuccess(true);
			if(flag) {
				result.setNotice("用户已经存在");
			}else {
				result.setNotice("用户不存在");
			}
		}catch(Exception e){
			logger.error("操作异常.",e);
			result.setNotice("操作异常!");
		}
		
		return result;
	}
	
	/**
	 * add a new user
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public ResultData addUser(User user) {
		ResultData result = new ResultData();
		user.set_id(System.currentTimeMillis()+"");
		try{
			boolean flag = userService.isUserExist(user.getUserId());
			
			if(flag) {
				result.setNotice("用户已存在，添加失败");
			}else {
				userService.addUser(user);
				
				result.setNotice("添加成功");
				result.setSuccess(true);
			}
		}catch(Exception e){
			logger.error("操作异常.",e);
			result.setNotice("操作异常!");
		}
		
		return result;
	}

	
}
