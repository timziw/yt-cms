package com.yh.cms.domain.system;

import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.yh.cms.domain.base.BaseEntity;

@Data
@EqualsAndHashCode( callSuper = true )
@ToString( callSuper = true )
@Table( name = "yh_sys_role_perm_rel" )
public class RolePermissionRel extends BaseEntity<String> {

	private static final long serialVersionUID = -4630495881239198523L;

	private String roleId; // 角色id

	private String permissionId; // 权限id
}
