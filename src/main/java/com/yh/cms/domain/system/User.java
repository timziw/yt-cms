package com.yh.cms.domain.system;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.apache.shiro.util.ByteSource;

import com.yh.cms.domain.base.BaseOperatorEntity;
import com.yh.cms.support.cms.enums.system.UserStatusEnum;

/**
 * 用户实体 liuyt 2017年11月28日 下午10:23:36
 */
@Data
@EqualsAndHashCode( callSuper = true )
@ToString( callSuper = true )
@Table( name = "yh_sys_user" )
public class User extends BaseOperatorEntity<String> {
	private static final long serialVersionUID = -6326715157279701225L;

	@Column( name = "user_name" )
	private String userName; // 用户名

	@Column( name = "password" )
	private String password; // 密码

	@Column( name = "salt" )
	private String salt; // 盐值

	private int status = UserStatusEnum.NORMAL.getStatus(); // 状态

	public boolean isNormal() {
		return getStatus() == UserStatusEnum.NORMAL.getStatus();
	}

	public ByteSource getSlatByte() {
		return ByteSource.Util.bytes( getSalt() );
	}
}
