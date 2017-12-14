package com.yh.cms.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yh.cms.controller.base.BaseController;
import com.yh.cms.domain.system.User;
import com.yh.cms.service.system.IUserService;
import com.yh.cms.support.cms.dto.resp.CommonResp;
import com.yh.cms.support.fastjson.JSON;

/**
 * 用户controller liuyt 2017年11月28日 下午10:15:38
 */
@Controller
@RequestMapping( "user" )
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;

	/**
	 * 用户列表
	 */
	@RequestMapping( value = "list", method = RequestMethod.GET )
	@JSON( type = User.class )
	public CommonResp list() {
		List<User> users = userService.findAll();
		return CommonResp.success( users );
	}
}
