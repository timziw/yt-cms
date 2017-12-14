package com.yh.cms.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yh.cms.controller.base.BaseController;

/**
 * 首页controller liuyt 2017年12月14日 下午7:47:43
 */
@Controller
public class IndexController extends BaseController {

	/**
	 * 首页
	 */
	@RequestMapping( value = { "/", "/index" }, method = RequestMethod.GET )
	public String index( Model model ) {
		return "admin/system/index";
	}
}
