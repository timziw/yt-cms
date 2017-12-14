package com.yh.cms.support.cms.dto.resp;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.yh.cms.support.cms.enums.RespCodeEnum;

/**
 * 公共返回对象 liuyt 2017年10月11日 下午7:42:08
 */
@Data
@NoArgsConstructor
public class CommonResp {

	private int code = RespCodeEnum.SUCCESS.getCode(); // 状态码 200-成功

	private String message = RespCodeEnum.SUCCESS.getExternalMsg();

	private Object data;

	CommonResp(Object object) {
		this.data = object;
	}

	CommonResp(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public static CommonResp success() {
		return new CommonResp();
	}

	public static CommonResp success( Object object ) {
		return new CommonResp( object );
	}

	public static CommonResp error( RespCodeEnum respCodeEnum ) {
		return new CommonResp( respCodeEnum.getCode(), respCodeEnum.getExternalMsg() );
	}

	public static CommonResp error() {
		return new CommonResp( RespCodeEnum.ERROR.getCode(), RespCodeEnum.ERROR.getExternalMsg() );
	}

	public static CommonResp error( int code, String message ) {
		return new CommonResp( code, message );
	}
}
