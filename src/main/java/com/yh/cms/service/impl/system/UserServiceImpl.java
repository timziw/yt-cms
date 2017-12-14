package com.yh.cms.service.impl.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.cms.dao.system.UserDao;
import com.yh.cms.domain.system.User;
import com.yh.cms.service.base.BasePageServiceImpl;
import com.yh.cms.service.system.IUserService;
import com.yh.cms.support.pagehelper.base.BasePageDao;

/**
 * 用户服务实现 liuyt 2017年11月28日 下午10:31:24
 */
@Service
public class UserServiceImpl extends BasePageServiceImpl<User, String> implements IUserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findByUserName( String userName ) {
		return userDao.findByUserName( userName );
	}

	@Override
	protected BasePageDao<User, String> getBasePageDao() {
		return userDao;
	}

}
