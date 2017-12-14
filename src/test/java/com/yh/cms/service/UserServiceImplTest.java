package com.yh.cms.service;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.yh.cms.domain.system.User;
import com.yh.cms.service.base.BaseSpringBootTest;
import com.yh.cms.service.system.IUserService;

public class UserServiceImplTest extends BaseSpringBootTest {

	@Resource
	private IUserService userService;

	@Autowired
	private HashedCredentialsMatcher credentialsMatcher;

	@Test
	public void testSave() {
		User user = new User();
		user.setUserName( "admin" );
		user.setPassword( "123456" );
		user.setSalt( "888888" );
		user.setPassword( new SimpleHash( "MD5", user.getPassword(), ByteSource.Util.bytes( user.getSalt() ), 1 ).toHex() );
		user.setCreateBy( "admin" );
		user.setCreateTime( new Date() );
		String insert = userService.insert( user );
		System.out.println( insert );
	}
}
