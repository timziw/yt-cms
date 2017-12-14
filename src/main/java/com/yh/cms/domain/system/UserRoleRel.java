package com.yh.cms.domain.system;

import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.yh.cms.domain.base.BaseEntity;

/**
 * 用户角色关联表 liuyt 2017年11月29日 下午4:02:17
 */
@Data
@EqualsAndHashCode( callSuper = true )
@ToString( callSuper = true )
@Table( name = "yh_sys_user_role_rel" )
public class UserRoleRel extends BaseEntity<String> {

	private static final long serialVersionUID = -3847401564602316414L;

	private String userId; // 用户id

	private String roleId; // 角色id
}
