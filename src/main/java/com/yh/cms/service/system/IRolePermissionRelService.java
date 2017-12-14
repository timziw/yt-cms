package com.yh.cms.service.system;

import java.util.List;

import com.yh.cms.domain.system.RolePermissionRel;
import com.yh.cms.service.base.IBasePageService;

/**
 * 角色权限关系服务接口 liuyt 2017年11月29日 下午8:21:36
 */
public interface IRolePermissionRelService extends IBasePageService<RolePermissionRel, String> {

	/**
	 * 通过角色集合查询权限编码集合
	 * 
	 * @param roleIds
	 * @return
	 */
	List<String> findNomalPermsByRoleIds( List<String> roleIds );
}
