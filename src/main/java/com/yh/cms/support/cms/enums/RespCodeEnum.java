package com.yh.cms.support.cms.enums;

import lombok.Getter;

/**
 * 返回码枚举 liuyt 2017年10月11日 下午7:43:33
 */
public enum RespCodeEnum {

	SUCCESS( 200, "成功", "成功" ), BUSINESS_EXCEPTION( 998, "系统业务异常", "系统业务异常" ), ERROR( 999, "系统错误", "系统错误" );

	@Getter
	int code; // 状态码

	@Getter
	String interiorMsg; // 内部错误信息 用于记录日志

	@Getter
	String externalMsg; // 外部错误信息 用户返回外部调用

	RespCodeEnum(int code, String interiorMsg, String externalMsg) {
		this.code = code;
		this.interiorMsg = interiorMsg;
		this.externalMsg = externalMsg;
	}
}
