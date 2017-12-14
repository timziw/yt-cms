package com.yh.cms.domain.system;

import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.yh.cms.domain.base.BaseOperatorEntity;

/**
 * 权限表 liuyt 2017年11月29日 下午4:03:38
 */
@Data
@EqualsAndHashCode( callSuper = true )
@ToString( callSuper = true )
@Table( name = "yh_sys_permission" )
public class Permission extends BaseOperatorEntity<String> {

	private static final long serialVersionUID = 820896875395277947L;

	private String code; // 权限编码

	private String name; // 权限名称

	private int type = 0; // 权限类型 0-url 1-按钮

	private int status = 0; // 状态 0-正常 see PermissionEnum.class

}
