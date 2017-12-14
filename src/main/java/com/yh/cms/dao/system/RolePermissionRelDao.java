package com.yh.cms.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yh.cms.domain.system.RolePermissionRel;
import com.yh.cms.support.pagehelper.base.BasePageDao;

/**
 * 角色权限关系dao liuyt 2017年11月29日 下午4:27:51
 */
public interface RolePermissionRelDao extends BasePageDao<RolePermissionRel, String> {

	/**
	 * 通过用户id 查询可用的权限集合
	 * 
	 * @param userId
	 * @return
	 */
	List<String> findNomalPermsByRoleIds( @Param( "roleIds" ) List<String> roleIds );
}
