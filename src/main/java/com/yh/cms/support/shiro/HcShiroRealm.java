package com.yh.cms.support.shiro;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.yh.cms.domain.system.User;
import com.yh.cms.service.system.IRolePermissionRelService;
import com.yh.cms.service.system.IUserRoleRelService;
import com.yh.cms.service.system.IUserService;

/**
 * 自定义认证realm
 * 
 * @author liuyt Date:2016年10月12日下午4:34:48
 */
@Slf4j
@Component
public class HcShiroRealm extends AuthorizingRealm {

	@Resource
	private IUserService userService;

	@Resource
	private IUserRoleRelService userRoleRelService;

	@Resource
	private IRolePermissionRelService rolePermissionRelService;

	/**
	 * 权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo( PrincipalCollection principals ) {
		SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
		try {
			ShiroUser shiroUser = (ShiroUser)principals.getPrimaryPrincipal();
			// 查询用户的角色
			List<String> roleCodes = userRoleRelService.findNomalRoleCodesByUserId( shiroUser.id );
			auth.setRoles( new HashSet<String>( roleCodes ) );

			// 查询用户角色的权限
			List<String> perms = rolePermissionRelService.findNomalPermsByRoleIds( shiroUser.roleIds );
			auth.setStringPermissions( new HashSet<String>( perms ) );
		}
		catch( Exception e ) {
			log.error( "query permission has eccor an exception . [{}]", e );
			throw e;
		}
		return auth;
	}

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo( AuthenticationToken token ) throws AuthenticationException {
		UsernamePasswordToken loginToken = (UsernamePasswordToken)token;
		User user = userService.findByUserName( loginToken.getUsername() );
		if( null != user ) {

			if( user.isNormal() ) {
				// 查询用户的角色
				List<String> roleCodes = userRoleRelService.findNomalRoleCodesByUserId( user.getId() );
				return new SimpleAuthenticationInfo( new ShiroUser( user.getId(), user.getUserName(), roleCodes ),
				        user.getPassword(), user.getSlatByte(), getName() );
			}
		}

		throw new UnknownAccountException( "帐号不存在" );
	}

	public void setUserService( IUserService userService ) {
		this.userService = userService;
	}

}
