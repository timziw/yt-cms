package com.yh.cms.service.impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.cms.dao.system.UserRoleRelDao;
import com.yh.cms.domain.system.UserRoleRel;
import com.yh.cms.service.base.BasePageServiceImpl;
import com.yh.cms.service.system.IUserRoleRelService;
import com.yh.cms.support.pagehelper.base.BasePageDao;

/**
 * 用户角色关系服务实现 liuyt 2017年11月29日 下午4:20:35
 */
@Service
public class UserRoleRelServiceImpl extends BasePageServiceImpl<UserRoleRel, String> implements IUserRoleRelService {

	@Autowired
	private UserRoleRelDao userRoleRelDao;

	@Override
	public List<String> findNomalRoleCodesByUserId( String userId ) {
		return userRoleRelDao.findNomalRoleCodesByUserId( userId );
	}

	@Override
	protected BasePageDao<UserRoleRel, String> getBasePageDao() {
		return userRoleRelDao;
	}
}
