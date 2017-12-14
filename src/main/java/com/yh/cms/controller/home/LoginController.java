package com.yh.cms.controller.home;

import static org.apache.shiro.web.filter.authc.FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yh.cms.controller.base.BaseController;

/**
 * 登录controller liuyt 2017年11月29日 下午8:46:44
 */
@Controller
public class LoginController extends BaseController {

	/**
	 * 登录页面跳转
	 */
	@RequestMapping( value = "/login", method = RequestMethod.GET )
	public String login( HttpServletRequest request ) {
		return "admin/system/login";
	}

	/**
	 * 登录提交
	 */
	@RequestMapping( value = "/login", method = RequestMethod.POST )
	public String loginSubmit( HttpServletRequest request, RedirectAttributes redirect ) {
		Object errorName = request.getAttribute( DEFAULT_ERROR_KEY_ATTRIBUTE_NAME );
		if( errorName != null ) {
			redirect.addFlashAttribute( DEFAULT_ERROR_KEY_ATTRIBUTE_NAME, errorName );
		}
		return "redirect:login";
	}
}
