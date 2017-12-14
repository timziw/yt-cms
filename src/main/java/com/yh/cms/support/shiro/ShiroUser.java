package com.yh.cms.support.shiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
 */
public class ShiroUser implements Serializable {
	private static final long serialVersionUID = 1L;

	public String id; // 用户ID

	public String username; // 用户名

	public List<String> roleIds = new ArrayList<String>(); // 角色

	public ShiroUser(String id, String username, List<String> roleIds) {
		this.id = id;
		this.username = username;
		this.roleIds = roleIds;
	}
}
