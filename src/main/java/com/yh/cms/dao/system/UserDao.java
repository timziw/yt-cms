package com.yh.cms.dao.system;

import org.apache.ibatis.annotations.Param;

import com.yh.cms.domain.system.User;
import com.yh.cms.support.pagehelper.base.BasePageDao;

/**
 * 用户持久接口 liuyt 2017年11月28日 下午10:27:01
 */
public interface UserDao extends BasePageDao<User, String> {

	User findByUserName( @Param( "userName" ) String userName );
}
