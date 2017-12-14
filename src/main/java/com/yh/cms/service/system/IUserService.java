package com.yh.cms.service.system;

import com.yh.cms.domain.system.User;
import com.yh.cms.service.base.IBasePageService;

/**
 * 用户服务 liuyt 2017年11月28日 下午10:30:12
 */
public interface IUserService extends IBasePageService<User, String> {

	User findByUserName( String userName );
}
