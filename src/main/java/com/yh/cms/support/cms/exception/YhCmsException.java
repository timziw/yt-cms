package com.yh.cms.support.cms.exception;

import com.yh.cms.support.cms.enums.RespCodeEnum;

/**
 * 转码项目业务exception liuyt 2017年10月23日 下午4:36:39
 */
public class YhCmsException extends RuntimeException {
	private static final long serialVersionUID = -8560943629756310901L;

	private int code; // 错误码

	public YhCmsException(RespCodeEnum respCodeEnum, Throwable e) {
		super( respCodeEnum.getExternalMsg(), e );
		this.code = respCodeEnum.getCode();
	}

	public YhCmsException(int code, String message, Throwable e) {
		super( message, e );
		this.code = code;
	}

	public YhCmsException(String message, Throwable e) {
		super( message, e );
		this.code = RespCodeEnum.ERROR.getCode();
	}

	public int getCode() {
		return code;
	}

	public void setCode( int code ) {
		this.code = code;
	}
}
