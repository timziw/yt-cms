package com.yh.cms.domain.system;

import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.yh.cms.domain.base.BaseOperatorEntity;

/**
 * 角色实体 liuyt 2017年11月29日 下午3:56:04
 */
@Data
@EqualsAndHashCode( callSuper = true )
@ToString( callSuper = true )
@Table( name = "yh_sys_role" )
public class Role extends BaseOperatorEntity<String> {

	private static final long serialVersionUID = 4486812865709749503L;

	private String code; // 角色编码

	private String name; // 角色名称

	private String remark; // 备注
}
