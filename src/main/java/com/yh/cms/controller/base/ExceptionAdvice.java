package com.yh.cms.controller.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yh.cms.support.cms.dto.resp.CommonResp;
import com.yh.cms.support.cms.enums.RespCodeEnum;
import com.yh.cms.support.cms.exception.YhCmsException;

/**
 * 全局异常处理 liuyt 2017年11月9日 下午7:38:52
 */
@Slf4j
@ControllerAdvice
public class ExceptionAdvice {

	/**
	 * 处理 cms 异常
	 */
	@ExceptionHandler( value = YhCmsException.class )
	@ResponseBody
	public CommonResp handlerHcFFmpegException( HttpServletRequest request, HttpServletResponse response, YhCmsException ex ) {
		log.error( "出现cms异常.异常信息为:[{}]", ex.getMessage() );
		return CommonResp.error( RespCodeEnum.BUSINESS_EXCEPTION.getCode(), ex.getMessage() );
	}

	/**
	 * 处理 其他 异常
	 */
	@ExceptionHandler( value = Exception.class )
	@ResponseBody
	public CommonResp handlerException( HttpServletRequest request, HttpServletResponse response, Exception ex ) {
		log.error( "出现系统异常.异常信息为:[{}]", ex.getMessage() );
		return CommonResp.error();
	}
}
