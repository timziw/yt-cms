package com.yh.cms.support.cms.enums.system;

import lombok.Getter;

/**
 * 用户状态枚举 liuyt 2017年11月29日 下午8:37:02
 */
public enum UserStatusEnum {

	NORMAL( 0, "正常" ), LOCK( 1, "锁定" );

	@Getter
	int status;

	@Getter
	String message;

	UserStatusEnum(int status, String message) {
		this.status = status;
		this.message = message;
	}
}
