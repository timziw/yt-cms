package com.yh.cms.service.impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.cms.dao.system.RolePermissionRelDao;
import com.yh.cms.domain.system.RolePermissionRel;
import com.yh.cms.service.base.BasePageServiceImpl;
import com.yh.cms.service.system.IRolePermissionRelService;
import com.yh.cms.support.pagehelper.base.BasePageDao;

/**
 * 角色权限关系服务实现 liuyt 2017年11月29日 下午8:23:00
 */
@Service
public class RolePermissionRelServiceImpl extends BasePageServiceImpl<RolePermissionRel, String> implements
        IRolePermissionRelService {

	@Autowired
	private RolePermissionRelDao rolePermissionRelDao;

	@Override
	public List<String> findNomalPermsByRoleIds( List<String> roleIds ) {
		return rolePermissionRelDao.findNomalPermsByRoleIds( roleIds );
	}

	@Override
	protected BasePageDao<RolePermissionRel, String> getBasePageDao() {
		return rolePermissionRelDao;
	}

}
