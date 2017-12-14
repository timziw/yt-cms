package com.yh.cms.service.system;

import java.util.List;

import com.yh.cms.domain.system.UserRoleRel;
import com.yh.cms.service.base.IBasePageService;

/**
 * 用户角色服务接口 liuyt 2017年11月29日 下午4:18:39
 */
public interface IUserRoleRelService extends IBasePageService<UserRoleRel, String> {

	/**
	 * 通过用户id 查询正常的角色编码集合
	 * 
	 * @param userId
	 * @return
	 */
	List<String> findNomalRoleCodesByUserId( String userId );
}
