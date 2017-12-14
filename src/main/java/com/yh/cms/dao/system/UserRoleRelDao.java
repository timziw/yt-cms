package com.yh.cms.dao.system;

import java.util.List;

import com.yh.cms.domain.system.UserRoleRel;
import com.yh.cms.support.pagehelper.base.BasePageDao;

/**
 * 用户角色关系dao liuyt 2017年11月29日 下午4:10:13
 */
public interface UserRoleRelDao extends BasePageDao<UserRoleRel, String> {

	/**
	 * 通过用户id 查询可用的角色编码集合
	 * 
	 * @param userId
	 * @return
	 */
	List<String> findNomalRoleCodesByUserId( String userId );
}
